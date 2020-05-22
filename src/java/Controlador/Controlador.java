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
import Modelo.OfertasProductos;
import Modelo.OfertasProductosDAO;
import Modelo.ProductoDAO;
import Modelo.Productos;
import Modelo.Tripulacion;
import Modelo.TripulacionDAO;
import Modelo.UnidadeTransporte;
import Modelo.UnidadeTransporteDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
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
    Tripulacion T = new Tripulacion();
    TripulacionDAO tdao = new TripulacionDAO();
    Envios en = new Envios();
    Envios env = new Envios();
    EnviosDAO envdao = new EnviosDAO();
    Tripulacion t = new Tripulacion();
    OfertasProductosDAO OPD = new OfertasProductosDAO();
    OfertasProductos OP = new OfertasProductos();
    Productos p = new Productos();
    ProductoDAO pdao = new ProductoDAO();
    Venta v = new Venta();
    VentaDAO vdao = new VentaDAO();
    List<Venta> listadodeproductos = new ArrayList<>();
    int ide, idu, idci, item, cod, cant, numeroVenta, oferta, producto, oferta1;
    float precio, subtotal, totalpagar, descuento;
    String descripcion;

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
                        UT.setIdUnidadTransporte(udao.ultimoID());
                        UT.setMarca(request.getParameter("txtMarcas"));
                        UT.setPlacas(request.getParameter("txtPlacas"));
                        UT.setModelo(request.getParameter("txtModelo"));
                        UT.setAnio(request.getParameter("txtAnio"));
                        UT.setCapacidad(request.getParameter("txtCapacidad"));
                        UT.setEstatus("A");
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
                        UT.setMarca(request.getParameter("txtMarcas"));
                        UT.setPlacas(request.getParameter("txtPlacas"));
                        UT.setModelo(request.getParameter("txtModelo"));
                        UT.setAnio(request.getParameter("txtAnio"));
                        UT.setCapacidad(request.getParameter("txtCapacidad"));
                        UT.setEstatus("A");
                        udao.Actualizar(UT);
                        request.getRequestDispatcher("Controlador?menu=UnidadeTransportecrud&accion=Listar").forward(request, response);
                        break;

                    case "Eliminar":
                        udao.Eliminar(Integer.parseInt(request.getParameter("id")));
                        request.getRequestDispatcher("Controlador?menu=UnidadeTransportecrud&accion=Listar").forward(request, response);
                        break;
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
                        cliente.setCodigoPostal(request.getParameter("txtcp"));
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
                        cliente.setCodigoPostal(request.getParameter("txtcp"));
                        cliente.setIdCiudad(Integer.parseInt(request.getParameter("txtciudad")));
                        cliente.setRfc(request.getParameter("txtrfc"));
                        cliente.setTelefono(request.getParameter("txttel"));
                        cliente.setEmail(request.getParameter("txtemail"));
                        CT.setContacto(request.getParameter("txtcontacto"));
                        CT.setLimiteCredito(Float.parseFloat(request.getParameter("txtcredito")));
                        cliente.setTipo("CT");
                        cliente.setEstatus("A");
                        CT.setClientes(cliente);
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
                        cliente.setTipo("CI");
                        cliente.setEstatus("A");
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
                        of.setEstatus("A");
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
                        of.setEstatus("A");
                        ofdao.Actualizar(of);
                        request.getRequestDispatcher("Controlador?menu=Ofertas&accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                        of = ofdao.listarID(Integer.parseInt(request.getParameter("id")));
                        request.setAttribute("of", of);
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
        if (menu.equals("Tripulacion")) {
            try {
                switch (accion) {
                    case "Listar":
                        List lista = tdao.listar();
                        request.setAttribute("listar", lista);
                        break;
                    case "Agregar":
                        em.setId(Integer.parseInt(request.getParameter("txtidEmpleado")));
                        en.setIdEnvio(Integer.parseInt(request.getParameter("txtidenvio")));
                        T.setRol(request.getParameter("txtrol"));
                        tdao.Agregar(T);
                        request.getRequestDispatcher("Controlador?menu=Tripulacion&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        em.setId(Integer.parseInt(request.getParameter("txtidEmpleado")));
                        en.setIdEnvio(Integer.parseInt(request.getParameter("txtidenvio")));
                        T.setRol(request.getParameter("txtrol"));
                        tdao.Actualizar(T);
                        request.getRequestDispatcher("Controlador?menu=Tripulacion&accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                        T = tdao.listarID(Integer.parseInt(request.getParameter("id")));
                        request.setAttribute("T", T);
                        request.getRequestDispatcher("Controlador?menu=Tripulacion&accion=Listar").forward(request, response);
                        break;

                    case "Delete":
                        break;

                }
                request.getRequestDispatcher("Tripulacion.jsp").forward(request, response);
            } catch (Exception e) {
            }
        }

        if (menu.equals("Envios")) {
            try {
                switch (accion) {
                    case "Listar":
                        udao = new UnidadeTransporteDAO();
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
        if (menu.equalsIgnoreCase("Ofertas_Asignacion")) {
            try {
                switch (accion) {
                    case "Listar":
                        ArrayList<Ofertas> lista = OPD.consultaGeneral();
                        request.setAttribute("carreras", lista);
                        lista = OPD.consultaGeneral();
                        System.out.println(lista);
                        ArrayList<Productos> listaP = OPD.consultaGeneralP();
                        request.setAttribute("carrera", listaP);
                        listaP = OPD.consultaGeneralP();
                        List listado = OPD.listar();
                        request.setAttribute("listar", listado);
                        break;

                    case "Agregar":
                        int oferta = Integer.parseInt(request.getParameter("oferta"));
                        int producto = Integer.parseInt(request.getParameter("producto"));
                        OP.setOfertas(oferta);
                        OP.setIdProducto(producto);
                        OPD.Agregar(OP);
                        request.getRequestDispatcher("Controlador?menu=Ofertas_Asignacion&accion=Listar").forward(request, response);
                        break;
                }
            } catch (Exception e) {
            }
            request.getRequestDispatcher("Ofertas_Asignacion.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("NuevaVenta")) {
            try {
                switch (accion) {
                    case "Listar":
                        //ArrayList<ClienteIndividual> lista=ctdao.consultaGeneral();
                        //request.setAttribute("carreras", lista);
                        //lista=ctdao.consultaGeneral();
                        //System.out.println(lista);
                        break;
                    case "BuscarCliente":
                        int dni = Integer.parseInt(request.getParameter("codigocliente"));
                        CI = cidao.listarId(dni);
                        System.out.println("paso el dni");
                        request.setAttribute("c", CI);
                        System.out.println(CI);
                        System.out.println("paso el ci");
                        break;
                    case "BuscarProducto":
                        int id = Integer.parseInt(request.getParameter("codigoproducto"));
                        p = pdao.buscar(id);
                        request.setAttribute("producto", p);
                        request.setAttribute("c", CI);
                        request.setAttribute("lista", listadodeproductos);
                        request.setAttribute("totalpagar", totalpagar);
                        //lista=ctdao.consultaGeneral();
                        //request.setAttribute("carreras", lista);
                        //ArrayList<ClienteIndividual> listado=ctdao.consultaGeneral();
                        //request.setAttribute("carreras", listado);
                        //listado=ctdao.consultaGeneral();
                        break;
                    case"BuscarOferta":
                        int idOferta = Integer.parseInt(request.getParameter("oferta"));
                        of =ofdao.listarID(idOferta);
                        request.setAttribute("of", of);
                        request.setAttribute("producto", p);
                        request.setAttribute("c", CI);
                        request.setAttribute("lista", listadodeproductos);
                        request.setAttribute("totalpagar", totalpagar);
                        break;
                    case "Agregar":
                        request.setAttribute("c", CI);
                        item = item + 1;
                        cod = p.getIdProducto();
                        oferta=of.getIdOferta();
                        descripcion = request.getParameter("nomproducto");
                        precio = Float.parseFloat(request.getParameter("precio"));
                        cant = Integer.parseInt(request.getParameter("cant"));
                        if (cod == OP.getIdProducto() && oferta == OP.getOfertas()) {
                            subtotal = precio * cant;
                            v = new Venta();
                            v.setItem(item);
                            v.setIdVenta(cod);
                            v.setDescripcionP(descripcion);
                            v.setPrecio(precio);
                            v.setCantidad(cant);
                            v.setSubtotal(subtotal);
                            listadodeproductos.add(v);
                            request.setAttribute("lista", listadodeproductos);
                            for (int i = 0; i < listadodeproductos.size(); i++) {
                                totalpagar = totalpagar + listadodeproductos.get(i).getSubtotal();
                                totalpagar = totalpagar;
                             }   
                        }

                        request.setAttribute("totalpagar", totalpagar);
                        break;
                    default:
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                }
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
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
