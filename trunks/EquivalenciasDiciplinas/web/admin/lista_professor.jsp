<%-- 
    Document   : lista_professor
    Created on : 07/05/2013, 14:31:31
    Author     : josimar
--%>

<%@page import="Daos.ProfessorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%session.setAttribute("professors", new ProfessorDao().listar());%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Todos os Professores</h3>
        <table class="table table-striped">
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Disciolina(s)</th>
                <th>#</th>
            </tr>
            <c:forEach items="${professors}" var="professor" varStatus="status">
                <tr>
                    <td>
                        <c:out value="${professor.nome}" />               
                    </td>

                    <td>
                        <c:out value="${professor.email}" />               
                    </td>
                    <td>
                         <c:forEach items="${professor.disciplinas}" var="d" varStatus="status">
                                <c:out value="${d.nome}" />     
                                 <c:out value=", " />    
                        </c:forEach>
                                   
                    </td>
                    <td>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
