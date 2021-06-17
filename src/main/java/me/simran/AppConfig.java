package me.simran;

import org.springframework.context.annotation.ComponentScan;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan
@EnableWebMvc
public class AppConfig{
    //TODO: override addCorsMappings Method to allow cross origin request to API

}
