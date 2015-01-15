package com.sh.manage.entity;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TMzGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_mz_group"
    ,schema="mz"
)

public class TMzGroup  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -2199570800814251259L;
	private short id;
     private String name;
     private boolean grouptype;


    // Constructors

    /** default constructor */
    public TMzGroup() {
    }

    
    /** full constructor */
    public TMzGroup(String name, boolean grouptype) {
        this.name = name;
        this.grouptype = grouptype;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)

    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    
    @Column(name="name")

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="grouptype")

    public boolean getGrouptype() {
        return this.grouptype;
    }
    
    public void setGrouptype(boolean grouptype) {
        this.grouptype = grouptype;
    }
   








}