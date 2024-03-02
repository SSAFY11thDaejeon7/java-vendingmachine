package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class CoinBox {

    private SortedMap<Integer, Integer> coins;

    public CoinBox() {
        coins = new TreeMap<>();
    }

    public SortedMap<Integer, Integer> generateCoins(int totalAmount) {
        RandomCoinGenerator generator = new RandomCoinGenerator();
        coins = generator.generateRandomCoins(totalAmount);
        return coins;
    }

    public SortedMap<Integer, Integer> generateChange(int inputAmount) {
        SortedMap<Integer, Integer> change = new TreeMap<>(Collections.reverseOrder());
        for (int coinAmount : coins.keySet()) {
            inputAmount = calculateChange(change, inputAmount, coinAmount);
        }
        return change;
    }

    private int calculateChange(SortedMap<Integer, Integer> change, int inputAmount, int coinAmount) {
        int coinCount = inputAmount / coinAmount;
        if (coinCount > coins.get(coinAmount)) {
            change.put(coinAmount, coins.get(coinAmount));
            coins.put(coinAmount, 0);
            inputAmount -= coinAmount * coins.get(coinAmount);
            return inputAmount;
        }

        change.put(coinAmount, coinCount);
        coins.put(coinAmount, coins.get(coinAmount) - coinCount);
        inputAmount -= coinAmount * coinCount;
        return inputAmount;
    }
}
