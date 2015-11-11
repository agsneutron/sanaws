<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>          
          <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/resources/bootstrap/img/logo_small.png"></a>
 
        </div>
        <div id="navbar" class="navbar-collapse collapse navbar-inverse-collapse">
          <ul class="nav navbar-nav ">
           <li><a href="#" onclick="envia('/home')">Reporte General</a></li>
            <li><a href="cobradores.html">Reporte por cobrador</a></li>
            <li><a href="solicitudes.html">Solicitudes</a></li>
            <li><a href="ruta-promotor.html">Ruta promotor</a></li>
            <li><a href="#" onclick="envia('/listausuarios')">Usuarios</a></li>
            <li><a href="logout">Salir</a></li>
          </ul>
        </div>
      </div>
    </nav>