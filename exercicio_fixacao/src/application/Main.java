package application;

import model.entities.Account;
import model.exceptions.WithdrawException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            sc.useLocale(Locale.US);
            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            Double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();

            account.withdraw(amount);
            System.out.println("New balance: " + String.format(Locale.US, "%.2f", account.getBalance()));

        } catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        } catch(WithdrawException e){
            System.out.println("Withdraw error: " + e.getMessage());
        } catch(java.util.InputMismatchException e){
            System.out.println("Input error: Invalid format entered.");
        } catch (Exception e){
            System.out.println("Unexpected error");
        }

    }
}
