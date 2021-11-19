import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioProducto {

    public static ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    public void agregarProducto(Producto producto)
    {
        listaProductos.add(producto);
    }

    public Producto obtenerProducto(String nombreProducto)
    {
        for (Producto producto: listaProductos){
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)){
                return producto;
            }
        }return null;
    }

}
