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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DELL
 */
public class UnidadeTransporteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UnidadeTransporte U =new UnidadeTransporte();
      int r;
    public List listar() {
    String sql="select * from UnidadesTransporte";
     List <UnidadeTransporte> lista =new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                UnidadeTransporte UT =new UnidadeTransporte();
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
            ps.setString(3, UT.getMarca() );
            ps.setString(2, UT.getPlacas() );
            ps.setString(4, UT.getModelo() );
            ps.setString(5, UT.getAnio() );
            ps.setString(6, UT.getCapacidad() ); 
            ps.executeUpdate();
        } catch (Exception e) {
          }
        return r;
    }
    
    
    public int Actualizar ( UnidadeTransporte UT ){
     String sql="Update UnidadesTransporte set placas=?,marca=?,modelo=?,anio=?,capacidad=? where idUnidadTransporte=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, UT.getPlacas());
            ps.setString(2, UT.getMarca());
            ps.setString(3, UT.getModelo());
            ps.setString(4, UT.getAnio() );
            ps.setString(5, UT.getCapacidad());
            ps.setInt(6, UT.getIdUnidadTransporte());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    }

    public UnidadeTransporte listarId(int id){
    String sql="select * from UnidadesTransporte where IdUnidadTransporte="+id;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                U.setIdUnidadTransporte(rs.getInt(1));
                U.setMarca(rs.getString(3));
                U.setPlacas(rs.getString(2));
                U.setModelo(rs.getString(4));
                U.setAnio(rs.getString(5));
                U.setCapacidad(rs.getString(6));
            }
        } catch (Exception e) {
        }
    return U;
    }
}
