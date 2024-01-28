import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getlogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(12345, 67890);
                data.put(32457, 54321);

                System.out.println("Welcome to ATM!");

                System.out.println("Enter customer Number:");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter PIN Number:");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\n" + "Invalid Input" + "\n");
                x = 2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();

            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else {
                System.out.println("\n" + "Incorrect customer number and pin number" + "\n");
            }

        } while (x == 1);

    }

    public void getAccountType() {

        System.out.println("Select to access the account:");
        System.out.println("1.Current Account");
        System.out.println("2.Savings Account");
        System.out.println("Exit");

        int selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                getCurrent();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("TRANSACTION COMPLETE THANK YOU!");
                break;

            default:
                System.out.println("\n" + "INVALID ENTRY" + "\n");
                getAccountType();
                break;
        }
    }

    public void getCurrent() {
        System.out.println("CURRENT ACCOUNT");
        System.out.println("1.VIEW BALANCE");
        System.out.println("2.WITHDRAW MONEY");
        System.out.println("3.DEPOSIT MONEY");
        System.out.println("EXIT");

        System.out.println("ENTER:");
        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("CURRENT ACCOUNT BALANCE" + moneyFormat.format(getCurrentBalance()));
                getAccountType();
                break;

            case 2:
                getCurrentWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCurrentDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("\n" + "INVALID ENTRY" + "\n");
                getCurrent();
        }
    }

    public void getSaving() {

        System.out.println("SAVINGS ACCOUNT");
        System.out.println("1.VIEW BALANCE");
        System.out.println("2.WITHDRAW MONEY");
        System.out.println("3.DEPOSIT MONEY");
        System.out.println("EXIT");

        System.out.println("ENTER:");
        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("SAINGS ACCOUNT BALANCE" + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("\n" + "INVALID ENTRY" + "\n");
                getSaving();
        }

    }
}
