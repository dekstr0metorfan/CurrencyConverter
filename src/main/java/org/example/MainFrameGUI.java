package org.example;

import javax.swing.*;

public class MainFrameGUI extends JFrame
{
    public MainFrameGUI()
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

        NBPbutton.addActionListener(e -> {
            SecondFrameGUI SecondFrameGUI = new SecondFrameGUI(1);
            SecondFrameGUI.setVisible(true);
        });

        JLabel NBPlabel = new JLabel("Polish National Bank");
        NBPlabel.setBounds(115, 50, 150, 50);
        panel.add(NBPlabel);

        JButton CoinCapButton = new JButton("CoinCap");
        CoinCapButton.setBounds(300, 100, 150, 100);
        panel.add(CoinCapButton);

        CoinCapButton.addActionListener(e -> {
            SecondFrameGUI SecondFrameGUI = new SecondFrameGUI(2);
            SecondFrameGUI.setVisible(true);
        });

        JLabel CoinCaplabel = new JLabel("CoinCap");
        CoinCaplabel.setBounds(350, 50, 150, 50);
        panel.add(CoinCaplabel);
    }
}