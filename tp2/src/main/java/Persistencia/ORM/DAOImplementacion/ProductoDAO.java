package Persistencia.ORM.DAOImplementacion;

import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import Persistencia.ORM.DAOInterface.IProducto;
import edu.utnfrc.iaew.tp2.model.Producto;

/**
 * @author Angelo Wolf, Patricio Carranza
 * @version 2.00.000
 * Ultimo cambio: 17/05/2016
 */
public class ProductoDAO extends GenericDAO<Producto, Integer> implements IProducto {

    private static final Logger LOG = Logger.getLogger(ProductoDAO.class);

    @Override
    public List<Producto> listarConStock() {
        Session session = getHibernateTemplate();
        List<Producto> objetos = new ArrayList<>();
        try {
            String sql = "from Producto where stockDisponible > 0";
            objetos = session.createQuery(sql).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los Productos.", e);
        }
        return objetos;
    }

    @Override
    public List<Producto> buscarConStock(String nombre) {
        Session session = getHibernateTemplate();
        List<Producto> objetos = new ArrayList<>();
        try {
            String sql = "from Producto where nombre = :nombre and stockDisponible > 0";
            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los Productos.", e);
        }
        return objetos;
    }

    @Override
    public int reservarStock(int idProducto, int cantidad) 
            throws StockInsuficienteException, 
                   ProductoInexistenteException {
        Session session = getHibernateTemplate();
        List<Producto> objetos = new ArrayList<>();
        try {
            String sql = "from Producto where idProducto = :idProducto";
            objetos = session.createQuery(sql).setParameter("idProducto", idProducto).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar producto", e);
        }
        if (!objetos.isEmpty()) {
            Producto prod = objetos.get(0);
            if(prod.getStockDisponible() < cantidad)
                throw new StockInsuficienteException(prod.getNombre(), 
                                                     prod.getStockDisponible(), 
                                                     cantidad);
            else {
                prod.setStockDisponible(prod.getStockDisponible() - cantidad);
                this.actualizar(prod);
                return cantidad;
            }
        } else {
            throw new ProductoInexistenteException(idProducto);
        }
    }

}
