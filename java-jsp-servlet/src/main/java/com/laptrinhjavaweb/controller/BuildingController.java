package com.laptrinhjavaweb.controller;

import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.IBuildingservice;
import com.laptrinhjavaweb.service.impl.BuildingService;

public class BuildingController {

//	public static void main(String[] args) {
//		int page=1;
//		int limit=2;
//		//int offset=(page -1) * limit;
//		String name="Tower";
//		String district="";
////		Integer buildingArea=null;
////		Integer numberOfBasement= null;
//		String buildingArea="";
//		String numberOfBasement="";
//		IBuildingservice buildingservice = new BuildingService();
//		BuildingSeachBuilder buildingSeachBuilder= new BuildingSeachBuilder.Builder()
//													.setName(name).setDistrict(district)
//													.setBuildingArea(buildingArea).setNumberOfBasement(numberOfBasement)
//													.build();
//		Pageable pageable =new PageRequest(page, limit);										
//		List<BuildingDTO> buildings = buildingservice.findAll(buildingSeachBuilder , pageable);
//	
//		for (BuildingDTO item : buildings) {
//			System.out.println("ID: " +item.getId()+" -Name: " + item.getName()+"   -Street: "+item.getStreet());
//			
//		}
//	}
}
