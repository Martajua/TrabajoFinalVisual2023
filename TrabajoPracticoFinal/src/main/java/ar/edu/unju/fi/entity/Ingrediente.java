package ar.edu.unju.fi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Entity
@Table(
        name = "ingredientes"
)
public class Ingrediente implements Serializable {

    //region Static Objects
    private static final Long serialVersionUID = 1L;
    //endregion

    //region Attributes
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ing_id"
    )
    private Integer id;

    @Column(
            name = "ing_estado"
    )
    private Boolean estado;

    @Column(
            name = "ing_nombre"
    )
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

    @ManyToMany(mappedBy = "ingredientes")
//    @NotNull(message = "Debe seleccionar una receta ")
    private List<Receta> recetas;
    //endregion

    //region Constructors
    public Ingrediente() {
        this.estado = true;
    }

    public Ingrediente(
            Integer id,
            Boolean estado,
            String nombre,
            List<Receta> recetas) {

        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.recetas = recetas;

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

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
    //endregion

    //region Methods
    //endregion

}
