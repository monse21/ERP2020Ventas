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
    

public Empleado validar(String email,String contrasena) throws ClassNotFoundException{
    Empleado em= new Empleado();
    String sql = "select idEmpleado,nombre,apaterno,amaterno,sexo,tipo,email,contrasena from Empleado where email='"+email+"' and contrasena='"+contrasena+"';";
    con=Conexion.conectar();
    try {
            rs = cn.consultar(sql);
            while (rs.next()) {            
            em.setId(rs.getInt("idEmpleado"));
            em.setNombre(rs.getString("nombre"));
            em.setPaterno(rs.getString("apaterno"));
            em.setMaterno(rs.getString("amaterno"));
            em.setSexo(rs.getString("sexo"));
            em.setTipo(rs.getString("tipo"));
            em.setEmail(rs.getString("email"));
            em.setContra(rs.getString("contrasena"));
           
        }
    } catch (Exception e) {
        System.out.println("eror: "+e.getMessage());
    }
    return em;
}
public List listar(){
         String sql = "select idEmpleado,nombre,apaterno,amaterno,tipo,sexo,email,contrasena,estatus from Empleado";
         List<Empleado>lista=new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
            Empleado em=new Empleado();
            em.setId(rs.getInt("idEmpleado"));
            em.setNombre(rs.getString("nombre"));
            em.setPaterno(rs.getString("apaterno"));
            em.setMaterno(rs.getString("amaterno"));
            em.setSexo(rs.getString("sexo"));
            em.setTipo(rs.getString("tipo"));
            em.setEmail(rs.getString("email"));
            em.setContra(rs.getString("contrasena"));
            em.setEstatus(rs.getString("estatus"));
            lista.add(em);
            }
        } catch (Exception e) {
        }
        System.out.println(lista);
        return lista;
    }
}
