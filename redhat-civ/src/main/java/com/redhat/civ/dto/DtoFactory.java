package com.redhat.civ.dto;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public class DtoFactory {

	public static <T> T CreateDto(Class<T> type, Object entity)
	{
		T result = null;
		
		try
		{
			result = type.newInstance();
			
			for(Field field : entity.getClass().getDeclaredFields())
			{
				Object value = field.get(entity);
				if(isCollection(value.getClass()))
				{
					//...
				}
				result.getClass().getField(field.getName()).set(result, value);
			}
		}
		catch(Exception ex) {}
		
		return result;
	}
	
	private static boolean isCollection(Object ob) 
	{
		  return ob != null && isClassCollection(ob.getClass());
	}
	
	private static boolean isClassCollection(@SuppressWarnings("rawtypes") Class c) 
	{
		  return Collection.class.isAssignableFrom(c) || Map.class.isAssignableFrom(c);
	}
	
}
