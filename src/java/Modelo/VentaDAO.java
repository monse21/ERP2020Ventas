package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String idVentas() {
        String idVentas = "";
        String sql = "select max(idVenta) from ventas";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idVentas = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idVentas;
    }

    public int guardarVenta(Venta ve) {
        String sql = "insert into ventas(idVenta,fecha,totalPagar,cantPagada,comentarios,estatus,idCliente,idEmpleado)values(?,?,?,?,?,?,?,?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdVenta());
            ps.setString(2, ve.getFecha());
            ps.setFloat(3, ve.getTotalPagar());
            ps.setFloat(4, ve.getCantPagada());
            ps.setString(5, ve.getComentarios());
            ps.setString(6, ve.getEstatus());
            ps.setInt(7, ve.getIdCliente());
            ps.setInt(8, ve.getIdEmpleado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int guardarDetalleVentas(Venta venta) {
        String sql = "insert into VentasDetalle(precioUnitario,cantidad,subtotal,idVenta,idProductoDetalle)values(?,?,?,?,?,?) ";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setFloat(1, venta.getTotalPagar());
            ps.executeUpdate();
        } catch (Exception e) {
        }

        return r;
    }

}
