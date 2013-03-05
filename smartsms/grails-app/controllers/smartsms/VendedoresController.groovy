package smartsms

import org.springframework.dao.DataIntegrityViolationException

class VendedoresController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [vendedoresInstanceList: Vendedores.list(params), vendedoresInstanceTotal: Vendedores.count()]
    }

    def create() {
        [vendedoresInstance: new Vendedores(params)]
    }

    def save() {
        def vendedoresInstance = new Vendedores(params)
        if (!vendedoresInstance.save(flush: true)) {
            render(view: "create", model: [vendedoresInstance: vendedoresInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'vendedores.label', default: 'Vendedores'), vendedoresInstance.id])
        redirect(action: "show", id: vendedoresInstance.id)
    }

    def show(Long id) {
        def vendedoresInstance = Vendedores.get(id)
        if (!vendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendedores.label', default: 'Vendedores'), id])
            redirect(action: "list")
            return
        }

        [vendedoresInstance: vendedoresInstance]
    }

    def edit(Long id) {
        def vendedoresInstance = Vendedores.get(id)
        if (!vendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendedores.label', default: 'Vendedores'), id])
            redirect(action: "list")
            return
        }

        [vendedoresInstance: vendedoresInstance]
    }

    def update(Long id, Long version) {
        def vendedoresInstance = Vendedores.get(id)
        if (!vendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendedores.label', default: 'Vendedores'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (vendedoresInstance.version > version) {
                vendedoresInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'vendedores.label', default: 'Vendedores')] as Object[],
                          "Another user has updated this Vendedores while you were editing")
                render(view: "edit", model: [vendedoresInstance: vendedoresInstance])
                return
            }
        }

        vendedoresInstance.properties = params

        if (!vendedoresInstance.save(flush: true)) {
            render(view: "edit", model: [vendedoresInstance: vendedoresInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'vendedores.label', default: 'Vendedores'), vendedoresInstance.id])
        redirect(action: "show", id: vendedoresInstance.id)
    }

    def delete(Long id) {
        def vendedoresInstance = Vendedores.get(id)
        if (!vendedoresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendedores.label', default: 'Vendedores'), id])
            redirect(action: "list")
            return
        }

        try {
            vendedoresInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendedores.label', default: 'Vendedores'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'vendedores.label', default: 'Vendedores'), id])
            redirect(action: "show", id: id)
        }
    }
}
