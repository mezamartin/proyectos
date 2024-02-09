package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Clases.PreguntaAbierta;

public class PreguntasAbiertasTest {
	private PreguntaAbierta pregunta1;
	
	@Before
	public void setUp(){
		pregunta1=new PreguntaAbierta("aca va la consigna");
		
	}

	
	
	@Test
	public void testUnaPreguntaAbiertaConoceSuConsigna() {
		assertTrue(pregunta1.getConsigna()=="aca va la consigna");
		
	}

}
