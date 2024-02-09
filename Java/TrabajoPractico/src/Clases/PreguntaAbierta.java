package Clases;

import java.util.List;

public class PreguntaAbierta extends Pregunta {
	private Respuesta respuestaSeleccionada;
	private List <Interesado> interesados;
	
	
	public PreguntaAbierta(String consigna){
		super(consigna);
		respuestaSeleccionada = new RespuestaSimple(this);
	}
	
	public Respuesta getRespuestasSeleccionadas() {
		return this.respuestaSeleccionada;
	}
	
	
	

	
	
}
