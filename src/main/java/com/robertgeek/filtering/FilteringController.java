package com.robertgeek.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping(path = "/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("a","b","c");
	}
	
	@GetMapping(path = "/filtering-list")
	public List<SomeBean> retrieveListSomeBean(){
		return Arrays.asList(new SomeBean("a","b","c"), new SomeBean("value1","value2","value3"));
	}
	
	@GetMapping(path = "filtering-dinamic")
	public MappingJacksonValue retrieveSomeBeanDinamic() {
		
		SomeBean sb = new SomeBean("a","b","c");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider fp = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(sb);
		mapping.setFilters(fp);
		return mapping;
	}
}
