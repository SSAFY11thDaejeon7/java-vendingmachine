package vendingmachine.domain;

import vendingmachine.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProductBox {
    List<Product> products;

    public ProductBox() {
        products = new ArrayList<>();
    }

    public void addProducts(String productsInfo) {
        StringTokenizer st = new StringTokenizer(productsInfo, "[],;");
        Validator.validateProductInfo(productsInfo);
        while (st.hasMoreTokens()) {
            products.add(new Product(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
    }

    public Product findProduct(String productName) {
        for (Product product : products) {
            if (product.isEqualToName(productName)) {
                return product;
            }
        }

        return null;
    }

    public int dispenseProduct(Product product) {
        int index = products.indexOf(product);
        Product findProduct = products.get(index);
        boolean soldOutFlag = findProduct.reduceQuantity();

        if (soldOutFlag) {
            products.remove(index);
        }

        return findProduct.getPrice();
    }

    public int findMinimumPrice() {
        int minimumPrice = Integer.MAX_VALUE;
        for (Product product : products) {
            minimumPrice = Math.min(minimumPrice, product.getPrice());
        }
        return minimumPrice;
    }

    public boolean checkSoldOut() {
        return products.isEmpty();
    }
}