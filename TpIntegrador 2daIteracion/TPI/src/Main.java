import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RepositorioProducto repositorioProducto = new RepositorioProducto();
        RepositorioCombo repositorioCombo = new RepositorioCombo();

        String jsonText1 = "{\"codigo\":100,\"nombre\":\"Mate-Termo Stanley\",\"precio\":17820.0,\"descripcion\":\"Termo original Stanley Mate original Stanley \",\"stock\":7}";
        String jsonText2 = "{\"codigo\":200,\"nombre\":\"Mate Stanley-Bombilla Pico Loro\",\"precio\":5931.0,\"descripcion\":\"Mate original Stanley  Bombilla pico de loro\",\"stock\":6}";
        String jsonText3 = "{\"codigo\":300,\"nombre\":\"Termo Stanley-Mate Stanley-Bobilla Pico Loro\",\"precio\":18441.0,\"descripcion\":\"Termo original Stanley   Mate original Stanley  Bombilla pico de loro\",\"stock\":7}";

        Gson gson = new Gson();

        Combo combo1 = gson.fromJson(jsonText1, Combo.class);
        Combo combo2 = gson.fromJson(jsonText2, Combo.class);
        Combo combo3 = gson.fromJson(jsonText3, Combo.class);

        repositorioCombo.agregarCombo(combo1);
        repositorioCombo.agregarCombo(combo2);
        repositorioCombo.agregarCombo(combo3);

        System.out.print(combo1.getCodigo());
        System.out.print("\n");
        System.out.print(combo2.getCodigo());
        System.out.print("\n");
        System.out.print(combo3.getCodigo());

        Producto producto1 = new Producto(1, "Mate original Stanley", 5900.0, "Mate termico de acero inoxidable", "Verde", 50, "Mates", 5723.00, 5605.00, 5487.00, true, "Oferta dia de la madre", 5310.00, LocalDate.of(2021, 10, 30), LocalDate.of(2021, 12, 20));
        Producto producto2 = new Producto(2, "Termo original Stanley", 13900.00, "Termo de acero inoxidable, con sistema antigoteo y con tapon cebador", "verde", 30, "Termos", 13483.00, 13205.00, 12927.00, true, "Oferta dia del padre", 12510.00, LocalDate.of(2021, 10, 10), LocalDate.of(2021, 12, 20));
        Producto producto3 = new Producto(3, "Bombilla pico de loro", 690.00, "Bombilla Alpaca Brasilera con correcta disipacion de calor", "Plateado", 50, "Bombillas", 669.30, 655.50, 641.70, true, "Oferta dia de la tradicion", 621.00, LocalDate.of(2021, 10, 30), LocalDate.of(2021, 12, 30));

        repositorioProducto.agregarProducto(producto1);
        repositorioProducto.agregarProducto(producto2);
        repositorioProducto.agregarProducto(producto3);

        producto1.agregarCombo(combo1);
        producto2.agregarCombo(combo3);
        producto3.agregarCombo(combo2);

        System.out.print("\n Ingrese opcion: \n ");
        System.out.print("\n 1. Mostrar productos disponibles ");
        System.out.print("\n 2. Mostrar combos disponibles ");
        System.out.print("\n 3. Seleccionar un producto en especifico ");
        System.out.print("\n 4. Mostrar combo en especifico ");
        System.out.print("\n 5. Seleccionar un producto y ver sus respectivos combos ");
        System.out.print("\n 6. Visualizar productos en oferta");
        System.out.print("\n 7. Visualizar precios de productos a partir de la cantidad deseada a comprar");
        System.out.print("\n 8. Visualizar precios de combos a partir de la cantidad deseada a comprar");

        Scanner scanner = new Scanner(System.in);

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                mostrarProductos();
                break;
            case 2:
                mostrarCombos();
                break;
            case 3:
                mostrarProductoEspecifico(repositorioProducto);
                break;
            case 4:
                mostrarComboEspecifico(repositorioCombo);
                break;
            case 5:
                mostrarCombosPorProducto(repositorioProducto);
                break;
            case 6:
                mostrarProductosEnOferta();
            case 7:
                precioProductoCantidad(repositorioProducto);
                break;
            case 8:
                precioComboCantidad(repositorioCombo);
                break;
            default:
                System.out.print("\n Ingrese una opcion valida");
                break;
        }
}

    private static void mostrarProductos()
    {
        System.out.print("\n Productos disponibles");

        for (Producto producto: RepositorioProducto.listaProductos){

            System.out.print("\n");

            System.out.print(" Descripcion: " + " " + producto.getDescripcion() + " " + " Precio: " + " " + producto.getPrecio());
        }
    }

    public static void mostrarCombos()
    {
        System.out.print("\n Combos disponibles");

        for (Combo combo: RepositorioCombo.listaCombos){

            System.out.print("\n");

            System.out.print("Descripcion: " + " " + combo.getDescripcion() + " " + " Precio: " + " " + combo.getPrecio());
        }
    }

    public static void mostrarProductoEspecifico(RepositorioProducto repositorioProducto)
    {
        Scanner scanner1 = new Scanner(System.in);

        System.out.print("\n Ingrese nombre del producto que desea seleccionar: ");

        String nombre = scanner1.nextLine();

        Producto producto = repositorioProducto.obtenerProducto(nombre);

        if (producto==null){
            System.out.print(" El combo no existe");
        }else{
            System.out.print("Descripcion: " + " " + producto.getDescripcion() + " " + " Precio: " + " " + producto.getPrecio());
        }
    }

    public static void mostrarComboEspecifico(RepositorioCombo repositorioCombo)
    {
        Scanner scanner1 = new Scanner(System.in);

        System.out.print("\n Ingrese nombre del combo a seleccionar: ");
        String nombreCombo = scanner1.nextLine();

        Combo combo = repositorioCombo.obtenerCombo(nombreCombo);

        if (combo==null){
            System.out.print(" El combo no existe");
        }else{
            System.out.print("Descripcion: " + " " + combo.getDescripcion() + " " + "Precio" + " " + combo.getPrecio());
        }
    }

    public static void mostrarCombosPorProducto(RepositorioProducto repositorioProducto)
    {
        mostrarProductos();

        System.out.print("\n Para visualizar los combos de un producto, ingrese el nombre del producto: ");

        Scanner scanner1 = new Scanner(System.in);

        String nombreProducto = scanner1.nextLine();

        Producto producto = repositorioProducto.obtenerProducto(nombreProducto);

        if (producto==null){
            System.out.print("El producto no existe ");
        }else{
            for (Combo combo: producto.getCombosPorProducto()){
                System.out.print("\n Descripcion combo: " + " " + combo.getDescripcion() + " " + " Precio: " + " " + combo.getPrecio());
            }
        }
    }

    public static void mostrarProductosEnOferta(){

        System.out.print("\n Productos en oferta ");

        for (Producto producto : RepositorioProducto.listaProductos) {
            if (producto.isEstaEnOferta()) {
                if (producto.fechaOfertaValida(producto.getFechaInicioOferta(),producto.getFechaFinOferta())){
                    System.out.print("Nombre: " + " " + producto.getNombre() + "Descripcion: " + producto.getDescripcion() + " " + producto.getPrecioOferta());
                }
            }
        }
    }

    public static void precioProductoCantidad(RepositorioProducto repositorioProducto)
    {
        Scanner scanner1 = new Scanner(System.in);

        System.out.print("\n Ingrese nombre del producto deseado: ");
        String nombreProducto = scanner1.nextLine();

        Producto producto = repositorioProducto.obtenerProducto(nombreProducto);

        if (producto == null) {
            System.out.print("\n El producto no existe");
        } else {
            System.out.print("\n Ingrese cantidad deseada: ");

            int cantidad = scanner1.nextInt();

            if (cantidad == 1) {
                System.out.print("\n Nombre producto: " + " " + producto.getDescripcionOferta() + "Precio unitario: " + " " + producto.getPrecioOferta());
            } else if (cantidad >= 2 && cantidad <= 5) {
                System.out.print("\n Descripcion oferta: " + " " + producto.getDescripcionOferta() + " " + " Precio: " + " " + producto.getPrecioDosCinco());
            } else if (cantidad >= 6 && cantidad < 10) {
                System.out.print("\n Descripcion oferta: " + " " + producto.getDescripcionOferta() + " " + "Precio: " + " " + producto.getPrecioSeisDiez());
            } else if (cantidad >= 10) {
                System.out.print("\n Descripcion oferta: " + " " + producto.getDescripcionOferta() + " " + " Precio: " + " " + producto.getPrecioDiezMas());
            }

        }
    }

    public static void precioComboCantidad(RepositorioCombo repositorioCombo)
    {
        Scanner scanner1 = new Scanner(System.in);

        System.out.print("\n Combos: ");

        for (Combo combo : RepositorioCombo.listaCombos) {
            System.out.print("\n Nombre combo: " + " " + combo.getNombre());
        }

        System.out.print("\n Ingrese combo deseado: ");

        String nombreCombo = scanner1.nextLine();

        Combo combo = repositorioCombo.obtenerCombo(nombreCombo);

        if (combo == null) {
            System.out.print("\n El combo no existe ");
        } else {

            System.out.print("\n Ingrese cantidad deseada: ");
            int cantidad = scanner1.nextInt();

            if (cantidad == 1) {
                System.out.print("\n Nombre combo: " + " " + combo.getNombre() + " Precio unitario: " + " " + combo.getPrecio());
            } else if (cantidad >= 2 && cantidad <= 5) {

                double precio = combo.getPrecio();

                // Se aplica descuento del 15 %

                combo.setPrecio(precio - ((combo.getPrecio() * 15) / 100));
                System.out.print("\n Descripcion combo: " + " " + combo.getDescripcion() + " Precio: " + " " + combo.getPrecio());
            }else if (cantidad >= 6 && cantidad <10){

                double precio = combo.getPrecio();

                // Se aplica descuento del 20 %

                combo.setPrecio(precio - ((combo.getPrecio() * 20) / 100));
                System.out.print("\n Descripcion combo: " + " " + combo.getDescripcion() + " Precio: " + " " + combo.getPrecio());
            }else if (cantidad >=10) {
                double precio = combo.getPrecio();

                // Se aplica descuento del 30 %

                combo.setPrecio(precio - ((combo.getPrecio() * 30) / 100));
                System.out.print("\n Descripcion combo: " + " " + combo.getDescripcion() + " Precio: " + " " + combo.getPrecio());
            }
        }
    }
}
