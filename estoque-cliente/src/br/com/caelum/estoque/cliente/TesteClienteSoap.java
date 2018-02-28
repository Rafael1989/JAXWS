package br.com.caelum.estoque.cliente;

public class TesteClienteSoap {
	
	public static void main(String[] args) {
		EstoqueWS cliente = new EstoqueWS_Service().getEstoqueWSPort();
		Filtro filtro = new Filtro();
		filtro.setNome("Iphone");
		filtro.setTipo("Livro");
		Filtros filtros = new Filtros();
		filtros.getFiltro().add(filtro);
		ListaItens lista = cliente.todosOsItens(filtros);
		System.out.println(lista);
		System.out.println(cliente);
	}

}
