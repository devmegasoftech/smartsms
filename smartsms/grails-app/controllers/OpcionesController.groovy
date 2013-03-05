import org.springframework.dao.DataIntegrityViolationException

class OpcionesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [opcionesInstanceList: Opciones.list(params), opcionesInstanceTotal: Opciones.count()]
    }

    def create() {
        [opcionesInstance: new Opciones(params)]
    }

    def save() {
        def opcionesInstance = new Opciones(params)
        if (!opcionesInstance.save(flush: true)) {
            render(view: "create", model: [opcionesInstance: opcionesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'opciones.label', default: 'Opciones'), opcionesInstance.id])
        redirect(action: "show", id: opcionesInstance.id)
    }

    def show(Long id) {
        def opcionesInstance = Opciones.get(id)
        if (!opcionesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'opciones.label', default: 'Opciones'), id])
            redirect(action: "list")
            return
        }

        [opcionesInstance: opcionesInstance]
    }

    def edit(Long id) {
        def opcionesInstance = Opciones.get(id)
        if (!opcionesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'opciones.label', default: 'Opciones'), id])
            redirect(action: "list")
            return
        }

        [opcionesInstance: opcionesInstance]
    }

    def update(Long id, Long version) {
        def opcionesInstance = Opciones.get(id)
        if (!opcionesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'opciones.label', default: 'Opciones'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (opcionesInstance.version > version) {
                opcionesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'opciones.label', default: 'Opciones')] as Object[],
                          "Another user has updated this Opciones while you were editing")
                render(view: "edit", model: [opcionesInstance: opcionesInstance])
                return
            }
        }

        opcionesInstance.properties = params

        if (!opcionesInstance.save(flush: true)) {
            render(view: "edit", model: [opcionesInstance: opcionesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'opciones.label', default: 'Opciones'), opcionesInstance.id])
        redirect(action: "show", id: opcionesInstance.id)
    }

    def delete(Long id) {
        def opcionesInstance = Opciones.get(id)
        if (!opcionesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'opciones.label', default: 'Opciones'), id])
            redirect(action: "list")
            return
        }

        try {
            opcionesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'opciones.label', default: 'Opciones'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'opciones.label', default: 'Opciones'), id])
            redirect(action: "show", id: id)
        }
    }
}
