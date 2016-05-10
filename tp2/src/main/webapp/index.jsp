<%-- 
    Document   : index
    Created on : 09/05/2016, 21:16:05
    Author     : ang_2
--%>

<%@page import="com.iaew.tp2.model.Producto"%>
<%@page import="java.util.List"%>
<%@page import="Persistencia.ORM.DAOImplementacion.ProductoDAO"%>
<%@page import="Persistencia.ORM.DAOImplementacion.UsuarioDAO"%>
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
            usuarioDAO.buscar("admin");

            ProductoDAO productoDAO = new ProductoDAO();
            List<Producto> lista = productoDAO.listar();
            for (Producto c : lista) {
                out.println(c.toString());
            }

        %>
    </body>
</html>
