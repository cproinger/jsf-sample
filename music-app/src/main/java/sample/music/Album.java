/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9.5
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2015/08/30 n. Chr. at 09:45:11 MESZ
*/
package sample.music;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.JoinFormula;

/**
 *
 * <p>Title: Album</p>
 *
 * <p>Description: Domain Object describing a Album entity</p>
 *
 */
@Entity (name="Album")
@Table (name="Album")
@NamedQueries ({
	 @NamedQuery(name="Album.findAll", query="SELECT a FROM Album a")
	,@NamedQuery(name="Album.findByTitle", query="SELECT a FROM Album a WHERE a.title = :title")
	,@NamedQuery(name="Album.findByTitleContaining", query="SELECT a FROM Album a WHERE a.title like :title")

})

public class Album implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Album.findAll";
    public static final String FIND_BY_TITLE = "Album.findByTitle";
    public static final String FIND_BY_TITLE_CONTAINING ="Album.findByTitleContaining";
	
    @Id @Column(name="Album_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    /**
     * lazy mapping of the track-count of this album
     */
    @ManyToOne(fetch = FetchType.LAZY)
//    @OneToOne(fetch = FetchType.LAZY) //-> NPE: Hibernate Bug?
    @JoinFormula(value = "Album_id", referencedColumnName = "Album_id")
    private AlbumTracks albumTracks;

//MP-MANAGED-ADDED-AREA-BEGINNING @Title-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Title-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Title@
    @Column(name="Title"  , length=160 , nullable=false , unique=false)
    private String title; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="Artist_id", referencedColumnName = "Artist_id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Artist artist;  

//    @Column(name="Artist_id"  , nullable=false , unique=true, insertable=false, updatable=false)
//    private Integer artistid_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @trackAlbumViaAlbumid-field-album@
    @OneToMany (targetEntity=sample.music.Track.class, fetch=FetchType.LAZY, mappedBy="album", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Track> tracks = new HashSet<Track>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Album() {
    }

    public Integer getId() {
        return id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Title@
    public String getTitle() {
        return title;
    }
	
    public void setTitle (String title) {
        this.title =  title;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Artist getArtist () {
    	return artist;
    }
    
//    public String getArtistName() {
//    	return artist == null ? null : artist.getName();
//    }
	
    public void setArtist(Artist artistid) {
    	this.artist = artistid;
    }

//    public Integer getArtistid_() {
//        return artistid_;
//    }
//	
//    public void setArtistid_ (Integer artistid) {
//        this.artistid_ =  artistid;
//    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @trackAlbumViaAlbumid-getter-album@
    public Set<Track> getTracks() {
        if (tracks == null){
            tracks = new HashSet<Track>();
        }
        return tracks;
    }

    public void setTracks (Set<Track> trackAlbumViaAlbumid) {
        this.tracks = trackAlbumViaAlbumid;
    }	
    
    public void addTrack (Track element) {
    	    getTracks().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
