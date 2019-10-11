package com.laptrinhjavaweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.anotation.Column;
import com.laptrinhjavaweb.anotation.Entity;

public class ResultSetMapper<T> {
	public List<T> mapRow(ResultSet rs, Class<T> zClass) {
		List<T> results = new ArrayList<>();
		try {
			// T object=zClass.newInstance();
			if (zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				Field[] fields = zClass.getDeclaredFields();
				while (rs.next()) {
					T object = zClass.newInstance();
					for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
						String columnName = resultSetMetaData.getColumnName(i + 1);
						Object columnValue = rs.getObject(i + 1);
						ComlumModel comlumModel=new ComlumModel();
						comlumModel.setColumnName(columnName);
						comlumModel.setColumnValue(columnValue);
						converResultSetToEntity(fields,comlumModel,object);
						Class<?> parentClass = zClass.getSuperclass();
						while (parentClass != null) {
							Field[] fieldParents = parentClass.getDeclaredFields();
							converResultSetToEntity(fieldParents,comlumModel,object);
							parentClass = parentClass.getSuperclass();
						}
					}
					results.add(object);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return results;
	}
	@SuppressWarnings("unchecked")
	private void converResultSetToEntity(Field[] fields,ComlumModel comlumModel,Object...objects) {
		T object=(T)objects[0];
		try {
			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					if (column.name().equals(comlumModel.getColumnName()) && comlumModel.getColumnValue() != null) {
						// convert data
						BeanUtils.setProperty(object, field.getName(), comlumModel.getColumnValue());
						break;
					}
				}
			}
		}catch (InvocationTargetException | IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		
	}
	static class ComlumModel{
		private String columnName;
		private Object columnValue;
		public String getColumnName() {
			return columnName;
		}
		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}
		public Object getColumnValue() {
			return columnValue;
		}
		public void setColumnValue(Object columnValue) {
			this.columnValue = columnValue;
		}
		
	}
}
