package br.com.coutsoft.screenmatch;

import br.com.coutsoft.screenmatch.main.Main;
import br.com.coutsoft.screenmatch.repository.SeriesRepository;
import br.com.coutsoft.screenmatch.view.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	@Autowired
	private SeriesRepository repository;

	public static void main(String[] args) {

		//new MainWindow("Screen Match v1.0");
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Main main = new Main(repository);
		main.main();
	}
}
