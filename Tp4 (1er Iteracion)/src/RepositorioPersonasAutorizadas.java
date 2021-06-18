import java.util.ArrayList;

public class RepositorioPersonasAutorizadas {
    private static ArrayList<Persona> listaPersonasAutorizadas = new ArrayList<Persona>();

    public void AgregarPersona(Persona nueva)
    {
        listaPersonasAutorizadas.add(nueva);
    }

    public Persona ObtenerPersona(String dni)
    {
        for (Persona persona : listaPersonasAutorizadas)
        {
            if (persona.getDni().equalsIgnoreCase(dni)){
                return persona;
            }
        }return null;
    }
}
