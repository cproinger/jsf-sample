package sample.music;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "AlbumTracks")
@BatchSize(size = 20)
public class AlbumTracks {

	@Id
	@Column(name = "Album_id")
	private Integer id;
	
	private int count;
	
	public Integer getId() {
		return id;
	}
	
	public int getCount() {
		return count;
	}
}
