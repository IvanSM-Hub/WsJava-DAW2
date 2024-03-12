package restfamilias.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
