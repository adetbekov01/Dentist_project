package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class AdminAddPage extends Container {
    private JLabel labeltitle;

    private JLabel labelname;
    private JTextField textname;

    private JLabel labeltime;
    private JTextField texttime;

    private JButton addd;
    private JButton back;

    public AdminAddPage() {
        setLayout(null);
        setSize(700, 700);

        labeltitle = new JLabel("DENTIST ADD PAGE ");
        labeltitle.setBounds(300,100, 1000,80);
        add(labeltitle);

        labelname = new JLabel("Name:");
        labelname.setBounds(250, 200, 80, 40);
        add(labelname);

        textname = new JTextField();
        textname.setBounds(340, 200, 100, 40);
        add(textname);

        labeltime = new JLabel("Time:");
        labeltime.setBounds(250, 250, 80, 40);
        add(labeltime);

        texttime = new JTextField();
        texttime.setBounds(340, 250, 100, 40);
        add(texttime);

        addd = new JButton("Add");
        addd.setBounds(250, 400, 100, 50);
        addd.setForeground(black);
        addd.setBackground(gray);
        addd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Dentists dentists = new Dentists(null, textname.getText(),texttime.getText());
                    Admin.addDentist(dentists);

                    textname.setText("");
                    texttime.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addd);

        back = new JButton("Back");
        back.setBounds(360, 400, 100, 50);
        back.setForeground(black);
        back.setBackground(gray);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Admin.showMenuPage();
            }
        });
        add(back);
    }
}

