/*  Nuestra clase Producto.java contiene a su vez una clase PrecioEvent el cual tiene un constructor y
    los métodos getProducto(), getProductoAntiguo() y getProductoNuevo(). Por otro lado, genera una 
    variable de tipo static final ProductoObservable, llamada OBSERVABLE, sobre la cual se instancia 
    ProductoObservable. El método a observar será setPrecio().

 */
package precioobserver;

import java.util.Observable;
import java.math.BigDecimal;

/**
 *
 * @author Robinson Concha
 */
public class Producto {
    
    public class PrecioEvent{
    
    private Producto producto;
    private BigDecimal precioAntiguo, precioNuevo;

        public PrecioEvent(Producto producto, BigDecimal precioAntiguo, BigDecimal precioNuevo) {
            this.producto = producto;
            this.precioAntiguo = precioAntiguo;
            this.precioNuevo = precioNuevo;
        }

        public Producto getProducto() {
            return producto;
        }

        public BigDecimal getPrecioAntiguo() {
            return precioAntiguo;
        }

        public BigDecimal getPrecioNuevo() {
            return precioNuevo;
        }
    
    }
    private static final ProductoObservable OBSERVABLE;
    
    private String nombre;
    private BigDecimal precio;
    
    static {
          OBSERVABLE = new ProductoObservable();
    
    }
    public static Observable getObservable() {
      return OBSERVABLE;
    }
    
    public Producto(String nombre, BigDecimal precio){
        this.nombre = nombre;
        this.precio = precio;
    
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }
     
    public void setPrecio(BigDecimal precio){
      PrecioEvent event = new PrecioEvent(this, this.precio, precio);
    
      this.precio = precio;
      
      synchronized(OBSERVABLE){
      OBSERVABLE.setChanged();
      OBSERVABLE.notifyObservers(event);
      }
    }
    
    private static class ProductoObservable extends Observable {
    
        @Override
        public synchronized void setChanged(){
          super.setChanged();
        }
    }
}
