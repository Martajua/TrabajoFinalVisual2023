package ar.edu.unju.fi.entity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class IndiceMasaCorporal {

    //region Attributes
    private Integer id;
    private Boolean estado;
    private LocalDate fechaImc;
    private Usuario usuario;
    //endregion

    //region Constructors

    public IndiceMasaCorporal() {
    }

    public IndiceMasaCorporal(
            Integer id,
            Boolean estado,
            LocalDate fechaImc,
            Usuario usuario) {

        this.id = id;
        this.estado = estado;
        this.fechaImc = fechaImc;
        this.usuario = usuario;

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
    //endregion

    //region Methods
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

        pesoIdeal = (float) (estaturaCentimetros - 100 + ((edad/10) * 0.9));
        mensaje.append(pesoIdeal);

        return mensaje.toString();
    }

    public short conversionMetroACentimetro(float estatura) {
        return (short) (estatura * 100);
    }

    public byte obtenerEdad(LocalDate fechaNacimiento) {
        return (byte) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now(ZoneId.systemDefault()));
    }
    //endregion

}
