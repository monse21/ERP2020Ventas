/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import config.Conexion1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */

public class UnidadesTransporteDAO {
    Conexion1 cn = new Conexion1();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    UnidadesTransporte UT= new UnidadesTransporte();
    public UnidadesTransporte buscar (String idUnidadTransporte){        
        String sql="select *from unidadTransporte"+idUnidadTransporte;
    try {       
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()) {
                UT.setIdUnidadTransporte(rs.getInt(1));
                UT.setPlacas(rs.getString(2));
                UT.setMarca(rs.getString(3));
                UT.setModelo(rs.getString(4));                
                UT.setCapacidad(rs.getInt(5));    
        }
    } catch (SQLException ex) {
        Logger.getLogger(UnidadesTransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return UT;
    }
    
    public int agregar(UnidadesTransporte UT){
    String sql="insert into UnidadesTransporte (?,?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(UT.getIdUnidadTransporte()));
            ps.setString(2, UT.getPlacas());
            ps.setString(3, UT.getMarca());
            ps.setString(4, UT.getModelo());
            ps.setString(5, String.valueOf(UT.getCapacidad()));
            
        } catch (SQLException ex) {
            Logger.getLogger(UnidadesTransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    
    }
    
    public UnidadesTransporte listarId(int id){
        try {
            String sql="select * from UnidadesTransporte where idUnidadTransporte="+id;
            
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                UT.setIdUnidadTransporte(rs.getInt(1));
                UT.setPlacas(rs.getString(2));
                UT.setMarca(rs.getString(3));
                UT.setModelo(rs.getString(4));
                UT.setCapacidad(rs.getInt(5));    
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnidadesTransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public int Actualizar (UnidadesTransporte UT){
        String sql="update UnidadesTransporte set IdUnidadTransporte=?,Placas=?, Marca=?, Modelo=? Capacidad=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(UT.getIdUnidadTransporte()));
            ps.setString(2, UT.getPlacas());
            ps.setString(3, UT.getMarca());
            ps.setString(4, UT.getModelo());
            ps.setString(5, String.valueOf(UT.getCapacidad()));
            
        } catch (SQLException ex) {
            Logger.getLogger(UnidadesTransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }
    
     public int delete (int id){
        String sql="update UnidadesTransporte Capacidad=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(2, UT.getPlacas());
            ps.setString(3, UT.getMarca());
            ps.setString(4, UT.getModelo());
            ps.setString(5, String.valueOf(UT.getCapacidad()));
            
        } catch (SQLException ex) {
            Logger.getLogger(UnidadesTransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }
    
     
}
