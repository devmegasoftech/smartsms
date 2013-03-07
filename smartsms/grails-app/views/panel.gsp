<%@ page contentType="text/html;charset=UTF-8" %>


  <g:render template="/encabezado/header" />
<aside>
<div class="hero-unit">
	<center><img src="img/header_logo.png"  /></center>
	
</div>
<ul class="thumbnails">
  
     <li class="span3">
      <a href="#/usuarios" class="btn thumbnail" onclick="bloquearUi();">
        <img src='img/escritorio128x128/usuario.png' class=""/>
        <p><b>Usuarios</b></p>
      </a>
    </li>
    <li class="span3">
      <a href="#/alumnos" class="btn thumbnail" onclick="bloquearUi();">
        <img src='img/escritorio128x128/alumnos.png' class=""/>
        <p><b>Alumnos</b></p>
      </a>
    </li>

    <li class="span3">
      <a href="#/familias" class="btn thumbnail" onclick="bloquearUi();">
        <img src='img/escritorio128x128/familia.png' class=""/>
        <p><b>Familias</b></p>
      </a>
    </li>

    <li class="span3">
      <a href="#/variosDatos" class="btn thumbnail" onclick="bloquearUi();">
        <img src='img/escritorio128x128/varios.png' class=""/>
        <p><b>Varios</b></p>
      </a>
    </li>

    <li class="span3">
      <a href="#/consultores" class="btn thumbnail" onclick="bloquearUi();">
        <img src='img/escritorio128x128/consultores.png' class=""/>
        <p><b>Consultores</b></p>
      </a>
    </li>
    
    <li class="span3">
      <a href="#/proyectos" class="btn thumbnail" onclick="bloquearUi();">
        <img style="width:128px" src='img/escritorio128x128/proyecto.png' class=""/>
        <p><b>Proyectos</b></p>
      </a>
    </li>

    <li class="span3">
      <a href="#/becas" class="btn thumbnail" onclick="bloquearUi();">
        <img style="width:128px" src='img/escritorio128x128/becas.png' class=""/>
        <p><b>Becas</b></p>
      </a>
    </li>

    <li class="span3">
      <a href="#/establecimientos" class="btn thumbnail" onclick="bloquearUi();">
        <img style="width:128px" src='img/escritorio128x128/establecimientos.png' class=""/>
        <p><b>Establecimientos</b></p>
      </a>
    </li>

    <li class="span3">
      <a href="#/actividades" class="btn thumbnail" onclick="bloquearUi();">
        <img style="width:128px" src='img/escritorio128x128/actividades.png' class=""/>
        <p><b>Actividades</b></p>
      </a>
    </li>

    <li class="span3">
      <a href="#/financistas" class="btn thumbnail" onclick="bloquearUi();">
        <img style="width:128px" src='img/escritorio128x128/money.png' class=""/>
        <p><b>Financistas</b></p>
      </a>
    </li>
    <li class="span3">
      <a href="#/reportes" class="btn thumbnail" onclick="bloquearUi();">
        <img style="width:128px" src='img/escritorio128x128/reportes.png' class=""/>
        <p><b>Reportes</b></p>
      </a>
    </li>


</ul>
</aside>
<script type="text/javascript">
  bloquearUi();
$(document).ready(function() {
	$('#contenido').css({'margin-left':'auto'});
  desbloquearUi();

});
</script>
  <g:render template="/footer/footer" />
