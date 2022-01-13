package br.sp.gabimarximo.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.sp.gabimarximo.appium.core.BaseTest;
import br.sp.gabimarximo.appium.pages.AbasPage;
import br.sp.gabimarximo.appium.pages.MenuPage;

public class AbasTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();
	
	@Test
	public void deveInteragircomAbas() {
		//Acessar menu abas
		menu.acessarAbas();
		
		//Verificar que está na aba 1
		Assert.assertTrue(page.isAba1());
		
		//Acessar a aba 2
		page.selecionarAba2();
		
		//Verificar que está na aba 2
		Assert.assertTrue(page.isAba2());
	}
}
