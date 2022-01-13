package br.sp.gabimarximo.appium.pages;

import org.openqa.selenium.By;

import br.sp.gabimarximo.appium.core.BasePage;

public class AccordionPage extends BasePage {

	public void selecionarOp1() {
		clicarPorTexto("Op��o 1");
	}

	public String obterValorOp1() {
		return obterTexto(By.xpath(
				"//*[@text='Op��o 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}

}
