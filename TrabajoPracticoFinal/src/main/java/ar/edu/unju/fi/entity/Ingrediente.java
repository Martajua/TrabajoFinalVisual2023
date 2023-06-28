package ar.edu.unju.fi.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Ingrediente {

    //region Attributes
    private Integer id;
    private Boolean estado;
    @NotBlank(
            message = "Introduce un nombre"
    )
    @Size(
            min = 3,
            max = 30,
            message = "El nombre solo puede contener entre 3 y 30 caracteres"
    )
    @Pattern(
            regexp = "[a-z A-Z]+",
            message = "Solo puede contener letras"
    )
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
