package br.com.senac.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Consiste principalmente em métodos @Bean que definem instanciação, configuração e lógica de inicialização para objetos gerenciados pelo contêiner Spring.
@Configuration
public class ConfigModelMapper {

//	Serve para exportar uma classe para o Spring, para que ele consiga carregar essa classe e fazer injeção de dependência dela em outra classes.
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}