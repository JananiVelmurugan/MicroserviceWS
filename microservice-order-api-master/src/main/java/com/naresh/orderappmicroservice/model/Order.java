package com.naresh.orderappmicroservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="book_id")
	private Long bookId;
	
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@Column(name="user_id")
	private Long userId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="ordered_date")	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime orderedDate;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="total_amount")
	private Integer totalAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", bookId=" + bookId + ", userId=" + userId + ", status=" + status + ", orderedDate="
				+ orderedDate + ", quantity=" + quantity + ", totalAmount=" + totalAmount + "]";
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	}
