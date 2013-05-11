<%-- 
    Document   : lista_cursos
    Created on : 07/05/2013, 20:01:09
    Author     : josimar
--%>

<%@page import="Daos.CursoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="cursos" class="Daos.CursoDao" scope="request" /> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul class="inline">
            <li> Você está aqui: <a href="index.jsp">Inicio</a></li>
            <li>/Escolha o curso</li>
        </ul>
        <h3>Escolha o Curso</h3>
        <ul>
            <c:forEach items="${cursos.listar()}" var="curso" varStatus="status">
                 
                 <li ><a href="#" onclick="abrirPag('lista_diciplina.jsp?curso_id=<c:out value="${curso.id}" />')"><c:out value="${curso.nome}" /></a></li>
                            
            </c:forEach>
        </ul>
    </body>
</html>
