package com.laptrinhjavaweb.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.ICustomerservice;
import com.laptrinhjavaweb.service.IUserservice;
import com.laptrinhjavaweb.service.impl.CustomerService;
import com.laptrinhjavaweb.service.impl.UserService;
import com.laptrinhjavaweb.utils.FormUtil;
@WebServlet(urlPatterns = { "/api-customer" })
public class CustomerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICustomerservice customerservice=new CustomerService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CustomerDTO customer = FormUtil.toModel(CustomerDTO.class, request);
		
		CustomerSearchBuilder uBuilder=new CustomerSearchBuilder.Builder()
				.setCustomerName(customer.getCustomerName())
				.setEmail(customer.getEmail())
				.setPhone(customer.getPhone())
				.setStaffId(customer.getStaffId())
				.build();
				
		Pageable pageable = new PageRequest(customer.getPage(), customer.getLimit());
		List<CustomerDTO> customers = customerservice.findAll(uBuilder, pageable);
		mapper.writeValue(response.getOutputStream(),customers);

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


}
