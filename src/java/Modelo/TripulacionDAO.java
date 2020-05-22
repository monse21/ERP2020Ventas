package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Empleado;
import Modelo.Envios;
/**
 *
 * @author DELL
 */
public class TripulacionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Tripulacion T = new Tripulacion();
    Empleado em= new Empleado();
    Envios en= new Envios();
    int r;
    
     public List listar() {
        String sql ="select * from Tripulacion"; 
        List<Tripulacion> lista = new ArrayList<>();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt(1));
                en.setIdEnvio(rs.getInt(2));
                T.setRol(rs.getString(3));
                T.setEmpleado(em);
                T.setEnvio(en);
                lista.add(T);    
            }
        } catch (Exception e) {
        }
        return lista;
}
     
     public int Agregar(Tripulacion T){
     String sql="insert into Tripulacion values ?,?,?";
            try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, T.getEmpleado().getId());
            ps.setInt(2, T.getEnvio().getIdEnvio());
            ps.setString(3, T.getRol());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
     }
     
     public int Actualizar (Tripulacion T){
        String sql ="Update Tripulacion set idEmpleado=?,idEnvio=?,rol=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, T.getEmpleado().getId());
            ps.setInt(2, T.getEnvio().getIdEnvio());
            ps.setString(3, T.getRol());
            ps.executeUpdate();
     } catch (Exception e) {
     }
     return r;
 }
     
     public Tripulacion listarID( int id ) {
        String sql ="select * from Tripulacion where idEmpleado="+id; 
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt(1));
                en.setIdEnvio(rs.getInt(2));
                T.setRol(rs.getString(3));
                T.setEmpleado(em);
                T.setEnvio(en);
            }
        } catch (Exception e) {
        }
        return T;
}
    
}
