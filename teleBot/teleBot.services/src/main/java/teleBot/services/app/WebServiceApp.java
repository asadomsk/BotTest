package teleBot.services.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import teleBot.models.Bot;


@SpringBootApplication(scanBasePackages = "teleBot")
public class WebServiceApp {

	public static void main(String[] args) {
        ApiContextInitializer.init();
     
		SpringApplication.run(WebServiceApp.class, args);
	

	}

}
