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
public class UnidadesTransporte {
    int idUnidadTransporte;
    String placas;
    String marca;
    String modelo;
    int capacidad;

    public UnidadesTransporte(int idUnidadTransporte, String placas, String marca, String modelo, int capacidad) {
        this.idUnidadTransporte = idUnidadTransporte;
        this.placas = placas;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    UnidadesTransporte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdUnidadTransporte() {
        return idUnidadTransporte;
    }

    public void setIdUnidadTransporte(int idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
     
    
    
}
