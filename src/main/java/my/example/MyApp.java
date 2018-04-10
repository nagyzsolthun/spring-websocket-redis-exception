package my.example;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {

	public static void main(String[] args) throws IOException, URISyntaxException {
		SpringApplication.run(MyApp.class, args);
	}

}
