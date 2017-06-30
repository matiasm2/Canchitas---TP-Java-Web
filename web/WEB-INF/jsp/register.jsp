<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Canchas | Registro</title>
        <%@include file="styles.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="row">
                <form class="col s10" action="/tpf/register.htm" method="POST">
                    <div class="row">
                        <h1>Registrate</h1>
                    </div>
                    <div class="row">
                      <div class="input-field col s10">
                        <input name="nombre" type="text" class="validate">
                        <label for="nombre">Nombre</label>
                      </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10">
                            <input name="email" type="email" class="validate">
                            <label for="email">Email</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10">
                            <input name="password" type="password" class="validate">
                            <label for="password">Password</label>
                        </div>
                    </div>
<!--                    <div class="row">
                        <div class="g-recaptcha" data-sitekey="your_site_key"></div>
                    </div>                    -->
                    <div class="row">
                        <button class="btn waves-effect waves-light blue lighten-2  " type="submit">Enviar</button>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="footer.jsp" %>
<!--        <script src="https://www.google.com/recaptcha/api.js" async defer></script>-->
        <%@include file="scripts.jsp" %>
    </body>
    
</html>
