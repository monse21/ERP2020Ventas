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

