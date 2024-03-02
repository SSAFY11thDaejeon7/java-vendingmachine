package vendingmachine.domain;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class RandomCoinGenerator {

    private static final int COIN_COUNT_ZERO = 0;
    private static final int COIN_COUNT_ONE = 1;

    private SortedMap<Integer, Integer> randomCoins;

    public RandomCoinGenerator() {
        randomCoins = new TreeMap<>(Collections.reverseOrder());
        setCoins();
    }

    private void setCoins() {
        for(Coin coin : Coin.values()) {
            randomCoins.put(coin.getAmount(), COIN_COUNT_ZERO);
        }
    }

    public SortedMap<Integer, Integer> generateRandomCoins(int amount) {
        while (amount > COIN_COUNT_ZERO) {
            int coin = Coin.getRandomCoin();
            if (amount >= coin) {
                amount -= coin;
                randomCoins.put(coin, randomCoins.get(coin) + COIN_COUNT_ONE);
            }
        }

        return randomCoins;
    }
}
