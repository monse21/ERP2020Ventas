/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DELL
 */
public class Envios {
   int  idEnvio;
   String fechaSalida;
   UnidadeTransporte unidad;

    public Envios() {
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public UnidadeTransporte getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadeTransporte unidad) {
        this.unidad = unidad;
    }
   
   
   
}
