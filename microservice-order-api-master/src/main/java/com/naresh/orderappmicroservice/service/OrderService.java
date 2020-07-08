package com.naresh.orderappmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naresh.orderappmicroservice.dao.OrderRepository;
import com.naresh.orderappmicroservice.model.Order;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public void save(Order o) {
		orderRepository.save(o);
	}

	public List<Order> list() {

		List<Order> list = orderRepository.list();

		return list;
	}


	public List<Order> findByUserId(Long userId) {
		return orderRepository.findByUserId(userId);
	}

	public Order findOne(Long orderId) {
		return orderRepository.findOne(orderId);

	}
}
