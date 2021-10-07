import java.util.ArrayList;

public class Producto {
     private int CodigoProducto;
     private String NombreProducto;
     private Double Precio;
     private String Descripcion;
     private String Color;
     private int Stock;
     public Categoria categoria;

     ArrayList<Combo> CombosPorProducto = new ArrayList<Combo>();

     public Producto(int CodigoProducto,String NombreProducto, Double Precio, String Descripcion, String Color, int Stock, Categoria categoria)
     {
          this.CodigoProducto = CodigoProducto;
          this.NombreProducto = NombreProducto;
          this.Precio = Precio;
          this.Descripcion = Descripcion;
          this.Color = Color;
          this.Stock = Stock;
          this.categoria = categoria;
     }

     public int getCodigoProducto() {
          return CodigoProducto;
     }

     public String getNombreProducto() {
          return NombreProducto;
     }

     public String getDescripcion() {
          return Descripcion;
     }

     public Double getPrecio() {
          return Precio;
     }

     public void agregarCombo(Combo combo)
     {
          CombosPorProducto.add(combo);
     }

     public ArrayList<Combo> getCombosPorProducto() {
          return CombosPorProducto;
     }
}
