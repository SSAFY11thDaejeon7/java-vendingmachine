package vendingmachine.dto;

public class SellInfoDto {

    private int inputAmount;
    private boolean changeNeedFlag;

    public SellInfoDto(int inputAmount, boolean changeNeedFlag) {
        this.inputAmount = inputAmount;
        this.changeNeedFlag = changeNeedFlag;
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public void setInputAmount(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    public boolean isChangeNeedFlag() {
        return changeNeedFlag;
    }

    public void setChangeNeedFlag(boolean changeNeedFlag) {
        this.changeNeedFlag = changeNeedFlag;
    }
}
