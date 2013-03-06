package smartsms

import org.springframework.dao.DataIntegrityViolationException

class TiposUsuariosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [tiposUsuariosInstanceList: TiposUsuarios.list(params), tiposUsuariosInstanceTotal: TiposUsuarios.count()]
    }

    def create() {
        [tiposUsuariosInstance: new TiposUsuarios(params)]
    }

    def save() {
        def tiposUsuariosInstance = new TiposUsuarios(params)
        if (!tiposUsuariosInstance.save(flush: true)) {
            render(view: "create", model: [tiposUsuariosInstance: tiposUsuariosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'tiposUsuarios.label', default: 'TiposUsuarios'), tiposUsuariosInstance.id])
        redirect(action: "show", id: tiposUsuariosInstance.id)
    }

    def show(Long id) {
        def tiposUsuariosInstance = TiposUsuarios.get(id)
        if (!tiposUsuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tiposUsuarios.label', default: 'TiposUsuarios'), id])
            redirect(action: "list")
            return
        }

        [tiposUsuariosInstance: tiposUsuariosInstance]
    }

    def edit(Long id) {
        def tiposUsuariosInstance = TiposUsuarios.get(id)
        if (!tiposUsuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tiposUsuarios.label', default: 'TiposUsuarios'), id])
            redirect(action: "list")
            return
        }

        [tiposUsuariosInstance: tiposUsuariosInstance]
    }

    def update(Long id, Long version) {
        def tiposUsuariosInstance = TiposUsuarios.get(id)
        if (!tiposUsuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tiposUsuarios.label', default: 'TiposUsuarios'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (tiposUsuariosInstance.version > version) {
                tiposUsuariosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tiposUsuarios.label', default: 'TiposUsuarios')] as Object[],
                          "Another user has updated this TiposUsuarios while you were editing")
                render(view: "edit", model: [tiposUsuariosInstance: tiposUsuariosInstance])
                return
            }
        }

        tiposUsuariosInstance.properties = params

        if (!tiposUsuariosInstance.save(flush: true)) {
            render(view: "edit", model: [tiposUsuariosInstance: tiposUsuariosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'tiposUsuarios.label', default: 'TiposUsuarios'), tiposUsuariosInstance.id])
        redirect(action: "show", id: tiposUsuariosInstance.id)
    }

    def delete(Long id) {
        def tiposUsuariosInstance = TiposUsuarios.get(id)
        if (!tiposUsuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tiposUsuarios.label', default: 'TiposUsuarios'), id])
            redirect(action: "list")
            return
        }

        try {
            tiposUsuariosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'tiposUsuarios.label', default: 'TiposUsuarios'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tiposUsuarios.label', default: 'TiposUsuarios'), id])
            redirect(action: "show", id: id)
        }
    }
}
