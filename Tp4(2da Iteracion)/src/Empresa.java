import java.util.ArrayList;

public class Empresa {
    private String razonSocial;
    private String cuit;
    private String domicilio;
    private String localidad;
    private String email;
    private String telefono;
    private String actividadEmpresa;

    private ArrayList<Persona> listaEmpleados = new ArrayList<Persona>();

    public Empresa(String razonSocial, String cuit, String domicilio, String localidad, String email, String telefono, String actividadEmpresa)
    {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.email = email;
        this.telefono = telefono;
        this.actividadEmpresa = actividadEmpresa;
    }

    public String getActividadEmpresa() {
        return actividadEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void AgregarEmpleado(Persona persona)
    {
        listaEmpleados.add(persona);
    }

    public Persona ObtenerEmpleado(String dni)
    {
        for (Persona persona: listaEmpleados)
        {
            if (persona.getDni().equalsIgnoreCase(dni))
            {
                return persona;
            }
        }return null;
    }

    public ArrayList<Persona> getListaEmpleados() {
        return listaEmpleados;
    }
}
