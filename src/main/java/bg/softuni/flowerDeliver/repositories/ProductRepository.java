package bg.softuni.flowerDeliver.repositories;

import bg.softuni.flowerDeliver.domain.entities.ProductEntity;
import bg.softuni.flowerDeliver.domain.enums.ProductCategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByCategory(ProductCategoryEnum category);

    ProductEntity findProductEntityById(Long id);

    ProductEntity findByName(String name);


}
