# 🔨 Proceso de Desarrollo - Sistema Peluquería Canina

## 📋 Índice

1. [Arquitectura General](#arquitectura-general)
2. [Diseño de la IGU](#diseño-de-la-igu)
3. [Flujo por Ventanas](#flujo-por-ventanas)
4. [Conexión IGU → Lógica → Persistencia](#conexión-igu--lógica--persistencia)
5. [Análisis Botón por Botón](#análisis-botón-por-botón)

---

## 🏗️ Arquitectura General

### Capas del Sistema

```
┌─────────────────────────────────────┐
│           IGU (Presentación)        │ ← Swing, formularios .form
├─────────────────────────────────────┤
│         Lógica de Negocio           │ ← Controladora, entidades
├─────────────────────────────────────┤
│         Persistencia (JPA)          │ ← JPA Controllers, BD
└─────────────────────────────────────┘
```

### Flujo de Datos

```
Usuario → Botón → Evento → Controladora → JPA → MySQL
     ↖                                           ↙
      ← Mensaje ← IGU ← Respuesta ← Resultado ←
```

---

## 🎨 Diseño de la IGU

### Ventanas Principales

#### 1. **Principal.java** - Ventana de Navegación

```java
// Botones principales y su función
- btnCargarDatos    → Abre CargaDatos.java
- btnVerDatos       → Abre VerDatos.java
- btnSalir          → System.exit(0)
```

#### 2. **CargaDatos.java** - Formulario de Registro

```java
// Campos de entrada
- txtNombre         → Nombre mascota
- txtRaza           → Raza de la mascota
- txtColor          → Color de la mascota
- txtObservaciones  → Observaciones médicas
- txtNomDuenio      → Nombre dueño (con autocompletado)
- txtCelDuenio      → Celular del dueño
- cmbAlergico       → ComboBox ¿Es alérgico?
- cmbAtEsp          → ComboBox ¿Atención especial?

// Botones de acción
- btnGuardar        → Guarda nueva mascota
- btnLimpiar        → Limpia todos los campos
- btnVolver         → Regresa a Principal
```

#### 3. **VerDatos.java** - Visualización y Gestión

```java
// Tabla de datos
- tablaMascotas     → JTable con todas las mascotas

// Botones de gestión
- btnEditar         → Abre ModificarDatos.java
- btnEliminar       → Elimina registro seleccionado
- btnVolver         → Regresa a Principal
```

#### 4. **ModificarDatos.java** - Formulario de Edición

```java
// Mismos campos que CargaDatos (pre-cargados)
// Botones de acción
- btnGuardar        → Guarda cambios (lógica compleja)
- btnLimpiar        → Limpia campos
- btnVolver         → Regresa a VerDatos
```

---

## 🔄 Flujo por Ventanas

### 1. Arranque de la Aplicación

**PeluqueriaCanina.java** (main)

```java
public static void main(String[] args) {
    Principal pantalla = new Principal();
    pantalla.setVisible(true);
    pantalla.setLocationRelativeTo(null);
}
```

### 2. Navegación desde Principal

```
Principal.java
├── btnCargarDatos → CargaDatos.java
├── btnVerDatos → VerDatos.java
└── btnSalir → System.exit(0)
```

### 3. Flujo de Carga de Datos

```
CargaDatos.java
├── Usuario llena formulario
├── btnGuardar → ActionEvent
├── Validación de campos
├── Llamada a Controladora
└── Mensaje de confirmación
```

### 4. Flujo de Visualización

```
VerDatos.java
├── Constructor → cargarGrilla()
├── btnEditar → ModificarDatos.java
├── btnEliminar → confirmación → Controladora
└── btnVolver → Principal.java
```

### 5. Flujo de Modificación

```
ModificarDatos.java
├── Constructor → cargarDatos(id)
├── btnGuardar → Lógica compleja
│   ├── ¿Cambió info dueño?
│   ├── ¿Dueño tiene múltiples mascotas?
│   └── Decisión del usuario
└── Actualización en BD
```

---

## 🔗 Conexión IGU → Lógica → Persistencia

### Ejemplo: Guardar Nueva Mascota

#### 1. **IGU (CargaDatos.java)**

```java
private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
    // Obtener datos del formulario
    String nombreMasco = convertirATitulo(txtNombre.getText().trim());
    String nombreDuenio = convertirATitulo(txtNomDuenio.getText().trim());
    // ... más campos

    // Llamada a la capa de lógica
    control.guardar(nombreMasco, raza, color, observaciones,
                   alergico, atEsp, nombreDuenio, celDuenio);
}
```

#### 2. **Lógica (Controladora.java)**

```java
public void guardar(String nombreMasco, String raza, String color,
                   String observaciones, String alergico, String atEsp,
                   String nombreDuenio, String celDuenio) {

    // 1. Buscar si el dueño ya existe
    List<Duenio> dueniosExistentes = controlPersis.buscarDuenioPorNombreYCelular(nombreDuenio, celDuenio);

    // 2. Crear o reutilizar dueño
    Duenio duenio;
    if (!dueniosExistentes.isEmpty()) {
        // Reutilizar dueño existente
        duenio = dueniosExistentes.get(0);
        System.out.println("Dueño encontrado: " + duenio.getNombre() + " (ID: " + duenio.getId_duenio() + ")");
    } else {
        // Crear nuevo dueño
        duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        System.out.println("Creando nuevo dueño: " + nombreDuenio);
    }

    // 3. Crear mascota
    Mascota masco = new Mascota();
    masco.setNombre(nombreMasco);
    masco.setRaza(raza);
    // ... más propiedades
    masco.setUnDuenio(duenio); // ← Relación JPA

    // 4. Persistir según corresponda
    if (dueniosExistentes.isEmpty()) {
        controlPersis.guardar(duenio, masco); // Crear dueño + mascota
    } else {
        controlPersis.guardarSoloMascota(masco); // Solo mascota
    }
}
```

#### 3. **Persistencia (ControladoraPersistencia.java)**

```java
public void guardar(Duenio duenio, Mascota masco) {
    // Primero crear el dueño
    dueJpa.create(duenio);
    // Luego crear la mascota (con referencia al dueño)
    mascoJpa.create(masco);
}

public void guardarSoloMascota(Mascota masco) {
    mascoJpa.create(masco); // Solo crear mascota
}
```

#### 4. **JPA Controller (MascotaJpaController.java)**

```java
public void create(Mascota mascota) {
    EntityManager em = getEntityManager();
    try {
        em.getTransaction().begin();

        // Manejar relación con Duenio
        Duenio unDuenio = mascota.getUnDuenio();
        if (unDuenio != null) {
            unDuenio = em.getReference(unDuenio.getClass(),
                                     unDuenio.getId_duenio());
            mascota.setUnDuenio(unDuenio);
        }

        em.persist(mascota); // ← INSERT SQL
        em.getTransaction().commit();
    } finally {
        em.close();
    }
}
```

#### 5. **Base de Datos (MySQL)**

```sql
-- JPA genera automáticamente:
INSERT INTO MASCOTA (nombre, raza, color, observaciones,
                     alergico, atencion_especial, UNDUENIO_ID_DUENIO)
VALUES ('Max', 'Golden retriever', 'Dorado', 'Muy juguetón',
        'NO', 'SI', 1);
```

---

## 🔍 Análisis Botón por Botón

### **Principal.java**

#### `btnCargarDatos`

```java
private void btnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {
    CargaDatos pantalla = new CargaDatos();
    pantalla.setVisible(true);
    pantalla.setLocationRelativeTo(null);
    this.dispose(); // Cierra ventana actual
}
```

**Función**: Navegación simple, abre formulario de carga.

#### `btnVerDatos`

```java
private void btnVerDatosActionPerformed(java.awt.event.ActionEvent evt) {
    VerDatos pantalla = new VerDatos();
    pantalla.setVisible(true);
    pantalla.setLocationRelativeTo(null);
    this.dispose(); // Cierra ventana actual
}
```

**Función**: Navegación a visualización, ejecuta consulta automáticamente.

### **CargaDatos.java**

#### `btnGuardar`

```java
private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
    // 1. Validación de campos obligatorios
    if (txtNombre.getText().isEmpty() || txtNomDuenio.getText().isEmpty()) {
        mostrarMensaje("Faltan completar campos", "Error", "Error al guardar");
        return;
    }

    // 2. Aplicar formatos
    String nombreMasco = convertirATitulo(txtNombre.getText().trim());
    String nombreDuenio = convertirATitulo(txtNomDuenio.getText().trim());

    // 3. Llamada a lógica de negocio
    control.guardar(nombreMasco, raza, color, observaciones,
                   alergico, atEsp, nombreDuenio, celDuenio);

    // 4. Feedback al usuario
    mostrarMensaje("Mascota guardada correctamente", "Info", "Guardado Exitoso");
}
```

**Función**: Validación → Formato → Persistencia → Feedback

#### `btnLimpiar`

```java
private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
    txtNombre.setText("");
    txtRaza.setText("");
    txtColor.setText("");
    txtObservaciones.setText("");
    txtNomDuenio.setText("");
    txtCelDuenio.setText("");
    cmbAlergico.setSelectedIndex(0);
    cmbAtEsp.setSelectedIndex(0);
}
```

**Función**: Reset de formulario, mejora UX.

### **VerDatos.java**

#### Constructor - `cargarGrilla()`

```java
private void cargarGrilla() {
    // 1. Definir modelo de tabla
    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Solo lectura
        }
    };

    // 2. Definir columnas
    String titulos[] = {"Num", "Nombre", "Color", "Raza", "Alérgico",
                       "At. Esp.", "Dueño", "Cel"};
    modeloTabla.setColumnIdentifiers(titulos);

    // 3. Obtener datos de la BD
    List<Mascota> listaMascotas = control.traerMascotas();

    // 4. Llenar tabla
    if (listaMascotas != null) {
        for (Mascota masco : listaMascotas) {
            Object[] objeto = {
                masco.getNum_cliente(),
                masco.getNombre(),
                masco.getColor(),
                masco.getRaza(),
                masco.getAlergico(),
                masco.getAtencion_especial(),
                masco.getUnDuenio().getNombre(),
                masco.getUnDuenio().getCelDuenio()
            };
            modeloTabla.addRow(objeto);
        }
    }

    tablaMascotas.setModel(modeloTabla);
}
```

**Función**: Consulta BD → Formato tabla → Display

#### `btnEliminar`

```java
private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
    // 1. Verificar selección
    if (tablaMascotas.getRowCount() > 0) {
        if (tablaMascotas.getSelectedRow() != -1) {

            // 2. Confirmación del usuario
            int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de que desea eliminar esta mascota?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                // 3. Obtener ID de la fila seleccionada
                int num_cliente = (Integer) tablaMascotas.getValueAt(
                    tablaMascotas.getSelectedRow(), 0);

                // 4. Llamada a lógica de negocio
                control.borrarMascota(num_cliente);

                // 5. Feedback y refresh
                mostrarMensaje("Mascota eliminada correctamente",
                              "Info", "Eliminación exitosa");
                cargarGrilla(); // Refrescar tabla
            }
        } else {
            mostrarMensaje("No seleccionó ninguna mascota",
                          "Error", "Error al eliminar");
        }
    } else {
        mostrarMensaje("No hay nada para eliminar en la tabla",
                      "Error", "Error al eliminar");
    }
}
```

**Función**: Validación → Confirmación → Eliminación → Refresh

#### `btnEditar`

```java
private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
    // 1. Verificar selección
    if (tablaMascotas.getRowCount() > 0) {
        if (tablaMascotas.getSelectedRow() != -1) {

            // 2. Obtener ID seleccionado
            int num_cliente = (Integer) tablaMascotas.getValueAt(
                tablaMascotas.getSelectedRow(), 0);

            // 3. Abrir ventana de edición con datos pre-cargados
            ModificarDatos pantallaModif = new ModificarDatos(num_cliente);
            pantallaModif.setVisible(true);
            pantallaModif.setLocationRelativeTo(null);
            this.dispose();

        } else {
            mostrarMensaje("No seleccionó ninguna mascota",
                          "Error", "Error al editar");
        }
    } else {
        mostrarMensaje("No hay nada para editar en la tabla",
                      "Error", "Error al editar");
    }
}
```

**Función**: Validación → Obtener ID → Navegación con parámetro

### **ModificarDatos.java**

#### Constructor con ID

```java
public ModificarDatos(int num_cliente) {
    initComponents();
    configurarAutocompletado(); // ← Funcionalidad avanzada
    cargarDatos(num_cliente);   // ← Pre-llenar formulario
}

private void cargarDatos(int num_cliente) {
    // 1. Obtener mascota de la BD
    this.masco = control.traerUnaMascota(num_cliente);

    // 2. Pre-llenar campos del formulario
    txtNombre.setText(masco.getNombre());
    txtRaza.setText(masco.getRaza());
    txtColor.setText(masco.getColor());
    txtObservaciones.setText(masco.getObservaciones());
    txtNomDuenio.setText(masco.getUnDuenio().getNombre());
    txtCelDuenio.setText(masco.getUnDuenio().getCelDuenio());

    // 3. Configurar ComboBoxes
    if (masco.getAlergico().equals("SI")) {
        cmbAlergico.setSelectedIndex(1);
    } else {
        cmbAlergico.setSelectedIndex(2);
    }

    if (masco.getAtencion_especial().equals("SI")) {
        cmbAtEsp.setSelectedIndex(1);
    } else {
        cmbAtEsp.setSelectedIndex(2);
    }
}
```

**Función**: Consulta → Pre-llenado → Configuración

#### `btnGuardar` (Lógica Compleja)

```java
private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
    // 1. Obtener datos actualizados del formulario
    String nombreMasco = convertirATitulo(txtNombre.getText());
    String nombreDuenio = convertirATitulo(txtNomDuenio.getText());
    String celDuenio = txtCelDuenio.getText().trim();
    // ... más campos

    // 2. Detectar si cambió información del dueño
    Duenio duenioOriginal = masco.getUnDuenio();
    String nombreOriginalTrim = duenioOriginal.getNombre() != null ?
                               duenioOriginal.getNombre().trim() : "";
    String celularOriginalTrim = duenioOriginal.getCelDuenio() != null ?
                                duenioOriginal.getCelDuenio().trim() : "";

    boolean cambioNombre = !Objects.equals(nombreDuenio.trim(), nombreOriginalTrim);
    boolean cambioCelular = !Objects.equals(celDuenio.trim(), celularOriginalTrim);
    boolean cambioInfo = cambioNombre || cambioCelular;

    // 3. LÓGICA COMPLEJA: ¿Qué hacer con el dueño?
    if (cambioInfo) {
        // 3a. Verificar si el dueño original tiene múltiples mascotas
        int cantidadMascotas = control.contarMascotasDelDuenio(duenioOriginal.getId_duenio());

        if (cantidadMascotas > 1) {
            // 3b. DECISIÓN DEL USUARIO: Dueño con múltiples mascotas
            String mensaje = "El dueño '" + duenioOriginal.getNombre() +
                           "' tiene " + cantidadMascotas + " mascotas registradas.\n\n" +
                           "¿Qué desea hacer?\n\n" +
                           "• SÍ: Crear/reemplazar un nuevo dueño solo para esta mascota\n" +
                           "• NO: Modificar el dueño existente (afectará todas sus mascotas)";

            int opcion = JOptionPane.showConfirmDialog(this, mensaje,
                        "Dueño con múltiples mascotas",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (opcion == JOptionPane.YES_OPTION) {
                // Crear/reutilizar dueño nuevo solo para esta mascota
                control.modificarMascotaConNuevoDuenio(masco, nombreMasco, raza, color,
                        observaciones, alergico, atEsp, nombreDuenio, celDuenio);
            } else {
                // Modificar dueño existente (afecta todas sus mascotas)
                control.modificarMascota(masco, nombreMasco, raza, color, observaciones,
                        alergico, atEsp, nombreDuenio, celDuenio);
            }
        } else {
            // 3c. Dueño tiene solo esta mascota, pero verificar reutilización
            control.modificarMascotaConNuevoDuenio(masco, nombreMasco, raza, color,
                    observaciones, alergico, atEsp, nombreDuenio, celDuenio);
        }
    } else {
        // 4. NO cambió info del dueño, solo actualizar mascota
        control.modificarMascota(masco, nombreMasco, raza, color, observaciones,
                alergico, atEsp, nombreDuenio, celDuenio);
    }

    // 5. Feedback y navegación
    mostrarMensaje("Edición realizada correctamente", "Info", "Edición Correcta");
    VerDatos pantalla = new VerDatos(); // ← Refresh automático
    pantalla.setVisible(true);
    pantalla.setLocationRelativeTo(null);
    this.dispose();
}
```

**Función**: Detección cambios → Análisis impacto → Decisión usuario → Actualización → Feedback

---

## 🔍 Métodos Clave de la Controladora

### **Método `guardar()` - Creación Inteligente**

```java
public void guardar(String nombreMasco, String raza, String color,
                   String observaciones, String alergico, String atEsp,
                   String nombreDuenio, String celDuenio) {

    // 1. BUSCAR SI YA EXISTE EL DUEÑO (evitar duplicados)
    List<Duenio> duenosExistentes = controlPersis.buscarDuenioPorNombreYCelular(nombreDuenio, celDuenio);

    Duenio duenio;
    if (!duenosExistentes.isEmpty()) {
        // Si ya existe, usar el existente
        duenio = duenosExistentes.get(0);
        System.out.println("Dueño encontrado: " + duenio.getNombre() + " (ID: " + duenio.getId_duenio() + ")");
    } else {
        // Si no existe, crear uno nuevo
        duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        System.out.println("Creando nuevo dueño: " + nombreDuenio);
    }

    // 2. CREAR LA MASCOTA
    Mascota masco = new Mascota();
    // ... setear propiedades
    masco.setUnDuenio(duenio);

    // 3. GUARDAR (solo crea dueño nuevo si no existía)
    if (duenosExistentes.isEmpty()) {
        controlPersis.guardar(duenio, masco);
    } else {
        controlPersis.guardarSoloMascota(masco);
    }
}
```

### **Método `modificarMascotaConNuevoDuenio()` - Reutilización Inteligente**

```java
public void modificarMascotaConNuevoDuenio(Mascota masco, String nombreMasco, String raza, String color,
        String observaciones, String alergico, String atEsp, String nombreDuenio, String celDuenio) {

    // Modificar datos de la mascota
    masco.setNombre(nombreMasco);
    // ... más propiedades

    // VERIFICAR SI YA EXISTE UN DUEÑO CON ESE NOMBRE Y CELULAR
    List<Duenio> duenosExistentes = controlPersis.buscarDuenioPorNombreYCelular(nombreDuenio, celDuenio);

    Duenio duenioParaAsignar;
    if (!duenosExistentes.isEmpty()) {
        // Ya existe un dueño con esos datos, usar el existente
        duenioParaAsignar = duenosExistentes.get(0);
        System.out.println("REUTILIZANDO dueño existente: " + duenioParaAsignar.getNombre() + " (ID: "
                + duenioParaAsignar.getId_duenio() + ")");
    } else {
        // No existe, crear un nuevo dueño
        duenioParaAsignar = new Duenio();
        duenioParaAsignar.setNombre(nombreDuenio);
        duenioParaAsignar.setCelDuenio(celDuenio);
        System.out.println("CREANDO nuevo dueño: " + nombreDuenio);
    }

    // Asignar el dueño a la mascota
    masco.setUnDuenio(duenioParaAsignar);

    // Guardar según corresponda
    if (duenosExistentes.isEmpty()) {
        // Crear nuevo dueño y actualizar mascota
        controlPersis.guardarNuevoDuenioYActualizarMascota(duenioParaAsignar, masco);
    } else {
        // Solo actualizar la mascota (el dueño ya existe)
        controlPersis.modificarMascota(masco);
    }
}
```

---

## 🎯 Patrones de Diseño Identificados

### 1. **MVC (Model-View-Controller)**

- **View**: Clases IGU (Principal, CargaDatos, VerDatos, ModificarDatos)
- **Controller**: Controladora.java
- **Model**: Entidades (Mascota, Duenio) + JPA Controllers

### 2. **DAO (Data Access Object)**

- JPA Controllers actúan como DAOs
- Separación entre lógica de negocio y acceso a datos

### 3. **Factory Pattern**

- EntityManagerFactory para crear EntityManagers
- Centralización de la creación de objetos de persistencia

### 4. **Strategy Pattern (implícito)**

- Diferentes estrategias para guardar según si el dueño existe o no
- Diferentes estrategias para modificar según si el dueño tiene múltiples mascotas

---

## 🚀 Evolución del Código

### Versión Inicial (Básica)

```java
// Versión simple - sin validaciones
btnGuardar → control.guardar() → JPA.create() → BD
```

### Versión Intermedia (Con validaciones)

```java
// Agregamos validaciones y formato
btnGuardar → validar() → formatear() → control.guardar() → JPA → BD
```

### Versión Actual (Empresarial)

```java
// Lógica compleja con casos edge
btnGuardar → validar() → detectarCambios() → analizarImpacto() →
           → decidirAccion() → ejecutarLogica() → actualizarBD() → feedback()
```

---

## 📈 Lecciones Aprendidas

1. **Separación de responsabilidades**: Cada capa tiene su función específica
2. **Validación en capas**: IGU + Lógica + BD para máxima robustez
3. **Experiencia de usuario**: Confirmaciones, feedback, navegación intuitiva
4. **Casos edge importantes**: Dueños con múltiples mascotas, duplicados, etc.
5. **Reutilización de código**: Métodos de formato, validación compartidos
6. **Prevención de duplicados**: Búsqueda antes de crear nuevas entidades
7. **Feedback informativo**: Logs de consola para debugging y comprensión

---

**📝 Autor**: Camila Villalba Heuer 
**📅 Fecha**: Noviembre 2024  
**🎯 Propósito**: Documentación del proceso de desarrollo para comprensión y referencia futura
