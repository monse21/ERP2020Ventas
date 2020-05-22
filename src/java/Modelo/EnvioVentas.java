/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Modelo.Envios;
/**
 *
 * @author Cristopher
 */
public class EnvioVentas {
    int id;
    int idVenta;
    String FechaEntregaPlaneada;
    String FechaEntregaReal;
    Envios envios = new Envios ();
    
    public EnvioVentas(){
    }
    
    public EnvioVentas(int id, int idVenta, String FechaEntregaPlaneada, String FechaEntregaReal){
        this.id = id;
        this.idVenta = idVenta;
        this.FechaEntregaPlaneada = FechaEntregaPlaneada;
        this.FechaEntregaReal = FechaEntregaReal;
    }
    
    public Envios getEnvio(){
        return envios;
    }
    
    public void setEnvio(Envios envios){
        this.envios = envios;
    }
    
    public int getIdVenta (){
        return idVenta;
    }
    
    public void setIdVenta (int idVenta){
        this.idVenta = idVenta;
    }
    
    public String getFechaEntregaPlaneada (){
        return FechaEntregaPlaneada;
    }
    
    public void setFechaEntregaPlaneada (String FechaEntregaPlaneada){
        this.FechaEntregaPlaneada = FechaEntregaPlaneada;
    }
    
    public String getFechaEntregaReal (){
        return FechaEntregaReal;
    }
    
    public void setFechaEntregaReal (String FechaEntregaReal){
        this.FechaEntregaReal = FechaEntregaReal;
    }
    
}
