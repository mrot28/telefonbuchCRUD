package com.mr.telefonbuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * CRUD-Anwendung Telefonbuch
 * Keine Oberfläche – nur REST-Services
 * 
 * 
 * @author Michael Rothmann
 *@version 1.0
 */
@SpringBootApplication
public class TelefonbuchApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelefonbuchApplication.class, args);
	}

}
