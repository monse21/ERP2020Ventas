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
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigotripu" value="${c.getIdEmpleado()}" class="form-control" placeholder="Codigo">
                                    <button  type="submit" name="accion" value="BuscarTripulacion" class="btn btn-outline-info">Buscar</button>
                                            
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nomproducto" value="${c.getRol()}" placeholder="Datos Producto" class="form-control">
                                </div>      
                            </div>
                                <div class="form-group">
                                   <!--!--> 
                                <label>Ventas</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoVenta" value="${m.getIdVenta()}" class="form-control" placeholder="Codigo">
                                    <button  type="submit" name="accion" value="BuscarVenta" class="btn btn-outline-info">Buscar</button>
                                            
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nomproducto" value="${m.getEstatus()}" placeholder="Datos Producto" class="form-control">
                                </div>      
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${m.getCantPagada()}" class="form-control" placeholder="S/.0.00">                                
                                </div>                             
                            </div>
                            <div class="form-group d-flex">    
                            <select name="carrera" id="carrera" class="form-control">
                                <option value="0" class="col-sm-6">--Elige una carrera--</option>
                    		<c:forEach items="${carreras}" var="carrera">
	                    		<option value="${carrera.idUnidadTransporte}">
								${carrera.modelo}
							</option>
                    		</c:forEach>
                    </select> 
                            </div>       
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
<div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover table-responsive">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>IDENTIFICADOR</th>
                                    <th>NOMBRES</th>
                                    <th>DIRECCION</th>
                                    <th>ESTADO</th>                                   
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody> 
                                <c:forEach var="em" items="${clientes}">
                                    <tr>
                                        <td>${em.getId()}</td>
                                        <td>${em.getDni()}</td>
                                        <td>${em.getNom()}</td>
                                        <td>${em.getDir()}</td>
                                        <td>${em.getEs()}</td>                                        
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${em.getId()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${em.getId()}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
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
