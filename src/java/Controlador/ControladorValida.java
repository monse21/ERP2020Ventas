package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.UnidadeTransporte;
import Modelo.UnidadeTransporteDAO;
import config.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jaime
 */
public class ControladorValida extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorValida</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorValida at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doget");
        processRequest(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                System.out.println("do post");
                String accion = request.getParameter("accion");
                Empleado em=new Empleado();
                EmpleadoDAO edao=new EmpleadoDAO();
                UnidadeTransporte UT = new UnidadeTransporte();
                UnidadeTransporteDAO udao= new UnidadeTransporteDAO();
                Conexion cn = new Conexion();

            if (accion.equalsIgnoreCase("Ingresar")) {
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
                    try {
                        em = edao.validar(user, pass);
                        System.out.println("No hay error en la clase");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Error de la clase "+ex.getMessage());
                    }

            if (em.getEmail() != null) {
                System.out.println("El usuario no es nulo");
                switch (em.getTipo()) {
                    case "A":
                        request.setAttribute("usuario", em);
                        request.getRequestDispatcher("Controlador?menu=BienvenidoAd").forward(request, response);
                        break;
                    case "":
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        System.out.println("hola");     
                        break;
                }    
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
