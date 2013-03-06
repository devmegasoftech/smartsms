<%@ page import="smartsms.Usuarios" %>



<div class="fieldcontain ${hasErrors(bean: usuariosInstance, field: 'idtipousuario', 'error')} required">
	<label for="idtipousuario">
		<g:message code="usuarios.idtipousuario.label" default="Idtipousuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="idtipousuario" name="idtipousuario.id" from="${smartsms.TiposUsuarios.list()}" optionKey="id" required="" value="${usuariosInstance?.idtipousuario?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuariosInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="usuarios.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="usuario" required="" value="${usuariosInstance?.usuario}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuariosInstance, field: 'clave', 'error')} required">
	<label for="clave">
		<g:message code="usuarios.clave.label" default="Clave" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="clave" required="" value="${usuariosInstance?.clave}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuariosInstance, field: 'activado', 'error')} ">
	<label for="activado">
		<g:message code="usuarios.activado.label" default="Activado" />
		
	</label>
	<g:checkBox name="activado" value="${usuariosInstance?.activado}" />
</div>

<div class="fieldcontain ${hasErrors(bean: usuariosInstance, field: 'aleatorio', 'error')} ">
	<label for="aleatorio">
		<g:message code="usuarios.aleatorio.label" default="Aleatorio" />
		
	</label>
	<g:textField name="aleatorio" value="${usuariosInstance?.aleatorio}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuariosInstance, field: 'fechacreacion', 'error')} ">
	<label for="fechacreacion">
		<g:message code="usuarios.fechacreacion.label" default="Fechacreacion" />
		
	</label>
	<g:textField name="fechacreacion" value="${usuariosInstance?.fechacreacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuariosInstance, field: 'fechaultimoacceso', 'error')} ">
	<label for="fechaultimoacceso">
		<g:message code="usuarios.fechaultimoacceso.label" default="Fechaultimoacceso" />
		
	</label>
	<g:textField name="fechaultimoacceso" value="${usuariosInstance?.fechaultimoacceso}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuariosInstance, field: 'foto', 'error')} ">
	<label for="foto">
		<g:message code="usuarios.foto.label" default="Foto" />
		
	</label>
	<g:textField name="foto" value="${usuariosInstance?.foto}"/>
</div>

