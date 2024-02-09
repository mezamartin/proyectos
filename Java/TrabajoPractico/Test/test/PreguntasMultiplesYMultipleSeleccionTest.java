package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Clases.PreguntaMultiplesOpcionesYMultiplesSelecciones;
import Clases.RespuestaMultiple;

public class PreguntasMultiplesYMultipleSeleccionTest {
	private PreguntaMultiplesOpcionesYMultiplesSelecciones preguntaMultipleSeleccion1;
	private RespuestaMultiple respuesta1;
	private RespuestaMultiple respuesta2;
	
	@Before
	public void setUp(){
		respuesta1=new RespuestaMultiple(preguntaMultipleSeleccion1);
		respuesta2 = new RespuestaMultiple(preguntaMultipleSeleccion1);
		preguntaMultipleSeleccion1=new PreguntaMultiplesOpcionesYMultiplesSelecciones("aca va la consigna", respuesta1);
	}

	@Test
	public void testUnaPreguntaDeMultiplesOpcionesYSeleccionesConoceSuConsigna(){
		assertTrue(preguntaMultipleSeleccion1.getConsigna()=="aca va la consigna");
	}
	
	@Test
	public void testUnaPreguntaDeMultiplesOpcionesYSeleccionesConoceSusPosiblesRespuestas() {
		assertTrue(preguntaMultipleSeleccion1.getPosiblesRespuestas() == respuesta1);
	}
	
	@Test
	public void testUnaPreguntaDeMultiplesOpcionesYSeleccionesPuedeSeleccionarUnaRespuesta() {
		preguntaMultipleSeleccion1.elegirRespuesta(respuesta2);
		assertTrue(preguntaMultipleSeleccion1.getRespuestasSeleccionadas() == respuesta2);
	}

	
	

}
