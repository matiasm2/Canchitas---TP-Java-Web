<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Canchas | Iniciar Sesión</title>
        <jsp:include page="styles.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="container">
            
            <div class="row">
                <form class="col s10" action="login.htm" method="post">
                    <div class="row">
                        <h1>Iniciar Sesión</h1>
                    </div>
                    <input name="tokeninvitacion" type="hidden" value="<c:out value='${tokeninvitacion}'/>"/>
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
                    <div class="row">
                        <button class="btn waves-effect waves-light blue lighten-2  " type="submit">Enviar</button>
                    </div>
            </form>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <jsp:include page="scripts.jsp"></jsp:include>
    </body>
</html>
