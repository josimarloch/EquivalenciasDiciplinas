<%-- 
    Document   : cadastra_disciplina
    Created on : 06/05/2013, 03:26:08
    Author     : josimar
--%>

<%@page import="Daos.ProfessorDao"%>
<%@page import="Daos.CursoDao"%>
<%@page import="java.util.List"%>
<%@page import="beans.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
    session.setAttribute("cursos", new CursoDao().listar());
    session.setAttribute("professors", new ProfessorDao().listar());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="form-horizontal" action="PersistenceManager" method="post" accept-charset="ISO-8859-1">
            <h3>Cadastro de Disciplina</h3>
            <div class="control-group">
                <label class="control-label" for="Nome" >Nome</label>
                <div class="controls">
                    <input type="text" id="Nome" name="nome" placeholder="Nome">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="curso" >Curso</label>
                <div class="controls">
                    <select id="curso" name="curso_id">
                        <c:forEach items="${cursos}" var="curso" varStatus="status">
                            <option value="  <c:out value="${curso.id}" />       ">
                                <c:out value="${curso.nome}" />               
                            </option>  
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="professor" >Professor</label>
                <div class="controls">
                    <select id="professor" name="professor_id">
                            <option value="0">
                                Escolha o Professor            
                            </option>  
                        <c:forEach items="${professors}" var="professor" varStatus="status">
                            <option value="  <c:out value="${professor.id}" />       ">
                                <c:out value="${professor.email}" />               
                            </option>  
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="ementa" >Ementa da Disciplina</label>
                <div class="controls">
                    <textarea rows="4" name="ementa" id="ementa"></textarea>
                </div>
            </div>


            <div class="control-group">
                <div class="controls">
                    <input type="hidden" name="ok" value="cadastra_disciplina"/>
                    <button type="submit" class="btn">Cadastrar</button>
                </div>
            </div>
        </form>
    </body>
</html>

