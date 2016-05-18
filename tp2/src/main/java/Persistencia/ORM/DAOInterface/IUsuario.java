package Persistencia.ORM.DAOInterface;

import Persistencia.ORM.Util.IGenericDAO;
import edu.utnfrc.iaew.tp2.model.Usuario;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IUsuario extends IGenericDAO<Usuario, Integer> {

    public List<Usuario> listar();

    public Usuario buscar(String nick);

}
