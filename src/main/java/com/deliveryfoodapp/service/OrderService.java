package com.deliveryfoodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliveryfoodapp.DTO.OrderDTO;
import com.deliveryfoodapp.DTO.OrderItemDTO;
import com.deliveryfoodapp.model.MenuItem;
import com.deliveryfoodapp.repository.MenuItemRepository;

@Service
public class OrderService {
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	public double getTotalAmount(OrderDTO orderDTO) {
		double totalAmount = 0;
		for(OrderItemDTO orderItemDTO : orderDTO.getItems()) {
			MenuItem menuItem = menuItemRepository.findById(orderItemDTO.getItemId());
			totalAmount += menuItem.getPrice() * orderItemDTO.getQuantity();
		}
		return totalAmount;
	}
}
