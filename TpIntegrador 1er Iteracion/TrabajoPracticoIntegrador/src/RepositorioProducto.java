import java.util.ArrayList;

public class RepositorioProducto {

    public static ArrayList<Producto> ListaDeProductos = new ArrayList<Producto>();

    public void agregarProducto (Producto producto)
    {
        ListaDeProductos.add(producto);
    }

    public static ArrayList<Producto> getListaDeProductos() {
        return ListaDeProductos;
    }

    public Producto obtenerProducto(String nombreProducto)
    {
        for (Producto producto: ListaDeProductos)
        {
            if(producto.getNombreProducto().equalsIgnoreCase(nombreProducto)){
                return producto;
            }
        }
        return null;
    }

    public void mostrarProductos(){

        for (Producto productosDisponibles: RepositorioProducto.getListaDeProductos())
        {
            System.out.print("\n");
            System.out.print("Codigo producto " + " " + productosDisponibles.getCodigoProducto() + " "  +  "Nombre Producto " + " " + productosDisponibles.getNombreProducto());
        }
    }
}
