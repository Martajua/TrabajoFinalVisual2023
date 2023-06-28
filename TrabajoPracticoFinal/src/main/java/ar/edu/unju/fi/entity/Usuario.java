package ar.edu.unju.fi.entity;

import java.time.LocalDate;

public class Usuario {

    //region Attributes
    private Integer id;
    private Boolean estado;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String sexo;
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
