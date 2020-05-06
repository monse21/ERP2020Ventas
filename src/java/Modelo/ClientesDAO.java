
package Modelo;

import config.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime
 */
public class ClientesDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ClientesTienda CT=new ClientesTienda();
    Clientes c1=new Clientes();
    int r;
        public ClientesTienda consultarDatosClienteTienda(int idCliente) {
    String sql="select UT.idCliente,UT.nombre,UT.contacto,UT.limiteCredito"+
            "c.dirección,c.codigoPostal,c.rfc,c.telefono,c.email,c.tipo"+
            "from ClientesTienda UT on UT.idCliente=c.idCliente"+
            "";
    ClientesTienda UT =new ClientesTienda();
        try {
            con=Conexion.conectar();
            ps.setInt(1, idCliente);
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                
                UT.setNombre(rs.getString("nombre"));
                UT.setContacto(rs.getString("contacto"));
                UT.setLimiteCredito(rs.getFloat("limiteCredito"));
                Clientes c=new Clientes();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setDireccion(rs.getString("dirección"));
                c.setCodigoPostal(rs.getString("codigoPostal"));
                c.setRfc(rs.getString("rfc"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setTipo(rs.getString("tipo"));
                c.setIdCiudad(rs.getInt("idCiudad"));
             
            }
        } catch (Exception e) {
        }
            System.out.println(UT);
        return UT;
            
        
    }
public List listar() {
    String sql="select * from Clientes";
     List <Clientes> lista =new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                ClientesTienda UT =new ClientesTienda();
                Clientes c=new Clientes();
                //UT.setClientes((Clientes) rs.getObject(c.getIdCliente()));
                
                c.setIdCliente(rs.getInt("idCliente"));
                c.setDireccion(rs.getString("dirección"));
                c.setCodigoPostal(rs.getString("codigoPostal"));
                c.setRfc(rs.getString("rfc"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setTipo(rs.getString("tipo"));
                c.setIdCiudad(rs.getInt("idCiudad"));
                lista.add(c);
            }
        } catch (Exception e) {
        }
        return lista;
    }
        
     public int registrarClienteTienda(ClientesTienda CT){
        String sql="{call Agregar_CT(?,?,?,?,?,?,?,?,?,?,?)}";
        String salida="Error";
         try {
             System.out.println("paso");
            con=Conexion.conectar();
            CallableStatement sp=con.prepareCall(sql);
            //CallableStatement sp=Conexion.conectar().prepareCall(sql);}
             System.out.println("no pasa de aqui");
            sp.setInt(1, CT.getClientes().getIdCliente());
             System.out.println("paso el id");
             sp.setString(2,CT.getClientes().getDireccion());
             System.out.println("paso direcccion");
             sp.setString(3,CT.getClientes().getCodigoPostal());
             System.out.println("paso el postal");
             sp.setString(4, CT.getClientes().getRfc());
             sp.setString(5, CT.getClientes().getTelefono());
             sp.setString(6, CT.getClientes().getEmail());
             sp.setString(7, CT.getClientes().getTipo());
             sp.setInt(8, CT.getClientes().getIdCiudad());
             sp.setString(9, CT.getNombre());
             sp.setString(10, CT.getContacto());
             sp.setFloat(11, CT.getLimiteCredito());
	     sp.execute();
             System.out.println("jeceuto");
         } catch (Exception e) {
             System.out.println("Error:"+e.getMessage());
         }
         return r;
         
     }
     
     //////////////////////////////////////////////////////////////////
        public String clienteCrdito(int idCity) throws ClassNotFoundException, SQLException {
        String credito="";
        String sql=("select*from ClienteTienda where idCliente=?;");
        try {
            
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idCity));
            rs=ps.executeQuery();
            while(rs.next()){
                credito=rs.getString("limiteCredito");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return credito;
    }
        public String clienteI(int idCity) throws ClassNotFoundException {
        String nombre="";
        String sql=("select*from ClienteTienda where idCliente=?;");
        try {
            
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idCity));
            rs=ps.executeQuery();
            while(rs.next()){
                nombre=rs.getString("nombre");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }
     public String clienteConta(int idCity) throws ClassNotFoundException {
        String credito="";
        String sql=("select*from ClienteTienda where idCliente=?;");
        try {
            
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idCity));
            rs=ps.executeQuery();
            while(rs.next()){
                credito=rs.getString("contacto");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return credito;
        
    }   

        
}
