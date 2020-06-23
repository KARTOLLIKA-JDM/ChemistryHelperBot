package bot;

import org.checkerframework.checker.units.qual.C;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {

    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        ChemistryHelperBot bot = new ChemistryHelperBot();

        try {
            botsApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

}
