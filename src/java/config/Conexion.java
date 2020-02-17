/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Statement;

public class Conexion {

    private java.sql.Connection connection = null;
    private final String url = "jdbc:sqlserver://";
    private final String serverName = "DESKTOP-F9UQSAA\\SQLEXPRESS";
    private final String portNumber = "1433";
    private final String databaseName = "ERP2020";
    private final String userName = "sa";
    private final String password = "sa";
    private final String statement = "select * from clientes;";
    // Informs the driver to use server a side-cursor,
    // which permits more than one active statement
    // on a connection.
    //private final String selectMethod = "Direct";

    // Constructor
    public Conexion() {
    }

    private String getConnectionUrl() {
        return url + serverName + ":" + portNumber + ";databaseName=" + databaseName + ";";//+"selectMethod="+ selectMethod + ";";
    }

    public java.sql.Connection getConnection() {
        try {
            Class.forName("Microsoft SQL Server 2005");
            connection = java.sql.DriverManager.getConnection(getConnectionUrl(),
                    userName, password);
            if (connection != null) {
                System.out.println("Connection Successful!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Trace in getConnection() : " + e.getMessage());
        }
        return connection;
    }

    /*
  * Display the driver properties, database details
     */
    public void displayDbProperties() {
        java.sql.DatabaseMetaData dm = null;
        java.sql.ResultSet result = null;
        try {
            connection = this.getConnection();
            if (connection != null) {
                dm = connection.getMetaData();
                System.out.println("Driver Information");
                System.out.println("\tDriver Name: " + dm.getDriverName());
                System.out
                        .println("\tDriver Version: " + dm.getDriverVersion());
                System.out.println("\nDatabase Information ");
                System.out.println("\tDatabase Name: " + dm.getDatabaseProductName());
                System.out.println("\tDatabase Version: " + dm.getDatabaseProductVersion());

                Statement select = connection.createStatement();
                result = select.executeQuery(statement);

                while (result.next()) {
                    System.out.println("Nombre: " + result.getString(1) + "\n");
                    System.out.println("Apellido: " + result.getString(2) + "\n");
                    System.out.println("Dni: " + result.getString(3) + "\n");
                }
                result.close();
                result = null;
                closeConnection();
            } else {
                System.out.println("Error: No active Connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dm = null;
    }

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
}
