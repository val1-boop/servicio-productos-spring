# Servicio de Productos

API REST en Spring Boot que expone un catálogo de productos, construida como primer ejercicio de servicios web.

Universidad Tecnológica Emiliano Zapata (UTEZ).

## Endpoints

| Método | Ruta | Qué devuelve |
|---|---|---|
| `GET` | `/productos` | La lista completa de productos |
| `GET` | `/productos/{id}` | El producto con ese identificador |

Ejemplo de respuesta:

```json
[
  { "id": 1, "precio": 100.0, "nombre": "Producto 1", "categoria": "Categoria 1" },
  { "id": 2, "precio": 200.0, "nombre": "Producto 2", "categoria": "Categoria 2" }
]
```

## Estructura

```
src/main/java/
├── com/practica/servicio/
│   ├── ServicioApplication.java          # Punto de entrada
│   ├── controller/
│   │   └── ControllerProducto.java       # Endpoints REST
│   └── product/
│       └── Objeto.java                   # Modelo: id, precio, nombre, categoría
└── servicio/
    └── ServiceProducto.java              # Lógica de negocio y datos en memoria
```

La separación es la clásica de tres capas: el **controlador** recibe las peticiones HTTP, el **servicio** contiene la lógica y los datos, y el **modelo** define la forma del producto. El controlador no sabe de dónde salen los datos; solo le pide al servicio.

## Tecnologías

Java · Spring Boot · Spring Web · Maven

## Cómo ejecutarlo

```bash
./mvnw spring-boot:run
```

En Windows:

```bash
mvnw.cmd spring-boot:run
```

Después:

```bash
curl http://localhost:8080/productos
curl http://localhost:8080/productos/1
```

## Estado actual y siguientes pasos

Es un ejercicio de introducción a Spring Boot, con el alcance limitado a propósito. Lo que faltaría para acercarlo a un servicio real:

- **El servicio se instancia con `new` en lugar de inyectarse.** Anotar `ServiceProducto` con `@Service` y recibirlo por constructor en el controlador dejaría que Spring administre su ciclo de vida, que es la forma correcta de trabajar con el framework.
- **`ServiceProducto` está fuera del paquete base** (`servicio` en vez de `com.practica.servicio`), así que queda fuera del escaneo de componentes. Moverlo es requisito para el punto anterior.
- **Los datos viven en memoria**, en un `ArrayList` con tres productos fijos que se reinician con la aplicación. Conectar JPA y una base de datos sería el siguiente paso natural.
- **Consultar un id inexistente devuelve una respuesta vacía con código 200.** Lo correcto sería responder `404 Not Found` usando `ResponseEntity`.
- Solo hay operaciones de lectura. Faltan `POST`, `PUT` y `DELETE` para completar el CRUD.
