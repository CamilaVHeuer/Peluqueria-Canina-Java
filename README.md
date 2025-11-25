# 🐕 Sistema de Gestión - Peluquería Canina

Sistema de gestión desarrollado en Java para peluquerías caninas que permite administrar información de mascotas y sus propietarios de manera eficiente y sencilla.

## 📋 Descripción del Proyecto

Esta aplicación de escritorio está diseñada para propietarios de peluquerías caninas que necesitan gestionar la información de sus clientes (mascotas y dueños). Proporciona una interfaz gráfica intuitiva para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los datos de manera rápida y eficiente.

### ✨ Funcionalidades Principales

- **Registro de mascotas y dueños**: Formulario completo para cargar nuevos clientes
- **Visualización de datos**: Lista organizada de todas las mascotas registradas
- **Edición de información**: Modificar datos existentes de mascotas y propietarios
- **Eliminación de registros**: Remover clientes que ya no utilizan el servicio
- **Limpieza de formularios**: Función para limpiar campos en caso de error durante la carga

## 🛠️ Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal
- **Java Swing**: Interfaz gráfica de usuario (GUI)
- **Maven**: Gestión de dependencias y construcción del proyecto
- **MySQL**: Base de datos relacional
- **JPA (Java Persistence API)**: Capa de persistencia
- **EclipseLink**: Proveedor de JPA para manejo de entidades
- **NetBeans**: IDE utilizado para el desarrollo (formularios .form incluidos)

## 📁 Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/mycompany/peluqueriacanina/
│   │       ├── PeluqueriaCanina.java          # Clase principal
│   │       ├── igu/                           # Interfaces Gráficas
│   │       │   ├── Principal.java             # Ventana principal
│   │       │   ├── CargaDatos.java            # Formulario de registro
│   │       │   ├── ModificarDatos.java        # Formulario de edición
│   │       │   └── VerDatos.java              # Visualización de datos
│   │       ├── logica/                        # Lógica de Negocio
│   │       │   ├── Controladora.java          # Controlador principal
│   │       │   ├── Mascota.java               # Entidad Mascota
│   │       │   └── Duenio.java                # Entidad Dueño
│   │       └── persistencia/                  # Capa de Persistencia
│   │           ├── ControladoraPersistencia.java
│   │           ├── MascotaJpaController.java
│   │           └── DuenioJpaController.java
│   └── resources/
│       └── META-INF/
│           └── persistence.xml                # Configuración JPA
└── pom.xml                                    # Configuración Maven
```

## ⚙️ Instalación y Configuración

### Prerrequisitos

- **Java JDK 17** o superior
- **Apache Maven 3.6+**
- **MySQL Server** (puede ser instalado a través de XAMPP)
- **IDE** (recomendado: NetBeans, IntelliJ IDEA, o Eclipse)

### Pasos de Instalación

1. **Clonar el repositorio**

   ```bash
   git clone https://github.com/CamilaVHeuer/Peluqueria-Canina-Java.git
   cd Peluqueria-Canina-Java
   ```

2. **Configurar la base de datos**

   - Iniciar XAMPP (o su servidor MySQL local)
   - Crear una base de datos llamada `peluqueria_canina`

   ```sql
   CREATE DATABASE peluqueria_canina;
   ```

3. **Configurar las credenciales de MySQL**

   - Editar el archivo `src/main/resources/META-INF/persistence.xml`
   - Ajustar las credenciales de conexión según tu configuración local:

   ```xml
   <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/peluqueria_canina?serverTimezone=UTC"/>
   <property name="jakarta.persistence.jdbc.user" value="tu_usuario_mysql"/>
   <property name="jakarta.persistence.jdbc.password" value="tu_contraseña_mysql"/>
   ```

4. **Compilar el proyecto**

   ```bash
   mvn clean compile
   ```

5. **Ejecutar la aplicación**
   ```bash
   mvn exec:java -Dexec.mainClass="com.mycompany.peluqueriacanina.PeluqueriaCanina"
   ```

## 🚀 Uso de la Aplicación

1. **Ejecutar** la aplicación desde la clase principal
2. **Interfaz Principal**: Se abrirá la ventana principal con opciones de navegación
3. **Cargar Datos**: Utilizar el formulario para registrar nuevas mascotas y dueños
4. **Ver Datos**: Visualizar todos los registros en formato de tabla
5. **Editar**: Seleccionar un registro y modificar la información necesaria
6. **Eliminar**: Remover registros que ya no sean necesarios

## 🔧 Configuración Adicional

- **Driver MySQL**: El proyecto incluye el driver MySQL Connector/J 8.0.33
- **JPA Schema Generation**: Configurado para crear automáticamente las tablas necesarias
- **Charset**: UTF-8 configurado para manejo correcto de caracteres especiales

## 📝 Origen del Proyecto

Este sistema surgió como parte de mis estudios en **Programación Orientada a Objetos (POO) en Java**, pero ha evolucionado hacia un proyecto más completo para demostrar habilidades en desarrollo de aplicaciones empresariales con Java.

## 📞 Contacto

- **GitHub**: [CamilaVHeuer](https://github.com/CamilaVHeuer)
- **LinkedIn**: [Camila V. Heuer](https://www.linkedin.com/in/camilavheuer/)
- **Email**: cbvillalbaheuer@gmail.com

---

_Desarrollado con 💙 como parte de mi crecimiento profesional en desarrollo Java_

**Autor**: Camila V. Heuer
