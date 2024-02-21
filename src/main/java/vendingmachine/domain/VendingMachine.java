package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class VendingMachine {

    private final CoinBox coinBox;
    private final ProductBox productBox;
    private int inputAmount;

    public VendingMachine() {
        coinBox = new CoinBox();
        productBox = new ProductBox();
    }

    public void addProducts(String productsString) {
        productBox.addProducts(productsString);
    }


}
