import java.util.Scanner;

public class Main {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Ingrese opcion: ");
        System.out.println(" 1. Registrar Persona ");

        int opcion = scanner.nextInt();

        switch (opcion){
            case 1:
                RegistrarActividadesAutorizaras();
                RegistrarPersona();
                break;
        }

    }

    public static void RegistrarPersona()
    {
        RepositorioActividad actividades = new RepositorioActividad();

        Scanner scanner = new Scanner(System.in);

        boolean seguirAgregando = true;


        while (seguirAgregando){

            System.out.println(" Ingrese dni: ");
            String dni = scanner.nextLine();

            System.out.println(" Ingrese nombre y apellido : ");
            String nombreApellido = scanner.nextLine();

            System.out.println(" Ingrese domicilio: ");
            String domicilio = scanner.nextLine();

            System.out.println(" Ingrese telefono: ");
            String telefono = scanner.nextLine();

            System.out.println(" Ingrese email: ");
            String email = scanner.nextLine();

            System.out.println(" Ingrese actividad que realiza: ");
            String actividadRealizada = scanner.nextLine();

            Persona persona1 = new Persona(dni,nombreApellido,domicilio,telefono,email,actividadRealizada);

            Actividad actividad = actividades.ObtenerActividad(actividadRealizada);

            if (actividad == null)
            {
                System.out.println(" La actividad no existe ");
                System.out.println(" La persona " + persona1.getDni() + " no puede ingresar ");
            }else {
                AutorizarIngreso(persona1);
            }

            System.out.println("\n Desea seguir registrando personas ? S / N ");

            String respuesta = scanner.nextLine();

            if(respuesta.compareToIgnoreCase("S")==0){
                seguirAgregando=true;
            }else {
                seguirAgregando=false;
            }

        }

    }

    public static void RegistrarActividadesAutorizaras()
    {
        RepositorioActividad actividades = new RepositorioActividad();

        Actividad actividad1 = new Actividad("Deporte");
        Actividad actividad2 = new Actividad("Gastronomia");
        Actividad actividad3 = new Actividad("Salud");

        actividades.AgregarActividad(actividad1);
        actividades.AgregarActividad(actividad2);
        actividades.AgregarActividad(actividad3);

    }

    public static void AutorizarIngreso(Persona persona)
    {
        RepositorioPersonasAutorizadas personasAutorizadas = new RepositorioPersonasAutorizadas();

        personasAutorizadas.AgregarPersona(persona);

        Persona autorizo = personasAutorizadas.ObtenerPersona(persona.getDni());

        if (autorizo == null)
        {
            System.out.println(" La persona no existe ");
        }else {
            System.out.println(" La persona existe y esta registrada en la lista de personas autorizadas ");
        }
    }
}
