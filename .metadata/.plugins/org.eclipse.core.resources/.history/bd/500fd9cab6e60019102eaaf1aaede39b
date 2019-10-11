package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingservice;

public class BuildingService implements IBuildingservice {
	private IBuildingRepository buildingRepository;
	private BuildingConverter buildingConverter;

	public BuildingService() {
		buildingRepository = (IBuildingRepository) new BuildingRepository();
		buildingConverter = new BuildingConverter();
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSeachBuilder filedSearch, Pageable pageable) {
		// java 7
		// List<BuildingDTO> result=new ArrayList<BuildingDTO>();
		// List<BuildingEntity>buildingEntities=buildingRepository.findAll();
		// for (BuildingEntity item: buildingEntities) {
		// BuildingDTO buildingDTO=buildingConverter.convertToDTO(item);
		// result.add(buildingDTO);
		// }
		// return result;
		// java 8
		// Covert theo thu cong
		// Map<String, Object> properties =new HashMap<>();
		// properties.put("name", filedSearch.getName());
		// properties.put("district", filedSearch.getDistrict());
		// if(StringUtils.isNotBlank( filedSearch.getBuildingArea())) {
		// properties.put("buildingArea",Integer.parseInt(filedSearch.getBuildingArea()));
		// }
		// if(StringUtils.isNotBlank( filedSearch.getNumberOfBasement())) {
		// properties.put("numberOfBasement",
		// Integer.parseInt(filedSearch.getNumberOfBasement()));
		// }
		//

		// Convert theo map
		Map<String, Object> properties = convertToMapProperties(filedSearch);
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(properties, pageable, filedSearch);
		return buildingEntities.stream().map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	private Map<String, Object> convertToMapProperties(BuildingSeachBuilder filedSearch) {
		Map<String, Object> properties = new HashMap<>();
		try {
			Field[] fields = BuildingSeachBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				// khac buildingtypes ms dc vo
				if (!field.getName().equals("buildingTypes") && !field.getName().startsWith("costRent")
						&& !field.getName().startsWith("areaRent") && !field.getName().startsWith("staffId")) {
					field.setAccessible(true);// cap quyen truy cap cho private
					if (field.get(filedSearch) instanceof String) {
						if (field.getName().equals("buildingArea") || field.getName().equals("numberOfBasement")) {
							if (field.get(filedSearch) != null && StringUtils.isNotEmpty((String) field.get(filedSearch))) {
								properties.put(field.getName().toLowerCase(),Integer.parseInt((String) field.get(filedSearch)));

							}
						} else {
							properties.put(field.getName().toLowerCase(), field.get(filedSearch));
						}
					}

				}

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return properties;
	}
}
