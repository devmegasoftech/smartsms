package smartsms

class TelVendedores {
    
    String telefono
    static belongsTo = [idVendedor: Vendedores]
    
    static constraints = {        
        telefono(blank:false, nullable: true)
        idVendedor(blank:false, nullable: true)
    }
}
