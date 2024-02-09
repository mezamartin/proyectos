package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Clases.Opcion;
import Clases.PreguntaMultiplesOpcionesSimpleSeleccion;
import Clases.RespuestaMultiple;
import Clases.RespuestaSimple;

public class PreguntasMultiplesSimpleSeleccionTest {
	private PreguntaMultiplesOpcionesSimpleSeleccion preguntaMultipleSimpleSeleccion1;
	private RespuestaSimple respuesta1;
	private RespuestaMultiple respuesta2;
	
	@Before
	public void setUp(){
		respuesta1=new RespuestaSimple(preguntaMultipleSimpleSeleccion1);
		respuesta2=new RespuestaMultiple(preguntaMultipleSimpleSeleccion1);
		preguntaMultipleSimpleSeleccion1=new PreguntaMultiplesOpcionesSimpleSeleccion ("aca va La Consigna", respuesta2);	
	}

	@Test
	public void testUnaPreguntaMultipleDeSimpleSeleccionConoceSuConsigna() {
		assertTrue(preguntaMultipleSimpleSeleccion1.getConsigna()=="aca va La Consigna");
	}
	
	@Test
	public void testUnaPreguntaDeMultiplesOpcionesYSimpleSeleccionConoceSusPosiblesRespuestas() {
		assertEquals(preguntaMultipleSimpleSeleccion1.getPosiblesRespuestas() , respuesta2);
	}
	
	@Test
	public void testUnaPreguntaDeMultiplesOpcionesYSimpleSeleccionPuedeSeleccionarUnaRespuesta() {
		preguntaMultipleSimpleSeleccion1.elegirRespuesta(respuesta1);
		assertTrue(preguntaMultipleSimpleSeleccion1.getRespuestasSeleccionadas() == respuesta1);
	}
	
	@Test
	public void testUnaPreguntaDeMultiplesOpcionesYSimpleSeleccionConoceSusRespuestasSeleccionadas() {
		preguntaMultipleSimpleSeleccion1.elegirRespuesta(respuesta1);
		assertEquals(preguntaMultipleSimpleSeleccion1.getRespuestasSeleccionadas(), respuesta1);
	}
	
	
	

}
