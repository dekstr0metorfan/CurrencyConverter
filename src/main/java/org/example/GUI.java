package org.example;

import javax.swing.*;

public class GUI extends JFrame
{
    public GUI()
    {
        JFrame frame = new JFrame("CurrencyConverter");
        frame.setSize(560, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        addComponent(panel);

        frame.setVisible(true);
    }

    private static void addComponent(JPanel panel)
    {
        panel.setLayout(null);

        JButton NBPbutton = new JButton("NBP");
        NBPbutton.setBounds(100, 100, 150, 100);
        panel.add(NBPbutton);
        NBPbutton.addActionListener(e ->
        {
            try
            {
                JOptionPane.showMessageDialog(null, Main.ShowResult(NBP.NBP_converter(100, "USD"), "PLN"), "100 USD to PLN", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
        });

        JLabel NBPlabel = new JLabel("Polish National Bank");
        NBPlabel.setBounds(115, 50, 150, 50);
        panel.add(NBPlabel);

        JButton CoinCapButton = new JButton("CoinCap");
        CoinCapButton.setBounds(300, 100, 150, 100);
        panel.add(CoinCapButton);

        CoinCapButton.addActionListener(e ->
        {
            try
            {
                JOptionPane.showMessageDialog(null, CoinCap.CoinCap_converter(1, "BTC"), "1 BTC to USD", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
        });

        JLabel CoinCaplabel = new JLabel("CoinCap");
        CoinCaplabel.setBounds(350, 50, 150, 50);
        panel.add(CoinCaplabel);
    }
}
