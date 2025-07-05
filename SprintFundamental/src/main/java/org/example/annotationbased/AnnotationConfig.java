package org.example.annotationbased;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.example.annotationbased")
@PropertySource("classpath:application.properties")
public class AnnotationConfig {

}
