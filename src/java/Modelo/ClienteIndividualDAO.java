package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Clientes;
/**
 *
 * @author DELL
 */
public class ClienteIndividualDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ClienteIndividual CI = new ClienteIndividual();
    Clientes cliente= new Clientes();
    int r;

    public List listar() {
        String sql = "select c.idCliente,cl.nombre,cl.apaterno,cl.amaterno,cl.sexo,c.dirección,c.codigoPostal,c.idCiudad,c.rfc,c.telefono,"
                       + "c.email,c.tipo,c.estatus from ClienteIndividual cl join Clientes c on cl.idCliente=c.idCliente where estatus='A'";
        List<ClienteIndividual> lista = new ArrayList<>();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                CI.setNombre(rs.getString(2));
                CI.setApaterno(rs.getString(3));
                CI.setAmaterno(rs.getString(4));
                CI.setSexo(rs.getString(5));
                cliente.setDireccion(rs.getString(6));
                cliente.setCodigoPostal(rs.getString(7));
                cliente.setIdCiudad(rs.getInt(8));
                cliente.setRfc(rs.getString(9));
                cliente.setTelefono(rs.getString(10));
                cliente.setEmail(rs.getString(11));
                cliente.setTipo(rs.getString(12));
                cliente.setEstatus(rs.getString(12));
                CI.setCliente(cliente);                
                lista.add(CI);                       
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int Agregar(ClienteIndividual CI) {
        String sql = "execute Agregar_CI ?,?,?,?,?,?,?,?,?,?,?,?,?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, CI.getCliente().getIdCliente());
            ps.setString(2, CI.getNombre());
            ps.setString(3, CI.getApaterno());
            ps.setString(4, CI.getAmaterno());
            ps.setString(5, CI.getSexo());
            ps.setString(6, CI.getCliente().getDireccion());
            ps.setString(7, CI.getCliente().getCodigoPostal());
            ps.setInt(8, CI.getCliente().getIdCiudad());
            ps.setString(9, CI.getCliente().getRfc());
            ps.setString(10, CI.getCliente().getTelefono());
            ps.setString(11, CI.getCliente().getEmail());
            ps.setString(12, CI.getCliente().getTipo());
            ps.setString(13, CI.getCliente().getEstatus());         
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int Actualizar(ClienteIndividual CI) {
        String sql ="execute Actualizar_CI ?,?,?,?,?,?,?,?,?,?,?,?,?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, CI.getCliente().getIdCliente());
            ps.setString(2, CI.getNombre());
            ps.setString(3, CI.getApaterno());
            ps.setString(4, CI.getAmaterno());
            ps.setString(5, CI.getSexo());
            ps.setString(6, CI.getCliente().getDireccion());
            ps.setString(7, CI.getCliente().getCodigoPostal());
            ps.setInt(8, CI.getCliente().getIdCiudad());
            ps.setString(9, CI.getCliente().getRfc());
            ps.setString(10, CI.getCliente().getTelefono());
            ps.setString(11, CI.getCliente().getEmail());
            ps.setString(12, CI.getCliente().getTipo());
            ps.setString(13, CI.getCliente().getEstatus());         
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

       public int Eliminar (int id) {
        String sql ="Update Clientes set estatus='I' where idCliente="+id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public ClienteIndividual listarId(int id) {
        String sql = "select c.idCliente,cl.nombre,cl.apaterno,cl.amaterno,cl.sexo,c.dirección,c.codigoPostal,c.idCiudad,c.rfc,\n" +
"c.telefono,c.email,c.tipo,c.estatus from ClienteIndividual cl join Clientes c on cl.idCliente=c.idCliente where c.idCliente=" + id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                CI.setNombre(rs.getString(2));
                CI.setApaterno(rs.getString(3));
                CI.setAmaterno(rs.getString(4));
                CI.setSexo(rs.getString(5));
                cliente.setDireccion(rs.getString(6));
                cliente.setCodigoPostal(rs.getString(7));
                cliente.setIdCiudad(rs.getInt(8));
                cliente.setRfc(rs.getString(9));
                cliente.setTelefono(rs.getString(10));
                cliente.setEmail(rs.getString(11));
                cliente.setTipo(rs.getString(12));
                cliente.setEstatus(rs.getString(12));
                CI.setCliente(cliente);                
            }
        } catch (Exception e) {
        }
        return CI;
    }

    public int ultimoID() {
        String sql = "select max(idCliente)+1 idCliente from Clientes";
        int id = 1;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("idCliente");
            }
            rs.close();

        } catch (Exception e) {
        }
        return id;
    }
    
 public ClienteIndividual buscar(String rfc){
        //Clientes c=new Clientes();
        String sql="select ct.nombre,c.rfc from ClienteTienda ct join Clientes c on ct.idCliente=c.idCliente where rfc="+rfc;
        try {
            con = Conexion.conectar();
            System.out.println("paso el conectar");
            ps = con.prepareStatement(sql);
            System.out.println("pasoe le sql");
            rs = ps.executeQuery();
            System.out.println("pasoe le query");
            while (rs.next()) {
                System.out.println("entro al wgile");
                CI.setNombre(rs.getString(1));
                System.out.println("paso el 1");
                cliente.setRfc(rs.getString(2));
                System.out.println("paso el 2");
                CI.setCliente(cliente);                
            }
        } catch (Exception e) {
        }
        return CI;
    }   
}
    