package org.example;

import java.util.Scanner;

/**
 * Clase principal que demuestra la implementación de dos patrones de diseño:
 * - Patrón Singleton: Universidad (única instancia del sistema)
 * - Patrón Prototype: Estudiante (clonación de estudiantes existentes)
 */
public class Main {
    private static Universidad universidad;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Inicializar universidad usando patrón Singleton
        universidad = Universidad.getInstance();
        scanner = new Scanner(System.in);

        // Cargar datos de prueba
        cargarDatosPrueba();

        // Mostrar menú principal
        mostrarBienvenida();
        mostrarMenuPrincipal();

        scanner.close();
    }

    private static void mostrarBienvenida() {
        System.out.println("========================================");
        System.out.println("   SISTEMA UNIVERSITARIO - UTP");
        System.out.println("========================================");
        System.out.println("Bienvenido al " + universidad.getNombre());
        System.out.println();
    }

    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de Estudiantes");
            System.out.println("2. Gestión de Cursos");
            System.out.println("3. Inscripciones");
            System.out.println("4. Estadísticas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    menuEstudiantes();
                    break;
                case 2:
                    menuCursos();
                    break;
                case 3:
                    menuInscripciones();
                    break;
                case 4:
                    universidad.mostrarEstadisticas();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el sistema universitario!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void menuEstudiantes() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE ESTUDIANTES ===");
            System.out.println("1. Registrar nuevo estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Clonar estudiante (Patrón Prototype)");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    universidad.listarEstudiantes();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    clonarEstudiante();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void registrarEstudiante() {
        System.out.println("\n--- Registro de Nuevo Estudiante ---");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el código: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese la carrera: ");
        String carrera = scanner.nextLine();

        System.out.print("Ingrese el ciclo (número): ");
        int ciclo = 0;
        try {
            ciclo = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un número para el ciclo.");
            scanner.nextLine(); // Limpiar buffer
            return;
        }

        Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, codigo, carrera, ciclo);
        universidad.agregarEstudiante(nuevoEstudiante);
    }

    private static void buscarEstudiante() {
        System.out.print("Ingrese el código del estudiante: ");
        String codigo = scanner.nextLine();

        Estudiante estudiante = universidad.buscarEstudiantePorCodigo(codigo);
        if (estudiante != null) {
            estudiante.mostrarInfo();
        } else {
            System.out.println("Estudiante no encontrado con código: " + codigo);
        }
    }

    // Método para demostrar el patrón Prototype
    private static void clonarEstudiante() {
        System.out.println("\n--- Clonar Estudiante (Patrón Prototype) ---");

        // Mostrar estudiantes disponibles para clonar
        if (universidad.getEstudiantes().isEmpty()) {
            System.out.println("No hay estudiantes registrados para clonar.");
            return;
        }

        System.out.println("Estudiantes disponibles para clonar:");
        universidad.listarEstudiantes();

        System.out.print("Ingrese el código del estudiante a clonar: ");
        String codigoOriginal = scanner.nextLine();

        Estudiante estudianteOriginal = universidad.buscarEstudiantePorCodigo(codigoOriginal);
        if (estudianteOriginal == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        // Solicitar datos para el nuevo estudiante clonado
        System.out.print("Ingrese el nombre del nuevo estudiante: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo código: ");
        String nuevoCodigo = scanner.nextLine();

        // Usar el patrón Prototype para crear el clon
        Estudiante estudianteClonado = estudianteOriginal.clonarConNuevosDatos(nuevoNombre, nuevoCodigo);

        // Agregar el estudiante clonado al sistema
        universidad.agregarEstudiante(estudianteClonado);

        System.out.println("\n¡Estudiante clonado exitosamente!");
        System.out.println("Datos originales:");
        estudianteOriginal.mostrarInfo();
        System.out.println("\nDatos del clon:");
        estudianteClonado.mostrarInfo();
    }

    private static void menuCursos() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CURSOS ===");
            System.out.println("1. Crear nuevo curso");
            System.out.println("2. Listar cursos");
            System.out.println("3. Ver detalles de curso");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearCurso();
                    break;
                case 2:
                    universidad.listarCursos();
                    break;
                case 3:
                    verDetallesCurso();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void crearCurso() {
        System.out.println("\n--- Creación de Nuevo Curso ---");
        System.out.print("Ingrese el código del curso: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese el nombre del curso: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el nombre del profesor: ");
        String profesor = scanner.nextLine();

        System.out.print("Ingrese los créditos: ");
        int creditos = scanner.nextInt();

        System.out.print("Ingrese la capacidad máxima: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Curso nuevoCurso = new Curso(codigo, nombre, profesor, creditos, capacidad);
        universidad.agregarCurso(nuevoCurso);
    }

    private static void verDetallesCurso() {
        System.out.print("Ingrese el código del curso: ");
        String codigo = scanner.nextLine();

        Curso curso = universidad.buscarCursoPorCodigo(codigo);
        if (curso != null) {
            curso.mostrarInfo();
            System.out.println();
            curso.listarEstudiantes();
        } else {
            System.out.println("Curso no encontrado con código: " + codigo);
        }
    }

    private static void menuInscripciones() {
        System.out.println("\n=== INSCRIPCIONES ===");
        System.out.print("Ingrese el código del estudiante: ");
        String codigoEstudiante = scanner.nextLine();

        System.out.print("Ingrese el código del curso: ");
        String codigoCurso = scanner.nextLine();

        universidad.inscribirEstudianteEnCurso(codigoEstudiante, codigoCurso);
    }

    // Método para cargar datos de ejemplo
    private static void cargarDatosPrueba() {
        // Estudiantes de ejemplo
        universidad.agregarEstudiante(new Estudiante("Juan", "Pérez", "U20241001", "Ingeniería de Sistemas", 3));
        universidad.agregarEstudiante(new Estudiante("María", "García", "U20241002", "Ingeniería Industrial", 2));
        universidad.agregarEstudiante(new Estudiante("Carlos", "López", "U20241003", "Administración", 1));

        // Cursos de ejemplo
        universidad.agregarCurso(new Curso("IS101", "Programación I", "Dr. Rodriguez", 4, 30));
        universidad.agregarCurso(new Curso("IS201", "Base de Datos", "Mg. Fernández", 3, 25));
        universidad.agregarCurso(new Curso("MA101", "Matemática Básica", "Dr. Morales", 3, 40));

        System.out.println("Datos de prueba cargados exitosamente.");
    }
}