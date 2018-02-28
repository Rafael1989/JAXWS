package br.com.caelum.estoque.ws;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface="br.com.caelum.estoque.ws.EstoqueWS",serviceName="EstoqueWS",portName="EstoqueWSPort")
public class EstoqueWSImpl implements EstoqueWS{

	@Override
	public ListaItens todosOsItens(Filtros filtros) {
		System.out.println("Chamando todos os itens");
		return new ListaItens();
	}

	@Override
	public CadastrarItemResponse cadastrarItem(CadastrarItem parameters, TokenUsuario tokenUsuario)
			throws AutorizacaoFault {
		System.out.println("Chamando cadastrarItem");
		return new CadastrarItemResponse();
	}

}
