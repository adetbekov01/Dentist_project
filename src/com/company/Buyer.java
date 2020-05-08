package com.company;


import java.io.*;
import java.net.*;
import java.util.*;
public class Buyer {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static BuyerMainFrame frame;
    public static Socket  socket;
    public static String accaunt=null;

    private static  ArrayList<BuyerData> buyers;

    public static void connectToServer(){
        try{
            socket=new Socket("127.0.0.1",8899);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addBuyer(BuyerData buyer){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Buyer");
        pd.setBuyer(buyer);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static ArrayList<BuyerData> listBuyers(){
        ArrayList<BuyerData> buyers=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Buyers");
        pd.setBuyers(buyers);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                buyers=pd.getBuyers();
                for(BuyerData bd : buyers)
                    System.out.println(bd);
            }
        }catch (Exception e){e.printStackTrace();}
        return buyers;
    }

    public static ArrayList<Dentists> listDentists(){
        ArrayList<Dentists> dentists=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List");
        try {
            outputStream.writeObject(pd);
            if((pd=(PackageData)inputStream.readObject())!=null){
                dentists=pd.getDentists();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return dentists;
    }


    public static void addOrders(Orders orders){
        PackageData pd=new PackageData();
        ArrayList<Orders> orders1 = new ArrayList<>();
        orders1.add(orders);
        pd.setOperationType("Add_T");
        pd.setOrders(orders1);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Orders> listOrders(){
        ArrayList<Orders> orders=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_T");
        pd.setOrders(orders);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                orders =pd.getOrders();
            }
        }catch (Exception e){e.printStackTrace();}
        return orders;
    }


    public static void showRegistrPage(){
        Buyer.frame.addBuyer.setVisible(false);
        Buyer.frame.regitr.setVisible(true);
        Buyer.frame.menu.setVisible(false);
        Buyer.frame.repaint();
    }

    public static void myLogin(String login){
        accaunt=login;
    }

    public static void showListPage(){
        Buyer.frame.menu.setVisible(false);
        Buyer.frame.addOrders.setVisible(false);
        Buyer.frame.listPage.setVisible(true);
        ArrayList<Orders>list=listOrders();
        frame.listPage.updateArea(list);
        Buyer.frame.repaint();
    }

    public static void showMainMenu() {
        Buyer.frame.addBuyer.setVisible(false);
        Buyer.frame.regitr.setVisible(false);
        Buyer.frame.listPage.setVisible(false);
        Buyer.frame.menu.setVisible(true);
        Buyer.frame.repaint();
    }


    public static void showMenuPage() {
        Buyer.frame.addBuyer.setVisible(true);
        Buyer.frame.regitr.setVisible(false);
        Buyer.frame.menu.setVisible(false);
        Buyer.frame.repaint();
    }


    public static void showPicture() {
        Buyer.frame.addBuyer.setVisible(false);
        Buyer.frame.regitr.setVisible(false);
        Buyer.frame.picture.setVisible(true);
        Buyer.frame.addOrders.setVisible(false);
        Buyer.frame.menu.setVisible(false);
        Buyer.frame.repaint();
    }


    public static void main(String[] args){
        connectToServer();
        frame = new BuyerMainFrame();
        frame.setVisible(true);
    }
}



