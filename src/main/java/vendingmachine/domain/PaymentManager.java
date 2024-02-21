package vendingmachine.domain;

public class PaymentManager {

    private int inputAmount;

    public PaymentManager() {
        inputAmount = 0;
    }

    public void addInputAmount(int amount) {
        inputAmount += amount;
    }

    public int reduceInputAmount(int amount) {
        return inputAmount -= amount;
    }

    public int getInputAmount() {
        return inputAmount;
    }
}
