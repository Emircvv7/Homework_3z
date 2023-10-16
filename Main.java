
class LimitException extends Exception {
    private double remainingAmount;

    public LimitException(String message, double remainingAmount) {
        super(message);
        this.remainingAmount = remainingAmount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }
}
class BankAccount {
    private double amount;

    public BankAccount(double initialAmount) {
        this.amount = initialAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        amount += sum;
    }

    public void withdraw(double sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Сумма для снятия больше, чем остаток на счете.", amount);
        }
        amount -= sum;
    }
}
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(15000.0);

        while (true) {
            try {
                account.withdraw(6000.0);
                System.out.println("Снято 6000 сом. Остаток на счете: " + account.getAmount());
            } catch (LimitException e) {
                double remainingAmount = e.getRemainingAmount();
                System.out.println("Произошло исключение: " + e.getMessage());
                System.out.println("Снято " + (6000.0 - (6000.0 - remainingAmount)) + " сом.");
                System.out.println("Остаток на счете: " + remainingAmount);
                break;
            }
        }
    }

}




