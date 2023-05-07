package com.deliveryfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryfoodapp.model.Driver;
import com.deliveryfoodapp.model.Order;
import com.deliveryfoodapp.repository.DriverRepository;
import com.deliveryfoodapp.repository.OrderRepository;

@RestController
public class DriverController {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	DriverRepository driverRepository;

	@GetMapping("/driver/orders")
	public List<Order> listOrders() {
		return orderRepository.findAllByStatus("PREPARING ORDER");
	}

	@PutMapping("/driver/orders/{id}/{driverId}")
	public Order updateOrderStatus(@PathVariable Long id, @PathVariable Long driverId) {
		Order order = orderRepository.findById(id);

		if (order.getStatus().equals("PREPARING ORDER")) {
			order.setStatus("OUT FOR DELIVERY");
			Driver driver = driverRepository.findById(driverId);
			order.setDriver(driver);

			return orderRepository.save(order);
		} else {
			throw new RuntimeException("Order is already out for delivery");
		}
	}

	@PutMapping("/driver/orders/{id}/delivered")
	public Order updateOrderStatusToDelivered(@PathVariable Long id) {
		Order order = orderRepository.findById(id);

		if (order.getStatus().equals("OUT FOR DELIVERY")) {
			order.setStatus("DELIVERED");

			return orderRepository.save(order);
		} else {
			throw new RuntimeException("Order is not out for delivery");
		}
	}
}