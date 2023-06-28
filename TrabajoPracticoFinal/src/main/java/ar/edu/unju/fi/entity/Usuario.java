package ar.edu.unju.fi.entity;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Usuario {

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
            message = "Introduce un apellido"
    )
    @Size(
            min = 3,
            max = 30,
            message = "El apellido solo puede contener entre 3 y 30 caracteres"
    )
    @Pattern(
            regexp = "[a-z A-Z]+",
            message = "Solo puede contener letras"
    )
    private String apellido;

    @Email(
            message = "Email no es correcto", regexp = ".*"
    )
    @NotBlank(
            message = "Debes introducir un email"
    )
    private String email;
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    @PastOrPresent(
            message = "La fecha ingresada es incorrecta"
    )
    @NotNull(
            message = "Debes introducir una fecha"
    )
    private LocalDate fechaNacimiento;
    @NotBlank(
            message = "Debes introducir un número de teléfono"
    )
    @Pattern(
            regexp = "0388-[0-9]{3}-[0-9]{4}"
    )
    private String telefono;
    @NotBlank(
            message = "Debes introducir tu sexo"
    )
    @Pattern(
            regexp = "masculino|femenino",
            flags = Pattern.Flag.CASE_INSENSITIVE
    )
    private String sexo;
    @NotEmpty(message = "Debes introducir tu estatura")
    @Min(0)
    private Float estatura;
    //endregion

    //region Constructors
    public Usuario() {
    }

    public Usuario(
            Integer id,
            Boolean estado,
            String nombre,
            String apellido,
            String email,
            LocalDate fechaNacimiento,
            String telefono,
            String sexo,
            Float estatura) {

        this.id = id;
        this.estado = estado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.sexo = sexo;
        this.estatura = estatura;

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
    //endregion

    //region Methods
    //endregion

}
