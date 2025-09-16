package org.example;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String codigo;
    private String nombre;
    private String profesor;
    private int creditos;
    private int capacidadMaxima;
    private List<Estudiante> estudiantes;

    // Constructor vacío
    public Curso() {
        this.estudiantes = new ArrayList<>();
    }

    // Constructor con parámetros
    public Curso(String codigo, String nombre, String profesor, int creditos, int capacidadMaxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
        this.creditos = creditos;
        this.capacidadMaxima = capacidadMaxima;
        this.estudiantes = new ArrayList<>();
    }

    // Métodos getter y setter
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getProfesor() { return profesor; }
    public void setProfesor(String profesor) { this.profesor = profesor; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

    public List<Estudiante> getEstudiantes() { return estudiantes; }

    // Método para agregar estudiante
    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiantes.size() < capacidadMaxima) {
            if (!estudiantes.contains(estudiante)) {
                estudiantes.add(estudiante);
                return true;
            } else {
                System.out.println("El estudiante ya está inscrito en este curso.");
                return false;
            }
        } else {
            System.out.println("El curso está lleno. Capacidad máxima: " + capacidadMaxima);
            return false;
        }
    }

    // Método para remover estudiante
    public boolean removerEstudiante(Estudiante estudiante) {
        return estudiantes.remove(estudiante);
    }

    // Método para mostrar información del curso
    public void mostrarInfo() {
        System.out.println("=== Información del Curso ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Profesor: " + profesor);
        System.out.println("Créditos: " + creditos);
        System.out.println("Estudiantes inscritos: " + estudiantes.size() + "/" + capacidadMaxima);
    }

    // Método para listar estudiantes
    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes inscritos en este curso.");
        } else {
            System.out.println("Estudiantes inscritos en " + nombre + ":");
            for (int i = 0; i < estudiantes.size(); i++) {
                System.out.println((i + 1) + ". " + estudiantes.get(i).toString());
            }
        }
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " (Prof. " + profesor + ")";
    }
}