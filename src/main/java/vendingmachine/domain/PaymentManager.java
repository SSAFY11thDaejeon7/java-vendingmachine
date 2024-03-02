package vendingmachine.domain;

import java.util.SortedMap;

public class PaymentManager {

    private static final int INIT_AMOUNT = 0;

    private int inputAmount;

    public PaymentManager() {
        inputAmount = INIT_AMOUNT;
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public void addInputAmount(int amount) {
        inputAmount += amount;
    }

    public int reduceInputAmount(int amount) {
        return inputAmount -= amount;
    }

    public SortedMap<Integer, Integer> generateChange(CoinBox coinBox) {
        return coinBox.generateChange(inputAmount);
    }
}
