package br.com.caelum.leilao.dominio;

import org.junit.Test;

import junit.framework.Assert;

public class TesteDoAvaliador {
	
	@Test
	public void deveEntenderLanesEmOrdemCrescente() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 500.0));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        leiloeiro.valorMedio(leilao);
        
        double maiorEsperado = 500;
        double menorEsperado = 300;

        // exibindo a saida
        
        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
        
		Assert.assertEquals(400 , leiloeiro.getValorMedio(), 0.00001);
    }
}
