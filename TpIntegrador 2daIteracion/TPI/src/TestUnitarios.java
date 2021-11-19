import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TestUnitarios {

    @Test
    public void testSettersGettersProducto(){

        Producto producto = new Producto();

        producto.setNombre("Mate original Stanley");
        Assert.assertEquals("Mate original Stanley", producto.getNombre());

        producto.setDescripcion("Termo de acero inoxidable, con sistema antigoteo y con tapon cebador");
        Assert.assertEquals("Termo de acero inoxidable, con sistema antigoteo y con tapon cebador",producto.getDescripcion());

        producto.setCategoria("Mates");
        Assert.assertEquals("Mates",producto.getCategoria());

        producto.setPrecio(5900.0);
        Assert.assertEquals(5900.00,producto.getPrecio(),5900.00);

    }

    @Test
    public void testSettersGettersCombo(){

        Combo combo = new Combo();

        combo.setCodigo(1);
        Assert.assertEquals(1,combo.getCodigo());

        combo.setNombre("Mate Stanley-Bombilla Pico Loro");
        Assert.assertEquals("Mate Stanley-Bombilla Pico Loro",combo.getNombre());

        combo.setDescripcion("Termo original Stanley Mate original Stanley");
        Assert.assertEquals("Termo original Stanley Mate original Stanley",combo.getDescripcion());

        combo.setPrecio(5931.0);
        Assert.assertEquals(5931.0,combo.getPrecio(),5931.0);
    }

    @Test
    public void testFechaOfertaValida()
    {
        Producto producto = new Producto();

        producto.setFechaInicioOferta(LocalDate.of(2021,11,16));
        producto.setFechaFinOferta(LocalDate.of(2021,12,15));

        Assert.assertTrue(producto.fechaOfertaValida(producto.getFechaInicioOferta(),producto.getFechaFinOferta()));
    }

    @Test
    public void testFechaOfertaInvalida()
    {
        Producto producto = new Producto();

        producto.setFechaInicioOferta(LocalDate.of(2021,12,10));
        producto.setFechaFinOferta(LocalDate.of(2021,12,20));

        Assert.assertFalse(producto.fechaOfertaValida(producto.getFechaInicioOferta(),producto.getFechaFinOferta()));
    }

    @Test
    public void testPrecioCantidadProducto()
    {
        Producto producto = new Producto();

        // Si la cantidad deseada esta entre 2 y 5.

        double precio;

        precio = 13483.00;

        Assert.assertEquals(precio,producto.getPrecioDosCinco(),13483.00);
    }

    @Test
    public void testPrecioCantidadCombo()
    {
        Combo combo = new Combo();
        combo.setPrecio(5931.0);

        // Si la cantidad deseada esta entre 6 y 10
        //Se aplica descuento del 20 %

        double precio;

        precio = combo.getPrecio() - ((combo.getPrecio()*20)/100);

        Assert.assertEquals(precio,combo.getPrecio(),5931.0);

    }
}
