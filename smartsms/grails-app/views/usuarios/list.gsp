
<%@ page import="smartsms.Usuarios" %>
<%@ page import="smartsms.TiposUsuarios" %>
<!DOCTYPE html>
<g:render template="/encabezado/header" />
	<body>
          
         
		<div id="list-usuarios" class="content scaffold-list" role="main">
			<h1>Usuarios</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
                        <g:if test="${session.user}">
                          <div class="message" role="status">Usted inicio sesion como: ${session.user} | <g:link action="logout"> Logout</g:link></div>
                        </g:if>
			<table cellpadding='0' cellspacing='0' border='0' class='table table-striped table-bordered' id='tablaAlumnos'>
				<thead>
					<tr>
					
                                          <th>#</th>
                                                <th><g:message code="usuarios.idtipousuario.label" default="Tipo" /></th>
					
						<g:sortableColumn property="usuario" title="${message(code: 'usuarios.usuario.label', default: 'Usuario')}" />
					
						<g:sortableColumn property="clave" title="${message(code: 'usuarios.clave.label', default: 'Clave')}" />
					
						<g:sortableColumn property="activado" title="${message(code: 'usuarios.activado.label', default: 'Activado')}" />
					
						<g:sortableColumn property="aleatorio" title="${message(code: 'usuarios.aleatorio.label', default: 'Aleatorio')}" />
					
						<g:sortableColumn property="fechacreacion" title="${message(code: 'usuarios.fechacreacion.label', default: 'Fechacreacion')}" />
                                                <th>Acciones</th>
					
					</tr>
				</thead>
				<tbody>
                                  
				<g:each in="${usuariosInstanceList}" status="i" var="usuariosInstance">
					<tr>
                                          <td><g:link action="show" id="${usuariosInstance.id}">${i+1}</g:link></td>
						<td>${fieldValue(bean: usuariosInstance, field: "idtipousuario")}</td>
					
						<td>${fieldValue(bean: usuariosInstance, field: "usuario")}</td>
					
						<td>${fieldValue(bean: usuariosInstance, field: "clave")}</td>
					
						<td><g:formatBoolean boolean="${usuariosInstance.activado}" /></td>
					
						<td>${fieldValue(bean: usuariosInstance, field: "aleatorio")}</td>
					
						<td>${fieldValue(bean: usuariosInstance, field: "fechacreacion")}</td>
                                                <td>
                                                  <a rel='tooltip' title='Eliminar' onclick="<g:remoteFunction action='delete' id='${usuariosInstance.id}'/>"><i class="icon-remove"></i></a>
                                                  <g:remoteLink update="[success: 'message', failure: 'error']" action="delete" id='${usuariosInstance.id}'> Delete Book</g:remoteLink>
                                                </td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
                        <div id="message" name="message" ></div>
                        <div id="error" name="error" ></div>
                        <script>
                        $(document).ready(function() {
                          desbloquearUi();
                          $('a[rel=popover]').popover({placement: 'left'});
                          $("a[rel='tooltip']").tooltip(); //tooltips bootstrap


                            $('#tablaAlumnos').dataTable({            
                              "sPaginationType": "bootstrap",
                              "oLanguage": {
                                "sLengthMenu": "_MENU_ registros por pagina"   
                              }         
                            });
                        });
                        </script>
			<div class="pagination">
				<g:paginate total="${usuariosInstanceTotal}" />
			</div>
		</div>
	</body>
<g:render template="/footer/footer" />
