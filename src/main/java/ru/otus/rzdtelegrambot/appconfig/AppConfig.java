package ru.otus.rzdtelegrambot.appconfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import ru.otus.rzdtelegrambot.botapi.RZDTelegramBot;
import ru.otus.rzdtelegrambot.botconfig.RZDTelegramBotConfig;

/**
 * @author Sergei Viacheslaev
 */

@Configuration
@EnableConfigurationProperties(RZDTelegramBotConfig.class)
public class AppConfig {

    private RZDTelegramBotConfig botConfig;

    public AppConfig(RZDTelegramBotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Bean
    public RZDTelegramBot RZDTelegramBot(RZDTelegramBotConfig botConfig) {
        DefaultBotOptions options = ApiContext
                .getInstance(DefaultBotOptions.class);
        options.setProxyHost(botConfig.getProxyHost());
        options.setProxyPort(botConfig.getProxyPort());
        options.setProxyType(botConfig.getProxyType());

        RZDTelegramBot rzdTelegramBot = new RZDTelegramBot(options,botConfig);

        return rzdTelegramBot;
    }

}
