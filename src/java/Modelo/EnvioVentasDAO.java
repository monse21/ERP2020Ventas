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
    int r;
    public List listar() {
    String sql="select * from EnviosVentas";
     List <EnvioVentas> lista =new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                EnvioVentas EV =new EnvioVentas();
                EV.setId(rs.getInt(1));
                EV.setIdVenta(rs.getInt(2));
                EV.setFechaEntregaPlaneada(rs.getString(3));
                EV.setFechaEntregaReal(rs.getString(4));
                lista.add(EV);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int Agregar ( EnvioVentas EV ){
     String sql="insert into EnviosVentas (IdEnvio,IdVenta,FechaEntregaPlanteada,FechaEntregaReal) values (?,?,?,?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, EV.getId());
            ps.setInt(2, EV.getIdVenta());
            ps.setString(3, EV.getFechaEntregaPlaneada());
            ps.setString(4, EV.getFechaEntregaReal());
            ps.executeUpdate();
        } catch (Exception e) {
          }
        return r;
    }
    
    
    public int Actualizar ( EnvioVentas EV ){
     String sql="Update EnviosVentas set idVenta=?,fechaEntregaPlanteada=?,fechaEntregaReal=? where idEnvio=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, EV.getFechaEntregaPlaneada() );
            ps.setString(2, EV.getFechaEntregaReal() );
            ps.setInt(3, EV.getIdVenta() );
            ps.setInt(4, EV.getId() );
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
                ev.setId(rs.getInt(1));
                ev.setIdVenta(rs.getInt(2));
                ev.setFechaEntregaPlaneada(rs.getString(3));
                ev.setFechaEntregaReal(rs.getString(4));
            }
        } catch (Exception e) {
        }
    return ev;
    }
}
