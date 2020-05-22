<%@page import="java.util.Iterator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Asigancion de Ofertas</title>
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
                    <form action="Controlador?menu=Ofertas_Asignacion" method="POST">
                        <div class="card-body">
                            <!--DATOS DE TRIPULACION-->
                            <div class="form-group">
                                <label>Asignar ofertas a productos</label>
                            </div>
                            <div class="form-group">
                                <label>Seleccionar Oferta</label>
                            </div>
                            <div class="form-group d-flex">     
                            <select name="oferta" id="carrera" value="" class="form-control">
                                <option value="0" class="col-sm-6">--Elige una oferta--</option>
                    		<c:forEach items="${carreras}" var="carrera">
	                    		<option value="${carrera.idOferta}">
                                                    ${carrera.nombre}
                                                    </option>
                    		</c:forEach>
                            </select>
                            </div> 
                            <div class="form-group">
                                <label>Seleccionar Producto</label>
                            </div>    
                            <div class="form-group d-flex">
                            <select name="producto" value="" id="carrera" class="form-control">
                                <option value="0" class="col-sm-6">--Elige un producto--</option>
                    		<c:forEach items="${carrera}" var="c">
	                    		<option value="${c.idProducto}">
							${c.descripcion}
							</option>
                    		</c:forEach>
                            </select>        
                            </div>   
                            <!--BOTON AGREGAR PRODUCTO AL REGISTRO-->
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">Agregar</button>
                                </div>
                            </div>
                        </div>  
                                
                    </form>
                </div>
            </div>
                 <div class="col-sm-8">
                            <div class="card">
                                <div class="card-body">
                                    <table id="datos" number-per-page="10" current-page="" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp full-width table-responsive">
                                        <thead>
                                            <tr>
                                                <th>IDPRODUCTO</th>
                                                <th>IDOFERTA</th>
                                            </tr>
                                        </thead>
                                        <tbody> 
                                            <c:forEach var="t" items="${listar}">
                                                <tr>
                                                    <td>${t.getIdProducto()}</td>
                                                    <td>${t.getOfertas()}</td>
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
      </section>  
    </body>
</html>
