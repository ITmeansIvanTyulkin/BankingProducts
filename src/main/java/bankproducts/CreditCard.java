package bankproducts;

public class CreditCard extends BankProduct {
    private final double INTERESTRATE;

    public CreditCard(String currency, double balance, String name, double INTERESTRATE) {
        super(currency, balance, name);
        this.INTERESTRATE = INTERESTRATE;
    }

    public double checkDebt() {
        // Реализация метода запроса задолженности
        return 0; // Пример возвращаемого значения
    }
}