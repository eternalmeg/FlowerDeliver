package bg.softuni.flowerDeliver.service;

import bg.softuni.flowerDeliver.domain.entities.ProductEntity;
import bg.softuni.flowerDeliver.domain.entities.CartEntity;
import bg.softuni.flowerDeliver.domain.entities.UserEntity;
import bg.softuni.flowerDeliver.repositories.ProductRepository;
import bg.softuni.flowerDeliver.repositories.ShoppingCartRepository;
import bg.softuni.flowerDeliver.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public CartService(UserRepository userRepository,
                       ProductRepository productRepository,
                       ShoppingCartRepository shoppingCartRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public CartEntity getNewCart() {

        CartEntity shoppingCart = new CartEntity();

        this.shoppingCartRepository.saveAndFlush(shoppingCart);

        return shoppingCart;
    }

    @Transactional
    public void addProductToTheCart(Long id,
                                    String username) {

        UserEntity user = this.userRepository.findByUsername(username);
        final ProductEntity product = this.productRepository.findProductEntityById(id);

        user.getCart().addProduct(product);
        user.getCart().increaseProductsSum(product.getPrice());
    }

    @Transactional
    public void removeProductFromTheCart(Long id,
                                         String username) {

        UserEntity user = this.userRepository.findByUsername(username);
        final ProductEntity product = this.productRepository.findProductEntityById(id);

        user.getCart().getProducts().remove(product);
        user.getCart().decreaseProductsSum(product.getPrice());

    }

}
