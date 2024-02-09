package Clases;



public abstract class Pregunta {
	protected String consigna;
	
	public Pregunta(String consigna){
		this.consigna=consigna;
	}
	
	public abstract Respuesta getRespuestasSeleccionadas();
	
	public String getConsigna(){
		return this.consigna;
	}
	
	

}
