package Controlador;

import Modelo.ClienteIndividual;
import Modelo.ClienteIndividualDAO;
import Modelo.Clientes;
import Modelo.ClientesDAO;
import Modelo.ClientesTienda;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Envios;
import Modelo.EnviosDAO;
import Modelo.Ofertas;
import Modelo.OfertasDAO;
import Modelo.Tripulacion;
import Modelo.UnidadeTransporte;
import Modelo.UnidadeTransporteDAO;
import java.io.IOException;
import java.util.ArrayList;
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
    UnidadeTransporteDAO udao = new UnidadeTransporteDAO();
    Clientes cliente = new Clientes();
    ClientesDAO ctdao = new ClientesDAO();
    ClienteIndividual CI = new ClienteIndividual();
    ClienteIndividualDAO cidao = new ClienteIndividualDAO();
    ClientesTienda CT = new ClientesTienda();
    Ofertas of = new Ofertas();
    OfertasDAO ofdao = new OfertasDAO();
    Envios env=new Envios();
    EnviosDAO envdao= new EnviosDAO();
    Tripulacion t =new Tripulacion();
    
    int ide, idu, idci;

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
                    request.setAttribute("listar", lista);
                    System.out.println(lista);
                    break;
                default:
                    throw new AssertionError();
                case "Editar":
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
                        request.setAttribute("listar", lista);
                        System.out.println(lista);
                        break;
                    case "Agregar":

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
                        idu = Integer.parseInt(request.getParameter("id"));
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
        if (menu.equals("clientes")) {
            try {
                switch (accion) {
                    case "Listar":
                        List lista = ctdao.listar();
                        request.setAttribute("listar", lista);
                        System.out.println(lista);
                        break;
                    case "Agregar":
                        cliente.setIdCliente(ctdao.ultimoID());
                        CT.setNombre(request.getParameter("txtnombre"));
                        cliente.setDireccion(request.getParameter("txtdir"));
                        cliente.setCodigoPostal(request.getParameter("txtcodigo"));
                        cliente.setIdCiudad(Integer.parseInt(request.getParameter("txtciudad")));
                        cliente.setRfc(request.getParameter("txtrfc"));
                        cliente.setTelefono(request.getParameter("txttel"));
                        cliente.setEmail(request.getParameter("txtemail"));
                        CT.setContacto(request.getParameter("txtcontacto"));
                        CT.setLimiteCredito(Float.parseFloat(request.getParameter("txtcredito")));
                        cliente.setTipo("CT");
                        cliente.setEstatus("A");
                        CT.setClientes(cliente);
                        ctdao.Agregar(CT);
                        request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        CT.setNombre(request.getParameter("txtnombre"));
                        cliente.setDireccion(request.getParameter("txtdir"));
                        cliente.setCodigoPostal(request.getParameter("txtcodigo"));
                        cliente.setIdCiudad(Integer.parseInt(request.getParameter("txtciudad")));
                        cliente.setRfc(request.getParameter("txtrfc"));
                        cliente.setTelefono(request.getParameter("txttel"));
                        cliente.setEmail(request.getParameter("txtemail"));
                        CT.setContacto(request.getParameter("txtcontacto"));
                        CT.setLimiteCredito(Float.parseFloat(request.getParameter("txtcredito")));
                        cliente.setTipo("CT");
                        cliente.setEstatus("A");
                        ctdao.Actualizar(CT);
                        request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                        CT = ctdao.listarID(Integer.parseInt(request.getParameter("id")));
                        request.setAttribute("CT", CT);
                        request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                        break;

                    case "Delete":
                        ctdao.Eliminar(Integer.parseInt(request.getParameter("id")));
                        request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                        break;
                }
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
            } catch (Exception e) {
            }

        }
        if (menu.equals("clienteIndividual")) {
            try {
                switch (accion) {
                        case "Listar":
                        List lista = cidao.listar();
                        request.setAttribute("listar", lista);
                        break;

                    case "Agregar":
                        cliente.setIdCliente(cidao.ultimoID());
                        CI.setNombre(request.getParameter("txtnombre"));
                        CI.setApaterno(request.getParameter("txtapaterno"));
                        CI.setAmaterno(request.getParameter("txtamaterno"));
                        CI.setSexo(request.getParameter("txtsexo"));
                        cliente.setDireccion(request.getParameter("txtdir"));
                        cliente.setCodigoPostal(request.getParameter("txtcp"));
                        cliente.setIdCiudad(Integer.parseInt(request.getParameter("txtciudad")));
                        cliente.setRfc(request.getParameter("txtrfc"));
                        cliente.setTelefono(request.getParameter("txttel"));
                        cliente.setEmail(request.getParameter("txtemail"));
                        cliente.setTipo(request.getParameter("T"));
                        cliente.setEstatus(request.getParameter("A"));
                        CI.setCliente(cliente);
                        cidao.Agregar(CI);
                        request.getRequestDispatcher("Controlador?menu=clienteIndividual&accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                        CI = cidao.listarId(Integer.parseInt(request.getParameter("id")));
                        request.setAttribute("CI", CI);
                        request.getRequestDispatcher("Controlador?menu=clienteIndividual&accion=Listar").forward(request, response);
                        break;

                    case "Actualizar":
                        CI.setNombre(request.getParameter("txtnombre"));
                        CI.setApaterno(request.getParameter("txtapaterno"));
                        CI.setAmaterno(request.getParameter("txtamaterno"));
                        CI.setSexo(request.getParameter("txtsexo"));
                        cliente.setDireccion(request.getParameter("txtdir"));
                        cliente.setCodigoPostal(request.getParameter("txtcp"));
                        cliente.setIdCiudad(Integer.parseInt(request.getParameter("txtciudad")));
                        cliente.setRfc(request.getParameter("txtrfc"));
                        cliente.setTelefono(request.getParameter("txttel"));
                        cliente.setEmail(request.getParameter("txtemail"));
                        cliente.setTipo(request.getParameter("T"));
                        cliente.setEstatus(request.getParameter("A"));
                        cidao.Actualizar(CI);
                        request.getRequestDispatcher("Controlador?menu=clienteIndividual&accion=Listar").forward(request, response);
                        break;  
                    
                    
                    case "Delete":
                        cidao.Eliminar(Integer.parseInt(request.getParameter("id")));
                        request.getRequestDispatcher("Controlador?menu=clienteIndividual&accion=Listar").forward(request, response);
                        break;
                }
                request.getRequestDispatcher("ClienteIndividual.jsp").forward(request, response);
            } catch (Exception e) {
            }

        }
        if (menu.equals("Ofertas")) {
            try {
                switch (accion) {
                    case "Listar":
                        List lista = ofdao.listar();
                        request.setAttribute("listar", lista);
                        System.out.println(lista);
                        break;
                    
                    case "Agregar":
                        of.setIdOferta(ofdao.ultimoID());
                        of.setNombre(request.getParameter("txtnombre"));
                        of.setDescripcion(request.getParameter("txtdescripcion"));
                        of.setDescuento(Integer.parseInt(request.getParameter("txtdescuento")));
                        of.setFechainicio(request.getParameter("txtfechaini"));
                        of.setFechafin(request.getParameter("txtfechafi"));
                        of.setCantMini(Integer.parseInt(request.getParameter("txtcantMin")));
                        of.setEstatus(request.getParameter("txtestatus"));
                        ofdao.agregar(of);
                        request.getRequestDispatcher("Controlador?menu=Ofertas&accion=Listar").forward(request, response);
                        break;
                    
                    case "Actualizar":
                        of.setNombre(request.getParameter("txtnombre"));
                        of.setDescripcion(request.getParameter("txtdescripcion"));
                        of.setDescuento(Float.parseFloat(request.getParameter("txtdescuento")));
                        of.setFechainicio(request.getParameter("txtfechaini"));
                        of.setFechafin(request.getParameter("txtfechafi"));
                        of.setCantMini(Integer.parseInt(request.getParameter("txtcantMin")));
                        of.setEstatus(request.getParameter("txtestatus"));
                        ofdao.Actualizar(of);
                        request.getRequestDispatcher("Controlador?menu=Ofertas&accion=Listar").forward(request, response);
                        break;

                        case "Editar":
                        of = ofdao.listarID(Integer.parseInt(request.getParameter("id")));
                        request.setAttribute("of",of);
                        request.getRequestDispatcher("Controlador?menu=Ofertas&accion=Listar").forward(request, response);
                        break;
                             
                        case "Delete":
                        ofdao.Eliminar(Integer.parseInt(request.getParameter("id")));
                        request.getRequestDispatcher("Controlador?menu=Ofertas&accion=Listar").forward(request, response);
                        break;

                }
                request.getRequestDispatcher("Ofertas.jsp").forward(request, response);
            } catch (Exception e) {
            }
        }
        if (menu.equals("Envios")) {
            try {
                switch (accion) {
                    case "Listar":
                    ArrayList<UnidadeTransporte> lista=udao.consultaGeneral();
                    request.setAttribute("carreras", lista);
                        udao= new UnidadeTransporteDAO();
                        lista=udao.consultaGeneral();
                    List listado = envdao.listar();
                    request.setAttribute("t", listado);    
                        System.out.println(listado);
                        break;        
                    case "Agregar":
                        
                      break;      
                }
                request.getRequestDispatcher("Envios.jsp").forward(request, response);
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
