package bg.softuni.flowerDeliver.web.rest;

import bg.softuni.flowerDeliver.domain.dto.view.OrderViewDto;
import bg.softuni.flowerDeliver.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderDetailsController {

    private final OrderService orderService;

    public OrderDetailsController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/api/order/details/{id}")
    public ResponseEntity<OrderViewDto> getOrderById(@PathVariable("id") Long id) {

        OrderViewDto orderDetail = orderService.getOrderById(id);

        return ResponseEntity.ok(orderDetail);
    }

}
