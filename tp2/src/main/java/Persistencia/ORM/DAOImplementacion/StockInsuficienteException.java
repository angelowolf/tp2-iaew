package Persistencia.ORM.DAOImplementacion;

/**
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.000
 * Ultimo cambio: 17/05/2016
 */
public class StockInsuficienteException extends Exception {
    
    private int stockActual;
    private int stockDemandado;
    private String nombreProducto;
    
    public StockInsuficienteException(String nombreProducto, 
                                      int stockActual,
                                      int stockDemandado) {
        this.stockActual = stockActual;
        this.stockDemandado = stockDemandado;
        this.nombreProducto = nombreProducto;
    }
    
    @Override
    public String getMessage() {
        return "No se puede reservar " + this.stockDemandado + " unidades de " +
                this.nombreProducto + " ya que su stock actual es " + this.stockActual;
    }
}
