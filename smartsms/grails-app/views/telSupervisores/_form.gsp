<%@ page import="smartsms.TelSupervisores" %>



<div class="fieldcontain ${hasErrors(bean: telSupervisoresInstance, field: 'idSupervisor', 'error')} required">
	<label for="idSupervisor">
		<g:message code="telSupervisores.idSupervisor.label" default="Id Supervisor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="idSupervisor" name="idSupervisor.id" from="${smartsms.Supervisores.list()}" optionKey="id" required="" value="${telSupervisoresInstance?.idSupervisor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: telSupervisoresInstance, field: 'telefono', 'error')} required">
	<label for="telefono">
		<g:message code="telSupervisores.telefono.label" default="Telefono" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefono" required="" value="${telSupervisoresInstance?.telefono}"/>
</div>

