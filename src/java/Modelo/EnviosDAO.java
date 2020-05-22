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
public class EnviosDAO {
 Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Envios en =new Envios();
    Empleado e=new Empleado();
    UnidadeTransporte u = new UnidadeTransporte();
    Tripulacion t =new Tripulacion();
   public List listar() {
        String sql = "select e.idEmpleado,e.nombre,e.apaterno,e.amaterno,t.rol,en.idEnvio,en.fechaSalida,u.idUnidadTransporte,u.placas from Empleado e join Tripulacion t on e.idEmpleado=t.idEmpleado"
+"join Envios en on t.idEmpleado=en.idEnvio"+
"join UnidadesTransporte u on en.idUnidadTransporte=u.idUnidadTransporte"; 
        List<Tripulacion> lista = new ArrayList<>();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setPaterno(rs.getString(3));
                e.setMaterno(rs.getString(4));
                t.setRol(rs.getString(5));
                en.setIdEnvio(rs.getInt(6));
                en.setFechaSalida(rs.getString(7));
                u.setIdUnidadTransporte(rs.getInt(8));
                u.setPlacas(rs.getString(9));
                t.setEnvio(en);
                t.setEmpleado(e);
                lista.add(t);                       
            }
        } catch (Exception e) {
        }
        return lista;
    } 
    
}
