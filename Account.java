import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int customerNumber;
    private int pinNumber;
    private double currentBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calcCurrentWithdraw(double amount) {
        currentBalance = (currentBalance - amount);
        return currentBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calcCurrentDeposit(double amount) {
        currentBalance = (currentBalance + amount);
        return currentBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public void getCurrentWithdrawInput() {
        System.out.println("CURRENT ACCOOUNT BALANCE:" + moneyFormat.format(currentBalance));
        System.out.println("ENTER THE AMOUNT:");

        double amount = input.nextDouble();
        if ((currentBalance - amount) >= 0) {
            calcCurrentWithdraw(amount);
        } else {
            System.out.println("INSUFFICIENT BALANCE" + "\n");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("SAVING ACCOUNT" + moneyFormat.format(savingBalance));
        System.out.println("ENTER AMOUNT:");

        double amount = input.nextDouble();
        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("AVAILABLE BALANCE:" + moneyFormat.format(savingBalance));
        } else {
            System.out.println("INSUFFICIENT BALANCE" + "\n");
        }

    }

    public void getCurrentDepositInput() {
        System.out.println("CURRENT ACCOUNT BALANCE:" + moneyFormat.format(currentBalance));
        System.out.println("ENTER DEPOSIT AMONUT:");
        double amount = input.nextDouble();
        if ((currentBalance + amount) >= 0) {
            calcCurrentDeposit(amount);
            System.out.println("AVAILABLE BALANCE:" + moneyFormat.format(currentBalance));
        } else {
            System.out.println("NEGATIVE BALANCE" + "\n");
        }
    }

    public void getSavingDepositInput() {
        System.out.println("SAVING ACCOUNT BALANCE:" + moneyFormat.format(savingBalance));
        System.out.println("ENTER DEPOSIT AMONUT:");
        double amount = input.nextDouble();
        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("AVAILABLE BALANCE:" + moneyFormat.format(savingBalance));
        } else {
            System.out.println("NEGATIVE BALANCE" + "\n");
        }
    }
}
