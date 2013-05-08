<%-- 
    Document   : cria_pedido
    Created on : 08/05/2013, 15:55:17
    Author     : josimar
--%>

<%@page import="Daos.DisciplinaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%session.setAttribute("disciplina", new DisciplinaDao().obterPorId(Integer.parseInt(request.getParameter("disciplina_id"))));%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul class="inline">
            <li> Você está aqui: <a href="index.jsp">Inicio</a></li>
            <li><a href="#" onclick="abrirPag('lista_cursos.jsp')">/Escolha o curso</a></li>
            <li><a href="#" onclick="abrirPag('lista_diciplina.jsp?curso_id=<c:out value="${disciplina.curso.id}" />')">/Escolha a disciplina</a></li>
            <li>/Escolha a disciplina</li>
        </ul>
        <h3>Pedido de Equivalencia para a Disciplina <c:out value="${disciplina.nome}" /></h3>
        <dl>
            <dt>Ementa da disciplina de <c:out value="${disciplina.nome}" />. </dt>
            <dd><c:out value="${disciplina.ementa}" /></dd>
        </Dl>
    </body>
</html>
