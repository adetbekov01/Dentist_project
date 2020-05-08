package com.company;

import javax.swing.*;
public class BuyerMainFrame extends JFrame {
    public BuyerAddPage addOrders;
    public BuyerMainMenu menu;
    public BuyerRegistr regitr;
    public BuyerListPage listPage;
    public BuyerAdd addBuyer;
    public Picture picture;


    public BuyerMainFrame(){
        setTitle("USER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);
        menu = new BuyerMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        addBuyer = new BuyerAdd();
        addBuyer.setLocation(0, 0);
        addBuyer.setVisible(true);
        add(addBuyer);

        picture = new Picture();
        picture.setLocation(0,0);
        picture.setVisible(false);
        add(picture);

        listPage = new BuyerListPage();
        listPage.setLocation(0, 0);
        listPage.setVisible(false);
        add(listPage);


        regitr=new BuyerRegistr();
        regitr.setLocation(0,0);
        regitr.setVisible(false);
        add(regitr);

        addOrders = new BuyerAddPage();
        addOrders.setLocation(0,0);
        addOrders.setVisible(false);
        add(addOrders);


        repaint();
    }
}
