package com.sh.manage.entity;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TMzArea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_mz_area"
    ,schema="mz"
)

public class TMzArea  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 5969408288235101895L;
	private Integer id;
     private String areacode;
     private String areaname;
     private boolean areagrade;
     private Integer parentcode;


    // Constructors

    /** default constructor */
    public TMzArea() {
    }

    
    /** full constructor */
    public TMzArea(String areacode, String areaname, boolean areagrade, Integer parentcode) {
        this.areacode = areacode;
        this.areaname = areaname;
        this.areagrade = areagrade;
        this.parentcode = parentcode;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="areacode", length=20)

    public String getAreacode() {
        return this.areacode;
    }
    
    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }
    
    @Column(name="areaname", length=20)

    public String getAreaname() {
        return this.areaname;
    }
    
    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }
    
    @Column(name="areagrade")

    public boolean getAreagrade() {
        return this.areagrade;
    }
    
    public void setAreagrade(boolean areagrade) {
        this.areagrade = areagrade;
    }
    
    @Column(name="parentcode")

    public Integer getParentcode() {
        return this.parentcode;
    }
    
    public void setParentcode(Integer parentcode) {
        this.parentcode = parentcode;
    }
   








}