package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Clases.AdministradorDeEncuesta;
import Clases.Encuesta;
import Clases.Pregunta;
import Clases.Respuesta;
import Clases.ResultadoDeEncuesta;

public class AdministradorTest {
	private Encuesta encuesta;
	private Pregunta pregunta1;
	private Pregunta pregunta2;
	private Respuesta respuesta1;
	private Respuesta respuesta2;
	private AdministradorDeEncuesta admin1;
	private ResultadoDeEncuesta resultado1;
	

	@Before
	public void setUp() {
		/*encuesta = new Encuesta(LocalDate.of(2019, 6, 14));
		pregunta1 = new PreguntaMultiplesOpcionesYMultiplesSelecciones("aca hay una consigna");
		pregunta2 = new PreguntaMultiplesOpcionesSimpleSeleccion("aca hay otra consigna");
		pregunta3 = new PreguntaMultiplesOpcionesYMultiplesSelecciones("consigna");
		pregunta4 = new PreguntaMultiplesOpcionesSimpleSeleccion("nueva consigna");
		encuesta.agregarPregunta(pregunta1);
		encuesta.agregarPregunta(pregunta2);
		encuesta.agregarPregunta(pregunta3);
		encuesta.agregarPregunta(pregunta4);
		//respuesta1 = new RespuestaMultiple(pregunta1);
		respuesta2 = new RespuestaSimple(pregunta2);
		respuesta3 = new RespuestaMultiple(pregunta3);
		resultado1 = new ResultadoDeEncuesta("pepe", "lopez", encuesta);*/
		
	}
	
	@Test
	public void testElAdministradorDeEncuestaConoceCualEsLaPreguntaActual(){
		respuesta1 = mock(Respuesta.class);
		encuesta = mock(Encuesta.class);
		pregunta1 = mock(Pregunta.class);
		pregunta2 = mock(Pregunta.class);
		resultado1 = mock(ResultadoDeEncuesta.class);
		respuesta2 = mock(Respuesta.class);
		List<Pregunta> listaP = new ArrayList <Pregunta>();
		List<Respuesta> listaR = new ArrayList <Respuesta>();
		//respuesta1.setearSiguientePregunta(pregunta2);
		//encuesta.agregarPregunta(pregunta2);
		
		when(resultado1.getEncuesta()).thenReturn(encuesta);
		when(encuesta.getListaDePreguntas()).thenReturn(listaP);
		//when(listaP.get(0)).thenReturn(pregunta1);
		listaP.add(pregunta1);
		
		admin1 = new AdministradorDeEncuesta(encuesta, resultado1);
		assertTrue(admin1.preguntaActual() == pregunta1);
	}
	
	@Test
	public void testCuandoSeRespondeUnaPreguntaLaPreguntaActualPasaASerLaSiguientePreguntaDeLaRespuesta() {
		respuesta1 = mock(Respuesta.class);
		encuesta = mock(Encuesta.class);
		pregunta1 = mock(Pregunta.class);
		pregunta2 = mock(Pregunta.class);
		resultado1 = mock(ResultadoDeEncuesta.class);
		respuesta2 = mock(Respuesta.class);
		List<Pregunta> listaP = new ArrayList <Pregunta>();
		List<Respuesta> listaR = new ArrayList <Respuesta>();
		//respuesta1.setearSiguientePregunta(pregunta2);
		//encuesta.agregarPregunta(pregunta2);
		
		when(resultado1.getEncuesta()).thenReturn(encuesta);
		when(encuesta.getListaDePreguntas()).thenReturn(listaP);
		//when(listaP.get(0)).thenReturn(pregunta1);
		listaP.add(pregunta1);
		
		admin1 = new AdministradorDeEncuesta(encuesta, resultado1);
		
		
		
		when(pregunta1.getRespuestasSeleccionadas()).thenReturn(respuesta2);
		when(resultado1.getCantidadDeRespuestasSeleccionadas()).thenReturn(1);
		when(resultado1.getRespuestasSeleccionadas()).thenReturn(listaR);
		//when(resultado1.getRespuestasSeleccionadas().get(resultado1.getCantidadDeRespuestasSeleccionadas()-1)).thenReturn(respuesta1);
		listaR.add(respuesta1);
		when(respuesta1.getSiguientePregunta()).thenReturn(pregunta2);
		admin1.responder(pregunta1);
		
		//assertTrue(admin1.preguntaActual() == pregunta2);
		assertEquals(admin1.preguntaActual(), pregunta2);
	}
	
	@Test
	public void unAdministradorConoceLaPreguntaAnterior(){
		respuesta1 = mock(Respuesta.class);
		encuesta = mock(Encuesta.class);
		pregunta1 = mock(Pregunta.class);
		pregunta2 = mock(Pregunta.class);
		resultado1 = mock(ResultadoDeEncuesta.class);
		respuesta2 = mock(Respuesta.class);
		List<Pregunta> listaP = new ArrayList <Pregunta>();
		List<Respuesta> listaR = new ArrayList <Respuesta>();
		//respuesta1.setearSiguientePregunta(pregunta2);
		//encuesta.agregarPregunta(pregunta2);
		
		when(resultado1.getEncuesta()).thenReturn(encuesta);
		when(encuesta.getListaDePreguntas()).thenReturn(listaP);
		//when(listaP.get(0)).thenReturn(pregunta1);
		listaP.add(pregunta1);
		
		admin1 = new AdministradorDeEncuesta(encuesta, resultado1);
		
		
		
		when(pregunta1.getRespuestasSeleccionadas()).thenReturn(respuesta2);
		when(resultado1.getCantidadDeRespuestasSeleccionadas()).thenReturn(1);
		when(resultado1.getRespuestasSeleccionadas()).thenReturn(listaR);
		//when(resultado1.getRespuestasSeleccionadas().get(resultado1.getCantidadDeRespuestasSeleccionadas()-1)).thenReturn(respuesta1);
		listaR.add(respuesta1);
		when(respuesta1.getSiguientePregunta()).thenReturn(pregunta2);
		admin1.responder(pregunta1);
		
		assertEquals(admin1.preguntaAnterior(),pregunta1);
	}

	

}
