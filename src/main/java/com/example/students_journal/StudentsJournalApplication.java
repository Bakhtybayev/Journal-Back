package com.example.students_journal;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "(Students) - Journal HTTP",
				version = "1",
				description = "",
				termsOfService = "",
				contact = @Contact(
						name = "Yeldar Bakhtybayev",
						email = "framehub.z0z@gmail.com"
				),
				license = @License(
						name = "Only students journal",
						url = "localhost:9191"
				)
		)
)
public class StudentsJournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsJournalApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
		@Override
			public void addCorsMappings(CorsRegistry registry) {
//			registry.addMapping("/**").allowedOrigins("http://localhost:4200");
//			registry.addMapping("/**").allowCredentials(true);
//			registry.addMapping("/**").allowedMethods("POST, GET, OPTIONS, DELETE, PUT");
//			registry.addMapping("/**").maxAge(3600);
//			registry.addMapping("Access-Control-Allow-Headers").allowedHeaders("Content-Type, Accept, X-Requested-With, x-customer-header-1, x-customer-header-2");
		}
		};
	}
}
