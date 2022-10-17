package br.ufsc.cursofs.AulaSpringBoot.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PedidoProduto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Embeddable
	public static class IdPk implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@ManyToOne
		@JoinColumn(name = "pedido_id")
		private Pedido pedido;
		
		@ManyToOne
		@JoinColumn(name = "produto_id")
		private Produto produto;
		public IdPk() {}
		public IdPk(Pedido pedido, Produto produto) {
			super();
			this.pedido = pedido;
			this.produto = produto;
		}
		public Pedido getPedido() {
			return pedido;
		}
		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}
		public Produto getProduto() {
			return produto;
		}
		public void setProduto(Produto produto) {
			this.produto = produto;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
			result = prime * result + ((produto == null) ? 0 : produto.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IdPk other = (IdPk) obj;
			if (pedido == null) {
				if (other.pedido != null)
					return false;
			} else if (!pedido.equals(other.pedido))
				return false;
			if (produto == null) {
				if (other.produto != null)
					return false;
			} else if (!produto.equals(other.produto))
				return false;
			return true;
		}
		
	}
	
	@EmbeddedId
	private IdPk id = new IdPk();
	private Double preco;
	private Double quantidade;
	
	public PedidoProduto() {}
	
	public PedidoProduto(Pedido pedido, Produto produto, Double preco, Double quantidade) {		
		this.preco = preco;
		this.quantidade = quantidade;
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getSubTotal() {
		return this.preco * this.quantidade;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoProduto other = (PedidoProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
