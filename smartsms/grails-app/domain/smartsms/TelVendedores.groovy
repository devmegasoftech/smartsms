package smartsms

class TelVendedores {
    int id
    String telefono
    static belongsTo = [idVendedor: Vendedores]
    
    static constraints = {
        id(blank:false, unique:true)
        telefono(blank:false, nullable: true)
        idVendedor(blank:false, nullable: true)
    }
}
