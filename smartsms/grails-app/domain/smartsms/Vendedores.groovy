package smartsms

class Vendedores {
    int id
    String nombre
    String apellido
    String direccion
    String email
    String codigo
    
    static constraints = {        
        nombre(blank:false, nullable: false)
        apellido(blank:false, nullable: false)
        email(blank:false, nullable: false)
        codigo(blank:false, nullable: false)
    }
}
