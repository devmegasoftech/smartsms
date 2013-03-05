package smartsms

import org.springframework.dao.DataIntegrityViolationException

class TelVendedoresController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [telVendedoresInstanceList: TelVendedores.list(params), telVendedoresInstanceTotal: TelVendedores.count()]
    }

    def create() {
        [telVendedoresInstance: new TelVendedores(params)]
    }

    def save() {
        def telVendedoresInstance = new TelVendedores(params)
        if (!telVendedoresInstance.save(flush: true)) {
            render(view: "create", model: [telVendedoresInstance: telVendedoresInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'telVendedores.label', default: 'TelVendedores'), telVendedoresInstance.id])
        redirect(action: "show", id: telVendedoresInstance.id)
    }

    def show(Long id) {
        def telVendedoresInstance = TelVendedores.get(id)
        if (!telVendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'telVendedores.label', default: 'TelVendedores'), id])
            redirect(action: "list")
            return
        }

        [telVendedoresInstance: telVendedoresInstance]
    }

    def edit(Long id) {
        def telVendedoresInstance = TelVendedores.get(id)
        if (!telVendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'telVendedores.label', default: 'TelVendedores'), id])
            redirect(action: "list")
            return
        }

        [telVendedoresInstance: telVendedoresInstance]
    }

    def update(Long id, Long version) {
        def telVendedoresInstance = TelVendedores.get(id)
        if (!telVendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'telVendedores.label', default: 'TelVendedores'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (telVendedoresInstance.version > version) {
                telVendedoresInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'telVendedores.label', default: 'TelVendedores')] as Object[],
                          "Another user has updated this TelVendedores while you were editing")
                render(view: "edit", model: [telVendedoresInstance: telVendedoresInstance])
                return
            }
        }

        telVendedoresInstance.properties = params

        if (!telVendedoresInstance.save(flush: true)) {
            render(view: "edit", model: [telVendedoresInstance: telVendedoresInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'telVendedores.label', default: 'TelVendedores'), telVendedoresInstance.id])
        redirect(action: "show", id: telVendedoresInstance.id)
    }

    def delete(Long id) {
        def telVendedoresInstance = TelVendedores.get(id)
        if (!telVendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'telVendedores.label', default: 'TelVendedores'), id])
            redirect(action: "list")
            return
        }

        try {
            telVendedoresInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'telVendedores.label', default: 'TelVendedores'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'telVendedores.label', default: 'TelVendedores'), id])
            redirect(action: "show", id: id)
        }
    }
}
