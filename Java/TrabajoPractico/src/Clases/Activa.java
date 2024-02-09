package Clases;

public class Activa extends Etapa {
	
	public void agregarResultado(ResultadoDeEncuesta resultado, Encuesta encuesta) {
		encuesta.incluirResultado(resultado);
		
	}

	public void removerResultado(ResultadoDeEncuesta resultado, Encuesta encuesta) {
		encuesta.quitarResultado(resultado);
		
	}
	
	
	public void cerrar(Encuesta encuesta) {
		encuesta.setEstado(new Cerrada());
	}
 
}
