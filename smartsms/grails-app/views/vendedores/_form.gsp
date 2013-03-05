<%@ page import="smartsms.Vendedores" %>



<div class="fieldcontain ${hasErrors(bean: vendedoresInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="vendedores.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${vendedoresInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vendedoresInstance, field: 'apellido', 'error')} required">
	<label for="apellido">
		<g:message code="vendedores.apellido.label" default="Apellido" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellido" required="" value="${vendedoresInstance?.apellido}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vendedoresInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="vendedores.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${vendedoresInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vendedoresInstance, field: 'codigo', 'error')} required">
	<label for="codigo">
		<g:message code="vendedores.codigo.label" default="Codigo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="codigo" required="" value="${vendedoresInstance?.codigo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vendedoresInstance, field: 'direccion', 'error')} ">
	<label for="direccion">
		<g:message code="vendedores.direccion.label" default="Direccion" />
		
	</label>
	<g:textField name="direccion" value="${vendedoresInstance?.direccion}"/>
</div>

