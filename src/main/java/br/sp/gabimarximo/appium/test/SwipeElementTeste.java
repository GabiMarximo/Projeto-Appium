package br.sp.gabimarximo.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.sp.gabimarximo.appium.core.BaseTest;
import br.sp.gabimarximo.appium.pages.MenuPage;
import br.sp.gabimarximo.appium.pages.SwipeListPage;

public class SwipeElementTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();

	@Test
	public void deveResolverDesafio() {
		// Clicar no Swipe List
		menu.clicarSwipeList();

		// Op��o 1 para a direita
		page.swipeElementRight("Op��o 1");

		// Bot�o + na Op��o 1
		page.clicarBotaoMais();

		// Verificar Op��o 1 (+)
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 1 (+)"));

		// Op��o 4 para a direita
		page.swipeElementRight("Op��o 4");

		// Bot�o - na Op��o 4
		page.clicarPorTexto("(-)");

		// Verificar Op��o 4 (-)
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 4 (-)"));

		// Op��o 5 para a esquerda
		page.swipeElementLeft("Op��o 5 (-)");

		// Verificar Op��o 5
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 5"));
	}
}
