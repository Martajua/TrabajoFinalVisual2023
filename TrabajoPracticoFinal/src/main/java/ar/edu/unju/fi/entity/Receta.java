package ar.edu.unju.fi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

import org.springframework.stereotype.Component;

@Component

@Entity

@Table(name = "recetas")
public class Receta {

	// region Attributes

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "receta_id")
	private Long id;

	@Column(name = "receta_estado")
	private Boolean estado;

	@Column(name = "receta_nombre")
	@NotEmpty(message = "El nombre no debe estar vacío")
	@Size(min = 3, max = 30, message = "El nombre solo puede contener entre 3 y 30 caracteres")
	/*
	 * Con el PAttern acepta nombres con tilde
	 */
	@Pattern(regexp="[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+",message="El nombre solo puede contener letras y espacios")
	private String nombre;

	@Column(name="receta_categoria")
  
	@NotBlank(message = "Debes seleccionar una categoria")
	@Pattern(regexp = "carnes|bebidas|dulces|ensaladas|legumbres y cereales|pescados|pan|sopas y cremas", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String categoria;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List <Ingrediente> ingredientes;

	@Column(name = "receta_preparacion")
	@NotBlank(message = "Introduce un nombre")
	@Size(min = 3, max = 30, message = "La preparación solo puede contener entre 3 y 30 caracteres")
	@Pattern(regexp = "[a-z A-Z 0-9]+", message = "Solo no puede contener caracteres especiales")
	private String preparacion;

	@Column(name = "receta_imagen")
	@NotBlank(message = "Introduce una dirección URL")
	@Size(min = 10, max = 100, message = "La dirección URL de la imagen solo puede contener entre 10 y 100 caracteres")
	private String imagen; 
	
	// endregion

	// region Constructors 
	
	public Receta() { }

	public Receta(Long id, Boolean estado, String nombre, String categoria, List<Ingrediente> ingredientes,
			String preparacion, String imagen) {

		this.id = id;
		this.estado = estado;
		this.nombre = nombre;
		this.categoria = categoria;
		this.ingredientes = ingredientes;
		this.preparacion = preparacion;
		this.imagen = imagen;

	} // endregion

	// region Getters and Setters 
	
	public Long getId() { return id; }

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

	// endregion

	// region Methods // endregion

}
