package ar.edu.unju.fi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Component
@Table(name = "indice_masa_corporal")
public class IndiceMasaCorporal {

    // region Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imc_id")
    private Long id;

    @Column(name = "imc_estado")
    private Boolean estado;

    @Column(name = "imc_fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaImc;
   
    @ManyToOne
    @JoinColumn(name = "imc_usuario")
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
    
    
 // Getter for IMC
    public Float getImc() {
        // Calculate and return the IMC based on the weight and height of the user
        // Replace this line with your actual IMC calculation logic
        return 0.0f;
    }
    
    
    

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
	
	
	public Float getImc(float peso) {
	    // Calculate the IMC based on the weight and height of the user
	    float imc = peso / (usuario.getEstatura() * usuario.getEstatura());
	    return imc;
	}
	
	
	

	public String calcularImc(float peso) {
		float imc = peso / (usuario.getEstatura() * usuario.getEstatura());
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

	public String calcularPesoIdeal() {
		float pesoIdeal = usuario.getEstatura() - 100 + ((obtenerEdad(usuario.getFechaNacimiento()) / 10) * 0.9f);
		return String.format("%.2f", pesoIdeal);
	}

	public short conversionMetroACentimetro(float estatura) {
		return (short) (estatura * 100);
	}

	public byte obtenerEdad(LocalDate fechaNacimiento) {
		return (byte) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}

	// endregion
}
