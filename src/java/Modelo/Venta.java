package Modelo;

public class Venta {

    int idVenta;
    Integer item;
    String fecha;
    Integer idproducto;
    float precio;
    float totalPagar;
    float cantPagada;
    String DescripcionP;
    String comentarios;
    String estatus;
    int idCliente;
    int idEmpleado;
    Integer cantidad;
    float subtotal;
    public Venta() {
    }

    public Venta(int idVenta, Integer item, String fecha,Integer idproducto, float precio, float totalPagar, float cantPagada, String DescripcionP, String comentarios, String estatus, int idCliente, int idEmpleado) {
        this.idVenta = idVenta;
        this.item = item;
        this.fecha = fecha;
        this.idproducto = idproducto;
        this.precio = precio;
        this.totalPagar = totalPagar;
        this.cantPagada = cantPagada;
        this.DescripcionP = DescripcionP;
        this.comentarios = comentarios;
        this.estatus = estatus;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    public float getCantPagada() {
        return cantPagada;
    }

    public void setCantPagada(float cantPagada) {
        this.cantPagada = cantPagada;
    }

    public String getDescripcionP() {
        return DescripcionP;
    }

    public void setDescripcionP(String DescripcionP) {
        this.DescripcionP = DescripcionP;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

}
