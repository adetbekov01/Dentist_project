package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyerRegistr extends Container {
    private JLabel login;
    private JTextField textLogin;
    private JLabel telephone;
    private JTextField textTelephone;
    private JPasswordField textpassword;
    private JLabel password;
    private JButton back;
    private JButton registr;

    public BuyerRegistr () {
        setLayout(null);
        setSize(700, 700);

        login = new JLabel("Login:");
        login.setBounds(250, 150, 80, 40);
        add(login);
        textLogin = new JTextField();
        textLogin.setBounds(340, 150, 100, 40);
        add(textLogin);

        password = new JLabel("Password:");
        password.setBounds(250, 200, 80, 40);
        add(password);

        textpassword = new JPasswordField();
        textpassword.setBounds(340, 200, 100, 40);
        add(textpassword);

        telephone = new JLabel("Telephone:");
        telephone.setBounds(250, 250, 80, 40);
        add(telephone);
        textTelephone = new JTextField();
        textTelephone.setBounds(340, 250, 100, 40);
        add(textTelephone);

        back=new JButton("Back");
        back.setBounds(340,410,100,50);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Buyer.showMenuPage();
            }
        });
        add(back);
        registr=new JButton("Registr");
        registr.setBounds(340,350,100,50);
        registr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    BuyerData buyer = new BuyerData(textLogin.getText(), textpassword.getText(),textTelephone.getText());
                    Buyer.addBuyer(buyer);
                    textLogin.setText("");
                    textpassword.setText("");
                    textTelephone.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        add(registr);
    }

    int x = 0, y = 100;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Tahoma", Font.BOLD + Font.PLAIN, 50);
        g2.setFont(font);
        g2.setColor(Color.GRAY);
        g2.drawString("Register part", x, y);
        try {
            Thread.sleep(100);
        } catch (Exception ex) {
        }
        x += 10;
        if (x > this.getWidth()) {
            x = 0;
        }
        repaint();
    }
}

