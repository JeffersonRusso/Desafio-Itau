package com.desafio.itau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 

//LINK PARA ENTRAR NO SWAGGER http://localhost:8080/swagger-ui.html#/


@EnableSwagger2
@Configuration 
public class SwaggerConfig {    
	@Bean
	public Docket docket(){
			
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis( RequestHandlerSelectors.basePackage
						("com.desafio.itau.controller") )
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
		}
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("Desafio itau")
				.description("API de transacoes e estatisticas")
				.version("1.0")
				.build();    
		}    
	}