
<%@ page import="smartsms.SupervisorVendedores" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'supervisorVendedores.label', default: 'SupervisorVendedores')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-supervisorVendedores" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-supervisorVendedores" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list supervisorVendedores">
			
				<g:if test="${supervisorVendedoresInstance?.idSupervisor}">
				<li class="fieldcontain">
					<span id="idSupervisor-label" class="property-label"><g:message code="supervisorVendedores.idSupervisor.label" default="Id Supervisor" /></span>
					
						<span class="property-value" aria-labelledby="idSupervisor-label"><g:fieldValue bean="${supervisorVendedoresInstance}" field="idSupervisor"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${supervisorVendedoresInstance?.idVendedor}">
				<li class="fieldcontain">
					<span id="idVendedor-label" class="property-label"><g:message code="supervisorVendedores.idVendedor.label" default="Id Vendedor" /></span>
					
						<span class="property-value" aria-labelledby="idVendedor-label"><g:fieldValue bean="${supervisorVendedoresInstance}" field="idVendedor"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${supervisorVendedoresInstance?.id}" />
					<g:link class="edit" action="edit" id="${supervisorVendedoresInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
