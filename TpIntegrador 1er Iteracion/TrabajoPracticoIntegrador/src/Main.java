import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        RepositorioCombo repositorioCombo = new RepositorioCombo();
        RepositorioProducto repositorioProducto = new RepositorioProducto();

        Producto producto1 = new Producto(1,"Mate",4.500,"Mate de aluminio","Negro",130,Categoria.CATEGORIA1);
        Producto producto2 = new Producto(2,"Termo",1.500,"Termo de 1 litro","Rojo",10,Categoria.CATEGORIA2);

        repositorioProducto.agregarProducto(producto1);
        repositorioProducto.agregarProducto(producto2);

        Producto producto3 = new Producto(3,"Bombilla",300.00,"Bombilla corta","Azul",40,Categoria.CATEGORIA3);
        Producto producto4 = new Producto(4,"Mate1",3.400,"Mate chico","Verde",13,Categoria.CATEGORIA1);

        repositorioProducto.agregarProducto(producto3);
        repositorioProducto.agregarProducto(producto4);

        Producto producto5 = new Producto(5,"Termo1",1.700,"Termo de 2 litros","Blanco",45,Categoria.CATEGORIA2);
        Producto producto6 = new Producto(6,"Bombilla1",450.00,"Bombilla larga","Gris",5,Categoria.CATEGORIA3);

        repositorioProducto.agregarProducto(producto5);
        repositorioProducto.agregarProducto(producto6);

        Combo combo1 = new Combo(1,"Combo Torpedo",6.700,"Mate con bombilla",3);
        Combo combo2 = new Combo(2,"Combo Acero",4.300,"Camionero acero mas dos letras",2);

        repositorioCombo.agregarCombo(combo1);
        repositorioCombo.agregarCombo(combo2);

        Combo combo3 = new Combo(3,"Combo Torpedo Acero",4.200,"Combo Torpedo Acero Premium",1);
        Combo combo4 = new Combo(4,"Latas",1.800,"Latas de yerba y azucar mas mate",4);
        repositorioCombo.agregarCombo(combo3);
        repositorioCombo.agregarCombo(combo4);

        producto1.agregarCombo(combo4);
        producto2.agregarCombo(combo3);
        producto3.agregarCombo(combo2);
        producto4.agregarCombo(combo1);



        System.out.print("\n Ingrese Opcion: \n");
        System.out.print("\n 1.  Mostrar productos disponibles ");
        System.out.print("\n 2.  Mostrar combos disponibles ");
        System.out.print("\n 3.  Seleccionar un producto en especifico ");
        System.out.print("\n 4.  Seleccionar un combo en especifico ");
        System.out.print("\n 5.  Seleccionar un producto y  ver sus respectivos combos \n");

        System.out.print("\n");

        Scanner scanner1 = new Scanner(System.in);

        int opcion = scanner1.nextInt();

        switch (opcion) {
            case 1:
               repositorioProducto.mostrarProductos();
            break;

            case 2:
                repositorioCombo.mostrarCombos();
            break;
            case 3:

                Scanner scanner3 = new Scanner(System.in);

                System.out.print("\n Ingrese nombre del producto que desea seleeccionar: ");

                String nombreProduct = scanner3.nextLine();

                Producto producto10 = repositorioProducto.obtenerProducto(nombreProduct);

                System.out.print(producto10.getDescripcion() + " " + "Precio: " + " " + producto10.getPrecio());
            break;
            case 4:

                Scanner scanner2 = new Scanner(System.in);

                System.out.print("\n Ingrese nombre del combo que desea seleccionar: ");

                String nombreCombo = scanner2.nextLine();

                Combo combo = repositorioCombo.obtenerCombo(nombreCombo);
                System.out.print( combo.getDescripcion() + " " + " Precio: " + " " +  combo.getPrecio());
            break;
            case 5:

                System.out.print("\n Productos disponibles ");

                repositorioProducto.mostrarProductos();

                Scanner scanner = new Scanner(System.in);

                System.out.print("\n");

                System.out.print(" Para visualizar los combos de un producto, ingrese nombre del producto a seleccionar: ");

                String nombreProducto = scanner.nextLine();

                Producto producto = repositorioProducto.obtenerProducto(nombreProducto);

                if (producto == null)
                {
                    System.out.println(" El producto no existe ");
                }else {
                    for (Combo combosPorProducto: producto.getCombosPorProducto()){
                        System.out.print(combosPorProducto.getDescripcion() + " " + "Precio: " + " " + combosPorProducto.getPrecio());
                    }
                }
            break;

        }

    }
}
