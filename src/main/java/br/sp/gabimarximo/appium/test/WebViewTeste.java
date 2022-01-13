package br.sp.gabimarximo.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.sp.gabimarximo.appium.core.BaseTest;
import br.sp.gabimarximo.appium.pages.MenuPage;
import br.sp.gabimarximo.appium.pages.WebViewPage;

public class WebViewTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		//Acessar menu
		menu.acessarSBHibrido();
		esperar(3000);
		page.entrarConTextoWeb();
		
		//Preencher email
		page.setEmail("a@c");
		
		//Preencher senha
		page.setSenha("abc");
		
		//Entrar
		page.entrar();
		
		//Verificar
		Assert.assertEquals("Bem vindo, Gabrielle", page.getMensagem());
	}
	
	@After
	public void tearDown() {
		page.sairConTextoWeb();
	}

}
