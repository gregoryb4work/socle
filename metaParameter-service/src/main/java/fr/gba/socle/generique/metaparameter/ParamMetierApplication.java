package fr.gba.socle.generique.metaparameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@Configuration
public class ParamMetierApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ParamMetierApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// necessaire pour les ressources statiques (docs)
		return application.sources(ParamMetierApplication.class);
	}

	@ControllerAdvice
	protected static class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
		public JsonpAdvice() {
			super("callback");
		}
	}

	@ControllerAdvice
	protected static class ErrorHandler {
		private final Logger log = LoggerFactory.getLogger(getClass());

		@ExceptionHandler(IllegalArgumentException.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public void processValidationError(IllegalArgumentException e) {
			log.info("Returning HTTP 400 Bad Request", e);
		}
	}

}
