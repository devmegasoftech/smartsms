package smartsms

import org.springframework.dao.DataIntegrityViolationException

class UsuariosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        if(session.user=="admin")
            redirect(action: "list", params: params)
            else
            render "Debe Registrarse para ingresar!"
    }

    def list(Integer max) {
        
         if(session.user=="admin")
         {
            params.max = Math.min(max ?: 10, 100)
            [usuariosInstanceList: Usuarios.list(params), usuariosInstanceTotal: Usuarios.count()]
         }
         else
         render "Debe Registrarse para ingresar!"
    }

    def create() {
        [usuariosInstance: new Usuarios(params)]
    }

    def save() {
        def usuariosInstance = new Usuarios(params)
        if (!usuariosInstance.save(flush: true)) {
            render(view: "create", model: [usuariosInstance: usuariosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'usuarios.label', default: 'Usuarios'), usuariosInstance.id])
        redirect(action: "show", id: usuariosInstance.id)
    }

    def show(Long id) {
        def usuariosInstance = Usuarios.get(id)
        if (!usuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuarios.label', default: 'Usuarios'), id])
            redirect(action: "list")
            return
        }

        [usuariosInstance: usuariosInstance]
    }

    def edit(Long id) {
        def usuariosInstance = Usuarios.get(id)
        if (!usuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuarios.label', default: 'Usuarios'), id])
            redirect(action: "list")
            return
        }

        [usuariosInstance: usuariosInstance]
    }

    def update(Long id, Long version) {
        def usuariosInstance = Usuarios.get(id)
        if (!usuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuarios.label', default: 'Usuarios'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (usuariosInstance.version > version) {
                usuariosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'usuarios.label', default: 'Usuarios')] as Object[],
                          "Another user has updated this Usuarios while you were editing")
                render(view: "edit", model: [usuariosInstance: usuariosInstance])
                return
            }
        }

        usuariosInstance.properties = params

        if (!usuariosInstance.save(flush: true)) {
            render(view: "edit", model: [usuariosInstance: usuariosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'usuarios.label', default: 'Usuarios'), usuariosInstance.id])
        redirect(action: "show", id: usuariosInstance.id)
    }

    def delete(Long id) {
        def usuariosInstance = Usuarios.get(id)
        if (!usuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuarios.label', default: 'Usuarios'), id])
            redirect(action: "list")
            return
        }

        try {
            usuariosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'usuarios.label', default: 'Usuarios'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'usuarios.label', default: 'Usuarios'), id])
            redirect(action: "show", id: id)
        }
    }
    
    def login={
        if(params.username=="admin" && params.password == "admin"){
            
            session.user="admin"
            
        }
        else
        {
            flash.message="Error!"
        }
        redirect(action:'list')
    }
    def logout= {
        session.user=null
        redirect(action:'index')
    }
}
