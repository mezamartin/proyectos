package Clases;

public abstract class Respuesta {
	
	protected Pregunta pregunta;
	protected Pregunta siguientePregunta;
	
	public Respuesta(Pregunta pregunta) {
		this.pregunta = pregunta;
		}
	
	
	public Pregunta getPregunta() {
		return this.pregunta;
	}
	
	public void setearSiguientePregunta(Pregunta siguientePregunta) {
		this.siguientePregunta = siguientePregunta;
	}
	
	public Pregunta getSiguientePregunta() {
		return this.siguientePregunta;
	}
	

}
