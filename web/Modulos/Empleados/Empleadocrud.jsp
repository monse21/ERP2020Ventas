<<<<<<< Upstream, based on origin/master
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>EMPLEADOS</title>
        <style>
            @media print{
                .parte01,img, .btn, .accion{
                    display: none;
                }
            }
                
        body {
                    margin: 3;
                    font-family: Arial, Helvetica, sans-serif;
                    text-align: center;
                    background-image: url(img/2.jpg);
                    background-position: center center;
                    background-repeat: no-repeat;
                    background-attachment: fixed;
                    background-size: cover;
                    background-color:#66999;
                    }    
        </style>
        <script type="text/javascript" src="js/jquery-2.1.3.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">           
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav"></ul>
                <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=Delete" target="myFrame">UNIDADES DE TRANSPORTE</a><br>
                    </li>

            </div>
                <div class="dropdown">
                <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getNom()}
                </button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="#">
                        <img src="img/user.png" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="Validar?accion=Salir">Salir</a>
                </div>
            </div>
            
              <!--<div class="embed-responsives m-4" style="height: 530px;">
             <iframe class="embed-responsive-item" name="myFrame"  style="height: 100%; width: 100%; border:navy"></iframe>
        </div>-->
        </nav>
        <div class="d-flex">
            <div class="col-lg-5 parte01">
                <div class="card">
                    <form></form>
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <!--DATOS DEL PRODUCTO-->
                            <div class="form-group">
                                <label>EMPLEADOS</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <label class=" col-sm-7 text-right mt-2">idEmpledo</label>
                                    <input type="text" name="idEmplado" value="${c.getDni()}" class="form-control" placeholder="idEmplado">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <label class=" col-sm-7 text-right mt-2">Nombre</label><br>
                                    <input type="text" name="Nombre" value="${c.getDni()}" class="form-control" placeholder="Nombre">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                         <label class=" col-sm-7 text-right mt-2">Apellido Paterno</label><br>
                                    <input type="text" name="apaterno" value="${c.getDni()}" class="form-control" placeholder="Apellido paterno">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <label class=" col-sm-7 text-right mt-2">Apellido Materno</label><br>
                                    <input type="text" name="amaterno" value="${c.getDni()}" class="form-control" placeholder="Apellido Materno">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <label class=" col-sm-7 text-right mt-2">Sexo</label>
                                    F<input type="checkbox" name="Sexo" value="${c.getDni()}" class="form-control" placeholder="Sexo">
                                    M<input type="checkbox" name="Sexo" value="${c.getDni()}" class="form-control" placeholder="Sexo">
                                </div>
                            </div> 
                                <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <label class=" col-sm-7 text-right mt-2">Tipo</label><br>
                                <input type="text" name="tipo" value="${c.getDni()}" class="form-control" placeholder="tipo">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <label class=" col-sm-7 text-right mt-2">email</label><br>
                                    <input type="email" name="email" value="${c.getDni()}" class="form-control" placeholder="email">
                                </div>
                            </div>                                              
                            <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <label class=" col-sm-7 text-right mt-2">Contraseña</label><br>
                                <input type="password" name="Contrasena" value="${c.getDni()}" class="form-control" placeholder="Contrasena">
                            </div>
                        </div>                                              
                    
                            <!--BOTON AGREGAR UNIDAD  AL REGISTRO-->
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">Agregar Unidad</button>
                                    <button type="submit" name="accion" value="Cancelar" class="btn btn-outline-primary">Cancelar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                                <table id="div1"  class="mdl-data-table mdl-js-data-table mdl-shadow--2dp full-width table-responsive" border="1" style="overflow: auto">
                                        <tbody>
   					</tbody>
				    </table>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card parte02">                    
                    <div class="card-body">                   
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr class="text-center">
                                    <th>IDEMPLEADO</th>
                                    <th>NOMBRE</th>
                                    <th>APELLIDO PATERNO</th>
                                    <th>APELLIDO PATERNO</th>
                                    <th>SEXO</th>
                                    <th>TIPO</th> 
                                    <th>EMAIL</th>
                                    <th>CONTRASEÑA</th>                                                              
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr class="text-center">
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcionP()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td class="d-flex">
                                            <a  class="btn btn-danger" href="Controlador?menu=NuevaVenta&accion=Delete" style="margin-left: 5px">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
                            <article id="respuesta"></article>              

        <script type="text/javascript"> 
        document.getElementById("buscar").addEventListener("click",function(){
         $.post("Controlador?menu=NuevaVenta&accion=BuscarCliente", $(document.forms[0]).serialize(), function(response){
             var respuesta = document.getElementById("respuesta");
             var datos = JSON.parse(response);
         });
         
        },false);
        </script>                    
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="js/js-render.js"></script>
    </body>
</html>

=======
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>venta</title>
        
    </head>
    <style>
        /* estado descactivado */
        markdesactivado{

            background-color: #ff1744;
            color: black;
            border-radius: 71px 69px 72px 71px;
            -moz-border-radius: 71px 69px 72px 71px;
            -webkit-border-radius: 71px 69px 72px 71px;
        }
        /* estado activo */
        markactivo{

            background-color: #00FF00;
            color: black;
            border-radius: 71px 69px 72px 71px;
            -moz-border-radius: 71px 69px 72px 71px;
            -webkit-border-radius: 71px 69px 72px 71px;
        }
    </style>
    <body>

        <!--cabecera de Menu -->
        <%@include file="FrmAdmin.jsp" %>
        <%@include file="css-js.jsp" %>

        <!-- pageContent -->
        <section class="full-width pageContent">
            <div class="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
                <div class="mdl-tabs__tab-bar">
                    <a href="#tabNewVenta" class="mdl-tabs__tab is-active">NUEVO</a>
                    <a href="#tabListVenta" class="mdl-tabs__tab">liSTAR</a>
                </div>
                <div class="mdl-tabs__panel is-active" id="tabNewVenta">
                    <div class="mdl-grid">
                        <div class="mdl-cell mdl-cell--4-col-phone mdl-cell--8-col-tablet mdl-cell--12-col-desktop">
                            <div class="full-width panel mdl-shadow--2dp">
                                <div class="full-width panel-tittle bg-primary text-center tittles">
                                    Nueva Venta
                                </div>
                            </div></div></div>
                    <div class="d-flex">
                        <div class="col-lg-5 parte01">
                            <div class="card">
                                <form></form>
                                <form action="Controlador?menu=NuevaVenta" method="POST">
                                    <div class="card-body">
                                        <!--DATOS DEL PRODUCTO-->
                                        <div class="form-group">
                                            <label>Datos del Cliente</label>
                                        </div>
                                        <select name="txtidcliente" class="mdl-textfield__input" required>
                                            <option style="background-color: white;" value=" disabled" selected="">Seleciona Cliente</option>
                                        </select>  <BR><BR>                          
                                        <!--DATOS DEL PRODUCTO-->
                                        <div class="form-group">
                                            <label>Datos Producto</label>
                                        </div>
                                        <div class="form-group d-flex">
                                            <div class="col-sm-6 d-flex">
                                                <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">
                                                <button  type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>

                                            </div>                           
                                            <div class="col-sm-6">
                                                <input type="text" name="nomproducto" value="${producto.getNom()}" placeholder="Datos Producto" class="form-control">
                                            </div>  
                                        </div>
                                        <div class="form-group d-flex">
                                            <div class="col-sm-6 d-flex">
                                                <input type="text" name="precio" value="${producto.getPre()}" class="form-control" placeholder="S/.0.00">                                
                                            </div>                           
                                            <div class="col-sm-3">
                                                <input type="number" value="1" name="cant" placeholder="" class="form-control">
                                            </div>  
                                            <div class="col-sm-3">
                                                <input type="text" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control">
                                            </div><br><br>  
                                        </div><br>
                                        <br><br>
                                        <!--BOTON AGREGAR PRODUCTO AL REGISTRO-->
                                        <div class="form-group">
                                            <div class="col-sm">
                                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">Agregar Producto</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <div class="card parte02">                    
                                <div class="card-body">
                                    <div class="d-flex ml-auto col-sm-6">
                                        <label class="text-right mt-2 col-sm-6">NRO. SERIE</label>
                                        <input readonly="" type="text" name="numeroserie" class="form-control text-center" value="${nserie}" style="font-weight: bold;font-size: 18px">
                                    </div>                      
                                    <br>
                                    <table class="table table-hover">
                                        <thead>
                                            <tr class="text-center">
                                                <th>N°</th>
                                                <th>ID</th>
                                                <th>PRODUCTO</th>
                                                <th>PRECIO</th>
                                                <th>CANTIDAD</th>
                                                <th>SUBTOTAL</th>                                    
                                                <th class="accion">ACCION</th>                                    
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="list" items="${lista}">
                                            <tr class="text-center">
                                                <td>${list.getItem()}</td>
                                                <td>${list.getIdproducto()}</td>
                                                <td>${list.getDescripcionP()}</td>
                                                <td>${list.getPrecio()}</td>
                                                <td>${list.getCantidad()}</td>
                                                <td>${list.getSubtotal()}</td>
                                                <td class="d-flex">
                                                    <a  class="btn btn-danger" href="Controlador?menu=NuevaVenta&accion=Delete" style="margin-left: 5px">Delete</a>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                                <div class="card-footer" >
                                    <div class="row">

                                        <div class="col-sm-6">
                                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                                            <a  class="btn btn-danger" href="Controlador?menu=NuevaVenta&accion=Delete" style="margin-left: 5px">Cancelar</a>
                                        </div>
                                        <div class="col-sm-6 ml-auto d-flex">                                
                                            <label class=" col-sm-6 text-right mt-2">Total a Pagar</label>                                                       
                                            <input type="text" name="txtTotal" value="S/.${totalpagar}0" class="form-control text-center font-weight-bold" style="font-size: 18px;">
                                        </div>
                                    </div>                        
                                </div>
                            </div>

                        </div>
                    </div>                            

                </div>
                <div class="full-width panel-content">




                    <div class="mdl-tabs__panel" id="tabListVenta">
                        <div class="mdl-grid">
                            <div class="mdl-cell mdl-cell--4-col-phone mdl-cell--8-col-tablet mdl-cell--12-col-desktop">
                                <div class="full-width panel-tittle bg-success text-center tittles">
                                    lista de ventas
                                </div>
                                <form action="#">
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                                        <label class="mdl-button mdl-js-button mdl-button--icon" for="buscar">
                                            <i class="fas fa-search"></i>
                                        </label>
                                        <div class="mdl-textfield__expandable-holder">
                                            <input onkeyup="doSearch()" class="mdl-textfield__input" type="text" id="buscar">
                                            <label class="mdl-textfield__label"></label>
                                        </div>
                                    </div>
                                </form>
                                <table   id="datos" number-per-page="4" current-page="" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp full-width table-responsive">
                                    <thead>

                                        <tr>


                                            <th class="mdl-data-table__cell--non-numeric">Cliente</th>
                                            <th>Tipo Comprobante</th>
                                            <th>Serie Comprobante</th>
                                            <th>Fecha</th>
                                            <th>total</th>
                                            <th>Estado</th>
                                            <th>opcion</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <!--%  ventaDAO pdao=new ventaDAO();
                                        List<venta>listS=pdao.ListadoVenta();
                                        Iterator<venta>iterr=listS.iterator();
                                     venta pro=null;
                                       double total=0;
                                        while (iterr.hasNext()) {
                                        pro = iterr.next(); %>

                                            <tr>
                                                <td class="mdl-data-table__cell--non-numeric"><--%= clienteDAO.getcliente(pro.getIdcliente())%></td>
                                                    <td><--%= pro.getTipo_comprobante()%></td>
                                                    <td><--%= pro.getSerie_comprobante()%></td>
                                                       <td><--%= pro.getFecha_hora()%></td>
                                                       <td>$<--%= pro.getTotal()%></td>
                                                        <-- % total=total+pro.getTotal();%>
                                                          <--% String Est ado=pro.getEstado();
                                                     if(Estado.equalsIgnoreCase("Vendido")){ %>
                                                         
                                                          <td><markactivo><---%= Estado %></markactivo></td>   
                                                      <--%   }else{ %>
                                                       
                                                             <td><markdesactivado><--%= Estado %></markdesactivado></td>    
                                                    <--%     }
                                                    %>
                                                    <td>
                                                      
                                                      <--% 
                                                     if(Estado.equalsIgnoreCase("Vendido")){ %>
                                                         
                                                        <a href="DetalleVControlador?accion=estado&id=<--%= pro.getId()%>" class="btn btn-danger" ><img src="Imagen/delete.png" title="Anular"/></a>
                                                       
                                                      <--%   }else{ %>
                                                       
                                                    <--%     }
                                                    %>
                                                         <a href="DetalleVControlador?accion=reporte&id=<--%= pro.getId()%>" class="btn btn-success" ><img src="Imagen/lpdf.png" title="Reporte"/></a>
                                                    
                                                    </td>
                                            </tr>
                                            <--%}%!-->


                                    </tbody>
                                </table>
                                <h4 style="background-color: white; color:navy">Total Vendido $ <!--%=total%--></h4>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
    </body>

</html>
>>>>>>> c6365be Conexion db,empleado
