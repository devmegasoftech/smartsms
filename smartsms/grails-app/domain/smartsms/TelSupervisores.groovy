package smartsms

class TelSupervisores {
    int id
    static belongsTo = [idSupervisor: Supervisores]
    String telefono
    static constraints = {
        id(blank:false, unique:true)
        idSupervisor(blank:false)
        telefono(blank:false)
    }
}
