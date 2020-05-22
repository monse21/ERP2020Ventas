package Modelo;

/**
 *
 * @author Jaime
 */
public class Productos {
int idProducto;
String nombre;
String descripcion;
int PuntoReorden;
String genero;
float precion;
float precioCompra;
float precioVenta;
String estatus;
String material;
int idMarca;
int idEstilo;
int idCategoria;

    public Productos() {
    }

    public Productos(int idProducto, String nombre, String descripcion, int PuntoReorden, String genero, float precion, float precioCompra, float precioVenta, String estatus, String material, int idMarca, int idEstilo, int idCategoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.PuntoReorden = PuntoReorden;
        this.genero = genero;
        this.precion = precion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.estatus = estatus;
        this.material = material;
        this.idMarca = idMarca;
        this.idEstilo = idEstilo;
        this.idCategoria = idCategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntoReorden() {
        return PuntoReorden;
    }

    public void setPuntoReorden(int PuntoReorden) {
        this.PuntoReorden = PuntoReorden;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPrecion() {
        return precion;
    }

    public void setPrecion(float precion) {
        this.precion = precion;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }


}
