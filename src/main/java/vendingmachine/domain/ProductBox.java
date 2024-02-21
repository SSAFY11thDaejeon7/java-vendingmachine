package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProductBox {
    List<Product> products;

    public ProductBox() {
        products = new ArrayList<>();
    }

    public void addProducts(String productsString) {
        StringTokenizer st = new StringTokenizer(productsString, "[],;");
        while (st.hasMoreTokens()) {
            products.add(new Product(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
    }
}