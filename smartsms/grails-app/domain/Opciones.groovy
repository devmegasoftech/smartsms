 
class Opciones {
	
	int id
	String codigo
	String idarticulo
	
static constraints = {
     		id(nullable:true)
 		codigo(nullable:true)
		idarticulo(nullable:true)
	
    }
    String toString() {
		return codigo;
	}
}

