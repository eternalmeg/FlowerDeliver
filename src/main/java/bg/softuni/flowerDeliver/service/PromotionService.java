package bg.softuni.flowerDeliver.service;

import bg.softuni.flowerDeliver.domain.entities.ProductEntity;
import bg.softuni.flowerDeliver.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;

import static bg.softuni.flowerDeliver.constants.Messages.*;

@Service
public class PromotionService {

    private final ProductRepository productRepository;

    public PromotionService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void makePromotions(DayOfWeek dayOfWeek) {

        ProductEntity rose = this.productRepository.findByName(ROSE);
        ProductEntity lily = this.productRepository.findByName(LILY);
        ProductEntity magic = this.productRepository.findByName(MAGIC);
        ProductEntity freshDew = this.productRepository.findByName(FRESH_DEW);
        ProductEntity whiteLady = this.productRepository.findByName(WHITE_LADY);


        switch (dayOfWeek) {
            case MONDAY -> monday(rose, magic, whiteLady);
            case TUESDAY -> tuesday(freshDew, lily);
            case WEDNESDAY -> wednesday(rose, lily);
            case THURSDAY -> thursday(magic, freshDew);
            case FRIDAY -> friday(rose, lily, whiteLady);
            case SATURDAY -> saturday(whiteLady, lily, freshDew, rose);
            case SUNDAY -> sunday(rose, whiteLady, freshDew, magic);
        }

    }

    private void sunday(ProductEntity rose,
                        ProductEntity whiteLady,
                        ProductEntity freshDew,
                        ProductEntity magic) {

        rose.setPrice(BigDecimal.valueOf(3.49));
        this.productRepository.save(rose);

        whiteLady.setPrice(BigDecimal.valueOf(28.59));
        this.productRepository.save(whiteLady);

        freshDew.setPrice(BigDecimal.valueOf(59.23));
        this.productRepository.save(freshDew);

        magic.setPrice(BigDecimal.valueOf(23.85));
        this.productRepository.save(magic);
    }

    private void saturday(ProductEntity whiteLady,
                          ProductEntity lily,
                          ProductEntity freshDew,
                          ProductEntity rose) {

        whiteLady.setPrice(BigDecimal.valueOf(28.59));
        this.productRepository.save(whiteLady);

        lily.setPrice(BigDecimal.valueOf(5.99));
        this.productRepository.save(lily);

        freshDew.setPrice(BigDecimal.valueOf(59.23));
        this.productRepository.save(freshDew);

        rose.setPrice(BigDecimal.valueOf(3.49));
        this.productRepository.save(rose);
    }
//friday(rose, lily, whiteLady);
    private void friday(ProductEntity rose,
                        ProductEntity lily,
                        ProductEntity whiteLady) {

        rose.setPrice(BigDecimal.valueOf(3.49));
        this.productRepository.save(rose);

        lily.setPrice(BigDecimal.valueOf(5.99));
        this.productRepository.save(lily);

        whiteLady.setPrice(BigDecimal.valueOf(28.59));
        this.productRepository.save(whiteLady);
    }
//thursday(magic, freshDew);
    private void thursday(ProductEntity magic,
                          ProductEntity freshDew) {

        magic.setPrice(BigDecimal.valueOf(23.85));
        this.productRepository.save(magic);

        freshDew.setPrice(BigDecimal.valueOf(59.23));
        this.productRepository.save(freshDew);
    }
    //wednesday(rose, lily);
    private void wednesday(ProductEntity rose,
                           ProductEntity lily) {

        rose.setPrice(BigDecimal.valueOf(3.49));
        this.productRepository.save(rose);

        lily.setPrice(BigDecimal.valueOf(5.99));
        this.productRepository.save(lily);
    }
//(freshDew, lily);
    private void tuesday(ProductEntity freshDew,
                         ProductEntity lily) {

        freshDew.setPrice(BigDecimal.valueOf(59.23));
        this.productRepository.save(freshDew);

        lily.setPrice(BigDecimal.valueOf(5.99));
        this.productRepository.save(lily);
    }
//case MONDAY -> monday(rose, magic, whiteLady);
    private void monday(ProductEntity rose,
                        ProductEntity magic,
                        ProductEntity whiteLady) {

        rose.setPrice(BigDecimal.valueOf(3.49));
        this.productRepository.save(rose);

        magic.setPrice(BigDecimal.valueOf(23.85));
        this.productRepository.save(magic);

        whiteLady.setPrice(BigDecimal.valueOf(28.59));
        this.productRepository.save(whiteLady);
    }

}
