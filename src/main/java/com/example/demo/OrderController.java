package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
class OrderController {
    private final OrderRepository repository;
    private final OrderModelAssembler assembler;

    OrderController(OrderRepository repository, OrderModelAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }
    @GetMapping("/orders")
    CollectionModel<EntityModel<Order>> all(){
        List<EntityModel<Order>> orders = repository.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
            
        return CollectionModel.of(orders,
            linkTo(methodOn(OrderController.class).all()).withSelfRel());
    }

    @GetMapping("/orders/{id}")
    EntityModel<Order> one(@PathVariable Long id){
        Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        return assembler.toModel(order);
    }

    @PostMapping("/orders")
    ResponseEntity<?> newOrder(@RequestBody Order newOrder){
        EntityModel<Order> orderModel = assembler.toModel(repository.save(newOrder));
        return ResponseEntity
            .created(orderModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(orderModel);
    }
}
