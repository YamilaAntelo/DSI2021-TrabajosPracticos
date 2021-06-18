public class Persona {
    private String dni;
    private String NombreApellido;
    private String Domicilio;
    private String Telefono;
    private String Email;
    private String ActividadRealizada;

    public Persona(String dni, String nombreApellido, String domicilio, String telefono, String email, String actividadRealizada)
    {
        this.dni = dni;
        this.NombreApellido = nombreApellido;
        this.Domicilio = domicilio;
        this.Telefono = telefono;
        this.Email = email;
        this.ActividadRealizada = actividadRealizada;
    }

    public String getDni() {
        return dni;
    }
}
