import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<String, HashMap<String, String>> map = new HashMap<>();
        map.put("123456789", new HashMap<>());
        map.put("987654321", new HashMap<>());
        map.get("123456789").put("pin number" , "123456");
        map.get("123456789").put("phone number" , "0123456789");
        map.get("123456789").put("name" , "Thomas");
        map.get("123456789").put("balance" , "50000");
        map.get("987654321").put("pin number" , "654321");
        map.get("987654321").put("phone number" , "0198765432");
        map.get("987654321").put("name" , "Chantel");
        map.get("987654321").put("balance" , "456052");

        boolean valid = false;
        Scanner in = new Scanner(System.in);
        while(!valid) {
            System.out.println("Enter Your Card Number");
            String card = in.next();
            System.out.println("Enter Your Pin Number");
            String pin = in.next();
            String actualPin = map.get(card).get("pin number");
            valid = pin.equals(actualPin);
            if (!valid) {
                System.out.println("Wrong Card Number or Pin Number");
                System.out.println("Try Again");
                break;
            } else {
                System.out.println("Congratulations on logging in");
                Scanner question = new Scanner(System.in);
                System.out.println("Press 1 to Withdraw");
                System.out.println("Press 2 to Deposit");
                System.out.println("Press 3 to Check Amount");
                System.out.println("Press 4 to Exit");
                String operation = question.next();
                int amount = 0;
                String total = map.get(card).get("balance");
                int BalanceInInteger = Integer.parseInt(total);
                switch(operation) {
                    case "1":
                        System.out.println("How much would you like to withdraw");
                        amount = in.nextInt();
                        if(amount < BalanceInInteger) {
                            BalanceInInteger -= amount;
                            System.out.println("You have withdraw " + amount + " and your bank left " + BalanceInInteger);
                        } else {
                            System.out.println("Your balance is insufficient to withdraw " + amount);
                        }
                        break;
                    case "2":
                        System.out.println("How much would like to deposit?");
                        amount = in.nextInt();
                        if(amount < BalanceInInteger) {
                            BalanceInInteger += amount;
                            System.out.println("You have deposit " + amount + " and your bank now have " + BalanceInInteger);
                        }
                        break;
                    case "3":
                        System.out.println("Here is your total amount in your bank");
                        System.out.println("Your total amount is " + total);
                        break;
                    default:
                        System.out.println("Have a nice day.");
                }
            }
        }

    }
}
