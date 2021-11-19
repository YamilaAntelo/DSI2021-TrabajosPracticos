import java.time.LocalDate;
import java.util.ArrayList;

public class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private String descripcion;
    private String color;
    private int stock;
    private String categoria;
    private double precioDosCinco;
    private double precioSeisDiez;
    private double precioDiezMas;
    private boolean estaEnOferta;
    private String descripcionOferta;
    private double precioOferta;
    private LocalDate fechaInicioOferta;
    private LocalDate fechaFinOferta;

    ArrayList<Combo> combosPorProducto = new ArrayList<Combo>();

    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, String descripcion, String color, int stock, String categoria, double precioDosCinco, double precioSeisDiez, double precioDiezMas, boolean estaEnOferta, String descripcionOferta, double precioOferta, LocalDate fechaInicioOferta, LocalDate fechaFinOferta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.color = color;
        this.stock = stock;
        this.categoria = categoria;
        this.precioDosCinco = precioDosCinco;
        this.precioSeisDiez = precioSeisDiez;
        this.precioDiezMas = precioDiezMas;
        this.estaEnOferta = estaEnOferta;
        this.descripcionOferta = descripcionOferta;
        this.precioOferta = precioOferta;
        this.fechaInicioOferta = fechaInicioOferta;
        this.fechaFinOferta = fechaFinOferta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioDosCinco() {
        return precioDosCinco;
    }

    public void setPrecioDosCinco(double precioDosCinco) {
        this.precioDosCinco = precioDosCinco;
    }

    public double getPrecioSeisDiez() {
        return precioSeisDiez;
    }

    public void setPrecioSeisDiez(double precioSeisDiez) {
        this.precioSeisDiez = precioSeisDiez;
    }

    public double getPrecioDiezMas() {
        return precioDiezMas;
    }

    public void setPrecioDiezMas(double precioDiezMas) {
        this.precioDiezMas = precioDiezMas;
    }

    public boolean isEstaEnOferta() {
        return estaEnOferta;
    }

    public void setEstaEnOferta(boolean estaEnOferta) {
        this.estaEnOferta = estaEnOferta;
    }

    public String getDescripcionOferta() {
        return descripcionOferta;
    }

    public void setDescripcionOferta(String descripcionOferta) {
        this.descripcionOferta = descripcionOferta;
    }

    public double getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }

    public LocalDate getFechaInicioOferta() {
        return fechaInicioOferta;
    }

    public void setFechaInicioOferta(LocalDate fechaInicioOferta) {
        this.fechaInicioOferta = fechaInicioOferta;
    }

    public LocalDate getFechaFinOferta() {
        return fechaFinOferta;
    }

    public void setFechaFinOferta(LocalDate fechaFinOferta) {
        this.fechaFinOferta = fechaFinOferta;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", color='" + color + '\'' +
                ", stock=" + stock +
                ", categoria='" + categoria + '\'' +
                ", precioDosCinco=" + precioDosCinco +
                ", precioSeisDiez=" + precioSeisDiez +
                ", precioDiezMas=" + precioDiezMas +
                ", estaEnOferta=" + estaEnOferta +
                ", descripcionOferta='" + descripcionOferta + '\'' +
                ", precioOferta=" + precioOferta +
                ", fechaInicioOferta=" + fechaInicioOferta +
                ", fechaFinOferta=" + fechaFinOferta +
                '}';
    }

    public void agregarCombo(Combo combo){
        combosPorProducto.add(combo);
    }

    public ArrayList<Combo> getCombosPorProducto() {
        return combosPorProducto;
    }

    public boolean fechaOfertaValida(LocalDate fechaInicioOferta, LocalDate fechaFinOferta){
        if (fechaInicioOferta.isBefore(LocalDate.now()) && fechaFinOferta.isAfter(LocalDate.now())){
            return true;
        }else{
            return false;
        }
    }
}
