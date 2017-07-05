<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Canchitas | Reserva</title>
        <%@include file="../styles.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="row">
                <form class="col s10" action="invitacion.htm" method="POST">
                    <div class="row">
                        <h1>Aceptar invitación</h1>
                    </div>
                    <div class="row">
                      <div class="input-field col s10">
                            <p>Desea aceptar la invitación?</p>
                            <br>
                            <input id="r1" type="radio" name="respuesta" value="si" />
                            <label for="r1">Si</label>
                            <input id="r2" type="radio" name="respuesta" value="no" />
                            <label for="r2">No</label>
                            <br>    
                      </div>
                    </div>
                        <input name="usuario" type="hidden" name="token" value="<c:out value='${usuario}'/>"/>
                        <input name="tokeninvitacion" type="hidden" name="token" value="<c:out value='${token}'/>"/>
                    
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
