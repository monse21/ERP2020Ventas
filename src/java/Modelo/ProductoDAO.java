package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Productos buscar(int id) {
         Productos p=new Productos();
        String sql = "select * from Productos where idProducto="+id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPuntoReorden(rs.getInt(4));
                p.setGenero(rs.getString(5));
                p.setPrecioCompra(rs.getFloat(6));
                p.setPrecioVenta(rs.getFloat(7));
                p.setEstatus(rs.getString(8));
                p.setMaterial(rs.getString(9));
                p.setIdMarca(rs.getInt(10));
                p.setIdEstilo(rs.getInt(11));
                p.setIdCategoria(rs.getInt(12));
            }
        } catch (Exception e) {
        }

        return p;
    }
}
