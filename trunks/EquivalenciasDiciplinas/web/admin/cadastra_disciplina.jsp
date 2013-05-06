<%-- 
    Document   : cadastra_disciplina
    Created on : 06/05/2013, 03:26:08
    Author     : josimar
--%>

<%@page import="Daos.CursoDao"%>
<%@page import="java.util.List"%>
<%@page import="beans.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% List<Curso> cursos = new CursoDao().listar();
session.setAttribute("cursos",cursos);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="form-horizontal" action="PersistenceManager" method="post" accept-charset="UTF-8">
            <h3>Cadastro de Disciplina</h3>
            <div class="control-group">
                <label class="control-label" for="Nome" >Nome</label>
                <div class="controls">
                    <input type="text" id="Nome" name="nome" placeholder="Nome">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="curso" >Nome</label>
                <div class="controls">
                    <select id="curso">
                        <c:forEach items="${cursos}" var="curso" varStatus="status">
                            <option>
                            <c:out value="${status.count}" />               
                            <c:out value="${curso.nome}" />               
                            </option>  
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="ementa" >Ementa da Disciplina</label>
                <div class="controls">
                    <textarea rows="3" name="ementa" id="ementa"></textarea>
                </div>
            </div>


            <div class="control-group">
                <div class="controls">
                    <input type="hidden" name="ok" value="cadastra_professor"/>
                    <button type="submit" class="btn">Cadastrar</button>
                </div>
            </div>
        </form>
    </body>
</html>

