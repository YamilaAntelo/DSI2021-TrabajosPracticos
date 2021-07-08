import java.util.ArrayList;

public class RepositorioIngreso {
    private static ArrayList<Ingreso> listaIngresos = new ArrayList<Ingreso>();

    public void AgregarIngreso(Ingreso ingreso)
    {
        listaIngresos.add(ingreso);
    }
    
    public boolean VerificarIngreso(String dni)
    {
        boolean resultado = false;
        for (Ingreso ingreso: listaIngresos)
        {
            if (ingreso.getPersona().getDni().equalsIgnoreCase(dni))
            {
                resultado = true;
            }
        }
        return resultado;
    }

    public Ingreso ObtenerIngreso(String dni)
    {
        for (Ingreso ingreso: listaIngresos)
        {
            if (ingreso.getPersona().getDni().equalsIgnoreCase(dni))
            {
                return ingreso;
            }
        }return null;
    }
}
