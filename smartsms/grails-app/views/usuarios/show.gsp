
<%@ page import="smartsms.Usuarios" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuarios.label', default: 'Usuarios')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-usuarios" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-usuarios" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list usuarios">
			
				<g:if test="${usuariosInstance?.idtipousuario}">
				<li class="fieldcontain">
					<span id="idtipousuario-label" class="property-label"><g:message code="usuarios.idtipousuario.label" default="Idtipousuario" /></span>
					
						<span class="property-value" aria-labelledby="idtipousuario-label"><g:link controller="tiposUsuarios" action="show" id="${usuariosInstance?.idtipousuario?.id}">${usuariosInstance?.idtipousuario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuariosInstance?.usuario}">
				<li class="fieldcontain">
					<span id="usuario-label" class="property-label"><g:message code="usuarios.usuario.label" default="Usuario" /></span>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:fieldValue bean="${usuariosInstance}" field="usuario"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuariosInstance?.clave}">
				<li class="fieldcontain">
					<span id="clave-label" class="property-label"><g:message code="usuarios.clave.label" default="Clave" /></span>
					
						<span class="property-value" aria-labelledby="clave-label"><g:fieldValue bean="${usuariosInstance}" field="clave"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuariosInstance?.activado}">
				<li class="fieldcontain">
					<span id="activado-label" class="property-label"><g:message code="usuarios.activado.label" default="Activado" /></span>
					
						<span class="property-value" aria-labelledby="activado-label"><g:formatBoolean boolean="${usuariosInstance?.activado}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuariosInstance?.aleatorio}">
				<li class="fieldcontain">
					<span id="aleatorio-label" class="property-label"><g:message code="usuarios.aleatorio.label" default="Aleatorio" /></span>
					
						<span class="property-value" aria-labelledby="aleatorio-label"><g:fieldValue bean="${usuariosInstance}" field="aleatorio"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuariosInstance?.fechacreacion}">
				<li class="fieldcontain">
					<span id="fechacreacion-label" class="property-label"><g:message code="usuarios.fechacreacion.label" default="Fechacreacion" /></span>
					
						<span class="property-value" aria-labelledby="fechacreacion-label"><g:fieldValue bean="${usuariosInstance}" field="fechacreacion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuariosInstance?.fechaultimoacceso}">
				<li class="fieldcontain">
					<span id="fechaultimoacceso-label" class="property-label"><g:message code="usuarios.fechaultimoacceso.label" default="Fechaultimoacceso" /></span>
					
						<span class="property-value" aria-labelledby="fechaultimoacceso-label"><g:fieldValue bean="${usuariosInstance}" field="fechaultimoacceso"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuariosInstance?.foto}">
				<li class="fieldcontain">
					<span id="foto-label" class="property-label"><g:message code="usuarios.foto.label" default="Foto" /></span>
					
						<span class="property-value" aria-labelledby="foto-label"><g:fieldValue bean="${usuariosInstance}" field="foto"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${usuariosInstance?.id}" />
					<g:link class="edit" action="edit" id="${usuariosInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
