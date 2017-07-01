<!-- Dropdown Structure -->
<ul id="dropdown1" class="dropdown-content">
  <li><a href="agregarcancha.htm">Agregar</a></li>
  <li><a href="vercanchas.htm">Ver Canchas</a></li>
<!--  <li class="divider"></li>
  <li><a href="#!">three</a></li>-->
</ul>
<ul id="dropdown2" class="dropdown-content">
  <li><a href="crearcancha.htm">Agregar</a></li>
  <li><a href="vercanchas.htm">Ver Canchas</a></li>
<!--  <li class="divider"></li>
  <li><a href="#!">three</a></li>-->
</ul>
<ul id="dropdown3" class="dropdown-content">
  <li><a href="creartamanocancha.htm">Agregar</a></li>
  <li><a href="vertamanocanchas.htm">Ver Tamaño de Canchas</a></li>
<!--  <li class="divider"></li>
  <li><a href="#!">three</a></li>-->
</ul>

<nav>
  <div class="nav-wrapper blue lighten-2">
    <a href="/" class="brand-logo">Canchas</a>
    <ul class="right hide-on-med-and-down">
        <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Reservas<i class="material-icons right">arrow_drop_down</i></a></li>
      <li><a class="dropdown-button" href="#!" data-activates="dropdown2">Canchas<i class="material-icons right">arrow_drop_down</i></a></li>
      <li><a class="dropdown-button" href="#!" data-activates="dropdown3">Tamaño Canchas<i class="material-icons right">arrow_drop_down</i></a></li>
      
      <li>
            <form action="../salir.htm" method="post">   
                <input name="casa" type="hidden" value="<c:out value="${usuario}"/>"></input>
                <button type="submit" class="btn waves-effect waves-light blue lighten-3">Salir</button>
            </form>
        </li>
    </ul>
  </div>
</nav>
        