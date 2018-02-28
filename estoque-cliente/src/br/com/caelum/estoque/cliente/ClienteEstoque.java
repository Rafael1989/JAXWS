package br.com.caelum.estoque.cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ClienteEstoque {
	
	public static void main(String[] args) throws MalformedURLException, AutorizacaoFault, DatatypeConfigurationException {
		URL url = new URL("http://localhost:8080/estoque-web/EstoqueWS?wsdl");
		QName qName = new QName("http://ws.estoque.caelum.com.br/","EstoqueWS");
		
		Service service = Service.create(url,qName);
		EstoqueWS cliente = service.getPort(EstoqueWS.class);
		
		Filtro filtro = new Filtro();
		filtro.setNome("Iphone");
		filtro.setTipo("Livro");
		
		Filtros filtros = new Filtros();
		filtros.getFiltro().add(filtro);
		
		TokenUsuario tokenUsuario = new TokenUsuario();
		tokenUsuario.setDataValidade(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(2018,02,28)));
		tokenUsuario.setToken("AAA");
		
		Item item = new Item();
		item.setCodigo("123");
		item.setNome("Iphone");
		item.setQuantidade(2);
		item.setTipo("Livro");
		
		CadastrarItem cadastrarItem = new CadastrarItem();
		cadastrarItem.setItem(item);
		
		cliente.cadastrarItem(cadastrarItem, tokenUsuario);
		
		ListaItens lista = cliente.todosOsItens(filtros);
		
		for (Item item2 : lista.item) {
			System.out.println(item2.getNome());
		}
	}

}
