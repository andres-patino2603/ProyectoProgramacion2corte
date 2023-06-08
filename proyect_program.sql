# Host: localhost  (Version 8.0.31)
# Date: 2023-06-07 22:22:33
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "clientes"
#

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `idCliente` int NOT NULL,
  `nombre` varchar(120) DEFAULT NULL,
  `direccion` varchar(120) DEFAULT NULL,
  `telefono` varchar(120) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `Contraseña` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
# Data for table "clientes"
#

INSERT INTO `clientes` VALUES (1,'Andres','calle 44#46','3007044070','andrespatino0845@gmail.com','1111'),(11,'Admin','aaa','345','asd','admin'),(123,' Andres ',' andrespatino0845@gmail.com ',' calle44#46 ',' 3007044070 ','1111'),(190,' Luis ',' Calancala ',' 30885662 ',' luis@gmail.com ',' 1111 '),(2222,' Antonio ',' 3007#joajsd ',' 3008044080 ',' Antonio@gmail.com ',' 1111 '),(4444,' Juana ',' LLAjfgo@tjo ',' 300808499 ',' juana@gmail.com ',' 1111 '),(6666,' Juan ',' Venezuela #45 ',' 3007044070 ',' juan@gmail.com ',' 1111 '),(6767,' Juan ',' Venezuela #45 ',' 3007044070 ',' juan@gmail.com ',' 1111 '),(44444,' rerrere ',' fdsadss ',' 123123123 ',' fdsaefs ',' 1111 '),(123532,' asfa ',' 123541f ',' 12341 ',' asdsas ',' 12345 '),(444444,' rerrere ',' fdsadss ',' 123123123 ',' fdsaefs ',' 1111 '),(11982385,' Andres ',' calle 44 # 46 ',' 30094990 ',' Andres@gmail,com ','1111'),(886758827,' Antonieta ',' Calle56 # 46 esquina ',' 3000700489 ',' Juanadearco@gmail.com ','1111'),(1193580734,' Andres ',' Calle44 # 46-107 ',' 3007044070 ',' andrespatino0845@gmail.com ','1111');

#
# Structure for table "cuenta"
#

DROP TABLE IF EXISTS `cuenta`;
CREATE TABLE `cuenta` (
  `NoCuenta` bigint NOT NULL DEFAULT '0',
  `Saldo` int NOT NULL,
  `numero_tarjeta` varchar(120) NOT NULL,
  `Identificacion` int DEFAULT NULL,
  `Cupo` int DEFAULT NULL,
  `Contraseña` int DEFAULT NULL,
  PRIMARY KEY (`NoCuenta`),
  KEY `Identificacion` (`Identificacion`),
  CONSTRAINT `cuenta_ibfk_1` FOREIGN KEY (`Identificacion`) REFERENCES `clientes` (`idCliente`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
# Data for table "cuenta"
#

INSERT INTO `cuenta` VALUES (124,3747100,'20039841',1,6000000,1111),(1234,2798000,'20039841',1,5000000,1111),(1245,1000,'123123',1,123123,1111),(1253,3204124,'1243123',123,6789908,1111),(2222,0,'21212121',1,1000000,1111),(5555,3078000,'234567',190,6000000,1111),(8888,4845600,'1234542',1,5000000,1111),(8989,4082900,'1324212',2222,10000000,1111),(9999,40000000,'54312345542',1,40000000,1111),(12345,1000000,'12341244',1,5788888,1111),(12459,1100,'123123',1,123123,1111),(787878,798400,'1254321',4444,1000000,1111);

#
# Structure for table "pedido2"
#

DROP TABLE IF EXISTS `pedido2`;
CREATE TABLE `pedido2` (
  `idPedido` int NOT NULL,
  `total` double(10,2) NOT NULL DEFAULT '0.00',
  `estado` enum('PEN',' PA',' SER',' CON',' REC') NOT NULL DEFAULT 'PEN',
  `IdCliente` int NOT NULL DEFAULT '0',
  `IdDetal` int NOT NULL DEFAULT '0',
  `IdCom` int NOT NULL DEFAULT '0',
  `fechaPedido` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idPedido`),
  KEY `IdCliente` (`IdCliente`),
  CONSTRAINT `pedido2_ibfk_1` FOREIGN KEY (`IdCliente`) REFERENCES `clientes` (`idCliente`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
# Data for table "pedido2"
#

INSERT INTO `pedido2` VALUES (1,154400.00,' PA',1,1,1,'2023-06-07 14:24:16'),(2,10000.00,' PA',123,2,2,'2023-06-07 14:25:57'),(3,25700.00,' PA',2222,3,3,'2023-06-07 14:28:48'),(4,7600.00,' PA',1,4,4,'2023-06-08 14:45:16');

#
# Structure for table "pedidocom"
#

DROP TABLE IF EXISTS `pedidocom`;
CREATE TABLE `pedidocom` (
  `IdCom` int NOT NULL DEFAULT '0',
  `IdPedido` int NOT NULL DEFAULT '0',
  KEY `pedidocom_ibfk_1` (`IdPedido`),
  CONSTRAINT `pedidocom_ibfk_1` FOREIGN KEY (`IdPedido`) REFERENCES `pedido2` (`idPedido`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
# Data for table "pedidocom"
#

INSERT INTO `pedidocom` VALUES (1,1),(2,2),(3,3),(4,4);

#
# Structure for table "productos"
#

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(120) DEFAULT NULL,
  `precio` double(10,1) DEFAULT '0.0',
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
# Data for table "productos"
#

INSERT INTO `productos` VALUES (2,'Clorox',1900.0,45),(3,'Vanish',5000.0,70),(4,'Atún',4600.0,45),(6,' Kotex ',15000.0,60),(7,' Mermelada ',2500.0,5),(8,' Agua ',500.0,71),(9,' Guitarra ',150000.0,16),(10,' Otra vez no sé ',10000.0,50),(11,' Almendras ',6000.0,50),(12,'Oreo',1500.0,30),(13,'DeTodito',7000.0,51),(14,'No séee',1500.0,80);

#
# Structure for table "detalles"
#

DROP TABLE IF EXISTS `detalles`;
CREATE TABLE `detalles` (
  `IdDetal` int NOT NULL,
  `IdPedido` int NOT NULL,
  `Cantidad` int NOT NULL,
  `IdProducto` int NOT NULL,
  KEY `detalles_ibfk_1` (`IdPedido`),
  KEY `detalles_ibfk_2` (`IdProducto`),
  CONSTRAINT `detalles_ibfk_1` FOREIGN KEY (`IdPedido`) REFERENCES `pedido2` (`idPedido`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `detalles_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `productos` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
# Data for table "detalles"
#

INSERT INTO `detalles` VALUES (1,1,1,2),(1,1,1,9),(1,1,1,7),(2,2,4,7),(3,3,3,2),(3,3,8,7),(4,4,4,2);

#
# Structure for table "prueba"
#

DROP TABLE IF EXISTS `prueba`;
CREATE TABLE `prueba` (
  `Id` int NOT NULL,
  `valor` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `IdPedido` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
# Data for table "prueba"
#

INSERT INTO `prueba` VALUES (6,30000,2,1),(1,400000,2,1),(9,450000,3,2),(6,30000,2,2),(1,400000,2,2),(6,15000,1,3),(1,400000,2,3),(7,2500,1,3),(1,400000,2,1),(1,400000,2,1),(1,400000,2,2),(6,15000,1,2),(1,200000,1,2),(6,15000,1,3),(1,200000,1,3),(8,1500,1,1),(1,400000,2,1),(1,400000,2,1),(1,400000,2,1),(1,400000,2,2),(7,2500,1,2),(1,400000,2,1),(1,400000,2,2),(7,2500,1,2),(1,400000,2,1),(6,15000,1,1),(1,400000,2,1),(2,1900,1,2),(6,15000,1,2),(1,400000,2,2),(2,1900,1,3),(6,15000,1,3),(1,400000,2,3),(8,500,1,1),(8,500,1,1),(8,500,1,1),(8,500,1,2),(8,500,1,1),(8,500,1,2),(8,500,1,3),(8,500,1,4),(8,500,1,5),(8,500,1,1),(8,500,1,2),(8,500,1,1),(8,500,1,1),(8,500,1,2),(8,500,1,1),(8,2000,2,1),(8,2500,3,1),(8,500,1,1),(8,500,1,1),(8,1000,2,1),(8,1000,2,1),(8,1000,2,1),(8,500,1,1),(8,500,1,1),(8,500,1,1),(8,500,1,1),(8,500,1,2),(8,500,1,1),(8,500,1,2),(8,500,1,1),(8,500,1,1),(8,500,1,1),(8,500,1,1),(8,500,1,1),(8,500,1,1),(8,500,1,2),(8,500,1,15),(8,500,1,15),(8,500,1,15),(8,500,1,15),(8,500,1,16),(8,500,1,17),(8,500,1,17),(8,500,1,17),(8,500,1,18),(8,500,1,19),(8,500,1,20),(8,500,1,21),(8,500,1,22),(8,500,1,23),(8,500,1,1),(8,500,1,2),(8,500,1,3),(7,2500,1,3),(3,5000,1,4),(8,500,1,4),(7,10000,2,4),(8,500,1,5),(7,5000,2,5),(8,1000,2,6),(7,7500,3,6),(8,1000,2,7),(7,7500,3,7),(8,2000,4,8),(1,200000,1,8),(4,18400,4,9),(2,38000,20,9),(6,30000,2,9),(8,5000,10,9),(1,800000,4,9),(1,1000000,5,10),(4,92000,20,11),(8,10000,20,11),(7,50000,20,11),(2,38000,20,12),(2,38000,20,13),(13,49000,7,14),(4,9200,2,15),(2,1900,1,15),(9,150000,1,15),(7,2500,1,15),(9,300000,2,16),(6,15000,1,16),(13,7000,1,16),(9,600000,4,17),(13,7000,1,18),(2,1900,1,19),(2,1900,1,19),(2,1900,1,1),(9,150000,1,1),(7,2500,1,1),(7,10000,4,2),(2,5700,3,3),(7,20000,8,3),(2,7600,4,4);

#
# Trigger "actualizarIDs"
#

DROP TRIGGER IF EXISTS `actualizarIDs`;
proyect_program

#
# Trigger "insertar_pedidoCom"
#

DROP TRIGGER IF EXISTS `insertar_pedidoCom`;
proyect_program
