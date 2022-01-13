package br.sp.gabimarximo.appium.test;

import static br.sp.gabimarximo.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sp.gabimarximo.appium.core.BaseTest;
import br.sp.gabimarximo.appium.pages.MenuPage;

public class OpcaoEscondidaTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		//Scroll down
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		
		menu.scrollDown();
		
		//Clicar menu
		menu.clicarPorTexto("Opção bem escondida");
		
		//Verificar mensagem
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		
		//Sair
		menu.clicarPorTexto("OK");
	}

}
