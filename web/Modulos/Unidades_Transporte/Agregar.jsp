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
        <title>UNIDADES DE TRANSPORTE</title>
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
                                <label>UNIDADES DE TRANSPORTE</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <label class=" col-sm-6 text-right mt-2">idUnidad</label>
                                    <input type="text" name="UnidadesTransporte" value="${c.getDni()}" class="form-control" placeholder="Unidades">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <label class=" col-sm-6 text-right mt-2">No. Placas</label><br>
                                    <input type="text" name="Placas" value="${c.getDni()}" class="form-control" placeholder="Placas">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                         <label class=" col-sm-6 text-right mt-2">Marca</label><br>
                                    <input type="text" name="Marca" value="${c.getDni()}" class="form-control" placeholder="Marca">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <label class=" col-sm-6 text-right mt-2">Modelo</label><br>
                                    <input type="text" name="Modelo" value="${c.getDni()}" class="form-control" placeholder="Modelo">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <label class=" col-sm-6 text-right mt-2">Año</label><br>
                                    <input type="date" name="anio" value="${c.getDni()}" class="form-control" placeholder="anio">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <label class=" col-sm-6 text-right mt-2">Capacidad</label><br>
                                    <input type="number" name="Capacidad" value="${c.getDni()}" class="form-control" placeholder="Capacidad">
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
						
                                            <!--%  ProductoDAO pdao=new ProductoDAO();
                                            List<Producto>listS=pdao.ListadoProductos();
                                            Iterator<Producto>iterr=listS.iterator();
                                         Producto pro=null;
                                            while (iterr.hasNext()) {
                                            pro = iterr.next(); %>

                                            <tr>
                                                <td><--%= pro.getId()%></td>
                                                        <td><--%= pro.getNom() %></td>
                                                        <td><--%= pro.getPre() %></td>
							
						</tr>
						<--%}%>
                                            -->

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
                                    <th>N°</th>
                                    <th>ID UNIDAD</th>
                                    <th>PLACAS</th>
                                    <th>MARCA</th>
                                    <th>MODELO</th>
                                    <th>AÑO</th> 
                                    <th>CAPACIDAD</th>                                                             
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

