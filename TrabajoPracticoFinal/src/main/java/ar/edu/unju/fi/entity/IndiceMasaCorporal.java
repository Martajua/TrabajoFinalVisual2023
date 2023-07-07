package ar.edu.unju.fi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
@Component
@Entity
@Table(name = "indice_masa_corporal")

public class IndiceMasaCorporal {

	// region Attributes
	
	/*
	 * @Id codigo es la clave primaria con valor incremental y secuencial
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="imc_id")
	private Long id;
	
	/*
	 * Atributo para trabajar con la eliminacion logica
	 */
	
	@Column(name = "imc_estado")
	private Boolean estado;
	
	@Column(name = "imc_fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Debes introducir una fecha")
	@Past(message = "La fecha ingresada es incorrecta")
	private LocalDate fechaImc;
	
	@ManyToOne
	@Column(name = "imc_usuario")
	@NotNull(message = "Debes seleccionar un usuario")
	private Usuario usuario;
	// endregion

	// region Constructors

	public IndiceMasaCorporal() {
	}

	public IndiceMasaCorporal(Long id, Boolean estado, LocalDate fechaImc, Usuario usuario) {

		this.id = id;
		this.estado = estado;
		this.fechaImc = fechaImc;
		this.usuario = usuario;

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

	public LocalDate getFechaImc() {
		return fechaImc;
	}

	public void setFechaImc(LocalDate fechaImc) {
		this.fechaImc = fechaImc;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	// endregion

	// region Methods
	public String calcularImc(float peso) {

		float imc = 0f;
		StringBuilder mensaje = new StringBuilder();
		DecimalFormat df = new DecimalFormat("#.##");

		imc = (float) (peso / Math.pow(usuario.getEstatura(), 2));

		mensaje.append("Su IMC es ");
		mensaje.append(df.format(imc));
		mensaje.append(" - ");

		if (imc < 18.5) {
			mensaje.append("Está por debajo de su peso ideal");
		} else if (imc <= 25) {
			mensaje.append("Está en su peso normal");
		} else {
			mensaje.append("Tiene sobrepeso");
		}

		return mensaje.toString();
	}

	public String calcularPesoIdeal() {

		float pesoIdeal = 0;
		short estaturaCentimetros = conversionMetroACentimetro(usuario.getEstatura());
		byte edad = obtenerEdad(usuario.getFechaNacimiento());
		StringBuilder mensaje = new StringBuilder();

		pesoIdeal = (float) (estaturaCentimetros - 100 + ((edad / 10) * 0.9));
		mensaje.append(pesoIdeal);

		return mensaje.toString();
	}

	public short conversionMetroACentimetro(float estatura) {
		return (short) (estatura * 100);
	}

	public byte obtenerEdad(LocalDate fechaNacimiento) {
		return (byte) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now(ZoneId.systemDefault()));
	}
	// endregion

}
