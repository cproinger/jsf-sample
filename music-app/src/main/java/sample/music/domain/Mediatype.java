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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

/**
 *
 * <p>Title: Mediatype</p>
 *
 * <p>Description: Domain Object describing a Mediatype entity</p>
 *
 */
@Entity (name="Mediatype")
@Table (name="Mediatype")
//@NamedQueries ({
//	 @NamedQuery(name="Mediatype.findAll", query="SELECT a FROM Mediatype a")
//	,@NamedQuery(name="Mediatype.findByName", query="SELECT a FROM Mediatype a WHERE a.name = :name")
//	,@NamedQuery(name="Mediatype.findByNameContaining", query="SELECT a FROM Mediatype a WHERE a.name like :name")
//
//})
@BatchSize(size = 20)
public class Mediatype implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Mediatype.findAll";
    public static final String FIND_BY_NAME = "Mediatype.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Mediatype.findByNameContaining";
	
    @Id @Column(name="MediaType_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @Name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Name@
    @Column(name="Name"  , length=120 , nullable=true , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @trackMediatypeViaMediatypeid-field-mediatype@
//    @OneToMany (targetEntity=example.chinook.domain.Track.class, fetch=FetchType.LAZY, mappedBy="mediatype", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
//    private Set <Track> trackMediatypeViaMediatypeid = new HashSet<Track>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Mediatype() {
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



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @trackMediatypeViaMediatypeid-getter-mediatype@
//    public Set<Track> getTrackMediatypeViaMediatypeid() {
//        if (trackMediatypeViaMediatypeid == null){
//            trackMediatypeViaMediatypeid = new HashSet<Track>();
//        }
//        return trackMediatypeViaMediatypeid;
//    }
//
//    public void setTrackMediatypeViaMediatypeid (Set<Track> trackMediatypeViaMediatypeid) {
//        this.trackMediatypeViaMediatypeid = trackMediatypeViaMediatypeid;
//    }	
    
//    public void addTrackMediatypeViaMediatypeid (Track element) {
//    	    getTrackMediatypeViaMediatypeid().add(element);
//    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
