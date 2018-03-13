package com.project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.project.model.ConnectionBuilder;

public class HelloWorld {
    private int id;
    private String message;

    public HelloWorld() {
    }

    public HelloWorld(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static HelloWorld getHelloWorld(){
        HelloWorld hello = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from helloworld");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String message = rs.getString("message");
                hello = new HelloWorld(id,message);
            }
            return hello;
        } catch (SQLException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e){

        }
        return hello;
    }

    @Override
    public String toString() {
        return "HelloWorld{" + "id=" + id + ", message=" + message + '}';
    }



}