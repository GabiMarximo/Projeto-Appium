package br.sp.gabimarximo.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.sp.gabimarximo.appium.core.BaseTest;
import br.sp.gabimarximo.appium.pages.MenuPage;
import br.sp.gabimarximo.appium.pages.SplashPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		//Acessar menu splash
		menu.acessarSplash();
		
		//Verificar que splash está sendo exibido
		page.isTelaSplashVisivel();
		
		//Aguardar saida do splash
		page.aguardarSplashSumir();
		
		//Verificar que o formulario esta aparecendo
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
	}

}
