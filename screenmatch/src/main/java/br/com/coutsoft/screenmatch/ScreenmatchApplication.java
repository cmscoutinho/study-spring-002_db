package br.com.coutsoft.screenmatch;

import br.com.coutsoft.screenmatch.main.Main;
import br.com.coutsoft.screenmatch.repository.SeriesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	private SeriesRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Main main = new Main(repository);
		main.main();
	}
}
