package com.naresh.orderappmicroservice.dto;

import java.time.LocalDateTime;

import com.naresh.orderappmicroservice.model.Order;

public class OrderDTO {

	private Long id;
	private String userName;
	private String bookTitle;
	private Integer bookPrice;
	private Integer quantity;
	private Integer totalAmount;
	private String status;
	private LocalDateTime orderedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Integer getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Integer getQuantity() {
		return quantity;
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

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", userName=" + userName + ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice
				+ ", quantity=" + quantity + ", totalAmount=" + totalAmount + ", status=" + status + ", orderedDate="
				+ orderedDate + "]";
	}

	public OrderDTO(Order o, UserDTO u, Book b) {

		this.id = o.getId();
		this.userName = u.getName();
		this.bookTitle = b.getTitle();
		this.bookPrice = b.getPrice();
		this.quantity = o.getQuantity();
		this.totalAmount = o.getTotalAmount();
		this.status = o.getStatus();
		this.orderedDate = o.getOrderedDate();
	}

}
