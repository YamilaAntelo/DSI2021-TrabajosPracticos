import java.util.ArrayList;

public class RepositorioCombo {

    public static ArrayList<Combo> listaCombos = new ArrayList<Combo>();

    public void agregarCombo(Combo combo){
        listaCombos.add(combo);
    }

    public Combo obtenerCombo(String nombreCombo)
    {
        for (Combo combo: listaCombos){
            if (combo.getNombre().equalsIgnoreCase(nombreCombo)){
                return combo;
            }
        }return null;
    }
}
