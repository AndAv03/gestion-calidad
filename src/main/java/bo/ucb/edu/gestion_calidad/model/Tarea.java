package bo.ucb.edu.gestion_calidad.model;

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
}