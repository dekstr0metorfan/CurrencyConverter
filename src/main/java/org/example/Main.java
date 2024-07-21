package org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean x = true;
        while(x)
        {
            System.out.println("Which converter do you want to use?");
            System.out.println("1 - Polish National Bank converter (other currencies -> PLN)");
            System.out.println("2 - CoinCap converter (cryptocurrency -> USD)");
            System.out.println("0 - end the program");
            System.out.println();
            System.out.println("Type the number of option you want to use:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter code of currency (according to ISO 4217): ");
            String code = scanner.nextLine();
            System.out.println("Enter amount of currency you want to get: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                    NBP.NBP_converter(amount, code);
                    break;
                case 2:
                    CoinCap.CoinCap_converter(amount, code);
                    break;
                case 0:
                    x = false;
                    break;
                default:
                    System.out.println("Pick the right number!");
                     break;
            }
        }
    }
}