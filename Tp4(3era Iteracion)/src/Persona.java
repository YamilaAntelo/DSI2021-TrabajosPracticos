import java.time.LocalDate;

public class Persona {
    private String dni;
    private String nombreApellido;
    private String domicilio;
    private String telefono;
    private String email;
    private LocalDate fechaInicioAutorizacion;
    private LocalDate fechaFinAutorizacion;
    private Empresa empresa;

    public Persona(String dni, String nombreApellido, String domicilio, String telefono, String email,LocalDate fechaInicioAutorizacion, LocalDate fechaFinAutorizacion)
    {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.fechaInicioAutorizacion = fechaInicioAutorizacion;
        this.fechaFinAutorizacion = fechaFinAutorizacion;
    }

    public String getDni() {
        return dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public LocalDate getFechaInicioAutorizacion() {
        return fechaInicioAutorizacion;
    }

    public LocalDate getFechaFinAutorizacion() {
        return fechaFinAutorizacion;
    }

    public void AsignarEmpresa(String razonSocial)
    {
        RepositorioEmpresa listaEmpresa = new RepositorioEmpresa();

        boolean resultado = listaEmpresa.VerificarExistencia(razonSocial);
        if (resultado)
        {
            Empresa empresa = listaEmpresa.ObtenerEmpresa(razonSocial);
            this.setEmpresa(empresa);
        }else {
            System.out.print(" Empresa no encontrada ");
        }
    }

    public boolean VerificarAutorizacion()
    {
        boolean resultado = false;

        if (this.getFechaFinAutorizacion().isAfter(LocalDate.now())){
            resultado = true;
        }

        return resultado;
    }

    public void BajaAutorizacion()
    {
        if (this.fechaFinAutorizacion.isAfter(LocalDate.now()))
        {
            this.fechaFinAutorizacion = LocalDate.now();
            System.out.print(" La persona: " + getDni() + " fue dado de baja correctamente ");
        }else{
            System.out.print(" La persona: " + getDni() + " ya fue dado de baja");
        }
    }
}
