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

		// Opção 1 para a direita
		page.swipeElementRight("Opção 1");

		// Botão + na Opção 1
		page.clicarBotaoMais();

		// Verificar Opção 1 (+)
		Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));

		// Opção 4 para a direita
		page.swipeElementRight("Opção 4");

		// Botão - na Opção 4
		page.clicarPorTexto("(-)");

		// Verificar Opção 4 (-)
		Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));

		// Opção 5 para a esquerda
		page.swipeElementLeft("Opção 5 (-)");

		// Verificar Opção 5
		Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));
	}
}
