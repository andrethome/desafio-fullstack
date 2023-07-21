package br.com.accenture.desafiofullstack.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;

	@Column(nullable = false, length = 14, unique = true)
	private String cnpjcpf;

	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = true, length = 10)
	private String rg;
	
	@Column(nullable = true, length = 10)
	private Date dtNascimento;
	
	@Column(nullable = false, length = 100, unique = true)
	private String email;

	@Column(nullable = false, length = 8)
	private String cep;

	public Fornecedor() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpjcpf() {
		return cnpjcpf;
	}

	public void setCnpjcpf(String cnpjcpf) {
		this.cnpjcpf = cnpjcpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((id == null) ? 0 : id.hashCode()); return result;
	 * }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Fornecedor other = (Fornecedor) obj; if (id == null) { if (other.id !=
	 * null) return false; } else if (!id.equals(other.id)) return false; return
	 * true; }
	 * 
	 * @Override public String toString() { return "Empresa [id=" + id + ", nome=" +
	 * nome + "]"; }
	 */
}
