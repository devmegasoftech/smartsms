
<%@ page import="smartsms.Articulos" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'articulos.label', default: 'Articulos')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-articulos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-articulos" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list articulos">
			
				<g:if test="${articulosInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="articulos.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${articulosInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${articulosInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="articulos.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${articulosInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${articulosInstance?.precio}">
				<li class="fieldcontain">
					<span id="precio-label" class="property-label"><g:message code="articulos.precio.label" default="Precio" /></span>
					
						<span class="property-value" aria-labelledby="precio-label"><g:fieldValue bean="${articulosInstance}" field="precio"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${articulosInstance?.existencia}">
				<li class="fieldcontain">
					<span id="existencia-label" class="property-label"><g:message code="articulos.existencia.label" default="Existencia" /></span>
					
						<span class="property-value" aria-labelledby="existencia-label"><g:fieldValue bean="${articulosInstance}" field="existencia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${articulosInstance?.idotroarticulo}">
				<li class="fieldcontain">
					<span id="idotroarticulo-label" class="property-label"><g:message code="articulos.idotroarticulo.label" default="Idotroarticulo" /></span>
					
						<span class="property-value" aria-labelledby="idotroarticulo-label"><g:link controller="articulos" action="show" id="${articulosInstance?.idotroarticulo?.id}">${articulosInstance?.idotroarticulo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${articulosInstance?.id}" />
					<g:link class="edit" action="edit" id="${articulosInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
