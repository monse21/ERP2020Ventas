/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.UnidadeTransporte;
import Modelo.UnidadeTransporteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jaime
 */
public class Controlador extends HttpServlet {
    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    UnidadeTransporte UT = new UnidadeTransporte();
    UnidadeTransporteDAO udao= new UnidadeTransporteDAO();
    int ide;
    int idu;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String menu = request.getParameter("menu");
            String accion = request.getParameter("accion");
    
     if (menu.equals("BienvenidoAd")) {
            request.getRequestDispatcher("BienvenidoAd.jsp").forward(request, response);
        }
     
     if (menu.equals("Empleadocrud")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("listar",lista);
                    System.out.println(lista);
                    break;
                    default:
                    throw new AssertionError();
                case"Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
            }
             request.getRequestDispatcher("Empleadocrud.jsp").forward(request, response);
    }
     
     if (menu.equals("UnidadeTransportecrud")) {
            try {
                switch (accion) {
                    case "Listar":
                        List lista = udao.listar();
                        request.setAttribute("listar",lista);
                        System.out.println(lista);
                        break;
                        
                    case"Agregar":
                        
                        UT.setIdUnidadTransporte(Integer.parseInt(request.getParameter("txtIdUnidadTransporte")));
                        UT.setMarca(request.getParameter("txtMarcas"));
                        UT.setPlacas(request.getParameter("txtPlacas"));
                        UT.setModelo(request.getParameter("txtModelo"));
                        UT.setAnio(request.getParameter("txtAnio"));
                        UT.setCapacidad(request.getParameter("txtCapacidad"));
                        udao.Agregar(UT);
                        request.getRequestDispatcher("Controlador?menu=UnidadeTransportecrud&accion=Listar").forward(request, response);
                    break;
                        
                    case "Editar":
                    break;
                    case "eliminar":
                    break;
                    default:
                        throw new AssertionError();
                   }
                request.getRequestDispatcher("UnidadeTransportecrud.jsp").forward(request, response);
            } catch (Exception e) {
            }
    }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
