package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    UnidadeTransporte UT = new UnidadeTransporte();
    int r;

    public List listar() {
        String sql = "select IdUnidadTransporte,Marca,Placas,Modelo,Anio,Capacidad,Estatus from UnidadesTransporte where estatus='A'";
        List<UnidadeTransporte> lista = new ArrayList<>();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UT.setIdUnidadTransporte(rs.getInt(1));
                UT.setMarca(rs.getString(2));
                UT.setPlacas(rs.getString(3));
                UT.setModelo(rs.getString(4));
                UT.setAnio(rs.getString(5));
                UT.setCapacidad(rs.getString(6));
                UT.setEstatus(rs.getString(7));
                lista.add(UT);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int Agregar(UnidadeTransporte UT) {
        String sql = "insert into UnidadesTransporte (IdUnidadTransporte,Marca,Placas,Modelo,Anio,Capacidad,Estatus) values (?,?,?,?,?,?,?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, UT.getIdUnidadTransporte());
            ps.setString(2, UT.getPlacas() );
            ps.setString(3, UT.getMarca() );
            ps.setString(4, UT.getModelo() );
            ps.setString(5, UT.getAnio() );
            ps.setString(6, UT.getCapacidad() ); 
            ps.setString(3, UT.getMarca());
            ps.setString(2, UT.getPlacas());
            ps.setString(4, UT.getModelo());
            ps.setString(5, UT.getAnio());
            ps.setString(6, UT.getCapacidad());
            ps.setString(7, UT.getEstatus());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int Actualizar(UnidadeTransporte UT) {
        String sql = "Update UnidadesTransporte set Placas=?,Marca=?,Modelo=?,Anio=?,Capacidad=?,Estatus=? where idUnidadTransporte=?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, UT.getMarca() );
            ps.setString(2, UT.getPlacas() );
            ps.setString(3, UT.getModelo() );
            ps.setString(4, UT.getAnio() );
            ps.setString(5, UT.getCapacidad() );
            ps.setInt(6, UT.getIdUnidadTransporte());
            System.out.println("Estoy Actualizando" );
            ps.setInt(7, UT.getIdUnidadTransporte());
            ps.setString(1, UT.getPlacas());
            ps.setString(2, UT.getMarca());
            ps.setString(3, UT.getModelo());
            ps.setString(4, UT.getAnio());
            ps.setString(5, UT.getCapacidad());
            ps.setString(6, UT.getEstatus());            
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public UnidadeTransporte listarId(int id) {
        String sql = "select * from UnidadesTransporte where IdUnidadTransporte=" + id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UT.setIdUnidadTransporte(rs.getInt(1));
                UT.setPlacas(rs.getString(2));
                UT.setMarca(rs.getString(3));
                UT.setModelo(rs.getString(4));
                UT.setAnio(rs.getString(5));
                UT.setEstatus(rs.getString(6));
                UT.setCapacidad(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return UT;
    }

    public int ultimoID() {
        String sql = "select max(idUnidadTransporte)+1 idUnidadTransporte from UnidadesTransporte";
        int id = 1;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("idUnidadTransporte");
            }
            rs.close();

        } catch (Exception e) {
        }
        return id;
    }

    public int Eliminar(int id) {
        String sql = "Update UnidadesTransporte set estatus='I' where IdUnidadTransporte=" + id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
