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
        <title>VENTAS</title>
        <%@include file="css-js.jsp" %>
        <%@include file="FrmAdmin.jsp" %>
        
<script type="text/javascript" src="js/jquery-2.1.3.js"></script>
    </head>
    <body>
       <section class="full-width pageContent">           
                
        <div class="d-flex">
            <div class="col-lg-5 parte01">
                <div class="card">
                    <form></form>
                    <form action="Controlador?menu=Envios" method="POST">
                        <div class="card-body">
                            <!--DATOS DE TRIPULACION-->
                            <div class="form-group">
                                <label>Tripulacion</label>
                            </div>
                            <div class="form-group">
                                    <label>Fecha Salida</label>
                                    <input type="date" value="${of.getFechafin()}" name="txtfechafi" class="form-control" >
                           </div>
                            <div class="form-group d-flex">    
                            <select name="carrera" id="carrera" class="form-control">
                                <option value="0" class="col-sm-6">--Elige un transporte--</option>
                    		<c:forEach items="${carreras}" var="carrera">
	                    		<option value="${carrera.idUnidadTransporte}">
								${carrera.modelo}
							</option>
                    		</c:forEach>
                            </select>
                            <select name="carrera" id="carrera" class="form-control">
                                <option value="0" class="col-sm-6">--Elige un transporte--</option>
                    		<c:forEach items="${empleados}" var="carrera">
	                    		<option value="${carrera.idUnidadTransporte}">
								${carrera.modelo}
							</option>
                    		</c:forEach>
                            </select>    
                                
                            </div>       
                            <!--BOTON AGREGAR PRODUCTO AL REGISTRO-->
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">Agregar Envio</button>
                                </div>
                            </div>
                        </div>
                                
                    </form>
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
                                                <th>DIRECCION</th>
                                                <th>CP</th>
                                                <th>CIUDAD</th>
                                                <th>RFC</th>
                                                <th>TEL</th>
                                                <th>EMAIL</th>
                                                <th>TIPO</th>
                                                <th>ESTATUS</th>
                                               
                                            </tr>
                                        </thead>
                                        <tbody> 
                                            <c:forEach var="t" items="${t}">
                                                <tr>
                                                    <td>${t.getId}</td>
                                                    <td>${t.getEmpleado.getNombre()}</td>
                                                    <td>${t.getEmpleado().getPaterno}</td>
                                                    <td>${t.getEmpleado().getMaterno}</td>
                                                    <td>${t.getRol()}</td>
                                                    <td>${t.getEnvio().getIdEnvio}</td>
                                                    <td>${t.getEnvio().getFechaSalida()}</td>
                                                    <td>${t.getEnvio().getUnidad().getIdUnidadTransporte()}</td>
                                                    <td>${t.getEnvio().getUnidad().getPlacas()}</td>
                                                    
                                                    <td>
                                                        <a class="btn btn-warning" href="Controlador?menu=clienteIndividual&accion=Editar&id=${CI.getCliente().getIdCliente()}">Editar</a>
                                                        <a class="btn btn-danger" href="Controlador?menu=clienteIndividual&accion=Delete&id=${CI.getCliente().getIdCliente()}">Delete</a>
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

                 
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="js/js-render.js"></script>
        </section>
    </body>
</html>
