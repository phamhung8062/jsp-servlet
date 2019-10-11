package com.laptrinhjavaweb.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.text.FormattableUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.IBuildingservice;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-building" })
public class BuildingAPI extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IBuildingservice buildingservice=new BuildingService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		BuildingDTO building = FormUtil.toModel(BuildingDTO.class, request);
		//BuildingDTO buildings = HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
		BuildingSeachBuilder buildingSeachBuilder = new BuildingSeachBuilder.Builder().setName(building.getName()).setDistrict(building.getDistrict())
				.setStreet(building.getStreet()).setWard(building.getWard())
				.setBuildingArea(building.getBuildingArea()).setNumberOfBasement(building.getNumberOfBasement())
				.setBuildingTypes(building.getBuildingTypes())
				.setAreaRentFrom(building.getAreaRentFrom()).setAreaRentTo(building.getAreaRentTo())
				.setCostRentFrom(building.getCostRentFrom()).setCostRentTo(building.getCostRentTo())
				.setStaffId(building.getStaffId())
				.build();
		Pageable pageable = new PageRequest(building.getPage(), building.getLimit());
		List<BuildingDTO> buildings = buildingservice.findAll(buildingSeachBuilder, pageable);
		mapper.writeValue(response.getOutputStream(), buildings);

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
