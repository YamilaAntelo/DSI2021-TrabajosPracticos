import java.util.ArrayList;

public class RepositorioCombo {

    ArrayList<Combo> ListaCombos = new ArrayList<Combo>();

    public void agregarCombo(Combo combo)
    {
        ListaCombos.add(combo);
    }

    public ArrayList<Combo> getListaCombos() {
        return ListaCombos;
    }

    public void mostrarCombos(){
        for (Combo combosDisponibles: getListaCombos())
        {
            System.out.print("\n");
            System.out.print("Nombre combo " + " " + combosDisponibles.getNombreCombo() + "\n " +  "Precio" + " " + combosDisponibles.getPrecio());
        }
    }

    public Combo obtenerCombo(String nombreCombo){
        for (Combo combo: ListaCombos)
        {
            if (combo.getNombreCombo().equalsIgnoreCase(nombreCombo)){
                return combo;
            }
        }
        return null;
    }
}
