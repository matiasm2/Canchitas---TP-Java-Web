<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Administradores | Agregar tamaño de cancha</title>
        <%@include file="../styles.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="row">
                <form class="col s10" action="/tpf/admin/creartamanocancha.htm" method="POST">
                    <div class="row">
                        <h1>Agregar tamaño de cancha</h1>
                    </div>
                    <div class="row">
                      <div class="input-field col s10">
                        <input name="tamanocancha" type="text" class="validate">
                        <label for="tamanocancha">Tamaño de la cancha (o tipo)</label>
                      </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s10">
                            <input name="precio" type="number" class="validate">
                            <label for="precio">Precio de este tamaño o tipo de cancha p/hora</label>
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
        <%@include file="../footer.jsp" %>
<!--        <script src="https://www.google.com/recaptcha/api.js" async defer></script>-->
        <%@include file="../scripts.jsp" %>
    </body>
    
</html>
