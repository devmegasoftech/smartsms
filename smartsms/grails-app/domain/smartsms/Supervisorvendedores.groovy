package smartsms

class Supervisorvendedores {
    
    int id
    int idSupervisor
    int idVendedor
    static constraints = {
        id(blank:false, unique: true)
        idSupervisor(blank:false)
        idVendedor(blank:false)
    }
}
