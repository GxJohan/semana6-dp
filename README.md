# Sistema Universitario - Patrones de Diseño

Sistema de gestión universitaria que demuestra la implementación de los patrones **Singleton** y **Prototype**.

## 🎯 Objetivos de Aprendizaje

- Comprender el patrón **Singleton** y su aplicación práctica
- Implementar el patrón **Prototype** para clonación de objetos
- Aplicar principios de programación orientada a objetos

## 🏗️ Estructura del Proyecto

```
src/main/java/org/example/
├── Main.java          # Clase principal con menús interactivos
├── Universidad.java   # Patrón Singleton - Una sola instancia
├── Estudiante.java    # Patrón Prototype - Clonación de objetos
└── Curso.java         # Gestión de cursos y inscripciones
```

## 🔧 Patrones Implementados

### 1. Patrón Singleton (Universidad)
**Ubicación:** `Universidad.java` líneas 7-31

```java
// Solo existe UNA instancia de Universidad en todo el sistema
Universidad uni = Universidad.getInstance();
```

**¿Por qué Singleton?**
- Solo debe existir una universidad en el sistema
- Garantiza acceso controlado a los datos centrales
- Evita duplicación de información

### 2. Patrón Prototype (Estudiante)
**Ubicación:** `Estudiante.java` líneas 63-83

```java
// Clona un estudiante existente con nuevos datos
Estudiante clon = estudianteOriginal.clonarConNuevosDatos("Maria", "U20241005");
```

**¿Por qué Prototype?**
- Permite crear estudiantes similares rápidamente
- Mantiene toda la configuración (carrera, ciclo) del original
- Útil para estudiantes de la misma familia o programa

## 🚀 Cómo Ejecutar

### Opción 1: Compilación Manual
```bash
# Compilar
javac -d target/classes -sourcepath src/main/java src/main/java/org/example/*.java

# Ejecutar
java -cp target/classes org.example.Main
```

### Opción 2: Con Maven (si está disponible)
```bash
mvn compile exec:java -Dexec.mainClass="org.example.Main"
```

## 📱 Funcionalidades

### Gestión de Estudiantes
1. **Registrar nuevo estudiante**
2. **Listar estudiantes**
3. **Buscar estudiante**
4. **🧬 Clonar estudiante** (Patrón Prototype)

### Gestión de Cursos
1. **Crear nuevo curso**
2. **Listar cursos**
3. **Ver detalles de curso**

### Inscripciones
- Inscribir estudiantes en cursos
- Ver estadísticas del sistema

## 🎮 Ejemplo de Uso

### Demostrar Patrón Prototype
1. Ejecuta la aplicación
2. Ve a "Gestión de Estudiantes" (opción 1)
3. Selecciona "Clonar estudiante" (opción 4)
4. Elige un estudiante existente
5. Ingresa nuevos datos para el clon
6. Observa cómo mantiene carrera y ciclo del original

### Comprobar Patrón Singleton
```java
// En cualquier parte del código, siempre obtienes la misma instancia
Universidad uni1 = Universidad.getInstance();
Universidad uni2 = Universidad.getInstance();
// uni1 == uni2 ✅ Son la misma instancia
```

## 📚 Datos de Prueba

El sistema incluye datos precargados:

**Estudiantes:**
- Juan Pérez (U20241001) - Ingeniería de Sistemas
- María García (U20241002) - Ingeniería Industrial
- Carlos López (U20241003) - Administración

**Cursos:**
- IS101 - Programación I
- IS201 - Base de Datos
- MA101 - Matemática Básica

## 🔍 Puntos Clave para Entender

### Singleton
- **Constructor privado** → No se puede hacer `new Universidad()`
- **Método getInstance()** → Única forma de obtener la instancia
- **Variable estática** → Mantiene la referencia única

### Prototype
- **Implementa Cloneable** → Habilita la clonación
- **Método clone()** → Crea copia exacta del objeto
- **Método personalizado** → Clona con datos específicos modificados

## 🎓 Para el Instructor

Este proyecto está diseñado para enseñar:
1. **Conceptos básicos** de OOP en Java
2. **Implementación práctica** de patrones de diseño
3. **Diferencias claras** entre ambos patrones
4. **Casos de uso reales** donde aplicar cada patrón

Los estudiantes pueden experimentar modificando los datos y observando cómo funcionan los patrones en tiempo real.