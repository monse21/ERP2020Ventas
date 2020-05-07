<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>CLIENTES INDIVUDUALES</title>
        <%@include file="css-js.jsp" %>
        <%@include file="FrmAdmin.jsp" %>
    </head>
    <body> 
        <section class="full-width pageContent">
            <div class="d-flex">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <form action="Controlador?menu=clienteIndividual" method="POST">
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <input type="text" id="nombre"  value="${CI.getNombre()}" name="txtnombre" class="form-control" >
                                </div>

                                <div class="form-group">
                                    <label>Apellido Paterno</label>
                                    <input type="text" id="apaterno"  value="${CI.getApaterno()}" name="txtapaterno" class="form-control" >
                                </div>

                                <div class="form-group">
                                    <label>Apellido materno</label>
                                    <input type="text" id="amaterno"  value="${CI.getAmaterno()}" name="txtamaterno" class="form-control" >
                                </div>

                                <div class="form-group">
                                    <label>Sexo
                                        <select value="${CI.getSexo()}" name="txtsexo" required >
                                            <option value="H">Hombre</option>
                                            <option value="M">Mujer</option>

                                        </select>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <div class="form-group">
                                        <label>Direccion</label>
                                        <input type="text" value="${CI.getCliente().getDireccion()}" name="txtdir" class="form-control" >
                                    </div>
                                    <div class="form-group">
                                        <label>Codigo Postal</label>
                                        <input type="number" value="${CI.getCliente().getCodigoPostal()}" name="txtcp" class="form-control" >
                                    </div>
                                    <div class="form-group">
                                        <label>RFC</label>
                                        <input type="text" value="${CI.getCliente().getRfc()}" name="txtrfc" class="form-control" >
                                    </div>
                                    <div class="form-group">
                                        <label>Telefono</label>
                                        <input type="text" value="${CI.getCliente().getTelefono()}" name="txttel" class="form-control" >
                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="text" value="${CI.getCliente().getEmail()}" name="txtemail" class="form-control" >
                                    </div>
                                    <div class="form-group">
                                        <label>Ciudad</label>
                                        <input type="text" value="${CI.getCliente().getIdCiudad()}" name="txtciudad" class="form-control" >
                                    </div>

                                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                                    </form>
                                </div>             
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
                                                <th>NOMBRE</th>
                                                <th>APELLIDO PATERNO</th>
                                                <th>APELLIDO MATERNO</th>
                                                <th>SEXO</th>
                                                <th>CONTACTO</th>
                                                <th>CREDITO</th>
                                                <th>DIRECCION</th>
                                                <th>CP</th>
                                                <th>RFC</th>
                                                <th>TEL</th>
                                                <th>EMAIL</th>
                                                <th>TIPO</th>
                                                <th>CIUDAD</th>
                                            </tr>
                                        </thead>
                                        <tbody> 
                                            <c:forEach var="CI" items="${listar}">
                                                <tr>
                                                    <td>${CI.getNombre()}</td>
                                                    <td>${CI.getApaterno()}</td>
                                                    <td>${CI.getAmaterno()}</td>
                                                    <td>${CI.getSexo()}</td>
                                                    <td>${CI.getCliente().getDireccion()}</td>
                                                    <td>${CI.getCliente().getCodigoPostal()}</td>
                                                    <td>${CI.getCliente().getIdCiudad()}</td>
                                                    <td>${CI.getCliente().getRfc()}</td>
                                                    <td>${CI.getCliente().getTelefono()}</td>
                                                    <td>${CI.getCliente().getEmail()}</td>
                                                    <td>${CI.getCliente().getTipo()}</td>
                                                    <td>${CI.getCliente().getEstatus()}</td>
                                                    <td>
                                                        <a class="btn btn-warning" href="Controlador?menu=clienteIndividual&accion=Editar&id=${CI.getCliente().getIdCliente()}">Editar</a>
                                                        <a class="btn btn-danger" href="Controlador?menu=clienteIndividual&accion=Delete&id=">Delete</a>
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
              </div> 
        </section>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
