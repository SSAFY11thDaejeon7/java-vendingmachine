package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ASK_MACHINE_TOTAL_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ASK_PRODUCT_INFO_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";
    private static final String ASK_INPUT_AMOUNT_MESSAGE = "\n투입 금액을 입력해 주세요.";
    private static final String ASK_PRODUCT_TO_PURCHASE_MESSAGE = "\n구매할 상품명을 입력해 주세요.";


    public String readMachineTotalAmount() {
        System.out.println(ASK_MACHINE_TOTAL_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String readProductInfo() {
        System.out.println(ASK_PRODUCT_INFO_MESSAGE);
        return Console.readLine();
    }

    public String readInputAmount() {
        System.out.println(ASK_INPUT_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String readProductToPurchase() {
        System.out.println(ASK_PRODUCT_TO_PURCHASE_MESSAGE);
        return Console.readLine();
    }
}
