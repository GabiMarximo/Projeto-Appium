package br.sp.gabimarximo.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.sp.gabimarximo.appium.core.BaseTest;
import br.sp.gabimarximo.appium.pages.DragNDropPage;
import br.sp.gabimarximo.appium.pages.MenuPage;

public class DragNDropTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private DragNDropPage page = new DragNDropPage();

	private String[] estadoInicial = new String[] { "Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,",
			"e arraste para", "qualquer local desejado." };

	private String[] estadoIntermediario = new String[] { "é uma lista", "Drag em Drop!", "Faça um clique longo,",
			"e arraste para", "Esta", "qualquer local desejado." };

	private String[] estadoFinal = new String[] { "Faça um clique longo,", "é uma lista", "Drag em Drop!",
			"e arraste para", "qualquer local desejado." };

	@Test
	public void deveEfetuarDragNDrop() {
		menu.clicarDragNDrop();
		
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, page.obterLista());

		page.arrastar("Esta", "e arraste para");

		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());

		page.arrastar("Faça um clique longo", "é uma lista");

		Assert.assertArrayEquals(estadoFinal, page.obterLista());

	}

}
