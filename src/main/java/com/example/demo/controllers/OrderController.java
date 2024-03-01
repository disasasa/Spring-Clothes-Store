package com.example.demo.controllers;

import com.example.demo.models.Clothes;
import com.example.demo.models.Order;
import com.example.demo.services.interfaces.ClothesServiceInterface;
import com.example.demo.services.interfaces.OrderServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders") // http://localhost:8080/orders
public class OrderController {
    private final OrderServiceInterface orderService;
    private final ClothesServiceInterface clothesService;

    public OrderController(OrderServiceInterface orderService, ClothesServiceInterface clothesService) {
        this.orderService = orderService;
        this.clothesService = clothesService;
    }
    @PostMapping({"/create","/create/"})
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        List<Clothes> clothes = clothesService.getByModel(order.getModel());
        if(clothes == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Clothes clothing = clothes.get(0);
            if (clothing.getAmount() >= order.getAmount()) {
                Order createdOrder = orderService.createOrder(order);
                clothing.setAmount(clothing.getAmount() - order.getAmount());
                clothesService.create(clothing);
                return new ResponseEntity<>(createdOrder,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

    @GetMapping({"","/"})
    public List<Order> getOrders() {
        return orderService.getAll();
    }

    @DeleteMapping({"/delete/{order_id}","/delete/{order_id}/"})
    public void deleteOrder(@PathVariable("order_id") int id) {
        orderService.deleteOrderById(id);
    }
}
