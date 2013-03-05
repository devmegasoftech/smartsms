
<%@ page import="smartsms.TelSupervisores" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'telSupervisores.label', default: 'TelSupervisores')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-telSupervisores" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-telSupervisores" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="telSupervisores.idSupervisor.label" default="Id Supervisor" /></th>
					
						<g:sortableColumn property="telefono" title="${message(code: 'telSupervisores.telefono.label', default: 'Telefono')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${telSupervisoresInstanceList}" status="i" var="telSupervisoresInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${telSupervisoresInstance.id}">${fieldValue(bean: telSupervisoresInstance, field: "idSupervisor")}</g:link></td>
					
						<td>${fieldValue(bean: telSupervisoresInstance, field: "telefono")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${telSupervisoresInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
