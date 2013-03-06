package smartsms

class Usuarios {

   int id
   static belongsTo=[idtipousuario:TiposUsuarios]
   String usuario
   String clave
   boolean activado
   String fechaultimoacceso
   String fechacreacion
   String aleatorio
   String foto
    
    static constraints = {
        id(blank:false, unique:true)
        idtipousuario(blank:false)
        usuario(blank:false)
        clave(blank:false)
    }
}
