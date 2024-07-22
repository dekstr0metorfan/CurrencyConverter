package org.example;

import javax.swing.*;

public class SecondFrameGUI extends JFrame
{
    private final JTextField code;
    private final JTextField amount;

    public SecondFrameGUI(int choice)
    {
        setTitle("CurrencyConverter");
        setSize(320, 300);
        setLocationRelativeTo(null);

        code = new JTextField();
        amount = new JTextField();
        JButton submitButton = new JButton("Calculate");

        JLabel amountLabel = new JLabel("Amount:");
        JLabel codeLabel = new JLabel("Currency code:");

        setLayout(null);
        amountLabel.setBounds(50, 10, 200, 30);
        amount.setBounds(50, 40, 200, 30);
        codeLabel.setBounds(50, 80, 200, 30);
        code.setBounds(50, 110, 200, 30);
        submitButton.setBounds(100, 180, 100, 30);

        add(code);
        add(amount);
        add(submitButton);
        add(amountLabel);
        add(codeLabel);

        if(choice == 1)
        {
            submitButton.addActionListener(e -> {
                String name = code.getText();
                double number = Double.parseDouble(amount.getText());
                try {
                    if(NBP.NBP_converter(number, name) == -1) {
                        JOptionPane.showMessageDialog(null, "Wrong parameters!", "CurrencyConverter", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, Main.ShowResult(NBP.NBP_converter(number, name), "PLN"), "CurrencyConverter", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

        if(choice == 2)
        {
            submitButton.addActionListener(e -> {
                String name = code.getText();
                double number = Double.parseDouble(amount.getText());
                try {
                    if(CoinCap.CoinCap_converter(number, name) == -1) {
                        JOptionPane.showMessageDialog(null, "Wrong parameters!", "CurrencyConverter", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, Main.ShowResult(CoinCap.CoinCap_converter(number, name), "USD"), "CurrencyConverter", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }
}
