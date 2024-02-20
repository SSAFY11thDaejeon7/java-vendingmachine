package vendingmachine.domain;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class RandomCoinGenerator {

    private SortedMap<Integer, Integer> randomCoins;

    public RandomCoinGenerator() {
        randomCoins = new TreeMap<>(Collections.reverseOrder());
        setCoins();
    }

    private void setCoins() {
        for(Coin coin : Coin.values()) {
            randomCoins.put(coin.getAmount(), 0);
        }
    }

    public SortedMap<Integer, Integer> generateRandomCoins(int amount) {
        while (amount > 0) {
            int coin = Coin.getRandomCoin();
            if (amount >= coin) {
                amount -= coin;
                randomCoins.put(coin, randomCoins.get(coin) + 1);
            }
        }

        return randomCoins;
    }
}
