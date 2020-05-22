/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Envios;
/**
 *
 * @author Cristopher
 */
public class EnvioVentasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    EnvioVentas ev = new EnvioVentas();
    Envios en = new Envios();
    int r;
    public List listar() {
    String sql="select * from EnviosVentas";
     List <EnvioVentas> lista =new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                
                en.setIdEnvio(rs.getInt(1));
                ev.setIdVenta(rs.getInt(2));
                ev.setFechaEntregaPlaneada(rs.getString(3));
                ev.setFechaEntregaReal(rs.getString(4));
                lista.add(ev);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int Agregar ( EnvioVentas ev ){
     String sql="insert into EnviosVentas values ?,?,?,?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ev.getEnvio().getIdEnvio());
            ps.setInt(2, ev.getIdVenta());
            ps.setString(3, ev.getFechaEntregaPlaneada());
            ps.setString(4, ev.getFechaEntregaReal());
            ps.executeUpdate();
        } catch (Exception e) {
          }
        return r;
    }
    
    
    public int Actualizar ( EnvioVentas ev ){
     String sql="Update EnviosVentas set idVenta=?,fechaEntregaPlanteada=?,fechaEntregaReal=? where idEnvio=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ev.getFechaEntregaPlaneada() );
            ps.setString(2, ev.getFechaEntregaReal() );
            ps.setInt(3, ev.getIdVenta() );
            ps.setInt(4, ev.getEnvio().getIdEnvio());
            System.out.println("Estoy Actualizando" );
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    }

    public EnvioVentas listarId(int id){
    String sql="select * from EnviosVentas where idEnvio="+id;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                en.setIdEnvio(rs.getInt(1));
                ev.setIdVenta(rs.getInt(2));
                ev.setFechaEntregaPlaneada(rs.getString(3));
                ev.setFechaEntregaReal(rs.getString(4));
            }
        } catch (Exception e) {
        }
    return ev;
    }
}
