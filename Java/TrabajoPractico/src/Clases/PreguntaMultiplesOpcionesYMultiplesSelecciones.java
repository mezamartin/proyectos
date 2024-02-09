package Clases;

import java.util.List;

public class PreguntaMultiplesOpcionesYMultiplesSelecciones extends Pregunta {
	private Respuesta posiblesRespuestas;
	private Respuesta respuestasSeleccionadas;
	private List <Interesado> interesados;

	public  PreguntaMultiplesOpcionesYMultiplesSelecciones(String consigna, RespuestaMultiple respuesta){
		super(consigna);
		this.consigna = consigna;
		posiblesRespuestas = respuesta;
		respuestasSeleccionadas = new RespuestaMultiple(this);
	}


	public Respuesta getPosiblesRespuestas() {
		return this.posiblesRespuestas;
	}


	public Respuesta getRespuestasSeleccionadas() {
		return this.respuestasSeleccionadas;
	}
	
	
	public void elegirRespuesta(RespuestaMultiple respuesta) {
		this.respuestasSeleccionadas = respuesta;
	}
	
	
	
}
