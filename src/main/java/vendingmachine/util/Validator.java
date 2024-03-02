package vendingmachine.util;

import vendingmachine.domain.Product;

import java.util.StringTokenizer;

public class Validator {

    public static void validateAmount(int amount) {
        if (amount <= 0 || amount % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10원으로 나누어 떨어지는 10원 이상의 금액을 입력해주세요.");
        }
    }

    public static void validateProductInfo(String info) {
        StringTokenizer st = new StringTokenizer(info, "[],;");
        try {
            while (st.hasMoreTokens()) {
                String productName = st.nextToken();
                int price = Integer.parseInt(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());

                if (price <= 0 || price % 10 != 0) {
                    throw new IllegalArgumentException("[ERROR] 10원으로 나누어 떨어지는 10원 이상의 금액을 입력해주세요.");
                }

                if (quantity <= 0) {
                    throw new IllegalArgumentException("[ERROR] 물품 개수를 1개 이상 입력해주세요.");
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 가격 또는 개수를 입력해주세요.");
        }
    }
}
