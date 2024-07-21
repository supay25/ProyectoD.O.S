/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class ServicioEmpleado  extends Service {
    
    
     public boolean Ver(String usuario, String clave) {
        EmpleadoTO c = null;

        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT COUNT(*) FROM usuario WHERE usuario = ? and clave=? ");
            stmt.setString(1, usuario);
            stmt.setString(2, clave);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                int count = resultado.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.out.println("El error: " + ex);
        }

        return false;
    }
     
   public Integer obtenerPermisoUsuario(String usuario) {
    try {
        PreparedStatement stmt = super.getConexion().prepareStatement("SELECT id_acceso FROM usuario WHERE usuario = ?");
        stmt.setString(1, usuario);
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            return resultado.getInt("id_acceso");
        }

        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Error al obtener permiso del usuario: " + ex.getMessage());
    }

    return null;
}

    
    
    
}
