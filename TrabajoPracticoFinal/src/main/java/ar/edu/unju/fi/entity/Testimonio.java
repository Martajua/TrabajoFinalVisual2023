package ar.edu.unju.fi.entity;

import java.time.LocalDate;

public class Testimonio {

    //region Attributes
    private Integer id;
    private Boolean estado;
    private LocalDate fechaCreacion;
    private Usuario usuario;
    private String comentario;
    //endregion

    //region Constructors
    public Testimonio() {
    }

    public Testimonio(
            Integer id,
            Boolean estado,
            LocalDate fechaCreacion,
            Usuario usuario,
            String comentario) {

        this.id = id;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.comentario = comentario;

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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    //endregion

    //region Methods
    //endregion

}
