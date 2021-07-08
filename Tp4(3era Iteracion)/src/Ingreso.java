import java.time.LocalDate;
import java.time.LocalTime;

public class Ingreso {
    private LocalDate fechaIngreso;
    private LocalTime horaingreso;
    private LocalTime horaSalida;
    private float temperatura;
    private boolean autorizacion;
    private String patente;
    private String lugarDestino;
    private Persona persona;

    public Ingreso(Persona persona, LocalDate fechaIngreso, LocalTime horaingreso, float temperatura)
    {
        this.persona = persona;
        this.fechaIngreso = fechaIngreso;
        this.horaingreso = horaingreso;
        this.temperatura = temperatura;
    }

    public void PatenteDestino(String patente, String lugarDestino)
    {
        this.patente = patente;
        this.lugarDestino = lugarDestino;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Persona getPersona() {
        return persona;
    }
}
