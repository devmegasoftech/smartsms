package smartsms

class Vendedores {
    int id
    String nombre
    String apellido
    String direccion
    String email
    String codigo
    
    static constraints = {
        id(blank:false, unique:true)
        nombre(blank:false)
        apellido(blank:false)
        email(blank:false)
        codigo(blank:false)
    }
}
