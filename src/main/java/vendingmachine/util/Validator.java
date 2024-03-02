package vendingmachine.util;

import java.util.StringTokenizer;

public class Validator {

    private static final String PRODUCT_INFO_DELIM = "[],;";
    private static final int AMOUNT_ZERO = 0;
    private static final int DIVISION_TEN = 10;
    private static final int REMAINDER_ZERO = 0;
    private static final int QUANTITY_ZERO = 0;


    public static void validateAmount(int amount) {
        if (amount <= AMOUNT_ZERO || amount % DIVISION_TEN != REMAINDER_ZERO) {
            ExceptionMessage.INVALID_AMOUNT.throwIllegalArgumentException();
        }
    }

    public static void validateProductInfo(String info) {
        StringTokenizer st = new StringTokenizer(info, PRODUCT_INFO_DELIM);
        try {
            while (st.hasMoreTokens()) {
                String productName = st.nextToken();
                int price = Integer.parseInt(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());

                if (price <= AMOUNT_ZERO || price % DIVISION_TEN != REMAINDER_ZERO) {
                    ExceptionMessage.INVALID_AMOUNT.throwIllegalArgumentException();
                }

                if (quantity <= QUANTITY_ZERO) {
                    ExceptionMessage.INVALID_PRODUCT_AMOUNT.throwIllegalArgumentException();
                }
            }
        } catch (NumberFormatException e) {
            ExceptionMessage.INVALID_PRODUCT_SETTING_INFO.throwIllegalArgumentException();
        }
    }

    public static void validateInputAmount(String amount) {
        try {
            int inputAmount = Integer.parseInt(amount);
            if (inputAmount <= AMOUNT_ZERO) {
                ExceptionMessage.INVALID_INPUT_AMOUNT.throwIllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            ExceptionMessage.INVALID_INPUT_AMOUNT_STRING.throwIllegalArgumentException();
        }
    }
}
