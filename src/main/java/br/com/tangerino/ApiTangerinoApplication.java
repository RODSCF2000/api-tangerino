package br.com.tangerino;

import java.util.TimeZone;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.tangerino.service.impl.CustomRepositoryImpl;
import jakarta.annotation.PostConstruct;

@PropertySource({ "classpath:application.yml" })
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
@ComponentScan({ "br.com.tangerino" })
public class ApiTangerinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTangerinoApplication.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
	}

	@Bean
	public ModelMapper modelMapper() {
	    ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
	    return modelMapper;
	}

	@Bean
	public ObjectWriter objectWriter() {
	    return new ObjectMapper().writer().withDefaultPrettyPrinter();
	}

	@Bean
	public ObjectMapper objectMapper() {
	    return new ObjectMapper();
	}

}
