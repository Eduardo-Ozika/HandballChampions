package br.com.crp.handeball;

import br.com.crp.handeball.model.entity.Gender;
import br.com.crp.handeball.model.entity.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class HandeballApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandeballApplication.class, args);
	}
}
