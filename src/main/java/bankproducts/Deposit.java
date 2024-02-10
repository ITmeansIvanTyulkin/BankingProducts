package bankproducts;

public class Deposit extends BankProduct {

    public Deposit(String currency, double balance, String name) {
        super(currency, balance, name);
    }

    public void close(double interestRate) {
        // Проверяем, что вклад еще не закрыт
        if (!isClosed()) {
            // Вычисляем проценты
            double interest = this.balance * interestRate / 100;
            // Добавляем проценты к балансу
            this.balance += interest;
            // Устанавливаем флаг закрытия вклада
            setClosed(true);
        }
    }
}