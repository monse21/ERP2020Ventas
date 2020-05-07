/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Jaime
 */
public class Ofertas {
int idOferta;
String nombre;
String descripcion;
float descuento;
Date fechainicio;
Date fechafin;
int cantMini;
String estatus;

    public Ofertas() {
    }

    public Ofertas(int idOferta, String nombre, String descripcion, float descuento, Date fechainicio, Date fechafin, int cantMini, String estatus) {
        this.idOferta = idOferta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.cantMini = cantMini;
        this.estatus = estatus;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public int getCantMini() {
        return cantMini;
    }

    public void setCantMini(int cantMini) {
        this.cantMini = cantMini;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }


}
