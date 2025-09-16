package org.example;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    // Patrón Singleton: única instancia de la universidad
    private static Universidad instanciaUnica = null;

    private String nombre;
    private List<Estudiante> estudiantes;
    private List<Curso> cursos;

    // Constructor privado para implementar Singleton
    private Universidad(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    // Método estático para obtener la única instancia (Patrón Singleton)
    public static synchronized Universidad getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Universidad("Universidad Tecnológica del Perú - UTP");
        }
        return instanciaUnica;
    }

    // Método para reinicializar la instancia si es necesario
    public static void reiniciarInstancia() {
        instanciaUnica = null;
    }

    // Métodos getter
    public String getNombre() { return nombre; }
    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public List<Curso> getCursos() { return cursos; }

    // Métodos para gestionar estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
            System.out.println("Estudiante " + estudiante.getNombreCompleto() + " registrado exitosamente.");
        } else {
            System.out.println("El estudiante ya está registrado en la universidad.");
        }
    }

    public Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equalsIgnoreCase(codigo)) {
                return estudiante;
            }
        }
        return null;
    }

    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("=== Lista de Estudiantes ===");
            for (int i = 0; i < estudiantes.size(); i++) {
                System.out.println((i + 1) + ". " + estudiantes.get(i).toString());
            }
        }
    }

    // Métodos para gestionar cursos
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            System.out.println("Curso " + curso.getNombre() + " agregado exitosamente.");
        } else {
            System.out.println("El curso ya existe en la universidad.");
        }
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equalsIgnoreCase(codigo)) {
                return curso;
            }
        }
        return null;
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles.");
        } else {
            System.out.println("=== Lista de Cursos ===");
            for (int i = 0; i < cursos.size(); i++) {
                System.out.println((i + 1) + ". " + cursos.get(i).toString());
            }
        }
    }

    // Método para inscribir estudiante en curso
    public void inscribirEstudianteEnCurso(String codigoEstudiante, String codigoCurso) {
        Estudiante estudiante = buscarEstudiantePorCodigo(codigoEstudiante);
        Curso curso = buscarCursoPorCodigo(codigoCurso);

        if (estudiante == null) {
            System.out.println("Estudiante no encontrado con código: " + codigoEstudiante);
            return;
        }

        if (curso == null) {
            System.out.println("Curso no encontrado con código: " + codigoCurso);
            return;
        }

        if (curso.agregarEstudiante(estudiante)) {
            System.out.println("Estudiante " + estudiante.getNombreCompleto() +
                             " inscrito exitosamente en " + curso.getNombre());
        }
    }

    // Método para mostrar estadísticas
    public void mostrarEstadisticas() {
        System.out.println("=== Estadísticas de " + nombre + " ===");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println("Total de cursos: " + cursos.size());

        int totalInscripciones = 0;
        for (Curso curso : cursos) {
            totalInscripciones += curso.getEstudiantes().size();
        }
        System.out.println("Total de inscripciones: " + totalInscripciones);
    }
}