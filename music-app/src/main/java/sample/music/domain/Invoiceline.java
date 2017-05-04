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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * <p>Title: Invoiceline</p>
 *
 * <p>Description: Domain Object describing a Invoiceline entity</p>
 *
 */
@Entity (name="Invoiceline")
@Table (name="Invoiceline")
//@NamedQueries ({
//	 @NamedQuery(name="Invoiceline.findAll", query="SELECT a FROM Invoiceline a")
//	,@NamedQuery(name="Invoiceline.findByUnitprice", query="SELECT a FROM Invoiceline a WHERE a.unitprice = :unitprice")
//
//	,@NamedQuery(name="Invoiceline.findByQuantity", query="SELECT a FROM Invoiceline a WHERE a.quantity = :quantity")
//
//})

public class Invoiceline implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Invoiceline.findAll";
    public static final String FIND_BY_UNITPRICE = "Invoiceline.findByUnitprice";
    public static final String FIND_BY_QUANTITY = "Invoiceline.findByQuantity";
	
    @Id @Column(name="InvoiceLine_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @UnitPrice-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @UnitPrice-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-UnitPrice@
    @Column(name="UnitPrice"   , nullable=false , unique=false)
    private java.math.BigDecimal unitprice; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @Quantity-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Quantity-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Quantity@
    @Column(name="Quantity"   , nullable=false , unique=false)
    private Integer quantity; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="Invoice_id", referencedColumnName = "Invoice_id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Invoice invoice;  

    @Column(name="Invoice_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer invoiceid_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="Track_id", referencedColumnName = "Track_id" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Track track;  

    @Column(name="Track_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer trackid_;

    /**
    * Default constructor
    */
    public Invoiceline() {
    }
    
    public Integer getId() {
        return id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-UnitPrice@
    public java.math.BigDecimal getUnitprice() {
        return unitprice;
    }
	
    public void setUnitprice (java.math.BigDecimal unitprice) {
        this.unitprice =  unitprice;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Quantity@
    public Integer getQuantity() {
        return quantity;
    }
	
    public void setQuantity (Integer quantity) {
        this.quantity =  quantity;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Invoice getInvoiceid () {
    	return invoice;
    }
	
    public void setInvoiceid (Invoice invoiceid) {
    	this.invoice = invoiceid;
    }

    public Integer getInvoiceid_() {
        return invoiceid_;
    }
	
    public void setInvoiceid_ (Integer invoiceid) {
        this.invoiceid_ =  invoiceid;
    }
	
    public Track getTrackid () {
    	return track;
    }
	
    public void setTrackid (Track trackid) {
    	this.track = trackid;
    }

    public Integer getTrackid_() {
        return trackid_;
    }
	
    public void setTrackid_ (Integer trackid) {
        this.trackid_ =  trackid;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
