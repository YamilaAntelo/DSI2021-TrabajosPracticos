import java.time.LocalDate;

public class Persona {
    private String dni;
    private String nombreApellido;
    private String domicilio;
    private String telefono;
    private String email;
    private String actividadRealizada;
    private LocalDate fechaAutorizacionHasta;
    private boolean habilitada;

    public Persona(String dni, String nombreApellido, String domicilio, String telefono, String email, String actividadRealizada, LocalDate fechaAutorizacionHasta)
    {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.actividadRealizada = actividadRealizada;
        this.fechaAutorizacionHasta = fechaAutorizacionHasta;
    }

    public LocalDate getFechaAutorizacionHasta() {
        return fechaAutorizacionHasta;
    }

    public String getDni() {
        return dni;
    }

    public String getActividadRealizada() {
        return actividadRealizada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public boolean getHabilitada()
    {
        return habilitada;
    }
}
