package Persistencia.ORM.DAOInterface;

import Persistencia.ORM.DAOImplementacion.ProductoInexistenteException;
import Persistencia.ORM.DAOImplementacion.StockInsuficienteException;
import Persistencia.ORM.Util.IGenericDAO;
import edu.utnfrc.iaew.tp2.model.Producto;
import java.util.List;

/**
 * @author Angelo Wolf, Patricio Carranza
 * @version 2.00.000
 * Ultimo cambio: 17/05/2016
 */
public interface IProducto extends IGenericDAO<Producto, Integer> {

    public List<Producto> listarConStock();
    public List<Producto> buscarConStock(String nombre)
            throws ProductoInexistenteException;
    public int reservarStock(int idProducto, int cantidad) 
            throws StockInsuficienteException, 
                   ProductoInexistenteException;
}
