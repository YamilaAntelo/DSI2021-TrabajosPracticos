
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Ingrese opcion: ");
        System.out.println(" 1. Registrar persona ");

        int opcion = scanner.nextInt();

        switch (opcion){
            case 1:
                RegistrarActividades();
                RegistrarPersona();
                break;
        }
    }

    public static void RegistrarActividades(){

        RepositorioActividad listaActividades = new RepositorioActividad();

        Actividad actividad1 = new Actividad("Rural");
        Actividad actividad2 = new Actividad("Salud");

        listaActividades.AgregarActividad(actividad1);
        listaActividades.AgregarActividad(actividad2);

    }

    public static void RegistrarPersona()
    {
        RepositorioActividad listaActividades = new RepositorioActividad();
        RepositorioPersonas listaPersonas = new RepositorioPersonas();

        Scanner scanner = new Scanner(System.in);

        LocalDate fecha1 = LocalDate.of(2021,8,15);

        System.out.println(" Ingrese dni: ");
        String dni = scanner.nextLine();

        System.out.println(" Ingrese nombre y apellido: ");
        String nombreApellido = scanner.nextLine();

        System.out.println(" Ingrese domicilio:  ");
        String domicilio = scanner.nextLine();

        System.out.println(" Ingrese telefono: ");
        String telefono = scanner.nextLine();

        System.out.println(" Ingrese email: ");
        String email = scanner.nextLine();

        System.out.println(" Ingrese actividad que realiza: ");
        String actividadRealizada = scanner.nextLine();


        Persona persona1 = new Persona(dni,nombreApellido,domicilio,telefono,email,actividadRealizada,fecha1);

        Actividad resultado1 = listaActividades.ObtenerActividad(persona1.getActividadRealizada());

        if (resultado1 == null){
            System.out.println(" La actividad no existe ");
        }else {
            listaPersonas.AgregarPersonaAutorizada(persona1);
            AutorizarIngreso(persona1);
        }
    }

    public static void AutorizarIngreso(Persona persona) {

        Scanner scanner = new Scanner(System.in);

        RepositorioPersonas listaPersonasAutorizadas = new RepositorioPersonas();

        Empresa empresa1 = new Empresa("Ospe","24542412","San Martin 34","Cordoba","empresa94@gmail.com","3564736212","Rural");

        Persona personaAutorizo = listaPersonasAutorizadas.obtenerPersona(persona.getDni());

        if (personaAutorizo==null){
            System.out.println(" La persona no existe ");
        }else{
            if (persona.getActividadRealizada().equalsIgnoreCase(empresa1.getActividadEmpresa())){
                if(persona.getFechaAutorizacionHasta().isAfter(LocalDate.now())){
                    empresa1.AgregarEmpleado(personaAutorizo);
                }else{
                    System.out.println(" Fecha vencida ");
                }
            }
        }

        System.out.println(" Empleados de la empresa " + empresa1.getRazonSocial());
        for (Persona item: empresa1.getListaEmpleados())
        {
            System.out.println(item.getDni());
        }

        System.out.println(" Desea dar de baja a algun empleado ? S/N ");
        String op = scanner.nextLine();
        if (op.compareToIgnoreCase("S")==0){
            RegistrarBajaEmpleado(empresa1);
        }

    }

    public static void RegistrarBajaEmpleado(Empresa empresa)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Ingrese DNI del empleado: ");
        String dni = scanner.nextLine();

        Persona persona = empresa.ObtenerEmpleado(dni);

        if (persona==null)
        {
            System.out.println(" La persona no se encuentra en la empresa ");
        }else{
            persona.setHabilitada(false);
            System.out.println(" Estado de la persona " + persona.getDni() +  " " +  persona.getHabilitada());
        }
    }


}
