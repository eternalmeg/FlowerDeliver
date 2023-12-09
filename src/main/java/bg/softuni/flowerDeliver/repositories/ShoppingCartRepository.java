package bg.softuni.flowerDeliver.repositories;

import bg.softuni.flowerDeliver.domain.entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<CartEntity,Long> {
}
