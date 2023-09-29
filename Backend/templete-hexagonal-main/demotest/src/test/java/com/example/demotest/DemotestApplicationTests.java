package com.example.demotest;

import com.example.demotest.controller.TicketDemoController;
import com.example.demotest.model.TicketDemoEntity;
import com.example.demotest.repository.TicketDemoEntityRepository;
import com.example.demotest.service.TicketDemoEntityAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@ExtendWith(SpringExtension.class)
@WebMvcTest(TicketDemoController.class)
class DemotestApplicationTests {

	//region Atributos
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private TicketDemoEntityRepository ticketRepository;
	@MockBean
	private TicketDemoEntityAdapter ticketJpaAdapter;
	private TicketDemoEntity ticket;
	private final ObjectMapper objectMapper = new ObjectMapper();
	//endregion
	@Spy
	List<TicketDemoEntity> listTicket;
	@BeforeEach
	public void setup() {
		ticket = new TicketDemoEntity(1, "Madre Hermosa","2023-02-02", "1948-03-26",1);


	}

	@Test
	void contextLoads() throws Exception {

		List<TicketDemoEntity> toDoList = new ArrayList<TicketDemoEntity>();
		toDoList.add(new TicketDemoEntity(1, "Madre Hermosa","2023-02-02", "1948-03-26",1));
		toDoList.add(new TicketDemoEntity(2, "user2@gmail.com", "2023-02-02","1979-10-16",0));
		toDoList.add(new TicketDemoEntity(3, "user2@gmail.com", "2023-02-02","1979-10-16",1));

		when(ticketJpaAdapter.get()).thenReturn(toDoList);
		mockMvc.perform(get("/ticketDemo/get"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$").isArray());

	}
	@Test
	public void testGetTicketById() throws Exception {
		when(ticketJpaAdapter.getById(1)).thenReturn(ticket);
		mockMvc.perform(get("/ticketDemo/ticket/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.usuario", is("Madre Hermosa")))
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$").isNotEmpty());
	}

	@Test
	public void testCreateTicket() throws Exception {
		when(ticketJpaAdapter.addTicket(ticket)).thenReturn(ticket);
		mockMvc.perform(
						post("/ticketDemo/create")
								.content(objectMapper.writeValueAsString(ticket))
								.contentType(MediaType.APPLICATION_JSON)
				)
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isNotEmpty());
	}

	@Test
	public void testUpdateTicket() throws Exception {
		when(ticketJpaAdapter.addTicket(ticket)).thenReturn(ticket);
		mockMvc.perform(
						post("/ticketDemo/update")
								.content(objectMapper.writeValueAsString(ticket))
								.contentType(MediaType.APPLICATION_JSON)
				)
				.andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void testDelete() throws Exception {

		//when(ticketJpaAdapter.removeTicket(id));
		mockMvc.perform(get("/ticketDemo/ticket/1"))
				.andDo(print())
				.andExpect(status().isOk());

	}
}
