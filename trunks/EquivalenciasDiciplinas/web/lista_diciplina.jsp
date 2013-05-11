<%-- 
    Document   : lista_diciplina
    Created on : 07/05/2013, 20:15:20
    Author     : josimar
--%>

<%@page import="Daos.CursoDao"%>
<%@page import="Daos.DisciplinaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%session.setAttribute("disciplinas", new DisciplinaDao().getPorIDCurso(request.getParameter("curso_id")));%>

<%session.setAttribute("curso", new CursoDao().obterPorId(Integer.parseInt(request.getParameter("curso_id"))));%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <ul class="inline">
            <li> Você está aqui: <a href="index.jsp">Inicio</a></li>
            <li><a href="#" onclick="abrirPag('lista_cursos.jsp?curso_id=<c:out value="${curso.id}" />')">/Escolha o curso</a></li>
            <li>/Escolha a disciplina</li>
        </ul>
         <h3>Escolha a Disciplina</h3>
         <ul>
             <c:forEach items="${disciplinas}" var="d" varStatus="status">
                 
                 <li ><a href="#" onclick="abrirPag('cria_pedido.jsp?disciplina_id=<c:out value="${d.id}" />')"><c:out value="${d.nome}" /></a></li>
                            
            </c:forEach>
        </ul>
    </body>
</html>
