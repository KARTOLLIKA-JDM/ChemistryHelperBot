package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ChemistryHelperBot extends TelegramLongPollingBot {

    private ElementInfo[] tableElements = new ElementInfo[]{
            new ElementInfo(1, "H", "Водород", 1.0F),
            new ElementInfo(2, "He", "Гелий", 4.0F)};

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();

            for (int j = 0; j < tableElements.length; j++) {
                ElementInfo elementInfo = tableElements[j];

                int serialNumberFromMessage;

                try {
                    serialNumberFromMessage = Integer.parseInt(message);
                } catch (Exception e) {
                    serialNumberFromMessage = 0;
                }

                if (elementInfo.getSerialNumber() == serialNumberFromMessage) {
                    sendMessage.setText(elementInfo.toString());
                } else if (elementInfo.getAbbreviation() == message) {
                    sendMessage.setText(elementInfo.toString());
                } else {
                    sendMessage.setText("Нет такого элемента!");
                }
            }

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    public String getBotUsername() {
        return "ChemistryHelperBot";
    }

    public String getBotToken() {
        return "1229143509:AAHN9smO8ATO_DOgFlwMA-hHzgRjUWdWU8g";
    }
}
