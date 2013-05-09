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
        </dl>
        <br/>
         <dl>
            <dt>Ementa da disciplina cursada</dt>
            <dd>Neste campo voce deve descrever a instutuição, nome da disciplina cursada carga horária e sua ementa.</dd>
        </dl>
        <form class="form-horizontal" action="PersistenceManager" method="post" accept-charset="ISO-8859-1">
            <div class="control-group">
                <label class="control-label" for="ementa" >Ementa da Disciplina Cursada</label>
                <div class="controls">
                    <textarea rows="4" cols="60" name="ementa" id="ementa"></textarea>
                </div>
            </div>
            <dl>
            <dt>Documento Comprobatório.</dt>
            <dd>Aqui você deve anexar um arquivo pdf que comprove a ementa da disciplina cursada.</dd>
        </dl>
            <div class="control-group">
                <label class="control-label" for="ementa" >Documento Copmrobatório</label>
                <div class="controls">
                    <input type="file" name="documento" id="documento" />

                </div>
            </div>

<br/>
            <div class="control-group">
                    <input type="hidden" name="ok" value="cadastra_disciplina"/>
                    <button type="submit" class="btn btn-primary">Submeter Pedido</button>
                    <button type="reset" class="btn btn-warning">Limpar Campos</button>
                    <a href="index.jsp"> <button class="btn btn-danger">Cancelar e voltar para inicio</button>
                    </a> 
            </div>
        </form>
    </body>
</html>
