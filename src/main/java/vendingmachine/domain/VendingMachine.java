package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class VendingMachine {

    private final CoinBox coinBox;
    private final ProductBox productBox;
    private PaymentManager paymentManager;

    public VendingMachine() {
        coinBox = new CoinBox();
        productBox = new ProductBox();
        paymentManager = new PaymentManager();
    }

    public SortedMap<Integer, Integer> generateCoins(int totalAmount) {
        return coinBox.generateCoins(totalAmount);
    }

    public void addProducts(String productsString) {
        productBox.addProducts(productsString);
    }

    public void addInputAmount(int amount) {
        paymentManager.addInputAmount(amount);
    }

    public int sellProduct(String productName) {
        Product product = productBox.findProduct(productName);
        int productPrice = productBox.dispenseProduct(product);
        int inputAmount = paymentManager.reduceInputAmount(productPrice);
        return inputAmount;
    }

    public int getInputAmount() {
        return paymentManager.getInputAmount();
    }

    public SortedMap<Integer, Integer> generateChange() {
        return paymentManager.generateChange(coinBox);
    }
}
