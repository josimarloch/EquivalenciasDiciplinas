<%-- 
    Document   : login
    Created on : 25/04/2013, 19:53:53
    Author     : josimar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
            .sidebar-nav {
                padding: 9px 0;
            }

            @media (max-width: 980px) {
                /* Enable use of floated navbar text */
                .navbar-text.pull-right {
                    float: none;
                    padding-left: 5px;
                    padding-right: 5px;
                }
            }
        </style>
        <link href="css/bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <form class="form-horizontal" action="LoginManager" method="post">
            <h3>Login</h3>
            <div class="control-group">
                <label class="control-label" for="inputEmail">Login</label>
                <div class="controls">
                    <input type="text" name="login" id="inputEmail" placeholder="Email ou RA">
                </div>
            </div>
            <div class="control-group">
                    <label class="control-label" for="inputPassword">Password</label>
                    <div class="controls">
                        <input type="password" id="inputPassword" placeholder="Password" name="senha">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <input type="hidden" value="login" name="ok"/>
                    <button type="submit" class="btn">Sign in</button>
                </div>
            </div>
        </form>
    </body>
</html>
