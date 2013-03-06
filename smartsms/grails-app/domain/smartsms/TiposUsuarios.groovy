package smartsms

class TiposUsuarios {
    int id
    String descripcion
    static constraints = {
        id(blank:false, unique:true)
        descripcion(blank:false, unique:true)
    }
    
    String toString(){
        return descripcion
    }
}
