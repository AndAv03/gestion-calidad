package bo.ucb.edu.gestion_calidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GestionCalidadApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GestionCalidadApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(GestionCalidadApplication.class, args);
	}
	

}
