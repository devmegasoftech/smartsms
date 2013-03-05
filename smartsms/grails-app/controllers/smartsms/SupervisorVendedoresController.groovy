package smartsms

import org.springframework.dao.DataIntegrityViolationException

class SupervisorVendedoresController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [supervisorVendedoresInstanceList: SupervisorVendedores.list(params), supervisorVendedoresInstanceTotal: SupervisorVendedores.count()]
    }

    def create() {
        [supervisorVendedoresInstance: new SupervisorVendedores(params)]
    }

    def save() {
        def supervisorVendedoresInstance = new SupervisorVendedores(params)
        if (!supervisorVendedoresInstance.save(flush: true)) {
            render(view: "create", model: [supervisorVendedoresInstance: supervisorVendedoresInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'supervisorVendedores.label', default: 'SupervisorVendedores'), supervisorVendedoresInstance.id])
        redirect(action: "show", id: supervisorVendedoresInstance.id)
    }

    def show(Long id) {
        def supervisorVendedoresInstance = SupervisorVendedores.get(id)
        if (!supervisorVendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'supervisorVendedores.label', default: 'SupervisorVendedores'), id])
            redirect(action: "list")
            return
        }

        [supervisorVendedoresInstance: supervisorVendedoresInstance]
    }

    def edit(Long id) {
        def supervisorVendedoresInstance = SupervisorVendedores.get(id)
        if (!supervisorVendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'supervisorVendedores.label', default: 'SupervisorVendedores'), id])
            redirect(action: "list")
            return
        }

        [supervisorVendedoresInstance: supervisorVendedoresInstance]
    }

    def update(Long id, Long version) {
        def supervisorVendedoresInstance = SupervisorVendedores.get(id)
        if (!supervisorVendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'supervisorVendedores.label', default: 'SupervisorVendedores'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (supervisorVendedoresInstance.version > version) {
                supervisorVendedoresInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'supervisorVendedores.label', default: 'SupervisorVendedores')] as Object[],
                          "Another user has updated this SupervisorVendedores while you were editing")
                render(view: "edit", model: [supervisorVendedoresInstance: supervisorVendedoresInstance])
                return
            }
        }

        supervisorVendedoresInstance.properties = params

        if (!supervisorVendedoresInstance.save(flush: true)) {
            render(view: "edit", model: [supervisorVendedoresInstance: supervisorVendedoresInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'supervisorVendedores.label', default: 'SupervisorVendedores'), supervisorVendedoresInstance.id])
        redirect(action: "show", id: supervisorVendedoresInstance.id)
    }

    def delete(Long id) {
        def supervisorVendedoresInstance = SupervisorVendedores.get(id)
        if (!supervisorVendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'supervisorVendedores.label', default: 'SupervisorVendedores'), id])
            redirect(action: "list")
            return
        }

        try {
            supervisorVendedoresInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'supervisorVendedores.label', default: 'SupervisorVendedores'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'supervisorVendedores.label', default: 'SupervisorVendedores'), id])
            redirect(action: "show", id: id)
        }
    }
}
