package smartsms

import org.springframework.dao.DataIntegrityViolationException

class UsuariosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        if(session.user!="admin")
            render (view:"index")
        else
           redirect(action: "list")
    }

    def list(Integer max) {
        
         if(session.user=="admin")
         {
            params.max = Math.min(max ?: 10, 100)
            [usuariosInstanceList: Usuarios.list(params), usuariosInstanceTotal: Usuarios.count()]
         }
         else
         redirect(action: "index")
         
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
        def usuario= Usuarios.findByUsuarioAndClave(params.username, params.password)
        if(usuario){
            
            session.user="admin"
            //redirect(action: "list", params: params)
            render("<script>setTimeout(\"window.location = 'list'\",1000); \$('.form').css('box-shadow','inset 0 0 10px 2px rgba(0,255,0,0.25), 0 0 50px 10px rgba(0,255,0,0.3)'); </script>");
        }
        else
        {
            render ("<script> \$('#frmLogin').effect('shake', { times:3 }, 70); setTimeout(\" \$('.alert').fadeIn(1000);\",500); \$('.form').css('box-shadow','inset 0 0 10px 2px rgba(255,0,0,0.25), 0 0 50px 10px rgba(255,0,0,0.7)'); </script>")
        }
        
    }
    def logout= {
        session.user=null
        redirect(action:'list')
    }
}
