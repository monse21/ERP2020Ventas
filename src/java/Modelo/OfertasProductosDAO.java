package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OfertasProductosDAO {
int r;
OfertasProductos OF= new OfertasProductos();
Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
public int Agregar(OfertasProductos OPD){
    
    String sql= "insert into OfertasProductos values(?,?)";  
    try {
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        ps.setInt(1, OPD.idProducto);
        ps.setInt(2, OPD.Ofertas);
        ps.executeUpdate();
    } catch (Exception e) {
        System.out.println(e);
    }
    
    return r;
}
 
public ArrayList<Ofertas> consultaGeneral(){
		ArrayList<Ofertas> lista=new ArrayList<Ofertas>();
		String sql="select idOferta,nombre from Ofertas";
		try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
			while(rs.next()){
				Ofertas c=new Ofertas();
				c.setIdOferta(rs.getInt(1));
                                c.setNombre(rs.getString(2));
				lista.add(c);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("Error:"+e.getMessage());
		}
		return lista;
	}

public ArrayList<Productos> consultaGeneralP(){
		ArrayList<Productos> lista=new ArrayList<Productos>();
		String sql="select idProducto,descripcion from Productos";
		try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
			while(rs.next()){
				Productos c=new Productos();
				c.setIdProducto(rs.getInt(1));
                                c.setDescripcion(rs.getString(2));
				lista.add(c);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("Error:"+e.getMessage());
		}
		return lista;
	}
public List listar() {
        String sql ="select * from OfertasProductos"; 
        List<OfertasProductos> lista = new ArrayList<>();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                OfertasProductos OF = new OfertasProductos();
                OF.setIdProducto(rs.getInt(1));
                OF.setOfertas(rs.getInt(2));
                lista.add(OF);               
            }
        } catch (Exception e) {
        }
        return lista;
}

    public OfertasProductos listarID( int id ) {
        String sql ="select * from OfertasProductos where idOferta="+id; 
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                OF.setIdProducto(rs.getInt(1));
                OF.setOfertas(rs.getInt(2));
            }
        } catch (Exception e) {
        }
        return OF;
}

}
