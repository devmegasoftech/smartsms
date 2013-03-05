package smartsms

import org.springframework.dao.DataIntegrityViolationException

class TelSupervisoresController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [telSupervisoresInstanceList: TelSupervisores.list(params), telSupervisoresInstanceTotal: TelSupervisores.count()]
    }

    def create() {
        [telSupervisoresInstance: new TelSupervisores(params)]
    }

    def save() {
        def telSupervisoresInstance = new TelSupervisores(params)
        if (!telSupervisoresInstance.save(flush: true)) {
            render(view: "create", model: [telSupervisoresInstance: telSupervisoresInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'telSupervisores.label', default: 'TelSupervisores'), telSupervisoresInstance.id])
        redirect(action: "show", id: telSupervisoresInstance.id)
    }

    def show(Long id) {
        def telSupervisoresInstance = TelSupervisores.get(id)
        if (!telSupervisoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'telSupervisores.label', default: 'TelSupervisores'), id])
            redirect(action: "list")
            return
        }

        [telSupervisoresInstance: telSupervisoresInstance]
    }

    def edit(Long id) {
        def telSupervisoresInstance = TelSupervisores.get(id)
        if (!telSupervisoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'telSupervisores.label', default: 'TelSupervisores'), id])
            redirect(action: "list")
            return
        }

        [telSupervisoresInstance: telSupervisoresInstance]
    }

    def update(Long id, Long version) {
        def telSupervisoresInstance = TelSupervisores.get(id)
        if (!telSupervisoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'telSupervisores.label', default: 'TelSupervisores'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (telSupervisoresInstance.version > version) {
                telSupervisoresInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'telSupervisores.label', default: 'TelSupervisores')] as Object[],
                          "Another user has updated this TelSupervisores while you were editing")
                render(view: "edit", model: [telSupervisoresInstance: telSupervisoresInstance])
                return
            }
        }

        telSupervisoresInstance.properties = params

        if (!telSupervisoresInstance.save(flush: true)) {
            render(view: "edit", model: [telSupervisoresInstance: telSupervisoresInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'telSupervisores.label', default: 'TelSupervisores'), telSupervisoresInstance.id])
        redirect(action: "show", id: telSupervisoresInstance.id)
    }

    def delete(Long id) {
        def telSupervisoresInstance = TelSupervisores.get(id)
        if (!telSupervisoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'telSupervisores.label', default: 'TelSupervisores'), id])
            redirect(action: "list")
            return
        }

        try {
            telSupervisoresInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'telSupervisores.label', default: 'TelSupervisores'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'telSupervisores.label', default: 'TelSupervisores'), id])
            redirect(action: "show", id: id)
        }
    }
}
