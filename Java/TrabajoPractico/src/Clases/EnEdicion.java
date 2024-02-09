package Clases;

public class EnEdicion extends Etapa {
	
	
	public void agregarPregunta(Pregunta pregunta, Encuesta encuesta){
		encuesta.incluirPregunta(pregunta);
	}
	

	
	public void removerPregunta(Pregunta pregunta, Encuesta encuesta){
		encuesta.quitarPregunta(pregunta);
	}
	
	public void publicar(Encuesta encuesta) {
		encuesta.setEstado(new Activa());
	}
	
	
}
