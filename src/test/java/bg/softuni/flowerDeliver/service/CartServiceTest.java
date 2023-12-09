package bg.softuni.flowerDeliver.service;

import bg.softuni.flowerDeliver.domain.entities.CartEntity;
import bg.softuni.flowerDeliver.repositories.ProductRepository;
import bg.softuni.flowerDeliver.repositories.ShoppingCartRepository;
import bg.softuni.flowerDeliver.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private ProductRepository mockProductRepository;

    @Mock
    private ShoppingCartRepository mockShoppingCartRepository;

    private CartService serviceToTest;

    @BeforeEach
    void setUp() {
        serviceToTest = new CartService(mockUserRepository, mockProductRepository, mockShoppingCartRepository);
    }

    @Test
    void testSaveInvoked() {

        serviceToTest.getNewCart();

        verify(mockShoppingCartRepository).saveAndFlush(any());

    }

    @Test
    void testReturnedCart() {

        CartEntity newCart = serviceToTest.getNewCart();

        Assertions.assertEquals(0, newCart.getProducts().size());
        Assertions.assertEquals(BigDecimal.ZERO, newCart.getProductsSum());
    }

}
