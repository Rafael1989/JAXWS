package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {
	
	private ItemDao itemDao = new ItemDao();
	
	@WebMethod(operationName="TodosOsItens")
	@ResponseWrapper(localName="itens")
	@WebResult(name="item")
	@RequestWrapper(localName="listaItens")
	public List<Item> getItens(@WebParam(name="filtros")Filtros filtros){
		System.out.println("Chamando getItens()");
		List<Filtro> lista = filtros.getLista();
		return itemDao.todosItens(lista);
	}
	
	@WebMethod(operationName="CadastrarItem")
	@WebResult(name="item")
	public Item cadastrarItem(@WebParam(name="tokenUsuario",header=true) TokenUsuario token,@WebParam(name="item")Item item) throws AutorizacaoException {
		System.out.println("Cadastrando item..." + item + "token " + token);
		
		boolean valido = new TokenDao().ehValido(token);
		
		if(!valido) {
			throw new AutorizacaoException("Token invalido");
		}
		
		new ItemValidador(item).validate();
		
		this.itemDao.cadastrar(item);
		return item;
	}
	

}
