import java.util.ArrayList;

public class RepositorioEmpresa {
    private static ArrayList<Empresa> listaEmpresas = new ArrayList<Empresa>();

    public void AgregarEmpresa(Empresa empresa)
    {
        listaEmpresas.add(empresa);
    }

    public boolean VerificarExistencia(String razonSocial) {
        boolean resultado = false;
        for (Empresa empresa : listaEmpresas) {
            if (empresa.getRazonSocial().equalsIgnoreCase(razonSocial)) {
                resultado = true;
            }
        }
        return  resultado;
    }

    public Empresa ObtenerEmpresa(String razonSocial)
    {
        for (Empresa empresa: listaEmpresas)
        {
            if (empresa.getRazonSocial().equalsIgnoreCase(razonSocial)){
                return empresa;
            }
        }return null;
    }
}
