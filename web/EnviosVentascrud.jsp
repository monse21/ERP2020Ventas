<%-- 
    Document   : EnviosVentas
    Created on : 05-may-2020, 20:46:13
    Author     : Cristopher
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <title>JSP Page</title>
            <%@include file="css-js.jsp" %>
            <%@include file="FrmAdmin.jsp" %>
        </head>
        <body> 
                  <section class="full-width pageContent">
            <div class="d-flex">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <form action="Controlador?menu=EnviosVentascrud" method="POST">
                                <div class="form-group">
                                    <label>id Envio</label>
                                    <input type="number" id="idEnvio"  value="${en.getIdEnvio ()}" name="txtIdEnvio" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>id Ventas</label>
                                    <input type="number" id="idVenta"  value="${ev.getIdVenta ()}" name="txtIdVenta" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Fecha de Entrega Planeada</label>
                                    <input type="text" value="${ev.getFechaEntregaPlaneada ()}" name="txtFechaEntregaPlaneada" class="form-control"  >
                                </div>
                                <div class="form-group">
                                    <label>Fecha de Entrega Real</label>
                                    <input type="text" value="${ev.getFechaEntregaReal ()}" name="txtFechaEntregaReal" class="form-control"  >
                                </div>
                                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                            </form>
                        </div>             
                    </div>
                </div>
               <div>               
                <div class="col-sm-8">
                    <div class="card">
                        <div class="card-body">
                            <table id="datos" number-per-page="10" current-page="" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp full-width table-responsive">
                                <thead>
                                    <tr>
                                        <th>ID ENVIO</th>
                                        <th>ID VENTA</th>
                                        <th>FECHA DE ENTREGA PLANEADA</th>
                                        <th>FECHA DE ENTREGA REAL</th>
                                    </tr>
                                </thead>
                                <tbody> 
                                    <c:forEach var="ev" items="${listar}">
                                            <tr>
                                            <td>${en.getIdEnvio ()}</td>
                                            <td>${ev.getIdVenta ()}</td>
                                            <td>${ev.getFechaEntregaPlaneada ()}</td>
                                            <td>${ev.getFechaEntregaReal ()}</td>
                                            <td>
                                                <a class="btn btn-warning" href="Controlador?menu=EnviosVentascrud&accion=Editar&id=${ev.getId ()}">Editar</a>
                                                <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Delete&id=${ev.getId ()}">Delete</a>
                                            </td>
                                            </tr>
                                    </c:forEach>
                                       
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
           </div>                      
            </section
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </body>
        </html>