package bg.softuni.flowerDeliver.service;

import bg.softuni.flowerDeliver.domain.entities.UserRoleEntity;
import bg.softuni.flowerDeliver.domain.enums.UserRoleEnum;
import bg.softuni.flowerDeliver.repositories.UserRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRoleEntity getRole(UserRoleEnum role){
        return this.userRoleRepository.findByRole(role);
    }

}
