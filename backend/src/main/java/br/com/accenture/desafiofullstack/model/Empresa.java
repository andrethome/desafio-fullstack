package br.com.accenture.desafiofullstack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;

	@Column(nullable = false, length = 14, unique = true)
	private String cnpj;

	@Column(nullable = false, length = 100)
	private String nomefantasia;
	
	@Column(nullable = false, length = 8)
	private String cep;
	
	public Empresa() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
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
	 * false; Empresa other = (Empresa) obj; if (id == null) { if (other.id != null)
	 * return false; } else if (!id.equals(other.id)) return false; return true; }
	 * 
	 * @Override public String toString() { return "Empresa [id=" + id + ", nome=" +
	 * nomefantasia + "]"; }
	 */
}
