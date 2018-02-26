package br.com.caelum.estoque.ws;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date dataErro;
	
	private String mensagem;

	public InfoFault(String mensagem, Date dataErro) {
		this.mensagem = mensagem;
		this.dataErro = dataErro;
	}
	
	public InfoFault() {
	}

}
