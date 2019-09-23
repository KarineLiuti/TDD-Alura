package br.com.caelum.leilao.dominio;

public class Avaliador {
    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private double valorMedio = 0;

    public void avalia(Leilao leilao) {
        for(Lance lance : leilao.getLances()) {
            if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
            if(lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
        }
    }
    
    public void valorMedio(Leilao leilao) {
    	double soma = 0;
    	
    	for (Lance lance : leilao.getLances()) {
    		soma += lance.getValor();
    	}
    	if (soma == 0) {
    		this.valorMedio = 0;
    		return;
    	}
    	this.valorMedio = (soma / leilao.getLances().size());
    }

    public double getMaiorLance() {
        return maiorDeTodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }

	public double getValorMedio() {
		return valorMedio;
	}
}
