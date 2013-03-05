

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'opciones.label', default: 'Opciones')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-opciones" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-opciones" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="codigo" title="${message(code: 'opciones.codigo.label', default: 'Codigo')}" />
					
						<g:sortableColumn property="idarticulo" title="${message(code: 'opciones.idarticulo.label', default: 'Idarticulo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${opcionesInstanceList}" status="i" var="opcionesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${opcionesInstance.id}">${fieldValue(bean: opcionesInstance, field: "codigo")}</g:link></td>
					
						<td>${fieldValue(bean: opcionesInstance, field: "idarticulo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${opcionesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
