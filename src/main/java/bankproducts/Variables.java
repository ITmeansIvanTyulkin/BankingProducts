package bankproducts;

import java.util.logging.Logger;

public interface Variables {

    String GREEN = "\u001B[32m";    // Сообщение зелёного цвета - значит, всё отлично.

    String BLUE = "\u001B[34m";     // Сообщение синего цвета - значит, что-то пошло не так.

    String RESET = "\u001B[0m";

    Logger LOGGER = Logger.getLogger(Variables.class.getName());

    static void LOGGER(String s) {
    }

    String depositName = "My deposit";

    String creditCardName = "My credit card";

    String CURRENCY_USD = "USD";

    int balance1 = 1000;

    int balance2 = 0;

    int amount1 = 500;

    int amount2 = 300;

    float interestRate1 = 0.01f;

    float interestRate2 = 0.10f;

    double initialBalance = 1000.0;

    double interestRate = 10.0;
}