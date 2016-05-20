<%-- 
    Document   : index
    Created on : 09/05/2016, 21:16:05
    Last Change: 17/05/2016 
    Version    : 1.00.001
    Author     : Angelo Wolf, Patricio Carranza
--%>

<%@page import="Persistencia.ORM.DAOImplementacion.StockInsuficienteException"%>
<%@page import="edu.utnfrc.iaew.tp2.model.Producto"%>
<%@page import="Persistencia.ORM.DAOImplementacion.ProductoDAO"%>
<%@page import="Persistencia.ORM.DAOImplementacion.UsuarioDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%

            UsuarioDAO usuarioDAO = new UsuarioDAO();            
            out.println(usuarioDAO.buscar("admin") + "<br><br>");

            ProductoDAO productoDAO = new ProductoDAO();
            List<Producto> lista = productoDAO.listarConStock();
            out.println("listarConStock() <br>");
            for (Producto c : lista) {
                out.println(c.toString() + "<br>");
            }
            out.println("<br>");
            
            lista = productoDAO.buscarConStock("mouse");
            out.println("buscarConStock(\"mouse\") <br>");
            for (Producto c : lista) {
                out.println(c.toString() + "<br>");
            }
            out.println("<br>");
            
            try {
                out.println("Reservado " + productoDAO.reservarStock(3, 2) + " del idProducto 3");
            } catch(StockInsuficienteException ex) {
                out.println(ex.getMessage());
            }
        %>
    </body>
</html>
