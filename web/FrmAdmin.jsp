<%@page import="com.sun.xml.wss.saml.assertion.saml11.jaxb10.AuthorityBinding"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>

<!-- navBar -->
	<div class="full-width navBar">
		<div class="full-width navBar-options">
			<i class="zmdi zmdi-more-vert btn-menu" id="btn-menu"></i>	
			<div class="mdl-tooltip" for="btn-menu">Menu</div>
			<nav class="navBar-options-list">
				<ul class="list-unstyle">
					<li class="btn-exit" id="btn-exi">
						<i class="zmdi zmdi-power"></i>
						<div class="mdl-tooltip" for="btn-exi">Salir</div>
					</li>
                                      
                                        <!---<li class="text-condensedLight noLink" ><small><--%= sesion.getAttribute("usuario")%></small></li>--->
					<li class="noLink">
						<figure>
							<img src="assets/img/avatar-male.png" alt="Avatar" class="img-responsive">
						</figure>
					</li>
				</ul>
			</nav>
		</div>
	</div>
	<!-- navLateral -->
	<section class="full-width navLateral">
		<div class="full-width navLateral-bg btn-menu"></div>
		<div class="full-width navLateral-body">
			<div class="full-width navLateral-body-logo text-center tittles">
				<i class="zmdi zmdi-close btn-menu"></i> Administrador
			</div>
			<figure class="full-width" style="height: 77px;">
				<div class="navLateral-body-cl">
					<img src="assets/img/avatar-male.png" alt="Avatar" class="img-responsive">
				</div>
				<figcaption class="navLateral-body-cr hide-on-tablet">
					<span>
						Bienvenido<br>
						<small>Admin</small>
					</span>
				</figcaption>
			</figure>
			<div class="full-width tittles navLateral-body-tittle-menu">
				<i class="zmdi zmdi-desktop-mac"></i><span class="hide-on-tablet">&nbsp; ESCRITORIO</span>
			</div>
			
			<nav class="full-width">
				<ul class="full-width list-unstyle menu-principal">
					<li class="full-width divider-menu-h"></li>
					<!--inicio almacen---->
					<li class="full-width">
						<a href="#" class="full-width btn-subMenu">
							<div class="navLateral-body-cl">
								<i class="zmdi zmdi-case"></i>
							</div>
							<div class="navLateral-body-cr hide-on-tablet">
								AlMACEN
							</div>
							<span class="zmdi zmdi-chevron-left"></span>
						</a>
						<ul class="full-width menu-principal sub-menu-options">
							<li class="full-width">
							<a href="diseño.jsp" class="full-width">
								<div class="navLateral-body-cl">
									<i class="zmdi zmdi-label"></i>
								</div>
								<div class="navLateral-body-cr hide-on-tablet">
									DISEÑOS
								</div>
							</a>
						   </li>
                                                   

						</ul>
					</li>
					<!--fin almacen---->
					
					
					<!--inicio ventas---->
					<li class="full-width divider-menu-h"></li>
					<li class="full-width">
						<a href="#" class="full-width btn-subMenu">
							<div class="navLateral-body-cl">
								<i  class="zmdi zmdi-shopping-cart"></i>
							</div>
							<div class="navLateral-body-cr hide-on-tablet">
								VENTA
							</div>
							<span class="zmdi zmdi-chevron-left"></span>
						</a>
						<ul class="full-width menu-principal sub-menu-options">
						<li class="full-width divider-menu-h"></li>	
							<li class="full-width">
                                                            <a href="clientes.jsp" class="full-width">
                                                                    <div class="navLateral-body-cl">
                                                                    <i class="zmdi zmdi-account "></i>
                                                                    </div>
                                                                    <div class="navLateral-body-cr hide-on-tablet">
                                                                            CLIENTES
                                                                    </div>
                                                            </a>
							</li>
							<li class="full-width">
							<a href="RegistrarVenta.jsp" class="full-width">
							<div class="navLateral-body-cl">
							<i class="zmdi zmdi-shopping-cart"></i>							
							</div>
							<div  class="navLateral-body-cr hide-on-tablet">
								VENTAS
							</div>
						    </a>
							</li>
						
						</ul>
					</li>
					<!--fin ventas---->
					<!--iniio Envios-->
                                        <li class="full-width divider-menu-h"></li>
					<li class="full-width">
						<a href="#" class="full-width btn-subMenu">
							<div class="navLateral-body-cl">
								<i  class="zmdi zmdi-shopping-cart"></i>
							</div>
							<div class="navLateral-body-cr hide-on-tablet">
								ENVIOS
							</div>
							<span class="zmdi zmdi-chevron-left"></span>
						</a>
						<ul class="full-width menu-principal sub-menu-options">
						<li class="full-width divider-menu-h"></li>	
							<li class="full-width">
                                                            <a href="proveedor.jsp" class="full-width">
                                                                    <div class="navLateral-body-cl">
                                                                    <i class="zmdi zmdi-account "></i>
                                                                    </div>
                                                                    <div class="navLateral-body-cr hide-on-tablet">
                                                                     UNIDADES DE TRANSPORTE                 
                                                                    </div>
                                                            </a>
							</li>
							<li class="full-width">
							<a href="compra.jsp" class="full-width">
							<div class="navLateral-body-cl">
							<i class="zmdi zmdi-shopping-cart"></i>							
							</div>
							<div  class="navLateral-body-cr hide-on-tablet">
								TRIPULACION
							</div>
						    </a>
							</li>
						
						</ul>
					</li>
                                        <!--fin Envio-->
					<!--inicio Acceso---->
					<li class="full-width divider-menu-h"></li>
					<li class="full-width">
						<a href="#!" class="full-width btn-subMenu">
							<div class="navLateral-body-cl">
								<i class="zmdi zmdi-face"></i>
							</div>
							<div class="navLateral-body-cr hide-on-tablet">
								ACCESO
							</div>
							<span class="zmdi zmdi-chevron-left"></span>
						</a>
						<ul class="full-width menu-principal sub-menu-options">
							<li class="full-width">
								<a href="usuarios.jsp" class="full-width">
									<div class="navLateral-body-cl">
										<i class="zmdi zmdi-key"></i>
									</div>
									<div class="navLateral-body-cr hide-on-tablet">
										USUARIOS
									</div>
								</a>
							</li>
                                                        <li class="full-width">
								<a href="empleado.jsp" class="full-width">
									<div class="navLateral-body-cl">
										<i class="zmdi zmdi-account"></i>
									</div>
									<div class="navLateral-body-cr hide-on-tablet">
										EMPLEADOS
									</div>
								</a>
							</li>
							
							
						</ul>
					</li>
					<!--fin acceso---->
                                        
                                        <!--inicio archivos---->
					<li class="full-width divider-menu-h"></li>
					<li class="full-width">
						<a href="#!" class="full-width btn-subMenu">
							<div class="navLateral-body-cl">
								<i class="zmdi zmdi-folder"></i>
							</div>
							<div class="navLateral-body-cr hide-on-tablet">
								ARCHIVOS
							</div>
							<span class="zmdi zmdi-chevron-left"></span>
						</a>
						<ul class="full-width menu-principal sub-menu-options">
							<li class="full-width">
								<a href="ArchivosPDF.jsp" class="full-width">
									<div class="navLateral-body-cl">
										<i class="zmdi zmdi-cloud-circle"></i>
									</div>
									<div class="navLateral-body-cr hide-on-tablet">
										PDF
									</div>
								</a>
							</li>
                                                       
						</ul>
                                                 
					</li>
					<!--fin archivos---->

				
				</ul>
			</nav>
			
		
		
		</div>
	</section>