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
    Ofertas OF = new Ofertas();
    int r;
    
    public List listar() {
        String sql ="select * from Ofertas where estatus='A'"; 
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
                OF.setFechainicio(rs.getString(5));
                OF.setFechafin(rs.getString(6));
                OF.setCantMini(rs.getInt(7));
                OF.setEstatus(rs.getString(8));
                lista.add(OF);               
            }
        } catch (Exception e) {
        }
        return lista;
}
 public int agregar(Ofertas o){
        String sql ="insert into Ofertas values(?,?,?,?,?,?,?,?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, o.getIdOferta());
            ps.setString(2, o.getNombre());
            ps.setString(3, o.getDescripcion());
            ps.setFloat(4, o.getDescuento());
            ps.setString(5,  o.getFechainicio());
            ps.setString(6, o.getFechafin());
            ps.setInt(7, o.getCantMini());
            ps.setString(8, o.getEstatus());
            ps.executeUpdate();
     } catch (Exception e) {
            System.out.println(e);
     }
     return r;
 }  
 
 
 public int Actualizar (Ofertas o){
        String sql ="Update Ofertas set nombre=?,despricion=?,porDescuento=?, fechaInicio=?,fechafin=?,canMinProducto=? where idOferta=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(7, o.getIdOferta());
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getDescripcion());
            ps.setFloat(3, o.getDescuento());
            ps.setString(4,  o.getFechainicio());
            ps.setString(5, o.getFechafin());
            ps.setInt(6, o.getCantMini());
           ps.executeUpdate();
     } catch (Exception e) {
     }
     return r;
 }
 
 
 
    public Ofertas listarID( int id ) {
        String sql ="select * from Ofertas where idOferta="+id; 
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                OF.setIdOferta(rs.getInt(1));
                OF.setNombre(rs.getString(2));
                OF.setDescripcion(rs.getString(3));
                OF.setDescuento(rs.getFloat(4));
                OF.setFechainicio(rs.getString(5));
                OF.setFechafin(rs.getString(6));
                OF.setCantMini(rs.getInt(7));
                OF.setEstatus(rs.getString(8));  
            }
        } catch (Exception e) {
        }
        return OF;
}
 
        public int Eliminar (int id) {
        String sql ="Update Ofertas set estatus='I' where idOferta="+id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
 
 
   public int ultimoID() {
        String sql = "select max(idOferta)+1 idOferta from Ofertas";
        int id = 1;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("idOferta");
            }
            rs.close();

        } catch (Exception e) {
        }
        return id;
    }
}
