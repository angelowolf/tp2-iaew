package edu.utnfrc.iaew.tp2.services;

import Persistencia.ORM.DAOImplementacion.*;
import edu.utnfrc.iaew.tp2.model.*;
import java.util.List;
import javax.jws.*;

/**
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.000
 * Ultimo cambio: 17/05/2016
 */
@WebService(serviceName = "InsumosInformaticos")
public class InsumosInformaticos {   
    
    @WebMethod(operationName = "consultarProductosDisponibles")
    public List<Producto> consultarProductosDisponibles() {
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.listarConStock();
    }

    
    @WebMethod(operationName = "reservarStock")
    public String reservarStock(@WebParam(name = "idProducto") int idProducto, @WebParam(name = "cantidad") int cantidad) 
            throws ProductoInexistenteException, StockInsuficienteException {        
        return "Se han reservado " + new ProductoDAO().reservarStock(idProducto, cantidad) +
                " unidades del producto " + new ProductoDAO().buscar(idProducto).getNombre() +
                ". El stock remanente es de " +  new ProductoDAO().buscar(idProducto).getStockDisponible();
    }

   
    @WebMethod(operationName = "consultarProductoPorNombre")
    public List<Producto> consultarProductoPorNombre(@WebParam(name = "nombre") String nombre) {
        return new ProductoDAO().buscarConStock(nombre);
    }
}
