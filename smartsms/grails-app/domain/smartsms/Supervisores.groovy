package smartsms

class Supervisores {

    String nombre
    String apellido
    String direccion
    Integer codigo
    String email
    
    static constraints = {
        nombre (blank:false)
        apellido (blank:false)
        direccion (blank:false)
        codigo (blank:false)
        email (balnk: false)
    }
}
