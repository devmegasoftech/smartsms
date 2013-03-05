package smartsms

import org.springframework.dao.DataIntegrityViolationException

class ArticulosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [articulosInstanceList: Articulos.list(params), articulosInstanceTotal: Articulos.count()]
    }

    def create() {
        [articulosInstance: new Articulos(params)]
    }

    def save() {
        def articulosInstance = new Articulos(params)
        if (!articulosInstance.save(flush: true)) {
            render(view: "create", model: [articulosInstance: articulosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'articulos.label', default: 'Articulos'), articulosInstance.id])
        redirect(action: "show", id: articulosInstance.id)
    }

    def show(Long id) {
        def articulosInstance = Articulos.get(id)
        if (!articulosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'articulos.label', default: 'Articulos'), id])
            redirect(action: "list")
            return
        }

        [articulosInstance: articulosInstance]
    }

    def edit(Long id) {
        def articulosInstance = Articulos.get(id)
        if (!articulosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'articulos.label', default: 'Articulos'), id])
            redirect(action: "list")
            return
        }

        [articulosInstance: articulosInstance]
    }

    def update(Long id, Long version) {
        def articulosInstance = Articulos.get(id)
        if (!articulosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'articulos.label', default: 'Articulos'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (articulosInstance.version > version) {
                articulosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'articulos.label', default: 'Articulos')] as Object[],
                          "Another user has updated this Articulos while you were editing")
                render(view: "edit", model: [articulosInstance: articulosInstance])
                return
            }
        }

        articulosInstance.properties = params

        if (!articulosInstance.save(flush: true)) {
            render(view: "edit", model: [articulosInstance: articulosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'articulos.label', default: 'Articulos'), articulosInstance.id])
        redirect(action: "show", id: articulosInstance.id)
    }

    def delete(Long id) {
        def articulosInstance = Articulos.get(id)
        if (!articulosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'articulos.label', default: 'Articulos'), id])
            redirect(action: "list")
            return
        }

        try {
            articulosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'articulos.label', default: 'Articulos'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'articulos.label', default: 'Articulos'), id])
            redirect(action: "show", id: id)
        }
    }
}
