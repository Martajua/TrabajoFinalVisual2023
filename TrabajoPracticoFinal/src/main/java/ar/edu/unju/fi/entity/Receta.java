package ar.edu.unju.fi.entity;

import java.util.List;

public class Receta {

    //region Attributes
    private Integer id;
    private Boolean estado;
    private String nombre;
    private String categoria;
    private List<Ingrediente> ingredientes;
    private String preparacion;
    private String imagen;
    //endregion

    //region Constructors
    public Receta() {
    }

    public Receta(
            Integer id,
            Boolean estado,
            String nombre,
            String categoria,
            List<Ingrediente> ingredientes,
            String preparacion,
            String imagen) {

        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.imagen = imagen;

    }
    //endregion

    //region Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    //endregion

    //region Methods
    //endregion

}
