package my.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@SpringBootApplication
public class MyApp {

	public static void main(String[] args) throws IOException, URISyntaxException {
		SpringApplication.run(MyApp.class, args);
	}


	/*
		This application has no preference with regards to task scheduling and both
		websocket and Spring Session Redis use this feature.

		EnableWebSocket runs first and registers a `defaultSockJsTaskScheduler`. As there
		are no other scheduler, `@EnableScheduler` in Spring Session Redis will use that
		as a default but that scheduler in this case isn't suitable for that use case.

		Creating your own scheduler prevents this conflict from happening.
	 */
	@Bean
	public TaskScheduler taskScheduler() {
		return new ConcurrentTaskScheduler(Executors.newSingleThreadScheduledExecutor());
	}

}
