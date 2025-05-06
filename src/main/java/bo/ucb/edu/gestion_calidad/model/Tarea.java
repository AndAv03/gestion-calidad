package bo.ucb.edu.gestion_calidad.model;

// Updated Tarea class with setDescripcion method
public class Tarea {
    private int id;
    private String descripcion;

    public Tarea(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}