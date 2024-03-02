package vendingmachine.view;

import java.util.Map;
import java.util.SortedMap;

public class OutputView {

    private static final String MACHINE_COINS_INFO_MESSAGE = "\n자판기가 보유한 동전";
    private static final String COINS_INFO_AMOUNT = "원 - ";
    private static final String COINS_INFO_COUNT = "개";
    private static final String INPUT_AMOUNT_MESSAGE = "\n투입 금액: ";
    private static final String INPUT_AMOUNT_WON = "원";
    private static final String CHANGE_MESSAGE = "\n잔돈";
    private static final int COIN_COUNT_ZERO = 0;


    public void printTotalCoins(Map<Integer, Integer> coinInfo) {
        System.out.println(MACHINE_COINS_INFO_MESSAGE);
        for (int coin : coinInfo.keySet()) {
            System.out.println(coin + COINS_INFO_AMOUNT + coinInfo.get(coin) + COINS_INFO_COUNT);
        }
    }

    public void printInputAmount(int inputAmount) {
        System.out.print(INPUT_AMOUNT_MESSAGE + inputAmount + INPUT_AMOUNT_WON);
    }

    public void printChange(SortedMap<Integer, Integer> changeInfo) {
        System.out.println(CHANGE_MESSAGE);
        for (int coin : changeInfo.keySet()) {
            if (changeInfo.get(coin) > COIN_COUNT_ZERO) {
                System.out.println(coin + COINS_INFO_AMOUNT + changeInfo.get(coin) + COINS_INFO_COUNT);
            }
        }
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
