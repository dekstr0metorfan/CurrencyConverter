package org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception {

        new GUI();
        /*
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Which converter do you want to use?");
            System.out.println("1 - Polish National Bank (fiat currencies -> PLN)");
            System.out.println("2 - CoinCap (cryptocurrencies -> USD)");
            System.out.println("3 - CoinCap x Polish National Bank (cryptocurrencies -> PLN)");
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
         */
    }

    public static String ShowResult(double number, String final_code)
    {
        String message = "";
        message += "Price of this currency is ";
        message += String.format("%.2f", number);
        message += " " + final_code;

        return message;
    }
}