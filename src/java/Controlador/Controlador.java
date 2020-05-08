/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClienteIndividual;
import Modelo.ClienteIndividualDAO;
import Modelo.Clientes;
import Modelo.ClientesDAO;
import Modelo.ClientesTienda;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.UnidadeTransporte;
import Modelo.UnidadeTransporteDAO;
import Modelo.EnvioVentas;
import Modelo.EnvioVentasDAO;
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
    Clientes cliente=new Clientes();
    ClientesDAO cdao=new ClientesDAO();
    ClienteIndividual CI =new ClienteIndividual();
    ClienteIndividualDAO cidao= new ClienteIndividualDAO();
    ClientesTienda ct=new ClientesTienda();

    EnvioVentas ev = new EnvioVentas();
    EnvioVentasDAO evdao = new EnvioVentasDAO();
    int ide;
    int idu;
    int iden;
    int idci;
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
                        idu=Integer.parseInt(request.getParameter("id"));
                        UT = udao.listarId(idu);
                        request.setAttribute("UT", UT);
                     request.getRequestDispatcher("Controlador?menu=UnidadeTransportecrud&accion=Listar").forward(request, response);     
                    break;
                    
                    case "Actualizar":
                        UT.setIdUnidadTransporte(Integer.parseInt(request.getParameter("txtIdUnidadTransporte")));
                        UT.setMarca(request.getParameter("txtMarcas"));
                        UT.setPlacas(request.getParameter("txtPlacas"));
                        UT.setModelo(request.getParameter("txtModelo"));
                        UT.setAnio(request.getParameter("txtAnio"));
                        UT.setCapacidad(request.getParameter("txtCapacidad"));
                        udao.Actualizar(UT);
                        request.getRequestDispatcher("Controlador?menu=UnidadeTransportecrud&accion=Listar").forward(request, response);
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
        if (menu.equals("clientes")) 
        {
            try {
                switch (accion) {
                    case "Listar":
                        List lista = cdao.listar();
                        //ClientesTienda c =cdao.consultarDatosClienteTienda(cliente.getIdCliente());
                        request.setAttribute("c", lista);
                        System.out.println(lista);
                        break;
                        default:
                        throw new AssertionError();
                    case "Agregar":
                        ct.setNombre(request.getParameter("nombre"));
                        ct.setContacto(request.getParameter("contacto"));
                        ct.setLimiteCredito(Float.parseFloat(request.getParameter("credito")));
                        cliente.setIdCliente(Integer.parseInt(request.getParameter("id")));
                        cliente.setDireccion(request.getParameter("direc"));
                        cliente.setCodigoPostal(request.getParameter("codigo"));
                        cliente.setRfc(request.getParameter("rfc"));
                        cliente.setTelefono(request.getParameter("tel"));
                        cliente.setEmail(request.getParameter("email"));
                        cliente.setTipo(request.getParameter("tipo") );
                        cliente.setIdCiudad(Integer.parseInt(request.getParameter("ciudad")));
                        ct.setClientes(cliente);
                        int msg=cdao.registrarClienteTienda(ct);
                          break;    
                   }
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
            } catch (Exception e) {
            }
 
        }
            if (menu.equals("EnviosVentascrud")) {
            try {
                switch (accion) {
                    case "Listar":
                        List lista = evdao.listar();
                        request.setAttribute("listar",lista);
                        System.out.println(lista);
                        break;
                        
                    case"Agregar":
                        ev.setId(Integer.parseInt(request.getParameter("txtIdEnvio")));
                        ev.setIdVenta(Integer.parseInt(request.getParameter("txtIdVenta")));
                        ev.setFechaEntregaPlaneada(request.getParameter("txtFechaEntregaPlaneada"));
                        ev.setFechaEntregaReal(request.getParameter("txtFechaEntregaReal"));
                        evdao.Agregar(ev);
                        request.getRequestDispatcher("Controlador?menu=EnviosVentascrud&accion=Listar").forward(request, response);
                    break;
                        
                    case "Editar":
                        iden=Integer.parseInt(request.getParameter("id"));
                        ev = evdao.listarId(iden);
                        request.setAttribute("ev", ev);
                     request.getRequestDispatcher("Controlador?menu=EnviosVentascrud&accion=Listar").forward(request, response);     
                    break;
                    
                    case "Actualizar":
                        ev.setId(Integer.parseInt(request.getParameter("txtIdEnvio")));
                        ev.setIdVenta(Integer.parseInt(request.getParameter("txtIdVenta")));
                        ev.setFechaEntregaPlaneada(request.getParameter("txtFechaEntregaPlaneada"));
                        ev.setFechaEntregaReal(request.getParameter("txrFechaEntregaReal"));
                        evdao.Actualizar(ev);
                        request.getRequestDispatcher("Controlador?menu=EnviosVentascrud&accion=Listar").forward(request, response);
                    break;
                    
                    case "eliminar":
                    break;
                    default:
                        throw new AssertionError();
                   }
                request.getRequestDispatcher("EnviosVentascrud.jsp").forward(request, response);
            } catch (Exception e) {
            }
    }

                if (menu.equals("clienteIndividual")) 
        {
            try {
                switch (accion) {
                    case "Listar":
                        List lista = cidao.listar();
                        request.setAttribute("listar", lista);
                        System.out.println(lista);
                        break;
                        default:
                        throw new AssertionError();
                    case "Agregar":
                        CI.setIdClienteI(Integer.parseInt(request.getParameter("txtidclientein")));
                        CI.setNombre(request.getParameter("txtnombre"));
                        CI.setApaterno(request.getParameter("txtapaterno"));
                        CI.setAmaterno(request.getParameter("txtamaterno"));
                        CI.setSexo(request.getParameter("txtsexo"));
                        cidao.Agregar(CI);
                        request.getRequestDispatcher("Controlador?menu=clienteIndividual&accion=Listar").forward(request, response);
                          break;  
                        
                     case "Editar":
                        idci=Integer.parseInt(request.getParameter("id"));
                        CI = cidao.listarId(idci);
                        System.out.println("id individual"+ idci);
                        request.setAttribute("CI", CI);
                     request.getRequestDispatcher("Controlador?menu=clienteIndividual&accion=Listar").forward(request, response);     
                    break;
                    
                    case "Actualizar":
                        CI.setIdClienteI(Integer.parseInt(request.getParameter("txtidclientein")));
                        CI.setNombre(request.getParameter("txtnombre"));
                        CI.setApaterno(request.getParameter("txtapaterno"));
                        CI.setAmaterno(request.getParameter("txtamaterno"));
                        CI.setSexo(request.getParameter("txtsexo"));
                        cidao.Actualizar(CI);
                        request.getRequestDispatcher("Controlador?menu=clienteIndividual&accion=Listar").forward(request, response);
                    break;
                   }
                request.getRequestDispatcher("ClienteIndividual.jsp").forward(request, response);
            } catch (Exception e) {
            }
 
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
