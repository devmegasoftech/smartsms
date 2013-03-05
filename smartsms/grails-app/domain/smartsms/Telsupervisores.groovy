package smartsms

class Telsupervisores {
    int id
    int idSupervisor
    String telefono
    static constraints = {
        id(blank:false, unique:true)
        idSupervisor(blank:false)
        telefono(blank:false)
    }
}
