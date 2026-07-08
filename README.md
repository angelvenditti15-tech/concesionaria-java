# IFES - Análisis de Sistemas - Programación 1
## TP Grupal - Sistema de Concesionaria

### Integrantes:
* **Angel Venditti**

---

## Descripción del Proyecto
Sistema de gestión de una concesionaria de vehículos desarrollado en Java. Permite registrar vehículos (autos, motos y camiones), gestionar clientes, realizar ventas y test drives, y persistir los datos entre ejecuciones.

### Características principales de la arquitectura:
* **Abstracción y Herencia:** Modelado estructurado de entidades mediante clases base (`Persona` y `Vehiculo`) y subclases especializadas (`Vendedor`, `Cliente`, `Auto`, `Moto`, `Camion`).
* **Diseño desacoplado mediante Interfaces:** Implementación de contratos lógicos como `IRepositorio` para la persistencia y manipulación del stock, e `ITransaccionable` para procesar flujos comerciales.
* **Gestión robusta de errores:** Creación de lógica para el manejo de excepciones personalizadas (`VehiculoNoDisponibleException`), asegurando la integridad de las transacciones.
* **Capa de Persistencia (Pattern Repository):** Diseño de un sistema de almacenamiento simulado (`RepositorioVehiculo`) para aislar la lógica de negocio.

---

## Tecnologías y Conceptos Aplicados:
* **Java 17+**
* **Programación Orientada a Objetos (POO)** avanzado
* **Collections Framework**
* **Streams & Lambdas**
* **Serialización** (Persistencia de datos)
* **Git**

---

## Instrucciones de Ejecución
*(Ejecutar desde la raíz del proyecto en la terminal)*

javac -d bin modelo/*.java interfaces/*.java excepciones/*.java repositorio/*.java convecionaria/*.java Main.java

java -cp bin Main


1. **Crear carpeta bin si no existe:**
   ```bash
   mkdir bin
