package bankproductsunittests;

import bankproducts.BankProduct;
import bankproducts.CreditCard;
import bankproducts.Deposit;
import bankproducts.Variables;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankProductTest {

    /*
    DOCUMENTATION.
    Unit tests.
    @Author QA Ivan Tyulkin.
    @Date 10.02.2024
    @Summary: В этих тестах мы проверяем функциональность методов `deposit`, `withdraw`, `checkDebt` и `close` для различных типов
    банковских продуктов. Таким образом, мы проверяем корректность работы реализованной архитектуры.
     */

    @Test
    @DisplayName("Тест на проверку функциональности метода `deposit`.")
    @Description("Проверка корректности работы метода размещения денежных средств на счёте клиента.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("ссылка на таск")
    public void testDeposit() {
        BankProduct deposit = new Deposit(Variables.CURRENCY_USD, Variables.balance1, Variables.depositName);
        deposit.deposit(Variables.amount1);
        Variables.LOGGER.info(Variables.GREEN + "Метод работает корректно: ожидаемое значение совпадает с фактическим. Дельта при этом составляет не более 0,001." + Variables.RESET);
        assertEquals(Variables.BLUE + "Метод работает некорректно: ожидаемое значение не совпадает с фактическим, либо превышает дельту." + Variables.RESET, 1500, deposit.checkBalance(), 0.001);
    }

    @Test
    @DisplayName("Тест на проверку функциональности метода `withdraw`.")
    @Description("Проверка корректности работы метода снятия денежных средств со счёта клиента.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("ссылка на таск")
    public void testWithdraw() {
        BankProduct creditCard = new CreditCard(Variables.CURRENCY_USD, Variables.balance1, Variables.creditCardName, Variables.interestRate1);
        creditCard.withdraw(Variables.amount2);
        Variables.LOGGER.info(Variables.GREEN + "Метод работает корректно: ожидаемое значение совпадает с фактическим. Дельта при этом составляет не более 0,001." + Variables.RESET);
        assertEquals(Variables.BLUE + "Метод работает некорректно: ожидаемое значение не совпадает с фактическим, либо превышает дельту." + Variables.RESET, 700, creditCard.checkBalance(), 0.001);
    }

    @Test
    @DisplayName("Тест на проверку функциональности метода `checkDebt`.")
    @Description("Проверка корректности работы метода запроса задолженности по счёту клиента.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("ссылка на таск")
    public void testCheckDebt() {
        CreditCard creditCard = new CreditCard(Variables.CURRENCY_USD, Variables.balance2, Variables.creditCardName, Variables.interestRate2);
        double debt = creditCard.checkDebt();
        Variables.LOGGER.info(Variables.GREEN + "Метод работает корректно: ожидаемое значение совпадает с фактическим. Дельта при этом составляет не более 0,001." + Variables.RESET);
        assertEquals(Variables.BLUE + "Метод работает некорректно: ожидаемое значение не совпадает с фактическим, либо превышает дельту." + Variables.RESET,0, debt, 0.001);
    }

    @Test
    @DisplayName("Тест на проверку функциональности метода 'close'.")
    @Description("Проверка корректности работы метода закрытия вклада.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("ссылка на таск")
    public void testClose() {
        Deposit deposit = new Deposit(Variables.CURRENCY_USD, Variables.initialBalance, Variables.depositName);
        deposit.close(Variables.interestRate);
        // Проверяем, что вклад успешно закрыт
        Variables.LOGGER.info(Variables.GREEN + "Вклад успешно закрыт!" + Variables.RESET);
        assertTrue(deposit.isClosed());
        // Проверяем, что проценты были начислены корректно
        Variables.LOGGER.info(Variables.GREEN + "Проценты были успешно начислены!" + Variables.RESET);
        assertEquals(Variables.initialBalance * (1 + Variables.interestRate / 100), deposit.checkBalance(), 0.001);
    }
}