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
public class ClientesDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ClientesTienda CT = new ClientesTienda();
    Clientes cliente = new Clientes();
               
    int r;

    public List listar() {
        String sql = "select c.idCliente,ct.nombre,c.dirección,c.codigoPostal,c.idCiudad,c.rfc,c.telefono,c.email,ct.contacto,ct.limiteCredito,c.tipo,c.estatus from ClienteTienda ct join Clientes c on ct.idCliente=c.idCliente where estatus='A'";
        List<ClientesTienda> lista = new ArrayList<>();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                CT.setNombre(rs.getString(2));
                cliente.setDireccion(rs.getString(3));
                cliente.setCodigoPostal(rs.getString(4));
                cliente.setIdCiudad(rs.getInt(5));
                cliente.setRfc(rs.getString(6));
                cliente.setTelefono(rs.getString(7));
                cliente.setEmail(rs.getString(8));
                CT.setContacto(rs.getString(9));
                CT.setLimiteCredito(rs.getFloat(10));
                cliente.setTipo(rs.getString(11));
                cliente.setEstatus(rs.getString(12));
                CT.setClientes(cliente);
                lista.add(CT);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int Agregar (ClientesTienda CT) {
        String sql = "execute Agregar_CT ?,?,?,?,?,?,?,?,?,?,?,?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, CT.getClientes().getIdCliente() );
            ps.setString(2, CT.getNombre());
            ps.setString(3, CT.getClientes().getDireccion());
            ps.setString(4, CT.getClientes().getCodigoPostal());
            ps.setInt(5,  CT.getClientes().getIdCiudad());
            ps.setString(6, CT.getClientes().getRfc());
            ps.setString(7, CT.getClientes().getTelefono());
            ps.setString(8, CT.getClientes().getEmail());
            ps.setString(9, CT.getContacto());
            ps.setFloat(10, CT.getLimiteCredito());
            ps.setString(11, CT.getClientes().getTipo() );
            ps.setString(12, CT.getClientes().getEstatus());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return r;

    }
    
    public int Actualizar (ClientesTienda CT) {
        String sql = "execute Actualizar_CT ?,?,?,?,?,?,?,?,?,?,?,?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, CT.getClientes().getIdCliente() );
            ps.setString(2, CT.getNombre());
            ps.setString(3, CT.getClientes().getDireccion());
            ps.setString(4, CT.getClientes().getCodigoPostal());
            ps.setInt(5, CT.getClientes().getIdCiudad());
            ps.setString(6, CT.getClientes().getRfc());
            ps.setString(7, CT.getClientes().getTelefono());
            ps.setString(8, CT.getClientes().getEmail());
            ps.setString(9, CT.getContacto());
            ps.setFloat(10, CT.getLimiteCredito());
            ps.setString(11, CT.getClientes().getTipo() );
            ps.setString(12, CT.getClientes().getEstatus());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
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
   
    
    public ClientesTienda listarID(int id) {
        String sql = "select c.idCliente,ct.nombre,c.dirección,c.codigoPostal,c.idCiudad,c.rfc"
                + ",c.telefono,c.email,ct.contacto,ct.limiteCredito,c.tipo,c.estatus from"
                + " ClienteTienda ct join Clientes c on ct.idCliente=c.idCliente where estatus='A' and c.idCliente="+id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                CT.setNombre(rs.getString(2));
                cliente.setDireccion(rs.getString(3));
                cliente.setCodigoPostal(rs.getString(4));
                cliente.setIdCiudad(rs.getInt(5));
                cliente.setRfc(rs.getString(6));
                cliente.setTelefono(rs.getString(7));
                cliente.setEmail(rs.getString(8));
                CT.setContacto(rs.getString(9));
                CT.setLimiteCredito(rs.getFloat(10));
                cliente.setTipo(rs.getString(11));
                cliente.setEstatus(rs.getString(12));
                CT.setClientes(cliente);
            }
        } catch (Exception e) {
        }
        return CT;
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

}
