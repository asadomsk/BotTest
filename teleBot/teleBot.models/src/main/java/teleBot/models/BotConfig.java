package teleBot.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
//@PropertySource("classpath:application.properties")
public class BotConfig {
	//@Value("${telegrambot.botToken}")
	private String webHookPath;
    private String botUserName;
	private String botToken;

	private DefaultBotOptions.ProxyType proxyType;
	private String proxyHost;
    private int proxyPort;
	public String getWebHookPath() {
		return webHookPath;
	}
	public void setWebHookPath(String webHookPath) {
		this.webHookPath = webHookPath;
	}
	public String getBotUserName() {
		return botUserName;
	}
	public void setBotUserName(String botUserName) {
		this.botUserName = botUserName;
	}
	public String getBotToken() {
		return botToken;
	}
	public void setBotToken(String botToken) {
		this.botToken = botToken;
	}
	public DefaultBotOptions.ProxyType getProxyType() {
		return proxyType;
	}
	public void setProxyType(DefaultBotOptions.ProxyType proxyType) {
		this.proxyType = proxyType;
	}
	public String getProxyHost() {
		return proxyHost;
	}
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}
	public int getProxyPort() {
		return proxyPort;
	}
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}
	

    
}