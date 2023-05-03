/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bufigol.tools;

import com.bufigol.constantes.DBConstantes;
import com.bufigol.constantes.MessageConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Bufigol
 */
public class DBToolkit {

    private Connection conn;
    
    public void connect() throws SQLException {
        try {
            Class.forName(DBConstantes.APACHECLASSNAME);
            conn = DriverManager.getConnection(DBConstantes.DB_URL, DBConstantes.DB_USER, DBConstantes.DB_PASSWORD);
            System.out.println(MessageConstants.DBConected);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new SQLException(MessageConstants.SQLExceptionErrorMsg);
        }
    }
    //()
    public void createUser(String usrName, Date fechaNacimiento, String email, String Nombre, String Apellido,String pwd) throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username,fechanacimiento,email,nombre,apellido,pwd) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, usrName);
            stmt.setString(2, fechaNacimiento.toString());
            stmt.setString(3, email);
            stmt.setString(4, Nombre);
            stmt.setString(5, Apellido);
            stmt.setString(6, pwd);
            stmt.executeUpdate();
            System.out.println("User " + usrName + " created successfully!");
        } catch (SQLException ex) {
            System.out.println("Error creating user: " + ex.getMessage());
            throw ex;
        }
    }
}
