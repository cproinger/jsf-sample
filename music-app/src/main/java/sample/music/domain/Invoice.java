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
//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.Timestamp;

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
 * <p>Title: Invoice</p>
 *
 * <p>Description: Domain Object describing a Invoice entity</p>
 *
 */
@Entity (name="Invoice")
@Table (name="Invoice")
//@NamedQueries ({
//	 @NamedQuery(name="Invoice.findAll", query="SELECT a FROM Invoice a")
//	,@NamedQuery(name="Invoice.findByInvoicedate", query="SELECT a FROM Invoice a WHERE a.invoicedate = :invoicedate")
//
//	,@NamedQuery(name="Invoice.findByBillingaddress", query="SELECT a FROM Invoice a WHERE a.billingaddress = :billingaddress")
//	,@NamedQuery(name="Invoice.findByBillingaddressContaining", query="SELECT a FROM Invoice a WHERE a.billingaddress like :billingaddress")
//
//	,@NamedQuery(name="Invoice.findByBillingcity", query="SELECT a FROM Invoice a WHERE a.billingcity = :billingcity")
//	,@NamedQuery(name="Invoice.findByBillingcityContaining", query="SELECT a FROM Invoice a WHERE a.billingcity like :billingcity")
//
//	,@NamedQuery(name="Invoice.findByBillingstate", query="SELECT a FROM Invoice a WHERE a.billingstate = :billingstate")
//	,@NamedQuery(name="Invoice.findByBillingstateContaining", query="SELECT a FROM Invoice a WHERE a.billingstate like :billingstate")
//
//	,@NamedQuery(name="Invoice.findByBillingcountry", query="SELECT a FROM Invoice a WHERE a.billingcountry = :billingcountry")
//	,@NamedQuery(name="Invoice.findByBillingcountryContaining", query="SELECT a FROM Invoice a WHERE a.billingcountry like :billingcountry")
//
//	,@NamedQuery(name="Invoice.findByBillingpostalcode", query="SELECT a FROM Invoice a WHERE a.billingpostalcode = :billingpostalcode")
//	,@NamedQuery(name="Invoice.findByBillingpostalcodeContaining", query="SELECT a FROM Invoice a WHERE a.billingpostalcode like :billingpostalcode")
//
//	,@NamedQuery(name="Invoice.findByTotal", query="SELECT a FROM Invoice a WHERE a.total = :total")
//
//})

public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Invoice.findAll";
    public static final String FIND_BY_INVOICEDATE = "Invoice.findByInvoicedate";
    public static final String FIND_BY_BILLINGADDRESS = "Invoice.findByBillingaddress";
    public static final String FIND_BY_BILLINGADDRESS_CONTAINING ="Invoice.findByBillingaddressContaining";
    public static final String FIND_BY_BILLINGCITY = "Invoice.findByBillingcity";
    public static final String FIND_BY_BILLINGCITY_CONTAINING ="Invoice.findByBillingcityContaining";
    public static final String FIND_BY_BILLINGSTATE = "Invoice.findByBillingstate";
    public static final String FIND_BY_BILLINGSTATE_CONTAINING ="Invoice.findByBillingstateContaining";
    public static final String FIND_BY_BILLINGCOUNTRY = "Invoice.findByBillingcountry";
    public static final String FIND_BY_BILLINGCOUNTRY_CONTAINING ="Invoice.findByBillingcountryContaining";
    public static final String FIND_BY_BILLINGPOSTALCODE = "Invoice.findByBillingpostalcode";
    public static final String FIND_BY_BILLINGPOSTALCODE_CONTAINING ="Invoice.findByBillingpostalcodeContaining";
    public static final String FIND_BY_TOTAL = "Invoice.findByTotal";
	
    @Id @Column(name="Invoice_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @InvoiceDate-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @InvoiceDate-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-InvoiceDate@
    @Column(name="InvoiceDate"   , nullable=false , unique=false)
    private Timestamp invoicedate; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @BillingAddress-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @BillingAddress-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-BillingAddress@
    @Column(name="BillingAddress"  , length=70 , nullable=true , unique=false)
    private String billingaddress; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @BillingCity-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @BillingCity-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-BillingCity@
    @Column(name="BillingCity"  , length=40 , nullable=true , unique=false)
    private String billingcity; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @BillingState-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @BillingState-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-BillingState@
    @Column(name="BillingState"  , length=40 , nullable=true , unique=false)
    private String billingstate; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @BillingCountry-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @BillingCountry-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-BillingCountry@
    @Column(name="BillingCountry"  , length=40 , nullable=true , unique=false)
    private String billingcountry; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @BillingPostalCode-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @BillingPostalCode-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-BillingPostalCode@
    @Column(name="BillingPostalCode"  , length=10 , nullable=true , unique=false)
    private String billingpostalcode; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @Total-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Total-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Total@
    @Column(name="Total"   , nullable=false , unique=false)
    private java.math.BigDecimal total; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="Customer_id", referencedColumnName = "Customer_id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Customer customer;  

    @Column(name="Customer_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer customerid_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @invoicelineInvoiceViaInvoiceid-field-invoice@
//    @OneToMany (targetEntity=example.chinook.domain.Invoiceline.class, fetch=FetchType.LAZY, mappedBy="invoice", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
//    private Set <Invoiceline> invoicelineInvoiceViaInvoiceid = new HashSet<Invoiceline>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Invoice() {
    }

    public Integer getId() {
        return id;
    }

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-InvoiceDate@
    public Timestamp getInvoicedate() {
        return invoicedate;
    }
	
    public void setInvoicedate (Timestamp invoicedate) {
        this.invoicedate =  invoicedate;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-BillingAddress@
    public String getBillingaddress() {
        return billingaddress;
    }
	
    public void setBillingaddress (String billingaddress) {
        this.billingaddress =  billingaddress;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-BillingCity@
    public String getBillingcity() {
        return billingcity;
    }
	
    public void setBillingcity (String billingcity) {
        this.billingcity =  billingcity;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-BillingState@
    public String getBillingstate() {
        return billingstate;
    }
	
    public void setBillingstate (String billingstate) {
        this.billingstate =  billingstate;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-BillingCountry@
    public String getBillingcountry() {
        return billingcountry;
    }
	
    public void setBillingcountry (String billingcountry) {
        this.billingcountry =  billingcountry;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-BillingPostalCode@
    public String getBillingpostalcode() {
        return billingpostalcode;
    }
	
    public void setBillingpostalcode (String billingpostalcode) {
        this.billingpostalcode =  billingpostalcode;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Total@
    public java.math.BigDecimal getTotal() {
        return total;
    }
	
    public void setTotal (java.math.BigDecimal total) {
        this.total =  total;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Customer getCustomer () {
    	return customer;
    }
	
    public void setCustomer (Customer customer) {
    	this.customer = customer;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @invoicelineInvoiceViaInvoiceid-getter-invoice@
//    public Set<Invoiceline> getInvoicelineInvoiceViaInvoiceid() {
//        if (invoicelineInvoiceViaInvoiceid == null){
//            invoicelineInvoiceViaInvoiceid = new HashSet<Invoiceline>();
//        }
//        return invoicelineInvoiceViaInvoiceid;
//    }
//
//    public void setInvoicelineInvoiceViaInvoiceid (Set<Invoiceline> invoicelineInvoiceViaInvoiceid) {
//        this.invoicelineInvoiceViaInvoiceid = invoicelineInvoiceViaInvoiceid;
//    }	
//    
//    public void addInvoicelineInvoiceViaInvoiceid (Invoiceline element) {
//    	    getInvoicelineInvoiceViaInvoiceid().add(element);
//    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
