import javax.swing.plaf.SplitPaneUI;
import java.util.ArrayList;

public class RepositorioPersonas {
    private static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

    public void AgregarPersona(Persona persona)
    {
        listaPersonas.add(persona);
    }

    public boolean VerificarExistencia(String dni)
    {
        boolean resultado = false;
        for (Persona persona: listaPersonas)
        {
            if (persona.getDni().equalsIgnoreCase(dni)){
                resultado = true;
            }
        }
        return resultado;
    }

    public Persona ObtenerPersona(String dni)
    {
        for (Persona persona: listaPersonas)
        {
            if (persona.getDni().equalsIgnoreCase(dni))
            {
                return persona;
            }
        }return null;
    }

}
