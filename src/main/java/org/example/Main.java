package org.example;

public class Main
{
    public static void main(String[] args)
    {
        new MainFrameGUI();
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