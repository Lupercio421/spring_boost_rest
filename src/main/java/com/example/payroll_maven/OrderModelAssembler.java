package com.example.payroll_maven;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    // Unconditional links to single-item resource and aggregate root
    @Override
    public EntityModel<Order> toModel(Order order){
        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));


    // Conditional links based on state of the orderda

    if (order.getStatus() == Status.IN_PROGRESS){
        orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
        orderModel.add(linkTo(methodOn(OrderController.class).complete(order.getId())).withRel("complete"));
    }

    return orderModel;
    }
}
