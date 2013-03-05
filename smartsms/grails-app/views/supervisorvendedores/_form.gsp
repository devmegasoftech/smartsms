<%@ page import="smartsms.SupervisorVendedores" %>



<div class="fieldcontain ${hasErrors(bean: supervisorVendedoresInstance, field: 'idSupervisor', 'error')} required">
	<label for="idSupervisor">
		<g:message code="supervisorVendedores.idSupervisor.label" default="Id Supervisor" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="idSupervisor" type="number" value="${supervisorVendedoresInstance.idSupervisor}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: supervisorVendedoresInstance, field: 'idVendedor', 'error')} required">
	<label for="idVendedor">
		<g:message code="supervisorVendedores.idVendedor.label" default="Id Vendedor" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="idVendedor" type="number" value="${supervisorVendedoresInstance.idVendedor}" required=""/>
</div>

