package org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Which converter do you want to use?");
            System.out.println("1 - Polish National Bank converter (fiat currencies -> PLN)");
            System.out.println("2 - CoinCap converter (cryptocurrency -> USD)");
            System.out.println("3 - CoinCap converter (cryptocurrency -> PLN)");
            System.out.println("0 - end the program");
            System.out.println();
            System.out.println("Type the number of option you want to use:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 0)
            {
                break;
            }
            System.out.println("Enter code of currency: ");
            String code = scanner.nextLine();
            System.out.println("Enter amount of currency you want to get: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                    ShowResult(NBP.NBP_converter(amount, code), "PLN");
                    break;
                case 2:
                    ShowResult(CoinCap.CoinCap_converter(amount, code), "USD");
                    break;
                case 3:
                    ShowResult(NBP.NBP_converter(CoinCap.CoinCap_converter(amount, code), "USD"), "PLN");
                    break;
                default:
                    System.out.println("Pick the right number!");
                     break;
            }
        }
    }

    public static void ShowResult(double number, String final_code)
    {
        System.out.print("Price of this currency is ");
        System.out.printf("%.2f", number);
        System.out.println(" " + final_code);
        System.out.println();
    }
}