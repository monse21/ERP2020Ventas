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
    int r;
    UnidadeTransporte UT =new UnidadeTransporte();
    
    public List listar() throws SQLException{
    String sql="select -* from UnidadesTransporte";
     List<UnidadeTransporte>lista=new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                UT.setIdUnidadTransporte(rs.getInt(1));
                UT.setPlacas(rs.getString(2));
                UT.setModelo(rs.getString(3));
                UT.setAnio(rs.getString(4));
                UT.setCapacidad(rs.getString(5));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UnidadeTransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
}
