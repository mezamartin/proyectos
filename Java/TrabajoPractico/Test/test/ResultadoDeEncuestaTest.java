package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import Clases.Encuesta;
import Clases.PreguntaMultiplesOpcionesSimpleSeleccion;
import Clases.PreguntaMultiplesOpcionesYMultiplesSelecciones;
import Clases.Respuesta;
import Clases.RespuestaMultiple;
import Clases.ResultadoDeEncuesta;

public class ResultadoDeEncuestaTest {
	private ResultadoDeEncuesta resultado;
	private PreguntaMultiplesOpcionesYMultiplesSelecciones pregunta1;
	private PreguntaMultiplesOpcionesSimpleSeleccion preguntaSiguiente1;
	private PreguntaMultiplesOpcionesYMultiplesSelecciones pregunta2;
	private PreguntaMultiplesOpcionesSimpleSeleccion preguntaSiguiente2;
	private Respuesta respuesta1;
	private Respuesta respuesta2;
	private RespuestaMultiple respuesta3;
	private RespuestaMultiple respuesta4;
	private Encuesta encuesta1;
	
	
	@Before
	public void setUp() {
		encuesta1=new Encuesta(LocalDate.of(2018, 5, 22));
		resultado = new ResultadoDeEncuesta("Juan", "Lopez",encuesta1);
		respuesta1 = new RespuestaMultiple(pregunta1);
		respuesta2 = new RespuestaMultiple (pregunta2);
		pregunta1= new PreguntaMultiplesOpcionesYMultiplesSelecciones("otra consigna", respuesta3);
		preguntaSiguiente1 = new PreguntaMultiplesOpcionesSimpleSeleccion("nueva consigna", respuesta4);
		//pregunta2 = new PreguntaMultiplesOpcionesYMultiplesSelecciones("consigna2");
		//preguntaSiguiente2 = new PreguntaMultiplesOpcionesSimpleSeleccion("consigna pregunta siguiente 2");
		
	}
	
	@Test
	public void testCuandoSeCreaUnResultadoNuevoSuListaDeRespuestasEstaVacia() {
		assertTrue(resultado.getRespuestasSeleccionadas().isEmpty());
	}
	
	@Test
	public void testUnResultadoPuedeAgregarUnaRespuestaASuListaDeRespuestas() {
		resultado.seleccionarRespuesta(respuesta1);
		assertFalse(resultado.getRespuestasSeleccionadas().isEmpty());
	}
	
	@Test
	public void testUnResultadoPuedeRemoverUnaRespuestaDeSuListaDeRespuestas() {
		resultado.seleccionarRespuesta(respuesta1);
		resultado.removerRespuesta(respuesta1);
		assertTrue(resultado.getRespuestasSeleccionadas().isEmpty());
	}
	
	
	@Test
	public void testUnResultadoConoceLaCantidadDeRespuestasDeSuLista() {
		resultado.seleccionarRespuesta(respuesta1);
		resultado.seleccionarRespuesta(respuesta2);
		assertEquals(2,resultado.getCantidadDeRespuestasSeleccionadas(),0);
	}
	
	@Test
	public void testUnResultadoConoceLaEncuestaALaCualPertenece(){
		assertTrue(resultado.getEncuesta()==encuesta1);
	}
	
	@Test
	public void testUnResultadoConoceLaRespuestaQueTiene() {
		resultado.seleccionarRespuesta(respuesta1);
		assertTrue(resultado.getRespuestasSeleccionadas().contains(respuesta1));
	}
	
	

}
