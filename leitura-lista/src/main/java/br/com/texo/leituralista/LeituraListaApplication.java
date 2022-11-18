package br.com.texo.leituralista;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import br.com.texo.leituralista.data.CSVToDataBaseH2;
import br.com.texo.leituralista.messages.HandlerMappingFilterBadRequest;

@SpringBootApplication
public class LeituraListaApplication {
	public static void main(String[] args) {
		SpringApplication.run(LeituraListaApplication.class, args);
		// Loading CSV file to H2 Memory DataBase
		CSVToDataBaseH2 loadFile = new CSVToDataBaseH2();

	}

	@Bean
	@Autowired
	public FilterRegistrationBean listHandlers(RequestMappingHandlerMapping requestMappingHandlerMapping) {
		FilterRegistrationBean register = new FilterRegistrationBean();
		register.setFilter(new HandlerMappingFilterBadRequest(requestMappingHandlerMapping));
		register.setName("handlerListFilter");
		register.setUrlPatterns(Arrays.asList(new String[] { "/*" }));
		register.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return register;
	}

}
