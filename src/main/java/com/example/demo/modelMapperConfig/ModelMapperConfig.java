package com.example.demo.modelMapperConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	public ModelMapper getModel() {
		return new ModelMapper();
	}

}
