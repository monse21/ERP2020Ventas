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
 * @author DELL
 */
public class UnidadeTransporteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UnidadeTransporte UT =new UnidadeTransporte();
      int r;
    public List listar() {
    String sql="select * from UnidadesTransporte";
     List <UnidadeTransporte> lista =new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                UT.setIdUnidadTransporte(rs.getInt(1));
                UT.setMarca(rs.getString(2));
                UT.setPlacas(rs.getString(3));
                UT.setModelo(rs.getString(4));
                UT.setAnio(rs.getString(5));
                UT.setCapacidad(rs.getString(6));
                lista.add(UT);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int Agregar ( UnidadeTransporte UT ){
     String sql="insert into UnidadesTransporte (IdUnidadTransporte,Marca,Placas,Modelo,Anio,Capacidad) values (?,?,?,?,?,?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, UT.getIdUnidadTransporte());
            ps.setString(2, UT.getMarca() );
            ps.setString(3, UT.getPlacas() );
            ps.setString(4, UT.getModelo() );
            ps.setString(5, UT.getAnio() );
            ps.setString(6, UT.getCapacidad() ); 
            ps.executeUpdate();
        } catch (Exception e) {
          }
        return r;
    }
    
    
    public int Actualizar ( UnidadeTransporte UT ){
     String sql="Update UnidadesTransporte  set IdUnidadTransporte=? ,Marca=? ,Placas=? ,Modelo=? ,Anio=? ,Capacidad=? where IdUnidadTransporte=? ";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, UT.getIdUnidadTransporte());
            ps.setString(2, UT.getMarca() );
            ps.setString(3, UT.getPlacas() );
            ps.setString(4, UT.getModelo() );
            ps.setString(5, UT.getAnio() );
            ps.setString(6, UT.getCapacidad() ); 
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }


}
