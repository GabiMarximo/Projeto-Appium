package br.sp.gabimarximo.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.sp.gabimarximo.appium.core.BaseTest;
import br.sp.gabimarximo.appium.pages.MenuPage;

public class SwipeTeste extends BaseTest {

	MenuPage menu = new MenuPage();

	@Test
	public void deveRealizarSwipe() {
		menu.acessarSwipe();

		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

		menu.swipeRight();

		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

		menu.clicarPorTexto(">");

		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

		menu.swipeLeft();
		menu.clicarPorTexto("<");

		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}
}
