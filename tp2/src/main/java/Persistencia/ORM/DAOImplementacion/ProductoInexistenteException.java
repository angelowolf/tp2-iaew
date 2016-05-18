package Persistencia.ORM.DAOImplementacion;

/**
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.000
 * Ultimo cambio: 17/05/2016
 */
public class ProductoInexistenteException extends Exception {
    
    private int idProducto;
    
    public ProductoInexistenteException(int idProducto) {
        this.idProducto = idProducto;
    }
    
    @Override
    public String getMessage() {
        return "No existe un producto con id = " + this.idProducto;
    }
}
