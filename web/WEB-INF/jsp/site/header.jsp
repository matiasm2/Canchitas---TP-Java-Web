<nav>
  <div class="nav-wrapper blue lighten-2">
    <a href="/" class="brand-logo">Canchas</a>
    <ul class="right hide-on-med-and-down">
        <li><a href="agregar.htm?usuario=<c:out value='${usuario}'/>">Agregar Reserva</a></li>
        <li>
            <form action="salir.htm" method="post">   
                <input name="casa" type="hidden" value="<c:out value='${usuario}'/>"></input>
                <button type="submit" class="btn waves-effect waves-light blue lighten-3">Salir</button>
            </form>
        </li>
    </ul>
  </div>
</nav>
        