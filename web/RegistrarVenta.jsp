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
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <!--DATOS DEL PRODUCTO-->
                            <div class="form-group">
                                <label>Seleccionar Cliente</label>
                            </div>
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigocliente" value="${c.getCliente().getRfc()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" id="buscar" name="accion" value="BuscarCliente" class="btn btn-outline-info" >Buscar</button>
                                </div>                           
                                <div class="col-sm-6">
                                    <input type="text" id="respuesta" name="nombrescliente" value="${c.getNombre()}" placeholder="Datos Cliente" class="form-control">
                                </div>                           
                            </div>
                            <!--DATOS DEL PRODUCTO-->
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoproducto" value="${producto.getIdProducto()}" class="form-control" placeholder="Codigo">
                                    <button  type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                  
                                </div>                           
                                <div class="col-sm-6">
                                    <input type="text" name="nomproducto" value="${producto.getNombre()}" placeholder="Datos Producto" class="form-control">
                                </div>  
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrecioVenta()}" class="form-control" placeholder="S/.0.00">                                
                                </div>                           
                                <div class="col-sm-3">
                                    <input type="number" value="1" name="cant" placeholder="" class="form-control">
                                </div>  
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getPuntoReorden()}" placeholder="Stock" class="form-control">
                                </div>  
                            </div>
                            <!---AGREGAR OFERTA-->    
                            <div class="form-group">
                                <label>Datos Oferta</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="oferta" value="${of.getIdOferta()}" class="form-control" placeholder="Codigo">
                                    <button  type="submit" name="accion" value="BuscarOferta" class="btn btn-outline-info">Buscar</button>
                                  
                                </div>                           
                                <div class="col-sm-6">
                                    <input type="text" name="ofertanomb" value="${of.getNombre()}" placeholder="Datos de la oferta" class="form-control">
                                </div>  
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="descuento" value="${of.getDescuento()}" class="form-control" placeholder="S/.0.00">                                
                                </div>                            
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
            <div class="col-sm-7">
                <div class="card parte02">                    
                    <div class="card-body">
                        <div class="d-flex ml-auto col-sm-6">
                            <label class="text-right mt-2 col-sm-6">NRO. SERIE</label>
                            <input readonly="" type="text" name="numeroserie" class="form-control text-center" value="${nserie}" style="font-weight: bold;font-size: 18px">
                        </div>                      
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr class="text-center">
                                    <th>N°</th>
                                    <th>ID</th>
                                    <th>PRODUCTO</th>
                                    <th>PRECIO</th>
                                    <th>CANTIDAD</th>
                                    <th>SUBTOTAL</th>                                    
                                    <th class="accion">ACCION</th>                                    
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
                    <div class="card-footer" >
                        <div class="row">
                           
                            <div class="col-sm-6">
                                <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                                <a  class="btn btn-danger" href="Controlador?menu=NuevaVenta&accion=Delete" style="margin-left: 5px">Cancelar</a>
                            </div>
                            <div class="col-sm-6 ml-auto d-flex">                                
                                <label class=" col-sm-6 text-right mt-2">Total a Pagar</label>                                                       
                                <input type="text" name="txtTotal" value="S/.${totalpagar}0" class="form-control text-center font-weight-bold" style="font-size: 18px;">
                            </div>
                        </div>                        
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
        </section>
    </body>
</html>
