import java.util.ArrayList;

public class RepositorioPersonas {
    private static ArrayList<Persona> listaPersonasAutorizadas = new ArrayList<Persona>();

    public void AgregarPersonaAutorizada(Persona persona){
        listaPersonasAutorizadas.add(persona);
    }

    public Persona obtenerPersona(String dni)
    {
        for (Persona persona : listaPersonasAutorizadas){
            if (persona.getDni().equalsIgnoreCase(dni)){
                return persona;
            }
        }return null;
    }
}
