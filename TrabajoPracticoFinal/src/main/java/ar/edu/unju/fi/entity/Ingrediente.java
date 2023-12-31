package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Component
@Table(name = "ingredientes")
public class Ingrediente {

	// region Attributes

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ingre_id")
	private Long id;

	@Column(name = "ingre_estado")
	private Boolean estado;

	@Column(name = "ingre_nombre")
	@NotBlank(message = "Introduce un nombre")
	@Size(min = 3, max = 30, message = "El nombre solo puede contener entre 3 y 30 caracteres")
	/* Con el PAttern acepta nombres con tilde */
	@Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+", message = "El nombre solo puede contener letras y espacios")
	private String nombre; 
	// endregion
	
	/*** Relacion ***/
	
	//con lazy se obtiene el id del contenido de la lista
	@ManyToOne
    @JoinColumn(name = "receta_id")//columna que contiene la llave foranea
    private Receta receta;

	// region Constructors 
	
	public Ingrediente() { }

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	
	public Ingrediente(Long id, Boolean estado,
			@NotBlank(message = "Introduce un nombre") @Size(min = 3, max = 30, message = "El nombre solo puede contener entre 3 y 30 caracteres") @Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+", message = "El nombre solo puede contener letras y espacios") String nombre,
			Receta receta) {
		super();
		this.id = id;
		this.estado = estado;
		this.nombre = nombre;
		this.receta = receta;
	}
	

	public Ingrediente(Boolean estado,
			@NotBlank(message = "Introduce un nombre") @Size(min = 3, max = 30, message = "El nombre solo puede contener entre 3 y 30 caracteres") @Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+", message = "El nombre solo puede contener letras y espacios") String nombre,
			Receta receta) {
		super();
		this.estado = estado;
		this.nombre = nombre;
		this.receta = receta;
	}

	// endregion

	// region Getters and Setters 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	// endregion

	// region Methods 
	// endregion

}
