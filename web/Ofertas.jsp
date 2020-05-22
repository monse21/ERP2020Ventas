<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>OFERTAS</title>
        <%@include file="css-js.jsp" %>
        <%@include file="FrmAdmin.jsp" %>
    </head>
    <body>
        <section class="full-width pageContent">
        <div class="d-flex">
                <div class="col-sm-2">
                    <div class="card">
                        <div class="card-body">
                            <form action="Controlador?menu=Ofertas" method="POST">
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <input type="text" id="nombre"  value="${of.getNombre()}" name="txtnombre" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Descripcion</label>
                                    <input type="text" id=""  value="${of.getDescripcion()}" name="txtdescripcion" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Descuento</label>
                                    <input type="number" id=""  value="${of.getDescuento()}" name="txtdescuento" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Fecha inicio</label>
                                    <input type="date" value="${of.getFechainicio()}" name="txtfechaini" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Fecha fin</label>
                                    <input type="date" value="${of.getFechafin()}" name="txtfechafi" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Cantidad Minima</label>
                                    <input type="number" value="${of.getCantMini()}" name="txtcantMin" class="form-control" >
                                </div>
                                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                            </form>
                        </div>    
                   </div>
              </div>
            <div>               
                   <div class="col-sm-14">
                        <div class="card">
                            <div class="card-body">
                                <table id="datos" number-per-page="10" current-page="" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp full-width table-responsive">
                                  <thead>
                                            <tr>
                                                <th>NOMBRE</th>
                                                <th>DESCRIPCION</th>
                                                <th>POR DESC.</th>
                                                <th>FECHA INICIO</th>
                                                <th>FECHA FIN</th>
                                                <th>CANT. MIN</th>  
                                            </tr>    
                                  </thead>  
                                   <tbody> 
                                <c:forEach var="of" items="${listar}">
                                    <tr>
                                        <td>${of.getNombre()}</td>
                                        <td>${of.getDescripcion()}</td>
                                        <td>${of.getDescuento()}</td>
                                        <td>${of.getFechainicio()}</td>    
                                        <td>${of.getFechafin()}</td>    
                                        <td>${of.getCantMini()}</td>    
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Ofertas&accion=Editar&id=${of.getIdOferta()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Ofertas&accion=Delete&id=${of.getIdOferta()}">Delete</a>
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
       </section> 
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
