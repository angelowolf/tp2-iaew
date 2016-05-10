/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOImplementacion;

import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import Persistencia.ORM.DAOInterface.IProducto;
import com.iaew.tp2.model.Producto;

/**
 *
 * @author ang_2
 */
public class ProductoDAO extends GenericDAO<Producto, Integer> implements IProducto {

    private static final Logger LOG = Logger.getLogger(ProductoDAO.class);

    @Override
    public List<Producto> listar() {
        Session session = getHibernateTemplate();
        List<Producto> objetos = new ArrayList<>();
        try {
            String sql = "from Producto";
            objetos = session.createQuery(sql).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los Productos.", e);
        }
        return objetos;
    }

}
