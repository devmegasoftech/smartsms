<%@ page import="smartsms.TiposUsuarios" %>



<div class="fieldcontain ${hasErrors(bean: tiposUsuariosInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="tiposUsuarios.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${tiposUsuariosInstance?.descripcion}"/>
</div>

