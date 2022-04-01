package com.example.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	 @PropertySource("classpath:textos.properties")   //,
	 //@PropertySource("classpath:textos2.properties") //ejemplo para varios properties
})
public class TextoPropertiesConfig {

}
