
<%@ page import="smartsms.Articulos" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'articulos.label', default: 'Articulos')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-articulos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-articulos" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'articulos.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="descripcion" title="${message(code: 'articulos.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="precio" title="${message(code: 'articulos.precio.label', default: 'Precio')}" />
					
						<g:sortableColumn property="existencia" title="${message(code: 'articulos.existencia.label', default: 'Existencia')}" />
					
						<th><g:message code="articulos.idotroarticulo.label" default="Idotroarticulo" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${articulosInstanceList}" status="i" var="articulosInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${articulosInstance.id}">${fieldValue(bean: articulosInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: articulosInstance, field: "descripcion")}</td>
					
						<td>${fieldValue(bean: articulosInstance, field: "precio")}</td>
					
						<td>${fieldValue(bean: articulosInstance, field: "existencia")}</td>
					
						<td>${fieldValue(bean: articulosInstance, field: "idotroarticulo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${articulosInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
