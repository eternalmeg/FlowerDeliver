package bg.softuni.flowerDeliver.repositories;

import bg.softuni.flowerDeliver.domain.entities.UserRoleEntity;
import bg.softuni.flowerDeliver.domain.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByRole(UserRoleEnum role);
}
