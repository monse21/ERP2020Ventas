package Modelo;
public class OfertasProductos {
    int idProducto;
    int Ofertas;

    public OfertasProductos() {
    }

    public OfertasProductos(int idProducto, int Ofertas) {
        this.idProducto = idProducto;
        this.Ofertas = Ofertas;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getOfertas() {
        return Ofertas;
    }

    public void setOfertas(int Ofertas) {
        this.Ofertas = Ofertas;
    }
    
    
    
}
