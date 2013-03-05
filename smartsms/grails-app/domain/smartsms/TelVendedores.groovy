package smartsms

class TelVendedores {
    int id
    int idVendedor
    String telefono
    static constraints = {
        id(blank:false, unique:true)
        idVendedor(blank:false)
        telefono(blank:false)
    }
}
