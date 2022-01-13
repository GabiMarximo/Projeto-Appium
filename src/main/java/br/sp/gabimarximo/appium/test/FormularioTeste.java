package br.sp.gabimarximo.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sp.gabimarximo.appium.core.BaseTest;
import br.sp.gabimarximo.appium.core.DriverFactory;
import br.sp.gabimarximo.appium.pages.FormularioPage;
import br.sp.gabimarximo.appium.pages.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Gabrielle");

		assertEquals("Gabrielle", page.obterNome());
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		page.selecionarCombo("Nintendo Switch");

		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());

		page.clicarCheck();
		page.clicarSwitch();

		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		page.escreverNome("Gabrielle");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");

		page.salvar();

		Assert.assertEquals("Nome: Gabrielle", page.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Off"));
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));
	}

	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		page.escreverNome("Gabrielle");

		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		page.salvarDemorado();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Gabrielle']")));

		Assert.assertEquals("Nome: Gabrielle", page.obterNomeCadastrado());
	}

	@Test
	public void deveAlterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("20/02/2000"));
	}

	@Test
	public void deveAlterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("10:40"));
	}

	@Test
	public void deveInteragirComSeekbar() {
		// Clicar no seekbar
		page.clicarSeekBar(0.67);

		// Salvar
		page.salvar();

		// Obter o valor
	}
}
