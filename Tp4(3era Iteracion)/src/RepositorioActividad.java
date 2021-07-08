import java.util.ArrayList;

public class RepositorioActividad {

    private static ArrayList<Actividad> listaActividades = new ArrayList<Actividad>();

    public void AgregarActividad(Actividad actividad)
    {
        listaActividades.add(actividad);
    }

    public Actividad ObtenerActividad(String nombre)
    {
        for (Actividad actividad: listaActividades)
        {
            if(actividad.getNombre().equalsIgnoreCase(nombre))
            {
                return actividad;
            }
        }return null;
    }
}
