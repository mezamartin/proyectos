package Clases;

import java.util.List;

public class PreguntaMultiplesOpcionesSimpleSeleccion extends Pregunta {
	
	private Respuesta posiblesRespuestas;
	private Respuesta respuestasSeleccionadas;
	private List <Interesado> interesados;
	
	public PreguntaMultiplesOpcionesSimpleSeleccion(String consigna, RespuestaMultiple respuesta){
		super(consigna);
		this.consigna=consigna;
		posiblesRespuestas = respuesta;
		respuestasSeleccionadas = new RespuestaSimple(this);
	}
	


	public Respuesta getPosiblesRespuestas() {
		return this.posiblesRespuestas;
	}

	
	
	public void elegirRespuesta(RespuestaSimple respuesta) {
		this.respuestasSeleccionadas = respuesta;
	}


	public Respuesta getRespuestasSeleccionadas() {
		return respuestasSeleccionadas;
	}

	
	

}
