package controller;

import controller.configuration.Animal;
import controller.configuration.Cat;
import controller.configuration.Dog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class MainApplication {

	/*
		@Autowired
		@Qualifier("personName")
		private String personName;
	*/
	// injetar propriedade diretamente
	@Value("${application.titleName}")
	private String titleName;


	@Cat
	private Animal animal;

	@Bean(name = "executarAnimal")
	public CommandLineRunner executar() {
		return args -> {
			this.animal.saySomething();
		};
	}

	/*
		@GetMapping("/person")
		public String person() {
			return personName;
		}
	 */

	@GetMapping("/title")
	public String title() {
		return titleName;
	}

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
