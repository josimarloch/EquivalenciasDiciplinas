<%-- 
    Document   : criabanco
    Created on : 09/05/2013, 20:42:34
    Author     : josimar
--%>

<%@page import="Daos.HibernateConfiguration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        HibernateConfiguration.createSchema();
        
%>
    </body>
</html>
