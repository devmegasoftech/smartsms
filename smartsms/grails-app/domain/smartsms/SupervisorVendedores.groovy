package smartsms

class SupervisorVendedores {
    
    int id
    static belongsTo = [idSupervisor:Supervisores, idVendedor:Vendedores]
    
    
    static constraints = {
        id(blank:false, unique: true)
        idSupervisor(blank:false)
        idVendedor(blank:false)
    }
}
