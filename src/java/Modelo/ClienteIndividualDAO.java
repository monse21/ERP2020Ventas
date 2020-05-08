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
public class ClienteIndividualDAO {
      Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ClienteIndividual CI = new ClienteIndividual();
    int r;
    
     public List listar() {
       String sql="select * from ClienteIndividual";
     List <ClienteIndividual> lista =new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                ClienteIndividual CI = new ClienteIndividual();
                CI.setIdClienteI(rs.getInt(1));
                CI.setNombre(rs.getString(2));
                CI.setApaterno(rs.getString(3));
                CI.setAmaterno(rs.getString(4));
                CI.setSexo(rs.getString(5));
                lista.add(CI);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int Agregar ( ClienteIndividual CI ){
     String sql="insert into ClienteIndividual (idCliente,nombre,apaterno,amaterno,sexo) values (?,?,?,?,?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, CI.getIdClienteI());
            ps.setString(2, CI.getNombre() );
            ps.setString(3, CI.getApaterno() );
            ps.setString(4, CI.getAmaterno());
            ps.setString(5, CI.getSexo());
            ps.executeUpdate();
        } catch (Exception e) {
          }
        return r;
    }
    
    
    public int Actualizar ( ClienteIndividual CI ){
     String sql="Update ClienteIndividual set idCliente=?,nombre=?,apaterno=?,amaterno=?,sexo=? where idCliente=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, CI.getIdClienteI());
            ps.setString(2, CI.getNombre());
            ps.setString(3, CI.getApaterno());
            ps.setString(4, CI.getAmaterno());
            ps.setString(5, CI.getSexo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public ClienteIndividual listarId(int id){
    String sql="select * from ClienteIndividual where IdCliente="+id;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                CI.setIdClienteI(rs.getInt(1));
                CI.setNombre(rs.getString(2));
                CI.setApaterno(rs.getString(3));
                CI.setAmaterno(rs.getString(4));
                CI.setSexo(rs.getString(5));
            }
        } catch (Exception e) {
        }
    return CI;
    }
    
}

