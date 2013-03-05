<%@ page import="smartsms.TelVendedores" %>



<div class="fieldcontain ${hasErrors(bean: telVendedoresInstance, field: 'idVendedor', 'error')} required">
	<label for="idVendedor">
		<g:message code="telVendedores.idVendedor.label" default="Id Vendedor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="idVendedor" name="idVendedor.id" from="${smartsms.Vendedores.list()}" optionKey="id" required="" value="${telVendedoresInstance?.idVendedor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: telVendedoresInstance, field: 'telefono', 'error')} required">
	<label for="telefono">
		<g:message code="telVendedores.telefono.label" default="Telefono" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefono" required="" value="${telVendedoresInstance?.telefono}"/>
</div>

