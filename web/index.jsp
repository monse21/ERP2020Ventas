

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/sweetalert2.css">
	<link rel="stylesheet" href="css/material.min.css">
	<link rel="stylesheet" href="css/jquery.mCustomScrollbar.css">
	<link rel="stylesheet" href="css/main.css">
        <script src="js/jqueryy.js" type="text/javascript"></script>    
        <script src="js/BuscadorTabla.js" type="text/javascript"></script>
        <script src="js/bootstrapp.min.js" type="text/javascript"></script> 
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.2.min.js"><\/script>')</script>
	<script src="js/material.min.js" ></script>
	<script src="js/sweetalert2.min.js" ></script>
	<script src="js/jquery.mCustomScrollbar.concat.min.js" ></script>
	<script src="js/main.js" ></script>
        
        <script  type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/paginacion.js"></script>
       
         <link href="css/bootstrapp.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
        html,body { 
  overflow:hidden; 
}
        body {
                    margin: 3;
                    font-family: Arial, Helvetica, sans-serif;
                    text-align: center;
                    background-image: url(img/Ventras_login.jpg);
                    background-position: center center;
                    background-repeat: no-repeat;
                    background-attachment: fixed;
                    background-size: cover;
                    background-color: #66999;
                    }    
        </style>

    <body class="cover">
	<div class="container-login">
		<p class="text-center" style="font-size: 80px;">
			<i class="zmdi zmdi-account-circle"></i>
		</p>
                <img src="img/logo.jpg" alt="70" width="170"/>
		<p class="text-center text-condensedLight">INGRESE SUS DATOS</p>
		<form  action="logincontroller" method="POST">
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input  name="txtUsuario" class="mdl-textfield__input" type="text" id="userName" required="">
			    <label  class="mdl-textfield__label" for="userName">USUARIO</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
			    <input name="txtPassword"  class="mdl-textfield__input" type="password" id="pass" required>
			    <label class="mdl-textfield__label" for="pass">CONTRASEÑA</label>
			</div>
                      <input type="submit" name="btnEntrar" value="Iniciar" id="SingIn" class="mdl-button mdl-js-button mdl-js-ripple-effect" style="color: #3F51B5; float:right;">
                      
		</form>
	</div>
     <%
            HttpSession sesion=request.getSession();
            String tipo="";
            if(request.getAttribute("tipo")!=null){
                tipo=request.getAttribute("tipo").toString();
                if(tipo.equalsIgnoreCase("Administrador")){
                    sesion.setAttribute("usuario", request.getAttribute("usuario"));
                    sesion.setAttribute("tipo", tipo);
                    response.sendRedirect("BienvenidoAd.jsp");
                }else if(tipo.equalsIgnoreCase("Envios")){
                    sesion.setAttribute("usuario", request.getAttribute("usuario"));
                    sesion.setAttribute("tipo", tipo);
                    response.sendRedirect("BienvenidoEnv.jsp");
                }else if(tipo.equalsIgnoreCase("Ventas")){
                    sesion.setAttribute("usuario", request.getAttribute("usuario"));
                    sesion.setAttribute("tipo", tipo);
                    response.sendRedirect("BienvenidoVentas.jsp");
                }
            }
           
            if(request.getParameter("cerrar")!=null){
                session.invalidate();
            }
       %>
      
</body>    
</html>
