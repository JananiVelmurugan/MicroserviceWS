package com.naresh.orderappmicroservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.naresh.orderappmicroservice.model.Order;

@Repository
public class OrderRepository {

	@PersistenceContext
	private EntityManager em;

	public List<Order> list() {
		List<Order> orderList = em.createQuery("from " + Order.class.getName(), Order.class).getResultList();
		em.close();
		return orderList;
	}

	public void save(Order o) {

		em.persist(o);
		em.close();
	}

	public Order findOne(Long orderId) {
		TypedQuery<Order> createQuery = em.createQuery("from " + Order.class.getName() + " where id = :orderId",
				Order.class);
		createQuery.setParameter("orderId", orderId);
		Order orderList = createQuery.getSingleResult();
		em.close();
		return orderList;
	}

	public List<Order> findByUserId(Long userId) {
		TypedQuery<Order> createQuery = em.createQuery("from " + Order.class.getName() + " where userId = :userId",
				Order.class);
		createQuery.setParameter("userId", userId);
		List<Order> orderList = createQuery.getResultList();
		em.close();
		return orderList;
	}

}
