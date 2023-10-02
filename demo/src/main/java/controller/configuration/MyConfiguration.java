package controller.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

// @Configuration

@Development
public class MyConfiguration {

    /*
    @Bean(name = "personName")
    public String personName() {
        return "Jon Doe";
    }
*/
    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("Rodando Configuracao");
        };
    }
}

// @Production
// @Profile("development") // roda apenas no ambiente informado



