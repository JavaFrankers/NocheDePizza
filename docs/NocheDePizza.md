# El Documento
## NocheDePizza
![Noche de pizza?](/img/nochedepizza.png)
### Roles
| Persona | Tarea                |
| - |----------------------|
| Cristian | Pedido               |
| Esther | Cliente              |
| Josué Francisco | Cliente              |
| Diego | Docker-Conexion JDBC |
| Pablo | Producto             |
| Carlos | M/R                  |
### Requisitos Técnicos
| ToDo  | Requisito                    |
|-------|------------------------------|
| Done  | Java 21                      |
| WIP   | Maven4+módulos               |
| WIP   | Este documento               |
|       | MySQL+JDBC usando patrón DAO |
|       | App de consola               |
|       | Docker                       |
| Done? | Diagrama Modelo Relacional   |
|       | Capturas                     |

### Contenido de este documento

| ToDo  | Contenido            |
|-------|----------------------|
|       | Descripcíon          |
| Done? | Diagrama M/R         |
|       | Instrucciones de uso |
|       | Créditos             |

### Funciones extra:
| ToDo | Funcion |
| - | - |
|  |  |
### Objetos:
| ToDo | Objeto | Obl | SQL | Atributos |
| - | - | - | - | - |
|  | Cliente | Sí |  | Id, nombre, teléfono, dirección |
|  | Producto | Sí |  | Id, nombre, precio, tipo |
|  | Pedido | Sí |  | Id, cliente_id, fecha, total, estado |
|  | LineaPedido | Sí |  | Id, pedido_id, producto_id, cantidad |
### Funciones:
| ToDo | Funcion |
| - | - |
|  | CRUD cliente: insertar, lista, modificar, borrar. |
|  | CRUD producto: insertar, lista, modificar, borrar. |
|  | Crear pedido |
|  | Guardar estado final pedido (entregado o cancelado) |
|  | Listar pedidos del día (Cliente, total y estado) |
|  | Lista pedidos cliente (Mostrar todos los pedidos del cliente) |
