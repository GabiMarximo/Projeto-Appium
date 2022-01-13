package br.sp.gabimarximo.appium.pages.seuBarriga;

import org.openqa.selenium.By;

import br.sp.gabimarximo.appium.core.BasePage;

public class SBHomePage extends BasePage {

	public String obterSaldoConta(String conta) {
		return obterTexto(By.xpath("//*[@text='" + conta + "']/following-sibling::android.widget.TextView"));
	}

}
