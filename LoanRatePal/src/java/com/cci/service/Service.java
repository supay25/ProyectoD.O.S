/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class Service {
    private Connection conectar = null;
    private String url = "jdbc:mysql://localhost:3306/loanratepal?serverTimezone=UTC&zeroDateTimeBehavior=convertToNull"; //Se busca el URL en el server
    private String usuario = "root"; //El usuario del MySQL
    private String password = "oirflame"; // La contraseña del MySQL
    
    //Constructor

    public Service() {
    }
    
    public Connection conectarBBDD() throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión Exitosa ");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conectar;
    }
    
    public Connection getConexion() throws SQLException
    {
        if (conectar == null)        
            conectarBBDD();    
        return conectar;
    }
    
}