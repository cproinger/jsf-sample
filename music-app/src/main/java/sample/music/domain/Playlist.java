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
package sample.music.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * <p>Title: Playlist</p>
 *
 * <p>Description: Domain Object describing a Playlist entity</p>
 *
 */
@Entity (name="Playlist")
@Table (name="Playlist")
//@NamedQueries ({
//	 @NamedQuery(name="Playlist.findAll", query="SELECT a FROM Playlist a")
//	,@NamedQuery(name="Playlist.findByName", query="SELECT a FROM Playlist a WHERE a.name = :name")
//	,@NamedQuery(name="Playlist.findByNameContaining", query="SELECT a FROM Playlist a WHERE a.name like :name")
//
//})

public class Playlist implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Playlist.findAll";
    public static final String FIND_BY_NAME = "Playlist.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Playlist.findByNameContaining";
	
    @Id @Column(name="Playlist_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @Name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Name@
    @Column(name="Name"  , length=120 , nullable=true , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-trackPlaylisttrackViaTrackid-playlist@
    @ManyToMany
    @JoinTable(name="PLAYLISTTRACK", 
        joinColumns=@JoinColumn(name="Playlist_id"), 
        inverseJoinColumns=@JoinColumn(name="Track_id") 
    )
    private Set <Track> trackPlaylisttrackViaTrackid = new HashSet <Track> (); 
// playlisttrack.TrackId->track.TrackId -- playlisttrack.TrackId->track.TrackId
// TRACK_PLAYLISTTRACK_VIA_TRACKID

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Playlist() {
    }

    public Integer getId() {
        return id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @playlisttrackViaPlaylistByPlaylistid-getter-playlist@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Track> getTrackPlaylisttrackViaTrackid() {
        if (trackPlaylisttrackViaTrackid == null){
            trackPlaylisttrackViaTrackid = new HashSet<Track>();
        }
        return trackPlaylisttrackViaTrackid;
    }

    public void setTrackPlaylisttrackViaTrackid (Set<Track> trackPlaylisttrackViaTrackid) {
        this.trackPlaylisttrackViaTrackid = trackPlaylisttrackViaTrackid;
    }
    	
    public void addTrackPlaylisttrackViaTrackid (Track element) {
        getTrackPlaylisttrackViaTrackid().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
