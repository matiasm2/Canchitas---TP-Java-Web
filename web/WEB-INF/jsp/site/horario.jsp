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
                <form class="col s10" action="horario.htm" method="POST">
                    <div class="row">
                        <h1>Agregar Reserva</h1>
                        <p>
                            Elija una cancha y una fecha para poder listar los horarios disponibles.
                        </p>
                    </div>
                    <div class="row">
                      <div class="input-field col s10">
                        <label for="cancha">Cancha</label>
                        <br>
                        <c:forEach var="item" items="${lista}">
                            <p>
                                <input type="radio" name="hora" value="<c:out value='${item.getHora()}'/>" id="<c:out value='${item.getHora()}'/>"/>
                                <label for="<c:out value='${item.getHora()}'/>" >Hora <c:out value='${item.getHora()}'/> </label>
                            </p>
                        </c:forEach>
                        <input name="fecha" type="hidden" value="<c:out value='${fecha}'/>"/>
                        <input name="nombrecancha" type="hidden" value="<c:out value='${nombrecancha}'/>"/>
                        <input name="usuario" type="hidden" value="<c:out value='${usuario}'/>"/>
                        
                        <br>
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
