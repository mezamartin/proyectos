package Clases;

public class RespuestaSimple extends Respuesta {
	private Opcion opcion;
	
	
	public RespuestaSimple(Pregunta pregunta) {
		super(pregunta);
		this.opcion = new Opcion ("afirmacion");
	}
	
	public Opcion getOpcion() {
		return this.opcion;
	}
	
	
}
