package com.digimaster.mybackend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// path dimulai dengan file: dan diakhiri dengan tanda /
		String[] resources = {"file:/Users/teke/Documents/myImage/", 
				"file:/Users/teke/Documents/Backend/images/",
				"file:/Users/teke/Documents/Backend/mybackend/images/"};
				
		registry.addResourceHandler("/images/**").addResourceLocations(resources);
	}
	
}
