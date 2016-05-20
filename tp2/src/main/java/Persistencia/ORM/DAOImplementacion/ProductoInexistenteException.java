package Persistencia.ORM.DAOImplementacion;

/**
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.01.000
 * Ultimo cambio: 19/05/2016
 */
public class ProductoInexistenteException extends Exception {
    
    private int idProducto;
    private String nombreProducto;
    
    public ProductoInexistenteException(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public ProductoInexistenteException(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    @Override
    public String getMessage() {
        if(nombreProducto != null)
            return "No existe un producto con nombre \"" + nombreProducto + "\".";
        return "No existe un producto con id = " + this.idProducto + ".";
    }
}
