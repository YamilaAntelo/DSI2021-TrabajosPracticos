import java.util.ArrayList;

public class RepositorioActividad {
    private static ArrayList<Actividad> listaActividades = new ArrayList<Actividad>();

    public void AgregarActividad(Actividad nueva)
    {
        listaActividades.add(nueva);
    }

    public Actividad ObtenerActividad(String nuevaActividad)
    {
        for (Actividad actividad : listaActividades){
            if (actividad.getNombre().equalsIgnoreCase(nuevaActividad)){
                return actividad;
            }
        }return null;
    }
}
