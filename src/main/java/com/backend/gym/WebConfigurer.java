package com.backend.gym;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/img/**").addResourceLocations("file:///" + System.getProperty("user.dir") + "/src/main/img/");
    	registry.addResourceHandler("/imgejercicio/**").addResourceLocations("file:///" + System.getProperty("user.dir") + "/src/main/imgejercicio/");
    }
}
