package com.mr.telefonbuch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(TelefonbuchRepository repository) {

		return args -> {
			
			log.info("Laden " + repository.save(new Telefonbucheintrag("069 1234567-0", "Max Mustermann", "Hochstr. 33, 60313 Frankfurt - Innenstadt ")));
			log.info("Laden " + repository.save(new Telefonbucheintrag("0174 5678876", "Tea Kurz", "Lange Str 1, 76530 Baden-Baden")));
			
		};
	}
}
