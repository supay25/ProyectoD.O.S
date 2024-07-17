/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.venecoland.classjava;
import java.io.Serializable;
import lombok.Data;



@Data
public class EmpleadoTO implements Serializable {
    
    private int cedula;
    private String nombre;
    private String email;
    private double salario;
    private int telefono;
    private int id_rol;
    private int id_acceso;

    public EmpleadoTO() {
    }

    public EmpleadoTO(int cedula, String nombre, String email, double salario, int telefono, int id_rol, int id_acceso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
        this.telefono = telefono;
        this.id_rol = id_rol;
        this.id_acceso = id_acceso;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_acceso() {
        return id_acceso;
    }

    public void setId_acceso(int id_acceso) {
        this.id_acceso = id_acceso;
    }
    
    
    
    
    
           
    
    
}
