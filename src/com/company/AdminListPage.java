package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class AdminListPage extends Container {
    private JLabel label;
    private JButton btn;
    private JTextArea area;

    public AdminListPage(){
        setLayout(null);
        setSize(700,700);

        label=new JLabel("MENU");
        label.setBounds(320,10,150,60);
        add(label);

        btn = new JButton("Back");
        btn.setLocation(210,500);
        btn.setSize(300,30);
        btn.setForeground(black);
        btn.setBackground(gray);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Admin.showMenuPage();
            }
        });
        add(btn);

        area = new JTextArea();
        area.setSize(600,400);
        area.setLocation(50,50);
        area.setForeground(black);
        area.setBackground(gray);
        add(area);
    }

    public void updateArea(ArrayList<Dentists> dentists){
        area.setText("");
        for(Dentists ts:dentists){
            area.append(ts+"\n");
        }
        repaint();
    }

}
