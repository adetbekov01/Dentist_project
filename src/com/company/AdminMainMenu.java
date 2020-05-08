package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;
import static java.awt.Color.gray;
import static java.awt.Color.cyan;

public class AdminMainMenu extends Container {
    public JButton addd;
    public JButton list;
    public JButton delete;
    public JButton exit;

    public AdminMainMenu() {
        setSize(700, 700);
        setLayout(null);
        setBackground(cyan);
        addd = new JButton("Add");
        addd.setLocation(200, 150);
        addd.setSize(300, 30);
        addd.setForeground(black);
        addd.setBackground(gray);
        addd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showAddPage();
            }
        });
        add(addd);

        list = new JButton("List");
        list.setLocation(200, 190);
        list.setSize(300, 30);
        list.setForeground(black);
        list.setBackground(gray);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showListPage();
            }
        });
        add(list);

        delete= new JButton("Delete");
        delete.setLocation(200, 240);
        delete.setSize(300, 30);
        delete.setForeground(black);
        delete.setBackground(gray);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Admin.showDeletePage();
            }
        });
        add(delete);

        exit = new JButton("Exit");
        exit.setForeground(black);
        exit.setBackground(gray);
        exit.setBounds(200, 370, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);

    }
}

