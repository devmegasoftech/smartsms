<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Sica 1.0</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="description" content="Control Academico">
    	<meta name="author" content="ResearchMobile">
    	<!--Estilos bootstrap-->
    	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    	<link href="css/ui-lightness/jquery-ui.css" rel="stylesheet">

    	
    	<style type="text/css">
    		body{
    			padding-top: 60px;
    			padding-bottom: 40px;
    		}
    		.sidebar-nav {
    			padding: 9px 0;
  			}
    	</style>

    	<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css">
    	<link rel="stylesheet" type="text/css" href="css/DT_bootstrap.css">
        <link href="css/style.css" rel="stylesheet">
        
    	<script src="js/jquery.js"></script>
        <script src="js/jquery.blockUI.js"></script>
        
    	<script type="text/javascript" src="js/jquery.ui.datepicker.js"></script>
    	<script src="js/sammy.js" type="text/javascript"></script>
    	<!--Falta el shortcut icon-->

    	<script type="text/javascript">

                function bloquearUi() { 
                $.blockUI({ 
                    message: $('#mensaje'),
                    css: { 
                      border: 'none', 
                      padding: '15px', 
                      
                      backgroundColor:'transparent', 
                      '-webkit-border-radius': '10px', 
                      '-moz-border-radius': '10px', 
                       color: '#fff' 
                      } 
                    }); 
             
                
                }
                function desbloquearUi()  {
                    setTimeout($.unblockUI, 500); 

                }

    		$(document).ready(function() {
                

        		$.validator.setDefaults({
            		submitHandler: function(form) {
                		var idForm = $(form).attr('id');
                		$.post($(form).attr('action'), $(form).serialize(), function(data) {
                    		$("#"+idForm+" .response").html(data);
                		});
            		}
        		});
    		});
        </script>

	</head>
	<body>
        <div id='mensaje' style='display:none;'> <!--<img src="img/loader1.gif" width="48" height="48" />-->
        <div class="blockMsg">Cargando espere un momento<br><br><br></div>
    <div class="circle"></div>
    <div class="circle1"></div>
    </div>
		<div class="navbar navbar-inverse navbar-fixed-top"><!-- Inicio Barra Negra-->
			<div class="navbar-inner">
				<div class="container-fluid">
					<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
						<span class="icon-bar"></span>
            			<span class="icon-bar"></span>
            			<span class="icon-bar"></span>
					</a>
					<a class="brand" href="#/">SICA</a>
					<div class="nav-collapse collapse">
			            <ul class="nav">
			            	
			              	<li class="active"><a id='btnescritorio' name='btnescritorio' href="#/">Escritorio</a></li>

                            <li class="dropdown">
			                	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Ayuda<b class="caret"></b></a>
			                	<ul class="dropdown-menu">
			                  		<li><a href="#/">Ayuda del Sistema</a></li>
			                  		<li><a id="acercade" name="acercade" href="#/">Acerca de</a></li>
			                  		<li class="divider"></li>
			                  		<li class="nav-header">Soporte</li>
			                  		<li><a href="">Centro de Soporte</a></li>
			                	</ul>
			              	</li>
			            </ul>
			            <ul class="nav pull-right">
              				<li class="dropdown"><a href="#"  class="dropdown-toggle"  data-toggle="dropdown">Opciones<b class="caret"></b></a>
                				<ul class="dropdown-menu">
                  					<li><a id="cCicloActual" name="cCicloActual">Cambiar Ciclo Actual</a></li>
                                    <li><a id="cpass" name="cpass" href="#">Cambiar Password</a></li>
                  					<li><a href="index.php?a=logout">Cerrar Sesión</a></li>
                				</ul>
              				</li>
            			</ul> 
            			<p class="navbar-text pull-right">Bienvenido <a href="#">${session.user}</a></p>      
			        </div>
				</div>
			</div>
		</div><!-- Fin Barra Negra-->
        
        <div class="modal hide fade in" id="MostrarDatos"></div>
        <div class="modal hide fade in" id="divmensajes"></div>
        <div class="modal hide fade in" id="divcambiarpass"></div>
        <div class="modal hide fade in" id="divcambiarPass"></div>
        <div class="modal hide fade in" id="divCambiarCiclo"></div>
        <script type="text/javascript">       
            
            
            $("#acercade").click(function () {     
                $("#divmensajes").load("includes/actions/acercaDe.php?a=ver").modal('show');
            });
           
            
        </script>
<div class="container" id="contenido" name="contenido">
