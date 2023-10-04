package todo;

import todo.domain.model.Users;
import todo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class MainApplication {

	@Bean
	public CommandLineRunner init(@Autowired UserRepository userRepository) {
		return args -> {
			Users userModel = new Users();
			userModel.setNome("Ana Maria");
			userRepository.create(userModel);
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}


	/*
		@Autowired
		@Qualifier("personName")
		private String personName;
	*/
// injetar propriedade diretamente
	/*
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

		@GetMapping("/person")
		public String person() {
			return personName;
		}


	@GetMapping("/title")
	public String title() {
		return titleName;
	}
	 */
