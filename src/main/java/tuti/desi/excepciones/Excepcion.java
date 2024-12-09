package tuti.desi.excepciones;

<<<<<<< HEAD
public class Excepcion extends Exception{

	
	/*
	 * Atributo al que está asociado el error
	 */
	private  String atributo;
	
	public Excepcion() {
		super();
		
	}

	public Excepcion(String mensaje) {
		super(mensaje);
	}

	public Excepcion(String mensaje, String atributo) {
		super(mensaje);
		this.atributo=atributo;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	

}
=======
public class Excepcion extends Exception {

    // Constructor sin parametros
    public Excepcion() {
        super();
    }

    // Constructor que permite pasar un mensaje de error
    public Excepcion(String message) {
        super(message);
    }

    // Constructor con mensaje y causa 
    public Excepcion(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor con causa
    public Excepcion(Throwable cause) {
        super(cause);
    }
}

>>>>>>> 17f7e9b (agrego archivos)
