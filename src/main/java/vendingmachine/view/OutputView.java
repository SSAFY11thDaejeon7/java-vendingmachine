package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;
import java.util.SortedMap;

public class OutputView {

    public void printTotalCoins(Map<Integer, Integer> coinInfo) {
        System.out.println("\n자판기가 보유한 동전");
        for (int coin : coinInfo.keySet()) {
            System.out.println(coin + "원 - " + coinInfo.get(coin) + "개");
        }
    }

    public void printInputAmount(int inputAmount) {
        System.out.print("\n투입 금액: " + inputAmount + "원");
    }

    public void printChange(SortedMap<Integer, Integer> changeInfo) {
        System.out.println("\n잔돈");
        for (int coin : changeInfo.keySet()) {
            if (changeInfo.get(coin) > 0) {
                System.out.println(coin + "원 - " + changeInfo.get(coin) + "개");
            }
        }
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
