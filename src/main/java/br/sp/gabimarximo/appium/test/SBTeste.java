package br.sp.gabimarximo.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.sp.gabimarximo.appium.core.BaseTest;
import br.sp.gabimarximo.appium.pages.MenuPage;
import br.sp.gabimarximo.appium.pages.seuBarriga.SBContasPage;
import br.sp.gabimarximo.appium.pages.seuBarriga.SBHomePage;
import br.sp.gabimarximo.appium.pages.seuBarriga.SBLoginPage;
import br.sp.gabimarximo.appium.pages.seuBarriga.SBMenuPage;
import br.sp.gabimarximo.appium.pages.seuBarriga.SBMovimentacaoPage;
import br.sp.gabimarximo.appium.pages.seuBarriga.SBResumoPage;

public class SBTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();
	
	@Before
	public void setup() {
		menu.acessarSBNativo();
		login.setEmail("a@c");
		login.setSenha("abc");
		login.entrar();
	}
	
	@Test
	public void deveInserirContaComSucesso() {
		menuSB.acessarContas();
		contas.setConta("Conta de Teste");
		contas.salvar();
		
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void deveExcluirConta() {
		menuSB.acessarContas();
		contas.selecionarConta("123");
		contas.excluir();
		
		Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void deveValidarInclusaoMov() {
		menuSB.acessarMovimentacoes();
		mov.salvar();
		
		Assert.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));
		
		mov.setDescricao("Desc");
		mov.salvar();
		
		Assert.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));
		
		mov.setInteressado("interess");
		mov.salvar();
		
		Assert.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));
		
		mov.setValor("123");
		mov.salvar();
		
		Assert.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));
		
		mov.setConta("Conta para alterar");
		mov.salvar();
		
		Assert.assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));

	}
	
	@Test
	public void deveAtualizarSaldoAoExcluirMov() {
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		
		menuSB.acessarResumo();
		resumo.excluirMovimentacao("Movimentação 3, calculo saldo");
		
		Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));
		
		menuSB.acessarHome();
		esperar(1000);
		home.scroll(0.2, 0.9);
		
		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));

		

		
		
	}

}
