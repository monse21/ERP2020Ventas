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
                            <form onsubmit="return Validar()"action="Controlador?menu=Empleado" method="POST">
                                <div class="form-group">
                                    <label>Contraseña</label>
                                    <input type="text" id="nombre" value="${empleado.getDni()}" name="txtDni" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Nombres</label>
                                    <input type="text" value="${empleado.getNom()}" name="txtNombres" class="form-control" pattern="-?[A-Za-záéíóúÁÉÍÓÚ ]*(\.[0-9]+)?" >
                                </div>
                                <div class="form-group">
                                    <label>Telefono</label>
                                    <input type="number" value="${empleado.getTel()}" name="txtTel" class="form-control" pattern="-?[0-9]*(\.[0-9]+)?" >
                                </div>
                                <div class="form-group">
                                    <label>Estado</label>
                                    <input type="number" value="${empleado.getEstado()}" name="txtEstado" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>Usuario</label>
                                    <input type="text" value="${empleado.getUser()}" name="txtUser" class="form-control" >
                                </div>
                                <input type="submit" name="accion" onsubmit="return Validar();" value="Agregar" class="btn btn-primary">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                            </form>
                        </div>                         
                    </div>
                </div>
               <div>               
                <div class="col-sm-8">
                    <div class="card">
                        <div class="card-body">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>NOMBRE</th>
                                        <th>A.PATRENO</th>
                                        <th>A.MATERNO</th>
                                        <th>SEXO</th>
                                        <th>TIPO</th>
                                        <th>ACCIONES</th>
                                    </tr>
                                </thead>
                                <tbody> 
                                        <c:forEach var="em" items="${listar}">
                                            <tr>
                                            <td>${em.getId()}</td>
                                            <td>${em.getNombre()}</td>
                                            <td>${em.getPaterno()}</td>
                                            <td>${em.getMaterno()}</td>
                                            <td>${em.getSexo()}</td>
                                            <td>${em.getTipo()}</td>
                                            <td>
                                                <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>
                                                <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}">Delete</a>
                                            </td>
                                            </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
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