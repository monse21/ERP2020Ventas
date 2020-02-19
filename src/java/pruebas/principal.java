/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import Modelo.EmpleadoDAO;
import config.Conexion;

/**
 *
 * @author Jaime
 */
public class principal {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Conexion cn = new Conexion();
        cn.consultar("select * from Empleado;");
        EmpleadoDAO edao= new EmpleadoDAO();
        edao.validar("jreyes@gmail.com", "123");
    }
}
