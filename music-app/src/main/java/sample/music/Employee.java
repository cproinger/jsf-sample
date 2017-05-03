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
 * <p>Title: Employee</p>
 *
 * <p>Description: Domain Object describing a Employee entity</p>
 *
 */
@Entity (name="Employee")
@Table (name="Employee")
//@NamedQueries ({
//	 @NamedQuery(name="Employee.findAll", query="SELECT a FROM Employee a")
//	,@NamedQuery(name="Employee.findByLastname", query="SELECT a FROM Employee a WHERE a.lastname = :lastname")
//	,@NamedQuery(name="Employee.findByLastnameContaining", query="SELECT a FROM Employee a WHERE a.lastname like :lastname")
//
//	,@NamedQuery(name="Employee.findByFirstname", query="SELECT a FROM Employee a WHERE a.firstname = :firstname")
//	,@NamedQuery(name="Employee.findByFirstnameContaining", query="SELECT a FROM Employee a WHERE a.firstname like :firstname")
//
//	,@NamedQuery(name="Employee.findByTitle", query="SELECT a FROM Employee a WHERE a.title = :title")
//	,@NamedQuery(name="Employee.findByTitleContaining", query="SELECT a FROM Employee a WHERE a.title like :title")
//
//	,@NamedQuery(name="Employee.findByBirthdate", query="SELECT a FROM Employee a WHERE a.birthdate = :birthdate")
//
//	,@NamedQuery(name="Employee.findByHiredate", query="SELECT a FROM Employee a WHERE a.hiredate = :hiredate")
//
//	,@NamedQuery(name="Employee.findByAddress", query="SELECT a FROM Employee a WHERE a.address = :address")
//	,@NamedQuery(name="Employee.findByAddressContaining", query="SELECT a FROM Employee a WHERE a.address like :address")
//
//	,@NamedQuery(name="Employee.findByCity", query="SELECT a FROM Employee a WHERE a.city = :city")
//	,@NamedQuery(name="Employee.findByCityContaining", query="SELECT a FROM Employee a WHERE a.city like :city")
//
//	,@NamedQuery(name="Employee.findByState", query="SELECT a FROM Employee a WHERE a.state = :state")
//	,@NamedQuery(name="Employee.findByStateContaining", query="SELECT a FROM Employee a WHERE a.state like :state")
//
//	,@NamedQuery(name="Employee.findByCountry", query="SELECT a FROM Employee a WHERE a.country = :country")
//	,@NamedQuery(name="Employee.findByCountryContaining", query="SELECT a FROM Employee a WHERE a.country like :country")
//
//	,@NamedQuery(name="Employee.findByPostalcode", query="SELECT a FROM Employee a WHERE a.postalcode = :postalcode")
//	,@NamedQuery(name="Employee.findByPostalcodeContaining", query="SELECT a FROM Employee a WHERE a.postalcode like :postalcode")
//
//	,@NamedQuery(name="Employee.findByPhone", query="SELECT a FROM Employee a WHERE a.phone = :phone")
//	,@NamedQuery(name="Employee.findByPhoneContaining", query="SELECT a FROM Employee a WHERE a.phone like :phone")
//
//	,@NamedQuery(name="Employee.findByFax", query="SELECT a FROM Employee a WHERE a.fax = :fax")
//	,@NamedQuery(name="Employee.findByFaxContaining", query="SELECT a FROM Employee a WHERE a.fax like :fax")
//
//	,@NamedQuery(name="Employee.findByEmail", query="SELECT a FROM Employee a WHERE a.email = :email")
//	,@NamedQuery(name="Employee.findByEmailContaining", query="SELECT a FROM Employee a WHERE a.email like :email")
//
//})

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Employee.findAll";
    public static final String FIND_BY_LASTNAME = "Employee.findByLastname";
    public static final String FIND_BY_LASTNAME_CONTAINING ="Employee.findByLastnameContaining";
    public static final String FIND_BY_FIRSTNAME = "Employee.findByFirstname";
    public static final String FIND_BY_FIRSTNAME_CONTAINING ="Employee.findByFirstnameContaining";
    public static final String FIND_BY_TITLE = "Employee.findByTitle";
    public static final String FIND_BY_TITLE_CONTAINING ="Employee.findByTitleContaining";
    public static final String FIND_BY_BIRTHDATE = "Employee.findByBirthdate";
    public static final String FIND_BY_HIREDATE = "Employee.findByHiredate";
    public static final String FIND_BY_ADDRESS = "Employee.findByAddress";
    public static final String FIND_BY_ADDRESS_CONTAINING ="Employee.findByAddressContaining";
    public static final String FIND_BY_CITY = "Employee.findByCity";
    public static final String FIND_BY_CITY_CONTAINING ="Employee.findByCityContaining";
    public static final String FIND_BY_STATE = "Employee.findByState";
    public static final String FIND_BY_STATE_CONTAINING ="Employee.findByStateContaining";
    public static final String FIND_BY_COUNTRY = "Employee.findByCountry";
    public static final String FIND_BY_COUNTRY_CONTAINING ="Employee.findByCountryContaining";
    public static final String FIND_BY_POSTALCODE = "Employee.findByPostalcode";
    public static final String FIND_BY_POSTALCODE_CONTAINING ="Employee.findByPostalcodeContaining";
    public static final String FIND_BY_PHONE = "Employee.findByPhone";
    public static final String FIND_BY_PHONE_CONTAINING ="Employee.findByPhoneContaining";
    public static final String FIND_BY_FAX = "Employee.findByFax";
    public static final String FIND_BY_FAX_CONTAINING ="Employee.findByFaxContaining";
    public static final String FIND_BY_EMAIL = "Employee.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING ="Employee.findByEmailContaining";
	
    @Id @Column(name="Employee_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//MP-MANAGED-ADDED-AREA-BEGINNING @LastName-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @LastName-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-LastName@
    @Column(name="LastName"  , length=20 , nullable=false , unique=false)
    private String lastname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @FirstName-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @FirstName-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-FirstName@
    @Column(name="FirstName"  , length=20 , nullable=false , unique=false)
    private String firstname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @Title-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @Title-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-Title@
    @Column(name="Title"  , length=30 , nullable=true , unique=false)
    private String title; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @BirthDate-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @BirthDate-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-BirthDate@
    @Column(name="BirthDate"   , nullable=true , unique=false)
    private Timestamp birthdate; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @HireDate-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @HireDate-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-HireDate@
    @Column(name="HireDate"   , nullable=true , unique=false)
    private Timestamp hiredate; 
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
    @Column(name="Email"  , length=60 , nullable=true , unique=false)
    private String email; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="ReportsTo", referencedColumnName = "Employee_id" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Employee reportsto;  

    @Column(name="ReportsTo"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer reportsto_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @customerEmployeeViaSupportrepid-field-employee@
//    @OneToMany (targetEntity=example.chinook.domain.Customer.class, fetch=FetchType.LAZY, mappedBy="supportrep", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
//    private Set <Customer> customerEmployeeViaSupportrepid = new HashSet<Customer>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @employeeEmployeeViaReportsto-field-employee@
//    @OneToMany (targetEntity=example.chinook.domain.Employee.class, fetch=FetchType.LAZY, mappedBy="reportsto", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
//    private Set <Employee> employeeEmployeeViaReportsto = new HashSet<Employee>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Employee() {
    }

    public Integer getId() {
        return id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-LastName@
    public String getLastname() {
        return lastname;
    }
	
    public void setLastname (String lastname) {
        this.lastname =  lastname;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-FirstName@
    public String getFirstname() {
        return firstname;
    }
	
    public void setFirstname (String firstname) {
        this.firstname =  firstname;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-Title@
    public String getTitle() {
        return title;
    }
	
    public void setTitle (String title) {
        this.title =  title;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-BirthDate@
    public Timestamp getBirthdate() {
        return birthdate;
    }
	
    public void setBirthdate (Timestamp birthdate) {
        this.birthdate =  birthdate;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-HireDate@
    public Timestamp getHiredate() {
        return hiredate;
    }
	
    public void setHiredate (Timestamp hiredate) {
        this.hiredate =  hiredate;
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


    public Employee getReportsto () {
    	return reportsto;
    }
	
    public void setReportsto (Employee reportsto) {
    	this.reportsto = reportsto;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @customerEmployeeViaSupportrepid-getter-employee@
//    public Set<Customer> getCustomerEmployeeViaSupportrepid() {
//        if (customerEmployeeViaSupportrepid == null){
//            customerEmployeeViaSupportrepid = new HashSet<Customer>();
//        }
//        return customerEmployeeViaSupportrepid;
//    }
//
//    public void setCustomerEmployeeViaSupportrepid (Set<Customer> customerEmployeeViaSupportrepid) {
//        this.customerEmployeeViaSupportrepid = customerEmployeeViaSupportrepid;
//    }	
//    
//    public void addCustomerEmployeeViaSupportrepid (Customer element) {
//    	    getCustomerEmployeeViaSupportrepid().add(element);
//    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @employeeEmployeeViaReportsto-getter-employee@
//    public Set<Employee> getEmployeeEmployeeViaReportsto() {
//        if (employeeEmployeeViaReportsto == null){
//            employeeEmployeeViaReportsto = new HashSet<Employee>();
//        }
//        return employeeEmployeeViaReportsto;
//    }
//
//    public void setEmployeeEmployeeViaReportsto (Set<Employee> employeeEmployeeViaReportsto) {
//        this.employeeEmployeeViaReportsto = employeeEmployeeViaReportsto;
//    }	
//    
//    public void addEmployeeEmployeeViaReportsto (Employee element) {
//    	    getEmployeeEmployeeViaReportsto().add(element);
//    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
