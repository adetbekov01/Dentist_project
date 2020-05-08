package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class BuyerListPage extends Container {

    private JLabel label;
    private JButton back;
    private JTextArea area;

    public BuyerListPage() {
        setLayout(null);
        setSize(700,700);

        label=new JLabel("LIST of Orders ");
        label.setBounds(10,10,50,20);

        area = new JTextArea();
        area.setSize(600,400);
        area.setLocation(50,50);
        area.setForeground(black);
        area.setBackground(gray);
        add(area);

        back = new JButton("BACK");
        back.setBounds(550, 500, 100, 50);
        back.setForeground(black);
        back.setBackground(gray);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buyer.showMainMenu();
            }
        });
        add(back);

    }

    public void updateArea(ArrayList<Orders> orders) {
        area.setText("");
        for (Orders ts : orders) {
            area.append(ts + "\n");
        }
        repaint();
    }
}

