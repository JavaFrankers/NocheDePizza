CREATE DATABASE nochedepizza;
USE nochedepizza;

CREATE TABLE producto(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(32),
    precio DECIMAL(4,2),
    tipo VARCHAR(32)
);

CREATE TABLE cliente(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(32),
    telefono INT,
    direccion VARCHAR(64)
);

CREATE TABLE pedido(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    fecha DATE,
    total DECIMAL(4,2),
		INT
);

CREATE TABLE lineaPedido(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_producto INT,
    id_pedido INT,
    cantidad INT
);

ALTER TABLE pedido
ADD CONSTRAINT fk_pedido_cliente
FOREIGN KEY (id_cliente)
REFERENCES cliente(id);

ALTER TABLE lineaPedido
ADD CONSTRAINT fk_linea_producto
FOREIGN KEY (id_producto)
REFERENCES producto(id);

ALTER TABLE lineaPedido
ADD CONSTRAINT fk_linea_pedido
FOREIGN KEY (id_pedido)
REFERENCES pedido(id);