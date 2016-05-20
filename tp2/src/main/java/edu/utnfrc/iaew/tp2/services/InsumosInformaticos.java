package edu.utnfrc.iaew.tp2.services;

import Persistencia.ORM.DAOImplementacion.*;
import edu.utnfrc.iaew.tp2.model.*;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.*;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPException;

/**
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.000
 * Ultimo cambio: 20/05/2016
 */
@WebService(serviceName = "InsumosInformaticos")
public class InsumosInformaticos {   
    
    @Resource
    WebServiceContext context;
    
    @WebMethod(operationName = "consultarProductosDisponibles")
    public List<Producto> consultarProductosDisponibles() {
        if(isAuthenticated()) 
            return new ProductoDAO().listarConStock();
        else
            throw new HTTPException(401);
    }

    
    @WebMethod(operationName = "reservarStock")
    public String reservarStock(@WebParam(name = "idProducto") int idProducto,
                                @WebParam(name = "cantidad") int cantidad) 
            throws ProductoInexistenteException,
                   StockInsuficienteException {    
        if(isAuthenticated()) {
            return "Se han reservado " + new ProductoDAO().reservarStock(idProducto, cantidad) +
                   " unidades del producto " + new ProductoDAO().buscar(idProducto).getNombre() +
                   ". El stock remanente es de " +  new ProductoDAO().buscar(idProducto).getStockDisponible();
        } else 
            throw new HTTPException(401);
    }

   
    @WebMethod(operationName = "consultarProductoPorNombre")
    public List<Producto> consultarProductoPorNombre(@WebParam(name = "nombre") String nombre) 
            throws ProductoInexistenteException {
        if(isAuthenticated())
            return new ProductoDAO().buscarConStock(nombre);
        else
            throw new HTTPException(401);
    }
    
    private boolean isAuthenticated() {
        MessageContext messageContext = context.getMessageContext();
        Map httpHeaders = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userNameList = (List) httpHeaders.get("usuario");
        List passwordList = (List) httpHeaders.get("pass");
        List<Usuario> usuarios = new UsuarioDAO().listar();
        
        for(Usuario singleUser : usuarios) {
            for(int i = 0; i < userNameList.size(); i++) {
                if(singleUser.getNick().equals((String) userNameList.get(i)) && 
                   singleUser.getClave().equals((String)passwordList.get(i)))
                    return true;
            }          
        }               
        return false;
    }
}
