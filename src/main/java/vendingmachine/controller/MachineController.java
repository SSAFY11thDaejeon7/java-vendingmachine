package vendingmachine.controller;

import vendingmachine.domain.RandomCoinGenerator;
import vendingmachine.domain.VendingMachine;
import vendingmachine.dto.SellInfoDto;
import vendingmachine.util.Validator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.Map;
import java.util.SortedMap;

public class MachineController {


    private final OutputView outputView;
    private final InputView inputView;
    private final VendingMachine vendingMachine = new VendingMachine();

    public MachineController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        setVendingMachineAmount();
        setProducts();
        setInputAmount();
        sellProducts();
        returnChange();
    }

    private void setVendingMachineAmount() {
        while (true) {
            try {
                int totalAmount = Integer.parseInt(inputView.readMachineTotalAmount());
                Map<Integer, Integer> coins = vendingMachine.generateCoins(totalAmount);
                outputView.printTotalCoins(coins);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void setProducts() {
        while (true) {
            try {
                String input = inputView.readProductInfo();
                vendingMachine.addProducts(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setInputAmount() {
        while (true) {
            try {
                String inputAmount = inputView.readInputAmount();
                Validator.validateInputAmount(inputAmount);
                vendingMachine.addInputAmount(Integer.parseInt(inputAmount));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        outputView.printInputAmount(vendingMachine.getInputAmount());
    }

    private void sellProducts() {
        while (true) {
            try {
                String input = inputView.readProductToPurchase();
                SellInfoDto sellInfoDto = vendingMachine.sellProduct(input);
                outputView.printInputAmount(sellInfoDto.getInputAmount());

                if (sellInfoDto.isChangeNeedFlag()) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void returnChange() {
        SortedMap<Integer, Integer> change = vendingMachine.generateChange();
        outputView.printChange(change);
    }
}
