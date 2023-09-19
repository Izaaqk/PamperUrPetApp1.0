package pe.pamperurpet.pamperurpetapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pe.pamperurpet.pamperurpetapp.entities.Propietario;

@SpringBootApplication
public class PamperUrPetAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PamperUrPetAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
