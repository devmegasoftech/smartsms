package smartsms

class Articulos {
    int id;
    String nombre
    String descripcion
    float precio
    int existencia
    static belongsTo = [idotroarticulo: Articulos]

    static constraints = {
        nombre blank: false, nullable: false
        descripcion blank: false, nullable: false
        precio blank: false, nullable: false
        existencia blank: false, nullable: false
        idotroarticulo blank: true, nullable: true

    }
}