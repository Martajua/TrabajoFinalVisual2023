package ar.edu.unju.fi.entity;

public class Ingrediente {

    //region Attributes
    private Integer id;
    private Boolean estado;
    private String nombre;
    //endregion

    //region Constructors
    public Ingrediente() {
    }

    public Ingrediente(
            Integer id,
            Boolean estado,
            String nombre) {

        this.id = id;
        this.estado = estado;
        this.nombre = nombre;

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
    //endregion

    //region Methods
    //endregion

}
