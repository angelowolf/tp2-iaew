/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Persistencia.ORM.Util.IGenericDAO;
import com.iaew.tp2.model.Usuario;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IUsuario extends IGenericDAO<Usuario, Integer> {

    public List<Usuario> listar();

    public Usuario buscar(String nick);

}
