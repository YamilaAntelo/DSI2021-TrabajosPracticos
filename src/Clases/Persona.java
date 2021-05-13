package Clases;

public class Persona {
    private String dni;
    private String nombreApellido;
    private String domicilio;
    private String telefono;
    private String email;
    private String actividad;

    public Persona(String dni, String nombreApellido, String domicilio, String telefono, String email, String actividad) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.actividad = actividad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getActividad() {
        return actividad;
    }
}

