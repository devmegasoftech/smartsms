<%@ page import="smartsms.Articulos" %>



<div class="fieldcontain ${hasErrors(bean: articulosInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="articulos.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${articulosInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: articulosInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="articulos.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${articulosInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: articulosInstance, field: 'precio', 'error')} required">
	<label for="precio">
		<g:message code="articulos.precio.label" default="Precio" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="precio" value="${fieldValue(bean: articulosInstance, field: 'precio')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: articulosInstance, field: 'existencia', 'error')} required">
	<label for="existencia">
		<g:message code="articulos.existencia.label" default="Existencia" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="existencia" type="number" value="${articulosInstance.existencia}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: articulosInstance, field: 'idotroarticulo', 'error')} required">
	<label for="idotroarticulo">
		<g:message code="articulos.idotroarticulo.label" default="Idotroarticulo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="idotroarticulo" type="number" value="${articulosInstance.idotroarticulo}" required=""/>
</div>

