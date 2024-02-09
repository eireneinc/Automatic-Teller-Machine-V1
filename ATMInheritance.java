package atm.inheritance;

import java.util.Scanner;

public class ATMInheritance {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PriInfo pr = new PriInfo();
        Password p = new Password();

        System.out.print("AUTOMATED TELLER MACHINE\nInput pin: ");
        String enteredPin = s.next();

        int accountIndex = -1;

        for (int i = 0; i < 5; i++) {
            if (enteredPin.equals(p.getPassword(i))) {
                accountIndex = i;
                break;
            }
        }

        if (accountIndex == -1) {
            System.out.println("Wrong pin!");
            return;
        }

        boolean pinUpdated = false;
        boolean continueTransaction = true;

        while (true) {
            if (pinUpdated) {
                System.out.print("AUTOMATED TELLER MACHINE\nInput pin: ");
                enteredPin = s.next();

                accountIndex = -1;
                for (int i = 0; i < 5; i++) {
                    if (enteredPin.equals(p.getPassword(i))) {
                        accountIndex = i;
                        break;
                    }
                }

                if (accountIndex == -1) {
                    System.out.println("Wrong pin!");
                    return;
                }

                pinUpdated = false;
            }

            System.out.println("[1] BALANCE [2] WITHDRAW [3] DEPOSIT [4] Get account number [5] Change Pin [6] Soon");
            System.out.print("Enter here: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("B A L A N C E\nP R O C E S S I N G . . . . .");
                    System.out.println("Current balance: " + pr.getBalance());
                    break;
                case 2:
                    System.out.print("W I T H D R A W\nAmount: ");
                    double withdrawAmount = s.nextDouble();
                    if (withdrawAmount > pr.getBalance()) {
                        System.out.println("Insufficient funds");
                    } else {
                        pr.setBalance(pr.getBalance() - withdrawAmount);
                        System.out.println("P R O C E S S I N G . . . . .");
                        System.out.println("Current balance: " + pr.getBalance());
                    }
                    break;
                case 3:
                    System.out.print("D E P O S I T\nEnter amount: ");
                    double depositAmount = s.nextDouble();
                    pr.setBalance(pr.getBalance() + depositAmount);
                    System.out.println("P R O C E S S I N G . . . . .");
                    System.out.println("Current balance: " + pr.getBalance());
                    break;
                case 4:
                    System.out.println("Your account number is: " + pr.getAccountNumber(accountIndex));
                    System.out.println("Your id number is: " + pr.getIdNumber(accountIndex));
                    break;
                case 5:
                    System.out.print("C H A N G E  P I N\nInput Old pin: ");
                    String oldPin = s.next();
                    if (oldPin.equals(p.getPassword(accountIndex))) {
                        System.out.print("Input new pin: ");
                        String newPin = s.next();
                        p.setPassword(accountIndex, newPin);
                        System.out.println("Successful");
                        pinUpdated = true;
                    } else {
                        System.out.println("Pin did not match");
                    }
                    break;
                case 6:
                    System.out.println("Soon");
                    break;
                default:
                    System.out.println("Sorry, other bank transaction is under maintenance.");
            }

            System.out.print("Do you want another transaction? [1]y [2]n: ");
            int continueChoice = s.nextInt();

            if (continueChoice == 2) {
                System.out.print("Do you want to Remove card? [1]Y [2]N: ");
                int removeCardChoice = s.nextInt();
                if (removeCardChoice == 1) {
                    System.out.println("Get your card");
                    return;
                } else {
                    continueTransaction = false;
                }
            }
        }
    }
}


























