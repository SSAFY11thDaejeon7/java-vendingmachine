package vendingmachine.domain;

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
}
