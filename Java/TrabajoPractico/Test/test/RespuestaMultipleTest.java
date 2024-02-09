package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Clases.Opcion;
import Clases.Pregunta;
import Clases.PreguntaMultiplesOpcionesSimpleSeleccion;
import Clases.PreguntaMultiplesOpcionesYMultiplesSelecciones;
import Clases.RespuestaMultiple;
import Clases.RespuestaSimple;

public class RespuestaMultipleTest {
	private RespuestaMultiple respuesta;
	private RespuestaMultiple respuesta2;
	private RespuestaMultiple respuesta3;
	private Opcion opcion;
	private Opcion opcion2;
	private Pregunta pregunta1;
	private Pregunta preguntaSiguiente;

	@Before
	public void setUp() {
		opcion = new Opcion("aca esta la afirmacion");
		opcion2 = new Opcion("aca esta la afirmacion2");
		respuesta = new RespuestaMultiple(pregunta1);
		respuesta2 = new RespuestaMultiple(preguntaSiguiente);
		respuesta3 = new RespuestaMultiple(pregunta1);
        pregunta1 = new PreguntaMultiplesOpcionesYMultiplesSelecciones("aca hay una consigna", respuesta);
        preguntaSiguiente = new PreguntaMultiplesOpcionesSimpleSeleccion("aca hay otra consigna", respuesta2);
		
	}

	@Test
	public void testUnaRespuestaConoceCualEsSuPregunta() {
		assertTrue(respuesta3.getPregunta() == pregunta1);
	}
	
	@Test
	public void testUnaRespuestaConoceCualEsSuSiguientePregunta() {
		respuesta.setearSiguientePregunta(preguntaSiguiente);
		assertTrue(respuesta.getSiguientePregunta() == preguntaSiguiente);
	}
	
	@Test
	public void testUnaRespuestaMultipleEmpiezaSinOpciones(){
		assertTrue(respuesta.getListaDeOpciones().isEmpty());
	}
	
	@Test
	public void testUnaRespuestaMultipleAgregaOpciones(){
		respuesta.agregarOpcion(opcion);
		respuesta.agregarOpcion(opcion2);
		assertFalse(respuesta.getListaDeOpciones().isEmpty());
	}
	
	@Test
	public void testUnRespuestaMultipleRemueveOpciones(){
		respuesta.agregarOpcion(opcion);
		respuesta.removerOpcion(opcion);
		assertTrue(respuesta.getListaDeOpciones().isEmpty());
	}

}
