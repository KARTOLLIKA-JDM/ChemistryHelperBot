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

            int serialNumberFromMessage;

            try {
                serialNumberFromMessage = Integer.parseInt(message);
            } catch (Exception e) {
                serialNumberFromMessage = 0;
            }

            int indexElement = serialNumberFromMessage - 1;
            boolean isGoodIndex = validateIndex(indexElement);
            if(isGoodIndex) {
                ElementInfo foundElement = tableElements[indexElement];
                sendMessage.setText(foundElement.toString());
            }
            else{
                sendMessage.setText("Нет такого элемента!!!");
            }

            // Если полученное число больше 0 и меньше количества элементов в массиве
            // то вычитай из него 1 и бери элемент с таким номером из массива
            // если первое условие не прошло, то пиши, что "Ты дурачек, что-ли, ты что мне пишешь?


            // Добавить функционал вычисления малярной массы


            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    private boolean validateIndex(int index){
            return index >= 0 && index < tableElements.length;
    }



    public String getBotUsername() {
        return "ChemistryHelperBot";
    }

    public String getBotToken() {
        return "1229143509:AAHN9smO8ATO_DOgFlwMA-hHzgRjUWdWU8g";
    }
}
