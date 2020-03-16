-- CREACION DE LA TABLA DE ERP2020
use ERP2020;
create database ERP2020
on primary
(
name=ERP2020_dat,--nombre logico del archivo de datos
filename='C:\Bases_Datos\ERP2020\ERP2020_dat.mdf',--nombre fisico
size=5MB, 
maxsize=10MB, 
filegrowth=1MB

)
log on
(
name=ERP2020_log,--nombre logioc del archivo de log
filename='C:\Bases_Datos\ERP2020\ERP2020_log.ldf',--nombre fisico
size=3MB, 
maxsize=6MB, 
filegrowth=1MB
)
go

-- CREACION DE LA TABLA DE PRODUCTOS
Create table Productos(
    idProducto integer not null,
    nombre varchar(50),
    descripcion varchar (100),
    puntoReorden integer,
    genero char,
    precioCompra float,
    precioVenta float,
    estatus char,
    material varchar(100),
    idMarca integer not null,
    idEstilo integer not null,
    idCategoria integer not null,
    constraint pk_Producto primary key(idProducto)
)
-- CREACION DE LA TABLA DE MARCAS
Create table Marcas(
    idMarca integer not null,
    nombre varchar(50),
    origen varchar(30),
    constraint pk_Marcas primary key (idMarca)
)
-- CREACION DE LA TABLA DE ESTILOS
Create table Estilos(
    idEstilo integer not null,
    nombre varchar(30),
    constraint  pk_Estilos primary key (idEstilo)
)
-- CREACION DE LA TABLA DE CATEGORIAS
Create Table Categorias(
    idCategoria integer not null,
    nombre varchar(30),
    constraint pk_Categorias primary key (idCategoria)
)
-- CREACION DE LA TABLA DE COLORES 
Create table Colores(
idColor integer not null,
nombre varchar(30),
constraint pk_Colores primary key (idColor)
)
-- CREACION DE LA TABLA DE DETALLES PRODUCTOS
Create table DetalleProductos(
    idProductoDetalle integer not null,
    talla float,
    existencia integer,
    idColor integer not null,
    idProducto integer not null,
    constraint pk_DetalleProductos primary key (idProductoDetalle)
)

-- CREACION DE LA TABLA DE EMPLEADO
Create table Empleado(
idEmpleado integer not null,
nombre varchar(20),
apaterno varchar (30),
amaterno varchar (30),
sexo char,
fotografia image,
tipo char,
email varchar (100),
constraint pk_idEmpleado primary key (idEmpleado)
) 

-- CREACION DE LA TABLA DE ClIENTES
Create table Clientes 
(
idCliente integer not null,
dirección varchar(80),
codigoPostal char(5),
rfc char(13),
telefono char (12),
email varchar(100),
tipo char,
idCiudad integer,
constraint pk_idCliente  primary key(idCliente)
);
-- CREACION DE LA TABLA DE VENTAS
Create table Ventas(
idVenta integer not null,
fecha date,
totalPagar float,
cantPagada float,
comentarios varchar(100),
estatus char,
idCliente integer,
idEmpleado integer not null,
constraint pk_idVenta primary key(idVenta)
) 
-- CREACION DE LA TABLA DE PAGOS
Create table Pagos(
idPago integer not null,
fecha date,
importe float,
idVenta integer,
idFormaPago integer,
constraint pk_idPago primary key (idPago)
)
-- CREACION DE LA TABLA DE DEVOLUCIONES
Create table Devoluciones(
idDevolucion integer not null,
fecha date,
idProductoDetalle integer,
cantidad integer,
precioUnitario integer,
total float,
motivo varchar(200),
idVenta integer not null,
constraint pk_Devoluciones primary key(idDevolucion)
)
-- CREACION DE LA TABLA DE FACTURAS
Create table Facturas(
folio char not null,
subtotal float,
iva float,
total float,
nombreDocXML varchar(100),
documentoXML varbinary(MAX),
nombreDocPDF varbinary(MAX),
docuentoPDF  varbinary(MAX),
idVenta integer not null,
constraint pk_Facturas primary key(folio)
)
-- CREACION DE LA TABLA DE UNIDADESTRANSPORTE
Create table UnidadesTransporte(
idUnidadTransporte integer not null,
placas varchar (10),
marca varchar (80),
modelo varchar (80),
anio integer,
capacidad integer,
constraint pk_UnidadesTransporte primary key(idUnidadTransporte)
)
-- CREACION DE LA TABLA DE ENVIOS VENTAS
Create table EnviosVentas(
idEnvio integer not null,
idVenta integer not null,
fechaEntregaPlanteada date,
fechaEntregaReal date,
constraint pk_enviosVentas primary key(idEnvio,idVenta)
)
-- CREACION DE LA TABLA DE ENVIOS
Create table Envios(
idEnvio integer not null,
fechaSalida date,
idUnidadTransporte integer not null,
constraint pk_Envios primary key(idEnvio)
)
-- CREACION DE LA TABLA DE TRIPULACION
Create table Tripulacion(
idEmpleado integer not null,
idEnvio integer not null,
rol varchar(20),
constraint pk_Tripulacion primary key (idEmpleado,idEnvio)
)

-- CREACION DE LA TABLA DE VENTAS DETALLE
Create table VentasDetalle(
idVentaDetalle integer not null,
precioUnitario float,
cantidad float,
subtotal float,
idVenta integer not null,
idProductoDetalle integer not null
constraint pk_VentaDetalle primary key(idVentaDetalle)
)
-- CREACION DE LA TABLA DE VENTASOFERTAS
Create table VentasOfertas(
idVentaDetalle integer not null,
idProducto integer not null,
idOferta integer not null,
constraint pk_VentasOfertas primary key (idVentaDetalle,idProducto,idOferta)
)


-- CREACION DE LA TABLA DE OFERTA
Create table Ofertas(
idOferta integer not null,
nombre varchar (50),
despricion varchar (100),
porDescuento float,
fechaInicio date,
fechafin date,
canMinProducto integer,
estatus char,
constraint pk_Ofertas primary key (idOferta)
)
-- CREACION DE LA TABLA DE CLIENTE INDIVIDUAL
Create table ClienteIndividual(
idCliente integer not null,
nombre varchar (30),
apaterno varchar (30),
amaterno varchar (30),
sexo char,
constraint pk_ClienteIndividual primary key (idCliente)
)
-- CREACION DE LA TABLA DE CLIENTE TIENDA
Create table ClienteTienda(
idCliente integer not null, 
nombre varchar(60),
contacto varchar(90),
limiteCredito float
constraint pk_ClienteTienda primary key (idCliente)
)


	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA VENTAS
alter table Ventas add constraint fk_ventas_idCliente_Clientes foreign key(idCliente) references Clientes(idCliente);
alter table Ventas add constraint fk_ventas_idEmpleado_Empleado foreign key (idempleado) references Empleado(idEmpleado)

	-- CREACIONE DE FOREIGN KEY PARA LA TABLA CLIENTE INDIVIDUAL
alter table ClienteIndividual add constraint fk_individual_idCliente_Clientes foreign key(idCliente) references Clientes(idCliente);
	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA CLIENTE TIENDA
alter table ClienteTienda add constraint fk_tienda_idCliente_Clientes foreign key(idCliente) references Clientes(idCliente);
	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA PAGOS
alter table Pagos add constraint fk_pagos_idVenta_Ventas foreign key(idVenta) references Ventas(idVenta);
	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA DEVOLUCIONES
alter table Devoluciones add constraint fk_devoluciones_idVenta_Ventas foreign key(idVenta) references Ventas(idVenta) 
	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA FACTURAS
alter table Facturas add constraint fk_faturas_idVenta_Ventas foreign key (idVenta) references Ventas(idVenta)
	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA ENVIOS VENTAS
alter table EnviosVentas add constraint fk_enviosVen_idVenta_Ventas foreign key (idVenta) references Ventas(idVenta)
alter table EnviosVentas add constraint fk_enviosVen_idEnvio_Envios foreign key (idEnvio) references Envios(idEnvio)

	-- CREACIONE DE FOREIGN KEY PARA LA TABLA ENVIOS VENTASOFERTAS
alter table VentasOfertas add constraint fk_Ofertas_VentasOfertas foreign key (idOferta) references Ofertas(idOferta) 
alter table VentasOfertas add constraint fk_Productos_VentasOfertas foreign key(idProducto) references Productos(idProducto)
	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA VENTAS DETALLE
alter table VentasDetalle add constraint fk_ventasDetalle_idVenta_Ventas foreign key (idVenta) references Ventas(idVenta)
	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA ENVIOS UNIDADES TRASNPORTE 
alter table Envios add constraint fk_idUnidadTransporte_UnidadesTransporte foreign key (idUnidadTransporte) references UnidadesTransporte(idUnidadTransporte)
	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA TRIPULACION
alter table Tripulacion add constraint fk_idEnvio_Envios foreign key (idEnvio) references Envios(idEnvio)
	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA VENTAS OFERTAS
alter table VentasOfertas add constraint fk_idVentaDetalle_VentasDetalle foreign key (idVentaDetalle) references VentasDetalle(idVentaDetalle)
---alter table VentasOfertas add constraint fk_idVentaDetalle_VentasOfreta foreign key (idOferta) references VentasOferta(idOferta)
	
	-- CREACIONE DE FOREIGN KEY PARA LA TABLA OFERTAS EMPLEADOS
alter table Tripulacion add constraint fk_Tripulacion_idEmpleado_Empleado foreign key (idEmpleado ) references Empleado(idEmpleado) 

    -- CREACIONE DE FOREIGN KEY PARA LA TABLA PRODUCTOS
alter table Productos add constraint fk_Productos_Marcas foreign key(idMarca) references Marcas(idMarca)
alter table Productos add constraint fk_Productos_Estilos foreign key(idEstilo) references Estilos(idEstilo)
alter table Productos add constraint fk_Productos_Categorias foreign key(idCategoria) references Categorias(idCategoria)

    -- CREACIONE DE FOREIGN KEY PARA LA TABLA DETALLEPRODUCTOS
alter table DetalleProductos add constraint fk_DetalleProductos_Colores foreign key(idColor) references Colores(idColor)
alter table DetalleProductos add constraint fk_DetalleProductos_Productos foreign key(idProducto) references Productos(idProducto)

 ----------------------------- MODULO RH -----------------------------
  create table RHEstado
(
	idEstado integer identity(1,1) not null,
	nombre varchar(60) not null,
	siglas varchar(10) not null
		constraint Estado_PK primary key (idEstado)
)

create table RHCiudades
(
	idCiudad integer identity(1,1) not null,
	nombre varchar(80) not null,
	Estado_idEstado integer not null
		constraint Ciudades_PK primary key (idCiudad),
	constraint Cudades_Estado_FK foreign key (Estado_idEstado) references RHEstado(idEstado)
)

create table RHDepartamentos
(
	idDepartamento integer identity(1,1) not null,
	nombre varchar(50) not null
		constraint Departamentos_PK primary key (idDepartamento)
)

create table RHPuestos
(
	idPuesto integer identity(1,1) not null,
	nombre varchar(60) not null,
	salarioMinimo float not null,
	salarioMaximo float not null,
	constraint Puestos_PK primary key (idPuesto)
)

create table RHEmpleados
(
	idEmpleado integer identity(1,1) not null,
	nombre varchar (30) not null,
	apaterno varchar (30) not null,
	amaterno varchar (30) not null,
	sexo char not null,
	fechaContratacion date not null default getdate(),
	fechaNacimiento date not null,
	salario float not null,
	nss varchar(10) not null,
	estadoCivil varchar(20) not null,
	diasVacaciones integer not null,
	diasPermiso integer not null,
	fotografia image not null,
	direccion varchar(80) not null,
	colonia varchar (50) not null,
	codigoPostal varchar(5) not null,
	escolaridad varchar(80) not null,
	porcentajeComision float not null,
	idDepartamento integer not null,
	idPuesto integer not null,
	idCiudad integer not null
		CONSTRAINT Empleados_PK PRIMARY KEY (idEmpleado),
	constraint chk_Sexo check (sexo in ('F','M')),
	constraint Empleados_Departamentos_FK foreign key (idDepartamento) references RHDepartamentos(idDepartamento),
	constraint Empleados_Puestos_FK foreign key (idPuesto) references RHPuestos(idPuesto),
	constraint Empleados_Ciudades_FK foreign key (idCiudad) references RHCiudades(idCiudad)
)

create table RHHistorialPuestos
(
	idEmpleado integer not null,
	idPuesto integer not null,
	idDepartamento integer not null,
	fechaInicio date not null,
	fechaFin date,
	salario float not null
		constraint FK_Historial_Empleados foreign key (idEmpleado) references RHEmpleados (idEmpleado),
	constraint FK_Historial_Puestos foreign key (idPuesto) references RHPuestos (idPuesto),
	constraint FK_Historial_Departamentos foreign key (idDepartamento) references RHDepartamentos (idDepartamento),
	constraint PK_HistorialPuestos primary key (idEmpleado,idPuesto,idDepartamento,fechaInicio)
	--constraint chk_fecha check (fechaFin>=fechaInicio)
)

create table RHDocumentacionEmpleado
(
	idDocumento integer identity(1,1) not null,
	nombreDocumento varchar(80) not null,
	fechaEntrega Date not null,
	documento varbinary(max) not null,
	idEmpleado integer not null
		constraint PK_DocumentacionEmpleado primary key (idDocumento),
	constraint FK_Documentacion_Empleado foreign key (idEmpleado) references RHEmpleados(idEmpleado)
)

create table RHIncapacidades
(
	idIncapacidad integer identity(1,1) not null,
	fechaInicio date not null,
	fechaFin date,
	enefermedad varchar(90) not null,
	idEmpleado integer not null
		constraint PK_Incapacidades primary key (idIncapacidad),
	constraint FK_Incapacidades_Empleado foreign key (idEmpleado) references RHEmpleados (idEmpleado),
	--constraint chk_fechaIncapacidad check (fechaFin>=fechaInicio)
)

create table RHHorarios
(
	idHorario integer identity(1,1) not null,
	horaInicio date not null,
	horaFin date not null,
	dias varchar(30) not null,
	idEmpleado integer not null
		constraint PK_Horarios primary key (idHorario)
		constraint FK_Horarios_Empleado foreign key (idEmpleado) references RHEmpleados (idEmpleado),
	--constraint chk_horario check (HoraFin>HoraInicio)
)

create table RHAusenciasJustificadas
(
	idAusencia integer identity(1,1) not null,
	fechaSolicitud date not null,
	fechaInicio date not null,
	fechaFin date not null,
	tipo char not null,
	idEmpleadoS integer not null,
	idEmpleadoA integer not null
		constraint PK_AusenciasJustificadas primary key(idAusencia),
	constraint FK_Ausencia_EmpleadosS foreign key (idEmpleadoS) references RHEmpleados (idEmpleado),
	constraint FK_Ausencia_EmpleadosA foreign key (idEmpleadoA) references RHEmpleados (idEmpleado),
	--constraint chk_fechaSolicitud check (fechaSolicitud>=fechaInicio),
	--constraint chk_fechaFin check (FechaFin>=fechaInicio)
)

create table RHNominas
(
	idNomina integer not null,
	fechaPago date not null,
	totalP float not null,
	totalD float not null,
	cantidadNeta float not null,
	diasTrabajados integer not null,
	faltas integer not null,
	fechaInicio date not null,
	fechaFin date not null,
	idEmpleado integer not null
		constraint PK_Nominas primary key (idNomina)
		constraint FK_Nominas_Empleado foreign key (idEmpleado) references RHEmpleados (idEmpleado),
	constraint chk_fechapagoNomina check (FechaPago>=fechaFin),
	constraint chk_fechafinNomina check (FechaFin>=fechaInicio),
)

create table RHDeducciones
(
	idDeduccion integer not null,
	nombre varchar(30) not null,
	descripcion varchar(80) not null,
	porcentaje float not null
		constraint PK_Deducciones primary key(idDeduccion)
)

create table RHNominasDeducciones
(
	idNomina integer not null,
	idDeduccion integer not null,
	importe float not null
		constraint PK_NominasDeducciones primary key (idNomina,idDeduccion),
	constraint FK_Nominas foreign key (idNomina) references RHNominas (idNomina),
	constraint FK_Deducciones foreign key (idDeduccion) references RHDeducciones
)

create table RHPercepciones
(
	idPercepcion integer not null,
	nombre varchar(30) not null,
	descripcion varchar(80) not null,
	diasPagar integer not null,
	constraint PK_Percepciones primary key (idPercepcion)
)

create table RHNominasPercepciones
(
	idNomina integer not null,
	idPercepcion integer not null,
	importe float not null
		constraint PK_NominasPercepciones primary key (idNomina,idPercepcion),
	constraint FK_NominaPercepcion foreign key (idNomina) references RHNominas(idNomina),
	constraint FK_Percepcion foreign key (idPercepcion) references RHPercepciones (idPercepcion)
)
go

CREATE TABLE RHUsuarios
(
	idUsuarios INT PRIMARY KEY NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	contraseña INT NOT NULL,
	estatus CHAR NOT NULL,
	tipo CHAR NOT NULL,
	fechaRegistro DATE NOT NULL,
	fotoPerfil image,
	idEmpleado INT NOT NULL FOREIGN KEY REFERENCES RHEmpleados (idEmpleado)
);
----------------------------- MODULO COMPRAS -----------------------------
create table ComprasProductos
(
	idProducto integer not null identity(1,1),
	nombre varchar(50) not null,
	descripcion varchar(100) not null,
	puntoReorden integer not null,
	genero char not null,
	precioCompra float not null,
	precioVenta float not null,
	estatus char not null,
	materia varchar(100) not null,
	idMarca integer not null,
	idEstilo integer not null,
	idCategoria integer not null
)

create table ComprasImagenesProducto
(
	idImagen integer identity(1,1) not null,
	nombreImagen varchar(100) not null,
	imagen image not null,
	principal char not null,
	idProducto integer not null
)

create table ComprasMarcas
(
	idMarca integer not null identity(1,1),
	nombre varchar(50) not null,
	origen varchar(30) not null
)

create table ComprasEstilos
(
	idEstilo integer not null identity(1,1),
	nombre varchar(30) not null
)

create table ComprasCategorias
(
	idCategoria integer not null identity(1,1),
	nombre varchar(30)
)

create table ComprasColores
(
	idColor integer not null identity(1,1),
	nombre varchar(30)
)

create table ComprasDetalleProductos
(
	idProductoDetalle integer not null identity(1,1),
	talla float not null,
	existencia integer not null,
	idColor integer not null,
	idProducto integer not null
)

create table ComprasProveedores
(
	idProveedor integer identity(1,1) not null,
	nombre varchar(80) not null,
	telefono char(12) not null,
	email varchar(100) not null,
	direccion varchar(80) not null,
	colonia varchar(50) not null,
	codigoPostal varchar(5) not null,
	idCiudad integer not null
)

create table ComprasContactosProveedor
(
	idContacto integer not null identity(1,1),
	nombre varchar(80) not null,
	telefono char(12) not null,
	email varchar(100)not null,
	idProveedor integer not null,
)

create table ComprasCuentasProveedor
(
	idProveedor integer not null,
	noCuenta varchar(10) not null,
	banco varchar(30) not null
)

create table ComprasPedidos
(
	idPedido integer not null identity(1,1),
	fechaRegistro date not null default getdate(),
	fechaRecepcion date not null,
	totalPagar float not null,
	cantidadPagada float not null,
	estatus char not null,
	idProveedor integer not null,
	idEmpleado integer not null
)

create table ComprasPedidoDetalle
(
	idPedido integer not null ,
	idProductoDetalle integer not null,
	cantPedida integer not null,
	precioUnitario float not null,
	subtotal float not null,
	cantRecibida integer not null,
	cantRechazada integer not null,
	cantAceptada float not null
)

create table ComprasFormasPago
(
	idFormaPago integer not null identity(1,1),
	nombre varchar(20)
)

create table ComprasPagosCompras
(
	idPago integer not null identity(1,1),
	fecha date not null default getdate(),
	importe float not null,
	idPedido integer not null,
	idFormaPago integer not null
)

create table ComprasProductosProveedor
(
	idProducto integer not null,
	idProveedor integer not null,
	diasRetardo integer not null,
	precioEstandar float not null,
	precioUltimaCompra float not null,
	cantMinPedir integer not null,
	cantMaxPedir integer not null
)

alter table ComprasProveedores add constraint Proveedores_PK primary key(idProveedor)

alter table ComprasContactosProveedor add constraint ContactosProveedor_PK primary key (idContacto)
alter table ComprasContactosProveedor add constraint ContactosProveedor_Proveedores_FK foreign key (idProveedor)
references ComprasProveedores(idProveedor)
----- CuentasProveedor -----
alter table ComprasCuentasProveedor add constraint CuentasProveedor_PK primary key (idProveedor,noCuenta,banco)
alter table ComprasCuentasProveedor add constraint CuentasProveedor_Proveedores_FK foreign key (idProveedor)
references ComprasProveedores(idProveedor)

----- Marcas -----
alter table ComprasMarcas add constraint Marcas_PK primary key(idMarca)

----- Estilos -----
alter table ComprasEstilos add constraint Estilos_PK primary key (idEstilo)

----- Categorias -----
alter table ComprasCategorias add constraint Categorias_PK primary key (idCategoria)

----- Colores -----
alter table ComprasColores add constraint Colores_PK primary key (idColor)

----- Productos -----
alter table ComprasProductos add constraint Productos_PK primary key (idProducto)
alter table ComprasProductos add constraint Productos_Marcas_FK foreign key(idMarca) references ComprasMarcas(idMarca)
alter table ComprasProductos add constraint Productos_Estilo_FK foreign key(idEstilo) references ComprasEstilos(idEstilo)
alter table ComprasProductos add constraint Productos_Categorias_FK foreign key(idCategoria) references ComprasCategorias(idCategoria)

----- ImagenesProducto -----
alter table ComprasImagenesProducto add constraint ImagenesProducto_PK primary key(idImagen)
alter table ComprasImagenesProducto add constraint ImagenesProducto_Producto_FK foreign key(idProducto) references ComprasProductos(idProducto)

----- DetalleProductos -----
alter table ComprasDetalleProductos add constraint DetalleProductos_PK primary key (idProductoDetalle)
alter table ComprasDetalleProductos add constraint DetalleProductos_Color_FK foreign key(idColor) references ComprasColores(idColor)
alter table ComprasDetalleProductos add constraint DetalleProductos_Productos_FK foreign key(idProducto) references ComprasProductos(idProducto)

----- Pedidos ----- 
alter table ComprasPedidos add constraint Pedidos_PK primary key(idPedido)
alter table ComprasPedidos add constraint Pedidos_Proveedores_FK foreign key(idProveedor) references ComprasProveedores(idProveedor)

----- PedidoDetalle -----
alter table ComprasPedidoDetalle add constraint PedidoDetalle_PK primary key (idPedido,idProductoDetalle)
alter table ComprasPedidoDetalle add constraint PedidoDetalle_DetalleProducto_FK foreign key (idProductoDetalle) references ComprasDetalleProductos(idProductoDetalle)
alter table ComprasPedidoDetalle add constraint PedidoDetalle_Pedidos_FK foreign key (idPedido) references ComprasPedidos(idPedido)

----- FormasPago -----
alter table ComprasFormasPago add constraint FormasPago_PK primary key (idFormaPago)

----- Pagos -----
alter table ComprasPagosCompras add constraint PagosCompras_PK primary key(idPago)
alter table ComprasPagosCompras add constraint PagosCompras_Pedidos_FK foreign key (idPedido) references ComprasPedidos(idPedido)
alter table ComprasPagosCompras add constraint PagosCompras_FormasPago_FK foreign key(idFormaPago) references ComprasFormasPago(idFormaPago)

----- ProductosProveedor -----
alter table ComprasProductosProveedor add constraint ProductosProveedor_PK primary key(idProducto,idProveedor)
alter table ComprasProductosProveedor add constraint ProductosProveedor_Productos_FK foreign key(idProducto) references ComprasProductos(idProducto)
alter table ComprasProductosProveedor add constraint ProductosProveedor_Proveedores_FK foreign key(idProveedor) references ComprasProveedores(idProveedor)
