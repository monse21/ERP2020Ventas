<%@page import="Modelo.Clientes"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.ClientesDAO"%>
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
        <%
            ClientesDAO city = new ClientesDAO();
            List<Clientes> datos = (List<Clientes>) request.getAttribute("listar");
        %>
    </head>
    <body> 
        <section class="full-width pageContent">
            <div class="d-flex">
                <div class="col-sm-2">
                    <div class="card">
                        <div class="card-body">
                            <form action="Controlador?menu=clientes" method="POST">
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <input type="text"  value="${CT.getNombre()}" name="txtnombre" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Contacto</label>
                                    <input type="Text" value="${CT.getContacto()}" name="txtcontacto" class="form-control"  >
                                </div>
                                <div class="form-group">
                                    <label>Credito</label>
                                    <input type="text" value="${CT.getLimiteCredito()}" name="txtcredito" class="form-control"  >
                                </div>
                                <div class="form-group">
                                    <label>Direccion</label>
                                    <input type="text" value="${CT.getClientes().getDireccion()}" name="txtdir" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Codigo Postal</label>
                                    <input type="number" value="${CT.getClientes().getCodigoPostal()}" name="txtcp" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>RFC</label>
                                    <input type="text" value="${CT.getClientes().getRfc()}" name="txtrfc" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Telefono</label>
                                    <input type="text" value="${CT.getClientes().getTelefono()}" name="txttel" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="text" value="${CT.getClientes().getEmail()}" name="txtemail" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Tipo</label>
                                    <input type="text" value="${CT.getClientes().getTipo()}" name="txttipo" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Ciudad</label>
                                    <input type="text" value="${CT.getClientes().getIdCiudad()}" name="txtciudad" class="form-control" >
                                </div>
                                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                            </form>
                        </div>             
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="card">
                        <div class="card-body">
                            <table id="datos" number-per-page="10" current-page="" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp full-width table-responsive">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>DIRECCION</th>
                                        <th>CP</th>
                                        <th>RFC</th>
                                        <th>TELEFONO</th>
                                        <th>EMAIL</th>
                                        <th>TIPO</th>
                                        <th>CIUDAD</th>
                                        <th>NOMBRE</th>
                                        <th>CONTACTO</th>>
                                        <th>CREDITO</th>
                                        <th>ACCIONES</th>
                                    </tr>
                                </thead>
                              <tbody> 
                                            <c:forEach var="CT" items="${listar}">
                                                <tr>
                                                    <td>${CT.getClientes().getIdCliente()}</td>
                                                    <td>${CT.getClientes().getDireccion()}</td>
                                                    <td>${CT.getClientes().getCodigoPostal()}</td>
                                                    <td>${CT.getClientes().getRfc()}</td>
                                                    <td>${CT.getClientes().getTelefono()}</td>
                                                    <td>${CT.getClientes().getEmail()}</td>
                                                    <td>${CT.getClientes().getTipo()}</td>
                                                    <td>${CT.getClientes().getIdCiudad()}</td>
                                                    <td>${CT.getNombre()}</td>
                                                    <td>${CT.getContacto()}</td>
                                                    <td>${CT.getLimiteCredito()}</td>
                                                    <td>
                                                        <a class="btn btn-warning" href="Controlador?menu=clientes&accion=Editar&id=${CT.getClientes().getIdCliente()}">Editar</a>
                                                        <a class="btn btn-danger" href="Controlador?menu=clientes&accion=Delete&id=${CT.getClientes().getIdCliente()}">Delete</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>       

        </section>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>