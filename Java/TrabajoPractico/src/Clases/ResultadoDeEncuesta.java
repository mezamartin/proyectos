package Clases;

import java.util.ArrayList;
import java.util.List;

public class ResultadoDeEncuesta {
	private Encuesta encuesta;
	private String nombreDelEncuestado;
	private String apellidoDelEncuestado;
	private List <Respuesta> respuestasSeleccionadas;
	
	public ResultadoDeEncuesta(String nombreDelEncuestado, String apellidoDelEncuestado,Encuesta encuesta) {
		this.nombreDelEncuestado = nombreDelEncuestado;
		this.apellidoDelEncuestado = apellidoDelEncuestado;
		this.encuesta=encuesta;
		respuestasSeleccionadas = new ArrayList <Respuesta>();
	}
	
	public  List <Respuesta> getRespuestasSeleccionadas(){
		return this.respuestasSeleccionadas;
	}
	
	
	public Integer getCantidadDeRespuestasSeleccionadas() {
		return this.respuestasSeleccionadas.size();
	}
	
	
	public Encuesta getEncuesta(){
		return this.encuesta;
	}
	
	public void seleccionarRespuesta(Respuesta respuesta) {
		this.respuestasSeleccionadas.add(respuesta);
	}
	
	
	
	public void removerRespuesta(Respuesta respuesta) {
		this.respuestasSeleccionadas.remove(respuesta);
	}
	
	
	
	
	
	
	
	
	

}
