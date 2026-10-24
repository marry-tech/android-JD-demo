package com.example.mytoyshop.Dao;

import com.example.mytoyshop.po.User;
import com.example.mytoyshop.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public boolean login(String name,String password){
        String sql = "select * from user where uname = ? and ucode = ?";

        Connection con = JDBCUtils.getConn();

        try {
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1,name);

            pst.setString(2,password);

            if(pst.executeQuery().next()){
                return true;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }finally {
            JDBCUtils.close(con);

        }

        return false;

    }

    public boolean register(User user){
        String sql = "insert into user(uname,ucode,uadress,uphone) values (?,?,?,?)";

        Connection con = JDBCUtils.getConn();

        try {
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1,user.getUsername());

            pst.setString(2,user.getPassword());

            pst.setString(3,user.getAdress());

            pst.setString(4,user.getPhone());

            int value = pst.executeUpdate();

            if(value>0){
                return true;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }finally {
            JDBCUtils.close(con);

        }

        return false;

    }

    public User findUser(String name){
        String sql = "select * from user where name = ?";

        Connection con = JDBCUtils.getConn();

        User user = null;

        try {
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1,name);

            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                int id = rs.getInt(6);

                String username = rs.getString(2);

                String passworddb = rs.getString(3);

                String adressdb = rs.getString(4);

                String phone = rs.getString(5);

                user = new User(id,username,passworddb,adressdb,phone);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }finally {
            JDBCUtils.close(con);

        }

        return user;

    }

}
