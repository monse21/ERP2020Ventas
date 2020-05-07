/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Jaime
 */
public class OfertasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ClienteIndividual CI = new ClienteIndividual();
    Clientes cliente= new Clientes();
    int r;
    
    public List listar() {
        String sql ="select * from Ofertas"; 
        List<Ofertas> lista = new ArrayList<>();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ofertas OF = new Ofertas();
                OF.setIdOferta(rs.getInt(1));
                OF.setNombre(rs.getString(2));
                OF.setDescripcion(rs.getString(3));
                OF.setDescuento(rs.getFloat(4));
                OF.setFechainicio(rs.getDate(5));
                OF.setFechafin(rs.getDate(6));
                OF.setCantMini(rs.getInt(7));
                OF.setEstatus(rs.getString(8));
                lista.add(OF);
                
            }
        } catch (Exception e) {
        }
        return lista;
}
 public int agregar(Ofertas o){
        String sql ="insert into Ofertas(nombres,despricion,porDescuento,fechaInicio,fechafin,canMinProducto,estatus)values(?,?,?,?,?,?,?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getDescripcion());
            ps.setFloat(3, o.getDescuento());
            ps.setDate(4, (java.sql.Date)o.getFechainicio());
            ps.setDate(5, (java.sql.Date) o.getFechafin());
            System.out.println("paso la ultima fecha");
            ps.setInt(6, o.getCantMini());
            ps.setString(7, o.getEstatus());
            ps.executeUpdate();
     } catch (Exception e) {
     }
     
     return r;
     
 }  
}
