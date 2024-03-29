/* 
   La clase ProductoObserver.java implementa el Observer y contiene un método llamado update que 
   verificará el Precio y enviará un mensaje reportando el cambio de estado.
 */
package precioobserver;
import java.util.Observable;
import java.util.Observer;
import precioobserver.Producto.PrecioEvent;
/**
 *
 * @author Robinson Concha
 */
public class ProductoObserver implements Observer {
    
    @Override
    @SuppressWarnings("unchecked")
    public void update(Observable observable, Object args) {
      if(args instanceof PrecioEvent){
          PrecioEvent evento = (PrecioEvent) args;
          System.out.printf("El producto %s ha cambiado de precio de %s a %s%n",
          evento.getProducto().getNombre(), evento.getPrecioAntiguo(), evento.getPrecioNuevo());
      
      }
    }
    
}
