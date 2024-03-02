package vendingmachine.domain;

import java.util.SortedMap;

public class PaymentManager {

    private int inputAmount;

    public PaymentManager() {
        inputAmount = 0;
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
