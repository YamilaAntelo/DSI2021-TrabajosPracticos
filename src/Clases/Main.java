package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Ingrese una opcion: ");
        System.out.println(" Opcion 1: Registrar persona ");

        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();
        switch (op){
            case 1:
                registrarPersona();
                break;
            case 2:
                break;
        }


    }

    public static void registrarPersona() {
        ArrayList<Actividad> listaActividades = new ArrayList<Actividad>();

        Actividad actividad1 = new Actividad("Deporte");
        Actividad actividad2 = new Actividad("Turismo");
        Actividad actividad3 = new Actividad("Restaurantes");

        listaActividades.add(actividad1);
        listaActividades.add(actividad2);
        listaActividades.add(actividad3);

        Persona persona1 = new Persona("40324123", "Luis Perez", "Lavalle30", "3576470820", "luisPerez94@gmail.com", "Deporte");
        Persona persona2 = new Persona("34232125", "MariaRodriguez", "Manuel Belgrano 286", "3564476789", "maria34@gmail.com", "Cine");

        int s = 0;

        for (int i = 0; i < listaActividades.size(); i++) {
            if (listaActividades.get(i).getNombreActividad() == persona1.getActividad()) {
                s = 1;
            }
        }

        if (s == 1) {
            System.out.println(" La persona " + persona1.getNombreApellido() + " puede ingresar ");
        } else {
            System.out.println(" La persona " + persona1.getNombreApellido() + " no puede ingresar ");
        }

        int b = 0;

        for(int i=0;i<listaActividades.size();i++) {
            if(listaActividades.get(i).getNombreActividad()==persona2.getActividad()){
                b=1;
            }
        }

        if(b==1){
            System.out.println(" La persona " + persona2.getNombreApellido() + " puede ingresar ");
        }else{
            System.out.println(" La persona " + persona2.getNombreApellido() + " no puede ingresar ");
        }
    }
}
