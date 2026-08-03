package com.example.proyectoinicio;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private Date fechaNacimiento;
    private int edad;
    private int imagenId;

    public Usuario(String nombre, String password, int edad, String email, int imagenId) {
        this.nombre = nombre;
        this.password = password;
        this.edad = edad;
        this.email = email;
        this.imagenId = imagenId;
    }

    public Usuario(String nombre, String apellido, int edad, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
    }

    public Usuario(String nombre, String password, String email) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getImagenId() {
        return imagenId;
    }
    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }


}
