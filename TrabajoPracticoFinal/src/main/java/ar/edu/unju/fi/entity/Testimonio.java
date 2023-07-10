/*
 * package ar.edu.unju.fi.entity;
 * 
 * import jakarta.persistence.Column; import jakarta.persistence.Entity; import
 * jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType; import jakarta.persistence.Id; import
 * jakarta.persistence.Table; import jakarta.validation.constraints.NotBlank;
 * import jakarta.validation.constraints.NotNull; import
 * jakarta.validation.constraints.Past; import
 * jakarta.validation.constraints.Size; import
 * org.springframework.format.annotation.DateTimeFormat; import
 * org.springframework.stereotype.Component;
 * 
 * import java.time.LocalDate;
 * 
 * @Component
 * 
 * @Entity
 * 
 * @Table(name = "testimonios") public class Testimonio {
 * 
 * // region Attributes
 * 
 * @Id
 * 
 * @GeneratedValue(strategy=GenerationType.IDENTITY)
 * 
 * @Column(name="test_id") private Integer id;
 * 
 * @Column(name = "test_estado") private Boolean estado;
 * 
 * @Column(name = "test_fechaCreacion")
 * 
 * @DateTimeFormat(pattern = "yyyy-MM-dd")
 * 
 * @NotNull(message = "Debes introducir una fecha")
 * 
 * @Past(message = "La fecha ingresada es incorrecta") private LocalDate
 * fechaCreacion;
 * 
 * @Column(name = "test_usuario")
 * 
 * @NotNull(message = "Debes seleccionar un usuario") private Usuario usuario;
 * 
 * @Column(name = "test_comentario")
 * 
 * @NotBlank(message = "Debes introducir un mensaje")
 * 
 * @Size(min = 5, max = 50, message =
 * "Los mensajes solo pueden contener entre 5 y 50 caracteres") private String
 * comentario; // endregion
 * 
 * // region Constructors public Testimonio() { }
 * 
 * public Testimonio(Integer id, Boolean estado, LocalDate fechaCreacion,
 * Usuario usuario, String comentario) {
 * 
 * this.id = id; this.estado = estado; this.fechaCreacion = fechaCreacion;
 * this.usuario = usuario; this.comentario = comentario;
 * 
 * } // endregion
 * 
 * // region Getters and Setters public Integer getId() { return id; }
 * 
 * public void setId(Integer id) { this.id = id; }
 * 
 * public Boolean getEstado() { return estado; }
 * 
 * public void setEstado(Boolean estado) { this.estado = estado; }
 * 
 * public LocalDate getFechaCreacion() { return fechaCreacion; }
 * 
 * public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion =
 * fechaCreacion; }
 * 
 * public Usuario getUsuario() { return usuario; }
 * 
 * public void setUsuario(Usuario usuario) { this.usuario = usuario; }
 * 
 * public String getComentario() { return comentario; }
 * 
 * public void setComentario(String comentario) { this.comentario = comentario;
 * } // endregion
 * 
 * // region Methods // endregion
 * 
 * }
 */
