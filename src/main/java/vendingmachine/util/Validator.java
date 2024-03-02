package vendingmachine.util;

public class Validator {

    public static void validateVendingMachineAmount(int totalAmount) {
        if (totalAmount < 0 || totalAmount % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10원으로 나누어 떨어지는 금액을 입력해주세요.");
        }
    }
}
