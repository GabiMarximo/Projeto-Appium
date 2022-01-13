package br.sp.gabimarximo.appium.pages;

import static br.sp.gabimarximo.appium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

import br.sp.gabimarximo.appium.core.BasePage;

public class WebViewPage extends BasePage{
	
	public void entrarConTextoWeb() {
		Set<String> contextHandles = getDriver().getContextHandles();

		getDriver().context((String) contextHandles.toArray()[1]);
	}
	
	public void setEmail(String valor) {
		getDriver().findElement(By.id("email")).sendKeys(valor);;
	}
	
	public void setSenha(String senha) {
		getDriver().findElement(By.id("senha")).sendKeys(senha);
	}
	
	public void entrar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String getMensagem() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void sairConTextoWeb() {
		getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
	}

}
