package ar.edu.unju.fi.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Receta {

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
    @NotBlank(
            message = "Debes introducir una categoria"
    )
    @Pattern(
            regexp = "carnes|bebidas|dulces|ensaladas|legumbres y cereales|pescados|pan|sopas y cremas",
            flags = Pattern.Flag.CASE_INSENSITIVE
    )
    private String categoria;
    @NotNull(
            message = "Debes seleccionar un usuario"
    )
    private List<Ingrediente> ingredientes;
    @NotBlank(
            message = "Introduce un nombre"
    )
    @Size(
            min = 3,
            max = 30,
            message = "La preparación solo puede contener entre 3 y 30 caracteres"
    )
    @Pattern(
            regexp = "[a-z A-Z 0-9]+",
            message = "Solo no puede contener caracteres especiales"
    )
    private String preparacion;
    @NotBlank(
            message = "Introduce una dirección URL"
    )
    @Size(
            min = 10,
            max = 30,
            message = "La dirección URL de la imagen solo puede contener entre 10 y 30 caracteres"
    )
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
