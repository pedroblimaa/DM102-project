package com.deliveryfoodapp.service;

import com.deliveryfoodapp.DTO.OrderDTO;
import com.deliveryfoodapp.DTO.OrderItemDTO;
import com.deliveryfoodapp.model.OrderItem;
import com.deliveryfoodapp.repository.OrderItemRepository;

public class OrderService {
	
	private OrderItemRepository orderItemRepository;
	
	public double getTotalAmount(OrderDTO orderDTO) {
		double totalAmount = 0;
		for(OrderItemDTO orderItemDTO : orderDTO.getItems()) {
			OrderItem orderItem = orderItemRepository.findById(orderItemDTO.getItemId());
			totalAmount += orderItem.getMenuItem().getPrice();
		}
		return totalAmount;
	}
}
