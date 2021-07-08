public class Empresa {
    private String razonSocial;
    private String cuit;
    private String domicilio;
    private String localidad;
    private String email;
    private String telefono;
    private Actividad actividad;

    public Empresa(String razonSocial, String cuit, String domicilio, String localidad, String email, String telefono, Actividad actividad)
    {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.email = email;
        this.telefono = telefono;
        this.actividad = actividad;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
}
