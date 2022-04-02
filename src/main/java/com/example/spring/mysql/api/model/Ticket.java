package com.example.spring.mysql.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket {
	@Id
	@GeneratedValue
	private int id;
	private double TicketAmt;
	private String category;
	public double getAmount() {
		return TicketAmt;
	}
	public void setAmount(double amount) {
		this.TicketAmt = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", amount=" + TicketAmt + ", category=" + category + "]";
	}
	
	public Integer getId(){
		return id;
	}
	

}