/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
private static Connection connection;
private static String url="jdbc:sqlserver://DESKTOP-F9UQSAA\\SQLEXPRESS:1433;databaseName=ERP2020";
private static String userName="sa";
private static String password="sa";
    public static Connection conectar() throws ClassNotFoundException{
        
        System.out.println("Se esta tratando de conectar a bd");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection=DriverManager.getConnection(url,"sa","sa");
            System.out.println("conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Conexion no establecida ... \n"+e.getMessage());
        }
        return connection;
    }
    public static Connection conectar(String user,String pwd) throws ClassNotFoundException{
        String url="jdbc:sqlserver://localhost:1433;databaseName=ERP2020";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection=DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Conexion no establecida ... \n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
    public void desconectar(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("No existia una conexion a SQL que cerrar");
        }
    }
    public void ejecutar(String sql) throws ClassNotFoundException{
        Connection con= conectar();
        Statement declara;
        try {
            declara=con.createStatement();
            ResultSet respuesta=declara.executeQuery(sql);
            desconectar();
        } catch (SQLException e) {
            System.out.println("Conexion no establecida ... \n"+e.getMessage());
        }
    }
    public ResultSet consultar(String sql) throws ClassNotFoundException{
        Connection con= conectar();
        Statement declara;
        try {
            declara=con.createStatement();
            ResultSet respuesta=declara.executeQuery(sql);
            return respuesta;
        } catch (SQLException e) {
            System.out.println("Conexion no establecida ... \n"+e.getMessage());
        }
        return null;
    }
//    public void displayDbProperties() {
//        java.sql.DatabaseMetaData dm = null;
//        java.sql.ResultSet result = null;
//        try {
//            connection = this.getConnection();
//            if (connection != null) {
//                dm = connection.getMetaData();
//                System.out.println("Driver Information");
//                System.out.println("\tDriver Name: " + dm.getDriverName());
//                System.out
//                        .println("\tDriver Version: " + dm.getDriverVersion());
//                System.out.println("\nDatabase Information ");
//                System.out.println("\tDatabase Name: " + dm.getDatabaseProductName());
//                System.out.println("\tDatabase Version: " + dm.getDatabaseProductVersion());
//
//                Statement select = connection.createStatement();
//                result = select.executeQuery(statement);
//
//                while (result.next()) {
//                    System.out.println("Nombre: " + result.getString(1) + "\n");
//                    System.out.println("Apellido: " + result.getString(2) + "\n");
//                    System.out.println("Dni: " + result.getString(3) + "\n");
//                }
//                result.close();
//                result = null;
//                closeConnection();
//            } else {
//                System.out.println("Error: No active Connection");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        dm = null;
//    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            connection = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public String logueo(String email, String contrasena) throws ClassNotFoundException{
        Connection con;
         System.out.println("Estas en el logueo ----------");
        PreparedStatement ps;
        ResultSet rs;
        String idPerfil = "";
        String sql="select tipo from Empleado where email='"+email+"'and contrasena='"+contrasena+"'";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("yes");
            while (rs.next()) {                
                idPerfil= rs.getString('A');
            }
        } catch (SQLException e) {
            System.out.println("nel"+e);
        }
        return idPerfil;
    }
}
