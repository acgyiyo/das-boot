package com.acgyiyo.boot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//esta antotación indica que esta clase va a ser la clase de configuracion de spring
@Configuration
public class PersistenceConfiguration {

	// con esto estamos creando un datasource primario cuyo prefijo de configuracion
	//"spring.datasource" va a estar en el application.properties indicando su configuracion y ademas es de tipo primario por el @primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	//se pueden tener mas datasource en caso de necesitarlos y flyway nos da un @FlywayDS annotation para marcarlo como secundario apropiadamente 
	@Bean
	@ConfigurationProperties("datasource.flyway")
	@FlywayDataSource
	public DataSource flywayDataSource() {
		return DataSourceBuilder.create().build();
	}

}
