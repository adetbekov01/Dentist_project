package com.company;
import java.io.*;
import java.net.*;
import java.util.*;

public class Admin {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static  Socket socket;
    public static AdminMainFrame frame;

    public static void connectToServer(){
        try {
            socket=new Socket("127.0.0.1",8899);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){e.printStackTrace();}
    }

    public static void addDentist(Dentists dentists){
        PackageData pd=new PackageData();
        pd.setOperationType("Add");
        pd.setDentist(dentists);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }


    public static ArrayList<Dentists> listDentists(){
        ArrayList<Dentists> dentists=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List");
        pd.setDentists(dentists);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                dentists=pd.getDentists();
            }
        }catch (Exception e){e.printStackTrace();}
        return dentists;
    }
    public static void deleteWithId(Long id){
        PackageData pd=new PackageData();
        pd.setOperationType("Delete");
        pd.setId(id);
        // ArrayList<book> rooms=pd.getBooks();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static void showAddPage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.list.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.add.setVisible(true);
        Admin.frame.repaint();
    }
    public static void showListPage(){
        frame.menu.setVisible(false);
        frame.add.setVisible(false);
        frame.deletePage.setVisible(false);
        frame.list.setVisible(true);
        ArrayList<Dentists> list = listDentists();
        Admin.frame.list.updateArea(list);
    }

    public static void showDeletePage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.add.setVisible(false);
        Admin.frame.list.setVisible(false);
        ArrayList<Dentists> list=listDentists();
        frame.deletePage.updateArea(list);
        Admin.frame.deletePage.setVisible(true);
        Admin.frame.repaint();
    }

    public static void showMenuPage(){
        Admin.frame.add.setVisible(false);
        Admin.frame.list.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.menu.setVisible(true);
        Admin.frame.welcome.setVisible(false);
        Admin.frame.repaint();
    }

    public static void main(String[] args){
        connectToServer();
        frame = new AdminMainFrame();
        frame.setVisible(true);
    }
}

