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
import Persistencia.ORM.DAOInterface.IUsuario;
import com.iaew.tp2.model.Usuario;

/**
 *
 * @author ang_2
 */
public class UsuarioDAO extends GenericDAO<Usuario, Integer> implements IUsuario {

    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class);

    @Override
    public List<Usuario> listar() {
        Session session = getHibernateTemplate();
        List<Usuario> objetos = new ArrayList<>();
        try {
            String sql = "from Usuario";
            objetos = session.createQuery(sql).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los Usuarios.", e);
        }
        return objetos;
    }

    @Override
    public Usuario buscar(String nick) {
        Session session = getHibernateTemplate();
        List<Usuario> objetos = new ArrayList<>();
        try {
            String sql = "from Usuario where nick = :nick";
            objetos = session.createQuery(sql).setParameter("nick", nick).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar usuario", e);
        }
        if (!objetos.isEmpty()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }

}
