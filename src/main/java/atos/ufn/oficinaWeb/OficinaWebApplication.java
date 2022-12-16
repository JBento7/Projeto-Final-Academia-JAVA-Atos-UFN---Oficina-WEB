package atos.ufn.oficinaWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OficinaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OficinaWebApplication.class, args);
		final Logger log = LoggerFactory.getLogger(OficinaWebApplication.class);
		log.info("Iniciando Sistema Oficina Web");
	}

}
