import java.util.ArrayList;

public class Combo {
    private int CodigoCombo;
    private String NombreCombo;
    private double Precio;
    private String Descripcion;
    private int Stock;

    public Combo(int CodigoCombo, String NombreCombo, double Precio, String Descripcion, int Stock)
    {
        this.CodigoCombo = CodigoCombo;
        this.NombreCombo = NombreCombo;
        this.Precio = Precio;
        this.Descripcion = Descripcion;
        this.Stock = Stock;
    }

    public String getNombreCombo() {
        return NombreCombo;
    }

    public double getPrecio() {
        return Precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }
}
