package tuti.desi;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
<<<<<<< HEAD
		return application.sources(Desi2024Application.class);
=======
		return application.sources(BurkettMarquezClausenApplication.class);
>>>>>>> 17f7e9b (agrego archivos)
	}

}
