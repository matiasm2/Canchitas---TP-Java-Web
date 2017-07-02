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
                <form class="col s10" action="agregar.htm" method="POST">
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
                        <c:forEach var="item" items="${canchas}">
                            <p>
                                <input type="radio" name="nombrecancha" value="<c:out value='${item.getNombre()}'/>" id="<c:out value='${item.getNombre()}'/>"/>
                                <label for="<c:out value='${item.getNombre()}'/>" >Cancha de <c:out value='${item.getNombre()}'/> Precio: <c:out value='${item.getTamanocancha().getPrecio()}'/></label>
                            </p>
                        </c:forEach>
                            <br>    
                      </div>
                        
                    </div>
                    
                    <div class="row">
                        <label for="fecha">Fecha</label>
                        <input name="fecha" type="date" /> 
                        <input name="usuario" type="hidden" value="<c:out value='${usuario}'/>"/>
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
