package teleBot.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

/**
 * @author Efrat S.
 * @version 1.0 A bot class that will extends Webhook for receiving updates from
 *          telegram api
 */

@Component
//public class Bot extends TelegramLongPollingBot  {
public class Bot extends TelegramWebhookBot {


	private static final Logger logger = LoggerFactory.getLogger(Bot.class);
	@Value("${telegrambot.botUserName}")
	private String botUserName;

	@Value("${telegrambot.botToken}")
	private String botToken;
	
	@Value("${telegrambot.botPath}")
	private String botPath;
	
	//@Value("${telegrambot.proxyType}")
	//private DefaultBotOptions.ProxyType proxyType;
	
	//@Value("${telegrambot.proxyHost}")
	//private String proxyHost;
	
	//@Value("${telegrambot.proxyPort}")
   // private int proxyPort;
	
	


	@Override
	public String getBotToken() {
		return botToken;
	}

	@Override
	public String getBotUsername() {
		return botUserName;
	}

	@Override
	public String getBotPath() {
		return botPath;
	}

//	@Override
//	public void onUpdateReceived(Update update) {
//		if (update.hasMessage()) {
//			Message message = update.getMessage();
//			SendMessage response = new SendMessage();
//			Long chatId = message.getChatId();
//			response.setChatId(chatId);
//			String text = message.getText();
//			response.setText(text);
//			try {
//				execute(response);
//				logger.info("Sent message \"{}\" to {}", text, chatId);
//			} catch (TelegramApiException e) {
//				logger.error("Failed to send message \"{}\" to {} due to error: {}", text, chatId, e.getMessage());
//			}
//		}
//	}

	@Override
	public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
		if (update.getMessage() != null && update.getMessage().hasText()) {
			long chat_id = update.getMessage().getChatId();

			try {
				execute(new SendMessage(chat_id, "Hi " + update.getMessage().getText()));
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public void setBotUserName(String botUserName) {
		this.botUserName = botUserName;
	}

	public void setBotToken(String botToken) {
		this.botToken = botToken;
	}
	
	public void setbotPath(String botPath) {
		this.botPath = botPath;
	}
	
//	public void setProxyType(DefaultBotOptions.ProxyType proxyType) {
//		this.proxyType = proxyType;
//	}
//	
//	public DefaultBotOptions.ProxyType getProxyType() {
//		return proxyType;
//	}
//
//
//	public String getProxyHost() {
//		return proxyHost;
//	}
//
//	public void setProxyHost(String proxyHost) {
//		this.proxyHost = proxyHost;
//	}
//
//	public int getProxyPort() {
//		return proxyPort;
//	}
//
//	public void setProxyPort(int proxyPort) {
//		this.proxyPort = proxyPort;
//	}

	@PostConstruct
	public void registerBot() {
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		// Set up Http proxy
		try {
			telegramBotsApi.registerBot(this);
			logger.info("username: {}, token: {}, path: {}", botUserName, botToken, botPath);

		} catch (Exception e) {
			logger.error("Error while registering bot in TelegramBotService error: {}", e.getLocalizedMessage());
		}
	}

}
