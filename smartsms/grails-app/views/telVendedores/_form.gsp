<%@ page import="smartsms.TelVendedores" %>



<div class="fieldcontain ${hasErrors(bean: telVendedoresInstance, field: 'telefono', 'error')} ">
	<label for="telefono">
		<g:message code="telVendedores.telefono.label" default="Telefono" />
		
	</label>
	<g:textField name="telefono" value="${telVendedoresInstance?.telefono}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: telVendedoresInstance, field: 'idVendedor', 'error')} ">
	<label for="idVendedor">
		<g:message code="telVendedores.idVendedor.label" default="Id Vendedor" />
		
	</label>
	<g:select id="idVendedor" name="idVendedor.id" from="${smartsms.Vendedores.list()}" optionKey="id" value="${telVendedoresInstance?.idVendedor?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

