package bg.softuni.flowerDeliver.service;


import bg.softuni.flowerDeliver.domain.entities.UserEntity;
import bg.softuni.flowerDeliver.domain.entities.UserRoleEntity;
import bg.softuni.flowerDeliver.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

import static bg.softuni.flowerDeliver.constants.Messages.ROLE;

public class FlowerDeliverUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public FlowerDeliverUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserEntityByUsername(username)
                .map(this::mapToUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " was not found"));
    }

    private UserDetails mapToUserDetails(UserEntity userEntity) {
        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                extractAuthorities(userEntity));
    }

    private List<GrantedAuthority> extractAuthorities(UserEntity userEntity) {
        return userEntity
                .getRoles()
                .stream()
                .map(this::mapRole).toList();
    }

    private GrantedAuthority mapRole(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority(ROLE + userRoleEntity.getRole().name());
    }


}
