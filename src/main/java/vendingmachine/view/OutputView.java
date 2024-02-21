package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

public class OutputView {

    public void printTotalCoins(Map<Integer, Integer> coinInfo) {
        System.out.println("자판기가 보유한 동전");
        for (int coin : coinInfo.keySet()) {
            System.out.println(coin + "원 - " + coinInfo.get(coin) + "개");
        }
    }

    public void printInputAmount(int inputAmount) {
        System.out.println("\n투입 금액: " + inputAmount + "원");
    }

    public void printChange(Map<Coin, Integer> coinInfo) {
        // TODO: DTO 만들어서 잔돈으로 반활할 수 있는 금액만 반환하도록 하기
        System.out.println("\n자판기가 보유한 동전");
        for (Coin coin : coinInfo.keySet()) {
            System.out.println(coin.getAmount() + "원 - " + coinInfo.get(coin) + "개");
        }
    }
}
