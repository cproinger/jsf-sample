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
 * <p>Title: Customer</p>
 *
 * <p>Description: Domain Object describing a Customer entity</p>
 *
 */
@Entity (name="Customer")
@Table (name="Customer")
//@NamedQueries ({
//	 @NamedQuery(name="Customer.findAll", query="SELECT a FROM Customer a")
//	,@NamedQuery(name="Customer.findByFirstname", query="SELECT a FROM Customer a WHERE a.firstname = :firstname")
//	,@NamedQuery(name="Customer.findByFirstnameContaining", query="SELECT a FROM Customer a WHERE a.firstname like :firstname")
//
//	,@NamedQuery(name="Customer.findByLastname", query="SELECT a FROM Customer a WHERE a.lastname = :lastname")
//	,@NamedQuery(name="Customer.findByLastnameContaining", query="SELECT a FROM Customer a WHERE a.lastname like :lastname")
//
//	,@NamedQuery(name="Customer.findByCompany", query="SELECT a FROM Customer a WHERE a.company = :company")
//	,@NamedQuery(name="Customer.findByCompanyContaining", query="SELECT a FROM Customer a WHERE a.company like :company")
//
//	,@NamedQuery(name="Customer.findByAddress", query="SELECT a FROM Customer a WHERE a.address = :address")
//	,@NamedQuery(name="Customer.findByAddressContaining", query="SELECT a FROM Customer a WHERE a.address like :address")
//
//	,@NamedQuery(name="Customer.findByCity", query="SELECT a FROM Customer a WHERE a.city = :city")
//	,@NamedQuery(name="Customer.findByCityContaining", query="SELECT a FROM Customer a WHERE a.city like :city")
//
//	,@NamedQuery(name="Customer.findByState", query="SELECT a FROM Customer a WHERE a.state = :state")
//	,@NamedQuery(name="Customer.findByStateContaining", query="SELECT a FROM Customer a WHERE a.state like :state")
//
//	,@NamedQuery(name="Customer.findByCountry", query="SELECT a FROM Customer a WHERE a.country = :country")
//	,@NamedQuery(name="Customer.findByCountryContaining", query="SELECT a FROM Customer a WHERE a.country like :country")
//
//	,@NamedQuery(name="Customer.findByPostalcode", query="SELECT a FROM Customer a WHERE a.postalcode = :postalcode")
//	,@NamedQuery(name="Customer.findByPostalcodeContaining", query="SELECT a FROM Customer a WHERE a.postalcode like :postalcode")
//
//	,@NamedQuery(name="Customer.findByPhone", query="SELECT a FROM Customer a WHERE a.phone = :phone")
//	,@NamedQuery(name="Customer.findByPhoneContaining", query="SELECT a FROM Customer a WHERE a.phone like :phone")
//
//	,@NamedQuery(name="Customer.findByFax", query="SELECT a FROM Customer a WHERE a.fax = :fax")
//	,@NamedQuery(name="Customer.findByFaxContaining", query="SELECT a FROM Customer a WHERE a.fax like :fax")
//
//	,@NamedQuery(name="Customer.findByEmail", query="SELECT a FROM Customer a WHERE a.email = :email")
//	,@NamedQuery(name="Customer.findByEmailContaining", query="SELECT a FROM Customer a WHERE a.email like :email")
//
//})

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Customer.findAll";
    public static final String FIND_BY_FIRSTNAME = "Customer.findByFirstname";
    public static final String FIND_BY_FIRSTNAME_CONTAINING ="Customer.findByFirstnameContaining";
    public static final String FIND_BY_LASTNAME = "Customer.findByLastname";
    public static final String FIND_BY_LASTNAME_CONTAINING ="Customer.findByLastnameContaining";
    public static final String FIND_BY_COMPANY = "Customer.findByCompany";
    public static final String FIND_BY_COMPANY_CONTAINING ="Customer.findByCompanyContaining";
    public static final String FIND_BY_ADDRESS = "Customer.findByAddress";
    public static final String FIND_BY_ADDRESS_CONTAINING ="Customer.findByAddressContaining";
    public static final String FIND_BY_CITY = "Customer.findByCity";
    public static final String FIND_BY_CITY_CONTAINING ="Customer.findByCityContaining";
    public static final String FIND_BY_STATE = "Customer.findByState";
    public static final String FIND_BY_STATE_CONTAINING ="Customer.findByStateContaining";
    public static final String FIND_BY_COUNTRY = "Customer.findByCountry";
    public static final String FIND_BY_COUNTRY_CONTAINING ="Customer.findByCountryContaining";
    public static final String FIND_BY_POSTALCODE = "Customer.findByPostalcode";
    public static final String FIND_BY_POSTALCODE_CONTAINING ="Customer.findByPostalcodeContaining";
    public static final String FIND_BY_PHONE = "Customer.findByPhone";
    public static final String FIND_BY_PHONE_CONTAINING ="Customer.findByPhoneContaining";
    public static final String FIND_BY_FAX = "Customer.findByFax";
    public static final String FIND_BY_FAX_CONTAINING ="Customer.findByFaxContaining";
    public static final String FIND_BY_EMAIL = "Customer.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING ="Customer.findByEmailContaining";
	
    @Id @Column(name="Customer_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @FirstName-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @FirstName-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-FirstName@
    @Column(name="FirstName"  , length=40 , nullable=false , unique=false)
    private String firstname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @LastName-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @LastName-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-LastName@
    @Column(name="LastName"  , length=20 , nullable=false , unique=false)
    private String lastname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @Company-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Company-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Company@
    @Column(name="Company"  , length=80 , nullable=true , unique=false)
    private String company; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @Address-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Address-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Address@
    @Column(name="Address"  , length=70 , nullable=true , unique=false)
    private String address; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @City-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @City-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-City@
    @Column(name="City"  , length=40 , nullable=true , unique=false)
    private String city; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @State-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @State-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-State@
    @Column(name="State"  , length=40 , nullable=true , unique=false)
    private String state; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @Country-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Country-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Country@
    @Column(name="Country"  , length=40 , nullable=true , unique=false)
    private String country; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @PostalCode-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @PostalCode-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-PostalCode@
    @Column(name="PostalCode"  , length=10 , nullable=true , unique=false)
    private String postalcode; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @Phone-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Phone-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Phone@
    @Column(name="Phone"  , length=24 , nullable=true , unique=false)
    private String phone; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @Fax-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Fax-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Fax@
    @Column(name="Fax"  , length=24 , nullable=true , unique=false)
    private String fax; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @Email-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Email-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Email@
    @Column(name="Email"  , length=60 , nullable=false , unique=false)
    private String email; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="SupportRep_id", referencedColumnName = "Employee_id" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Employee supportrep;  

    @Column(name="SupportRep_id"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer supportrepid_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @invoiceCustomerViaCustomerid-field-customer@
//    @OneToMany (targetEntity=example.chinook.domain.Invoice.class, fetch=FetchType.LAZY, mappedBy="customer", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
//    private Set <Invoice> invoiceCustomerViaCustomerid = new HashSet<Invoice>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Customer() {
    }

    public Integer getId() {
        return id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-FirstName@
    public String getFirstname() {
        return firstname;
    }
	
    public void setFirstname (String firstname) {
        this.firstname =  firstname;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-LastName@
    public String getLastname() {
        return lastname;
    }
	
    public void setLastname (String lastname) {
        this.lastname =  lastname;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Company@
    public String getCompany() {
        return company;
    }
	
    public void setCompany (String company) {
        this.company =  company;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Address@
    public String getAddress() {
        return address;
    }
	
    public void setAddress (String address) {
        this.address =  address;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-City@
    public String getCity() {
        return city;
    }
	
    public void setCity (String city) {
        this.city =  city;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-State@
    public String getState() {
        return state;
    }
	
    public void setState (String state) {
        this.state =  state;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Country@
    public String getCountry() {
        return country;
    }
	
    public void setCountry (String country) {
        this.country =  country;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-PostalCode@
    public String getPostalcode() {
        return postalcode;
    }
	
    public void setPostalcode (String postalcode) {
        this.postalcode =  postalcode;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Phone@
    public String getPhone() {
        return phone;
    }
	
    public void setPhone (String phone) {
        this.phone =  phone;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Fax@
    public String getFax() {
        return fax;
    }
	
    public void setFax (String fax) {
        this.fax =  fax;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Email@
    public String getEmail() {
        return email;
    }
	
    public void setEmail (String email) {
        this.email =  email;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Employee getSupportrep () {
    	return supportrep;
    }
	
    public void setSupportrep (Employee supportrepid) {
    	this.supportrep = supportrepid;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @invoiceCustomerViaCustomerid-getter-customer@
//    public Set<Invoice> getInvoiceCustomerViaCustomerid() {
//        if (invoiceCustomerViaCustomerid == null){
//            invoiceCustomerViaCustomerid = new HashSet<Invoice>();
//        }
//        return invoiceCustomerViaCustomerid;
//    }
//
//    public void setInvoiceCustomerViaCustomerid (Set<Invoice> invoiceCustomerViaCustomerid) {
//        this.invoiceCustomerViaCustomerid = invoiceCustomerViaCustomerid;
//    }	
//    
//    public void addInvoiceCustomerViaCustomerid (Invoice element) {
//    	    getInvoiceCustomerViaCustomerid().add(element);
//    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
