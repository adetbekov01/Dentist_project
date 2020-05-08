package com.company;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    public static Long id = null;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject()) != null) {

                if (pd.getOperationType().equals("Add")) {
                    try {
                        Dentists dentists = pd.getDentist();
                        addAnimesToDb(dentists);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }   else if(pd.getOperationType().equals("Add_T")){
                    try {
                        Orders orders= pd.getOrders().get(0);
                        addOrdersToDb(orders);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } else if (pd.getOperationType().equals("List_Buyers")) {
                    ArrayList<BuyerData> buyers = getAllBuyers();
                    PackageData resp = new PackageData();
                    resp.setBuyers(buyers);
                    outputStream.writeObject(resp);
                }
                else if (pd.getOperationType().equals("List")) {
                    ArrayList<Dentists> dentists = getDentists();
                    PackageData resp = new PackageData();
                    resp.setDentists(dentists);
                    outputStream.writeObject(resp);
                }


                else if (pd.getOperationType().equals("Add_Buyer")) {
                    try {
                        BuyerData buyer = pd.getBuyer();
                        addBuyer(buyer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }   else if(pd.getOperationType().equals("List_T")){
                    ArrayList<Orders>orders=getOrders();
                    PackageData pd2=new PackageData();
                    pd2.setOrders(orders);
                    outputStream.writeObject(pd2);
                }
                else if (pd.getOperationType().equals("Delete")) {
                    Long id = pd.getId();
                    deleteBookToDB(id);
                } else {
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Orders> getOrders() {
        ArrayList<Orders> orders = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM orders";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                orders.add(new Orders(res.getLong("id"), res.getInt("dentististid"), res.getString("name"), res.getString("surname")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }


    public void addBuyer(BuyerData buyer) {
        try {

            PreparedStatement pse = connection.prepareStatement("INSERT INTO buyerdata (login, password,telephoneNumber,id) VALUES(?,?,?,NULL)");
            pse.setString(1, buyer.getLogin());
            pse.setString(2, buyer.getPassword());
            pse.setString(3, buyer.getTelephoneNumber());
            pse.executeUpdate();
            pse.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAnimesToDb(Dentists dentists) {
        try {
            PreparedStatement ps=connection.prepareStatement("insert into dentist(id,name,time) values(null,?,?)");

            ps.setString(1,dentists.getName());
            ps.setString(2,dentists.getTime());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<BuyerData> getAllBuyers() {
        ArrayList<BuyerData> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from buyerdata");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new BuyerData(rs.getString("login"), rs.getString("password"),rs.getString("telephoneNumber"), rs.getLong("id")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public  void addOrdersToDb(Orders orders) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into orders(id,dentististid,name,surname) values(null,?,?,?)");

            ps.setInt(1,orders.getDentistsId());
            ps.setString(2,orders.getName());
            ps.setString(3,orders.getSurname());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Dentists> getDentists() {
        ArrayList<Dentists> dentists = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM dentist";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                dentists.add(new Dentists(res.getLong("id"),res.getString("name"),res.getString("time")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dentists;
    }

    public void deleteBookToDB(Long id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM dentist WHERE id=?");
            ps.setLong(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

