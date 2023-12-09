package bg.softuni.flowerDeliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FlowerDeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowerDeliverApplication.class, args);
    }

}
