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
public class EmpleadoDAO {
 Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

public Empleado validar(String email,String contrasena) throws ClassNotFoundException{
    Empleado em= new Empleado();
    String sql = "select * from Empleado where email='"+email+"' and contrasena='"+contrasena+"';";
    con=Conexion.conectar();
    try {
            rs = cn.consultar(sql);
            while (rs.next()) {            
            em.setId(rs.getInt(1));
            em.setNombre(rs.getString(2));
            em.setPaterno(rs.getString(3));
            em.setMaterno(rs.getString(4));
            em.setSexo(rs.getString(5));
            em.setTipo(rs.getString(6));
            em.setEmail(rs.getString(7));
            em.setContra(rs.getString(8));
        }
    } catch (Exception e) {
        System.out.println("eror: "+e.getMessage());
    }
    return em;
}
public List listar(){
        String sql="select * from Empleado";
        List<Empleado>lista=new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
            Empleado em=new Empleado();
            em.setId(rs.getInt(1));
            em.setNombre(rs.getString(2));
            em.setPaterno(rs.getString(3));
            em.setMaterno(rs.getString(4));
            em.setSexo(rs.getString(5));
            em.setTipo(rs.getString(6));
            em.setEmail(rs.getString(7));
            em.setContra(rs.getString(8));
                lista.add(em);
            }
        } catch (Exception e) {
        }
        System.out.println(lista);
        return lista;
    }
}
