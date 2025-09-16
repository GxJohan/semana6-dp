package org.example;

// Implementa Cloneable para el patrón Prototype
public class Estudiante implements Cloneable {
    private String nombre;
    private String apellido;
    private String codigo;
    private String carrera;
    private int ciclo;
    private double promedio;

    // Constructor vacío
    public Estudiante() {}

    // Constructor con parámetros
    public Estudiante(String nombre, String apellido, String codigo, String carrera, int ciclo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.carrera = carrera;
        this.ciclo = ciclo;
        this.promedio = 0.0;
    }

    // Métodos getter y setter
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public int getCiclo() { return ciclo; }
    public void setCiclo(int ciclo) { this.ciclo = ciclo; }

    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    // Método para mostrar información del estudiante
    public void mostrarInfo() {
        System.out.println("=== Información del Estudiante ===");
        System.out.println("Nombre: " + getNombreCompleto());
        System.out.println("Código: " + codigo);
        System.out.println("Carrera: " + carrera);
        System.out.println("Ciclo: " + ciclo);
        System.out.println("Promedio: " + promedio);
    }

    @Override
    public String toString() {
        return codigo + " - " + getNombreCompleto() + " (" + carrera + ")";
    }

    // Implementación del patrón Prototype
    @Override
    public Estudiante clone() {
        try {
            // Clonación superficial - suficiente para tipos primitivos y String
            return (Estudiante) super.clone();
        } catch (CloneNotSupportedException e) {
            // Esto no debería pasar ya que implementamos Cloneable
            throw new RuntimeException("Error al clonar estudiante", e);
        }
    }

    // Método de conveniencia para crear un clon con datos modificados
    public Estudiante clonarConNuevosDatos(String nuevoNombre, String nuevoCodigo) {
        Estudiante clon = this.clone();
        clon.setNombre(nuevoNombre);
        clon.setCodigo(nuevoCodigo);
        // Resetear promedio para el nuevo estudiante
        clon.setPromedio(0.0);
        return clon;
    }
}