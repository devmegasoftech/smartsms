



<div class="fieldcontain ${hasErrors(bean: opcionesInstance, field: 'codigo', 'error')} ">
	<label for="codigo">
		<g:message code="opciones.codigo.label" default="Codigo" />
		
	</label>
	<g:textField name="codigo" value="${opcionesInstance?.codigo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: opcionesInstance, field: 'idarticulo', 'error')} ">
	<label for="idarticulo">
		<g:message code="opciones.idarticulo.label" default="Idarticulo" />
		
	</label>
	<g:textField name="idarticulo" value="${opcionesInstance?.idarticulo}"/>
</div>

