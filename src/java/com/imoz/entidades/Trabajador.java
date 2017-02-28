package com.imoz.entidades;

import java.sql.Date;

public class Trabajador {

    private int idTrabajador;
    private String nombre;
    private String apellidos;
    private String sexo;
    private Date fechaNacimiento;
    private String numDocumento;
    private String direccion;
    private String telefono;
    private String email;
    private String acceso;
    private String usuario;
    private String password;

    public Trabajador() {
    }

    public Trabajador(String nombre, String apellidos, String sexo, Date fechaNacimiento, String numDocumento, String direccion, String telefono, String email, String acceso, String usuario, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.numDocumento = numDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.acceso = acceso;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "idTrabajador=" + idTrabajador + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", numDocumento=" + numDocumento + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", acceso=" + acceso + ", usuario=" + usuario + ", password=" + password + '}';
    }

    
    
    
}
