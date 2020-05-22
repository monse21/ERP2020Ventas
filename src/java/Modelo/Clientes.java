package Modelo;

/**
 *
 * @author Jaime
 */
public class Clientes {
    int idCliente;
    String direccion;
    String codigoPostal;
    String rfc;
    String telefono;
    String email;
    String tipo;
    String estatus;
    int idCiudad;

    public Clientes() {
    }

    public Clientes(int idCliente, String direccion, String codigoPostal, String rfc, String telefono, String email, String tipo, int idCiudad,String estatus) {
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.rfc = rfc;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;
        this.idCiudad = idCiudad;
        this.estatus=estatus;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
    
}
