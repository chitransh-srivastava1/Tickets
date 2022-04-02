package com.example.spring.mysql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.mysql.api.dao.TicketDao;
import com.example.spring.mysql.api.model.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketDao dao;

	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets) {
		dao.saveAll(tickets);
		return "ticket booked : " + tickets.size();
	}

	@GetMapping("/getTickets")
	public List<Ticket> getTickets() {
		return (List<Ticket>) dao.findAll();
	}

	@PostMapping("/updateTickets")
	public String updateTickets(@RequestBody Ticket ticket) {
		Ticket oldTicket = dao.findById(ticket.getId()).get();
		oldTicket.setAmount(ticket.getAmount());
		oldTicket.setCategory(ticket.getCategory());
		dao.save(oldTicket);
		return new String("Updated");
	}

	@DeleteMapping("/deleteTicket")
	public String deleteTicket(@RequestParam Integer id) {
		if(((List<Ticket>) dao.findAll()).size()==0){
			return new String("Record does not exist");	
		}
		dao.deleteById(id);
		return new String("Deleted");
	}
}