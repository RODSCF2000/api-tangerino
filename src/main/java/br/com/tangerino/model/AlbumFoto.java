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
 * The persistent class for the album_foto database table.
 * 
 */
@Entity
@Table(name="album_foto")
@NamedQuery(name="AlbumFoto.findAll", query="SELECT a FROM AlbumFoto a")
public class AlbumFoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="album_id", insertable = false, updatable = false)
	private Album album;

	private byte[] foto;

	public AlbumFoto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}