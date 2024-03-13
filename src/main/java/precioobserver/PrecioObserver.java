/*  Finalmente, la clase cliente PrecioObserver instanciará la clase Producto e ingresará dos valores con 
    sus respectivos precios. Luego instancia la clase ProductoObserver y preparará la clase Producto 
    para un cambio. Se setearán los nuevos precios y su resultado demostrará los cambios de precios
 */
package precioobserver;

import java.util.Observer;
import java.math.BigDecimal;
/**
 *
 * @author Robinson Concha
 */
public class PrecioObserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Producto p1 = new Producto("Libro", new BigDecimal("3.99"));
        Producto p2 = new Producto("Lector Libros electronico", new BigDecimal("129"));
        
        Observer o1 = new ProductoObserver();
        Producto.getObservable().addObserver(o1);
         
        p1.setPrecio(new BigDecimal("4.99"));
        p2.setPrecio(new BigDecimal("119"));
    
    }
    
}
