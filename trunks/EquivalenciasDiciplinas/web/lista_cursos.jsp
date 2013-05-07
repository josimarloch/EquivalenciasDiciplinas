<%-- 
    Document   : lista_cursos
    Created on : 07/05/2013, 20:01:09
    Author     : josimar
--%>

<%@page import="Daos.CursoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%session.setAttribute("cursos", new CursoDao().listar());%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Escolha o Cursos</h3>
        <ul>
            <c:forEach items="${cursos}" var="curso" varStatus="status">
                 
                 <li ><a href="#" onclick="abrirPag('lista_diciplina.jsp?curso_id=<c:out value="${curso.id}" />')"><c:out value="${curso.nome}" /></a></li>
                            
            </c:forEach>
        </ul>
    </body>
</html>
