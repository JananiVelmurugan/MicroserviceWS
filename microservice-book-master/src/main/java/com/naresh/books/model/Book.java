package com.naresh.books.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="created_by")
	private Long createdBy;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Column(name="created_date")
	private LocalDateTime createdDate;

	@Column(name="price")
	private Long price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", price=" + price + "]";
	}
	
	
}
