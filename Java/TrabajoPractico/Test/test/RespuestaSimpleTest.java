package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import Clases.Opcion;
import Clases.Pregunta;
import Clases.PreguntaMultiplesOpcionesSimpleSeleccion;
import Clases.PreguntaMultiplesOpcionesYMultiplesSelecciones;
import Clases.RespuestaMultiple;
import Clases.RespuestaSimple;

public class RespuestaSimpleTest {
	private Pregunta pregunta1;
	private Pregunta preguntaSiguiente;
	private RespuestaSimple respuesta;
	private RespuestaMultiple respuesta2;
	private RespuestaMultiple respuesta3;
	
	
	
	@Before
	public void setUp() {
		respuesta = new RespuestaSimple(pregunta1);
        pregunta1 = new PreguntaMultiplesOpcionesYMultiplesSelecciones("aca hay una consigna", respuesta2);
        preguntaSiguiente = new PreguntaMultiplesOpcionesSimpleSeleccion("aca hay otra consigna", respuesta3);
		
	}
	

	@Test
	public void testUnaRespuestaConoceCualEsSuPregunta() {
		assertTrue(pregunta1 == respuesta.getPregunta());
	}
	
	@Test
	public void testUnaRespuestaConoceCualEsSuSiguientePregunta() {
		respuesta.setearSiguientePregunta(preguntaSiguiente);
		assertTrue(respuesta.getSiguientePregunta() == preguntaSiguiente);
	}
}
