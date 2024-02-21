package vendingmachine.controller;

import vendingmachine.domain.RandomCoinGenerator;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.Map;

public class MachineController {


    private final OutputView outputView;
    private final InputView inputView;
    private final VendingMachine vendingMachine = new VendingMachine();

    public MachineController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        int totalAmount = Integer.parseInt(inputView.readMachineTotalAmount());
        Map<Integer, Integer> coins = vendingMachine.generateCoins(totalAmount);
        outputView.printTotalCoins(coins);

        String input = inputView.readProductInfo();
        vendingMachine.addProducts(input);

        int inputAmount = Integer.parseInt(inputView.readInputAmount());
        vendingMachine.addInputAmount(inputAmount);

        outputView.printInputAmount(vendingMachine.getInputAmount());
        input = inputView.readProductToPurchase();
        int amount = vendingMachine.sellProduct(input);
        outputView.printInputAmount(amount);
    }
}
