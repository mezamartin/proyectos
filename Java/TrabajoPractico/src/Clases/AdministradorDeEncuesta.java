package Clases;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeEncuesta {
	private Encuesta encuesta;
	private List <Pregunta> preguntas;
	private List <Pregunta> preguntasRespondidas;
	private Notificador notificador1;
	private Pregunta preguntaActual;
	private ResultadoDeEncuesta resultado;
	
	
	public AdministradorDeEncuesta(Encuesta encuesta1,ResultadoDeEncuesta resultado1) {
		resultado=resultado1;
		encuesta = resultado1.getEncuesta();
		preguntas = encuesta.getListaDePreguntas();
		preguntasRespondidas = new ArrayList <Pregunta>();
		preguntaActual= preguntas.get(0);
	}
	
	public Pregunta preguntaActual() {
		return this.preguntaActual;
	}
	
	public List <Pregunta> getPreguntas(){
		return this.preguntas;
	}
	
	public List <Pregunta> getPreguntasRespondidas(){
		return this.preguntasRespondidas;
	}
	
	private void reAsignarPreguntaActual(){
		this.getPreguntasRespondidas().add(this.preguntaActual());
		this.getPreguntas().remove(this.preguntaActual());
		this.preguntaActual = this.resultado.getRespuestasSeleccionadas().get(resultado.getCantidadDeRespuestasSeleccionadas()-1).getSiguientePregunta();
	}
	

	public Pregunta preguntaAnterior() {
		return (preguntasRespondidas.get(preguntasRespondidas.size() - 1));
	}
	
	public void responder(Pregunta pregunta) {
		resultado.seleccionarRespuesta(pregunta.getRespuestasSeleccionadas());
		this.reAsignarPreguntaActual();
	}
	
	/*public void notificar() {
		notificador1.avisarleAInvestigador();
	}*/
	

}
