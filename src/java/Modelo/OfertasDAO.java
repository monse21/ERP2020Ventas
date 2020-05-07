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
}
