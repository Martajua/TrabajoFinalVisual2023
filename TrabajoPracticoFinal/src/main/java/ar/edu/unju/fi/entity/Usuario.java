package ar.edu.unju.fi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Entity
@Table(name = "usuarios")
public class Usuario {

	// region Attributes

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long id;

	@Column(name = "usu_estado")
	private Boolean estado;

	@Column(name = "usu_nombre")
	@NotBlank(message = "Introduce un nombre")
	@Size(min = 3, max = 30, message = "El nombre solo puede contener entre 3 y 30 caracteres")
	/* Con el PAttern acepta nombres con tilde */
	@Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+", message = "El nombre solo puede contener letras y espacios")
	private String nombre;

	@Column(name = "usu_apellido")
	@NotBlank(message = "Introduce un apellido")
	@Size(min = 3, max = 30, message = "El apellido solo puede contener entre 3 y 30 caracteres")
	/* Con el PAttern acepta apellidos con tilde */
	@Pattern(regexp = "[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+", message = "El apellido solo puede contener letras y espacios")
	private String apellido;

	@Column(name = "usu_email")
	@Email(message = "Email no es correcto", regexp = ".*")
	@NotBlank(message = "Debes introducir un email")
	private String email;

	@Column(name = "usu_fechaNacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "La fecha ingresada es incorrecta")
	@NotNull(message = "Debes introducir una fecha")
	private LocalDate fechaNacimiento;

	@Column(name = "usu_telefono")
    @NotBlank(message = "Debes introducir un número de teléfono")
    @Pattern(regexp = "^[0-9]+$", message = "El número de teléfono debe contener solo dígitos")
	private String telefono;

	@Column(name = "usu_sexo")
	@NotBlank(message = "Debes introducir tu sexo")
	@Pattern(regexp = "masculino|femenino", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String sexo;

	@Column(name = "usu_estatura")
	@NotNull(message = "Debes introducir tu estatura")
	@Min(0)
	private Float estatura;
	
	
	
	/*
	 * @Column(name = "usu_peso")
	 * 
	 * @NotNull(message = "Debes introducir tu peso")
	 * 
	 * @Min(value = 0, message = "El peso debe ser mayor que cero") private Float
	 * peso;
	 */
	
	@Column(name = "usu_admin")
	private Boolean admin=false;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<IndiceMasaCorporal> indicesMasaCorporal;
	// endregion

	// region Constructors
	public Usuario() {
	}

	
	public Usuario(Long id, Boolean estado, String nombre, String apellido, String email, LocalDate fechaNacimiento, String telefono, String sexo,Float estatura, Boolean admin) {
		super();
		this.id = id;
		this.estado = estado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.sexo = sexo;
		this.estatura = estatura;
		this.admin = admin;
	}


	// endregion

	public Boolean getAdmin() {
		return admin;
	}


	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}


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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Float getEstatura() {
		return estatura;
	}

	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}
	/* endregion */

	// region Methods 
	
	public String calcularImc(float peso) {
        float imc = peso / (estatura * estatura);
        String mensaje;
        if (imc < 18.5) {
            mensaje = "Su IMC es " + String.format("%.2f", imc) + " - Está por debajo de su peso ideal";
        } else if (imc <= 25) {
            mensaje = "Su IMC es " + String.format("%.2f", imc) + " - Está en su peso normal";
        } else {
            mensaje = "Su IMC es " + String.format("%.2f", imc) + " - Tiene sobrepeso";
        }
        return mensaje;
    }
	
	// endregion

}
 
