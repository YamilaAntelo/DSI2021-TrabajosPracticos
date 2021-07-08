import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        RepositorioActividad listaActividades = new RepositorioActividad();

        Scanner scanner = new Scanner(System.in);

        //Actividades autorizadas

        Actividad actividad1 = new Actividad("Salud");
        Actividad actividad2 = new Actividad("Rural");

        listaActividades.AgregarActividad(actividad1);
        listaActividades.AgregarActividad(actividad2);

        System.out.print(" Ingrese opcion: ");
        System.out.print("\n 1.Registrar Empresa ");
        System.out.print("\n 2.Registrar Persona ");
        System.out.print("\n 3. Autorizar ingreso ");
        System.out.print("\n 4. Registrar salida ");
        System.out.print("\n 5. Registrar baja autorizacion ");

        int opcion = scanner.nextInt();
        switch (opcion)
        {
            case 1:
                RegistrarEmpresa();
                break;
            case 2:
                RegistrarEmpresa();
                RegistrarPersona();
                break;
            case 3:
                RegistrarEmpresa();
                RegistrarPersona();
                AutorizarIngreso();
                break;
            case 4:
                RegistrarSalida();
                break;
            case 5:
                RegistrarBajaAutorizacion();
                break;
            default:
                System.out.print(" Ingrese una opcion valida ");
        }

    }

    public static void RegistrarEmpresa()
    {
        RepositorioActividad listaActividades = new RepositorioActividad();
        RepositorioEmpresa listaEmpresas = new RepositorioEmpresa();

        Empresa empresa1 = new Empresa("Ospe","045","San Martin 453","Cordoba","Ospe92@gmail.com","3564231126",listaActividades.ObtenerActividad("Salud"));
        Empresa empresa2 = new Empresa("BioAgro","03","Manuel Belgrano 342","Santa Fe","BioAgro32@gmail.com","3567342312",listaActividades.ObtenerActividad("Rural"));

        listaEmpresas.AgregarEmpresa(empresa1);
        listaEmpresas.AgregarEmpresa(empresa2);
    }

    public static void RegistrarPersona()
    {
        RepositorioPersonas listaPersonas = new RepositorioPersonas();

        Persona persona1 = new Persona("40231434","Benjamin Perez","Lavalle 30","3576453423","Benja34@gmail.com", LocalDate.of(2021,5,10),LocalDate.of(2021,10,10));
        persona1.AsignarEmpresa("BioAgro");
        listaPersonas.AgregarPersona(persona1);

        Persona persona2 = new Persona("33231321","Maria Romero","Falucho 234","3573234321","Maria99@gmail.com",LocalDate.of(2021,4,12),LocalDate.of(2021,11,20));
        persona2.AsignarEmpresa("Ospe");
        listaPersonas.AgregarPersona(persona2);

        Persona persona3 = new Persona("40801578", "Luna Ramos","San Martin 342","3576543232","Luna93@gmail.com",LocalDate.of(2021,3,3), LocalDate.of(2021,10,29));
        persona3.AsignarEmpresa("Ospe");
        listaPersonas.AgregarPersona(persona3);
    }

    public static void AutorizarIngreso()
    {
        RepositorioPersonas listaPersonas = new RepositorioPersonas();
        RepositorioIngreso listaIngresos = new RepositorioIngreso();

        Scanner scanner = new Scanner(System.in);
        System.out.print(" Ingrese dni de la persona: ");
        String dni = scanner.nextLine();

        boolean existencia = listaPersonas.VerificarExistencia(dni);
        if (existencia)
        {
           System.out.print(" Persona encontrada ");
           System.out.print("\n Nombre: " + listaPersonas.ObtenerPersona(dni).getNombreApellido());

           boolean autorizacion = listaPersonas.ObtenerPersona(dni).VerificarAutorizacion();

           if (autorizacion)
           {
               System.out.print("\n Persona Autorizada \n");

               Scanner scanner1 = new Scanner(System.in);
               System.out.print("\n Ingrese temperatura: ");
               float temperatura = scanner1.nextFloat();

               Ingreso ingreso = new Ingreso(listaPersonas.ObtenerPersona(dni),LocalDate.now(), LocalTime.now(),temperatura);


               if (temperatura<37){
                   ingreso.setAutorizacion(true);

                   Scanner scanner2 = new Scanner(System.in);
                   System.out.print("\n Ingrese patende del vehiculo: ");
                   String patente = scanner2.nextLine();

                   Scanner scanner3 = new Scanner(System.in);
                   System.out.print("\n Ingrese lugar de destino: ");
                   String destino = scanner3.nextLine();

                   ingreso.PatenteDestino(patente,destino);

                   System.out.print("\nIngreso autorizado ");
               }else{
                   ingreso.setAutorizacion(false);
                   ingreso.setHoraSalida(LocalTime.now());
                   System.out.print("\n Ingreso no autorizazdo ");
               }
               listaIngresos.AgregarIngreso(ingreso);
           }else{
               System.out.print(" Persona no autorizada ");
           }
        }else
        {
            System.out.print(" Persona no encontrada");
        }
    }

    public static void RegistrarSalida()
    {
        RepositorioIngreso listaIngresos =new RepositorioIngreso();

        Scanner scanner = new Scanner(System.in);
        System.out.print(" Ingrese dni de la persona: ");
        String dni = scanner.nextLine();

        boolean resultado = listaIngresos.VerificarIngreso(dni);

        if (resultado)
        {
            listaIngresos.ObtenerIngreso(dni).setHoraSalida(LocalTime.now());
            System.out.print(" Salida registrada ");
        }else {
            System.out.print(" No se encontraron ingresos ");
        }
    }

    public static void RegistrarBajaAutorizacion()
    {
        RepositorioPersonas listaPersonas = new RepositorioPersonas();

        Scanner scanner = new  Scanner(System.in);
        System.out.print(" Ingrese dni: ");
        String dni = scanner.nextLine();

       boolean resultado = listaPersonas.VerificarExistencia(dni);

       if (resultado)
       {
           listaPersonas.ObtenerPersona(dni).BajaAutorizacion();
       }else{
           System.out.print(" Persona no encontrada ");
       }
    }
}


