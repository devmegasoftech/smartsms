package smartsms

class TelVendedores {
    
    String telefono
    static belongsTo = [idVendedor: Vendedores]
    
    static constraints = {
        id(blank:false, unique:true)
        idVendedor(blank:false)
        telefono(blank:false)
    }
}
