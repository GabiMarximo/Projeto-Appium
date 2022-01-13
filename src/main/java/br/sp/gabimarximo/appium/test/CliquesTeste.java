package br.sp.gabimarximo.appium.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sp.gabimarximo.appium.core.BaseTest;
import br.sp.gabimarximo.appium.pages.CliquesPage;
import br.sp.gabimarximo.appium.pages.MenuPage;

public class CliquesTeste extends BaseTest {

	private static MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@BeforeClass
	public static void setup() {
		menu.acessarCliques();
	}

	@Test
	public void deveRealizarCliqueLongo() {
		page.cliqueLongo();

		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	
	}

}
