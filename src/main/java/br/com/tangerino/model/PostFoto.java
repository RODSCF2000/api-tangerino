package br.com.tangerino.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the post_foto database table.
 * 
 */
@Entity
@Table(name="post_foto")
@NamedQuery(name="PostFoto.findAll", query="SELECT p FROM PostFoto p")
public class PostFoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private byte[] foto;

	@ManyToOne
	@JoinColumn(name="post_id", insertable = false, updatable = false)
	private Post post;

	public PostFoto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}