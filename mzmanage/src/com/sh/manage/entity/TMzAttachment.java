package com.sh.manage.entity;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TMzAttachment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_sys_attachment"
    ,schema="mz"
)

public class TMzAttachment  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -4025325275332161751L;
	private Integer aid;
     private boolean type;
     private Integer uid;
     private Integer downloads;
     private String filename;
     private String newfilename;
     private String filepath;
     private Integer uploadtime;


    // Constructors

    /** default constructor */
    public TMzAttachment() {
    }

    
    /** full constructor */
    public TMzAttachment(boolean type, Integer uid, Integer downloads, String filename, String newfilename, String filepath, Integer uploadtime) {
        this.type = type;
        this.uid = uid;
        this.downloads = downloads;
        this.filename = filename;
        this.newfilename = newfilename;
        this.filepath = filepath;
        this.uploadtime = uploadtime;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="aid", unique=true, nullable=false)

    public Integer getAid() {
        return this.aid;
    }
    
    public void setAid(Integer aid) {
        this.aid = aid;
    }
    
    @Column(name="type")

    public boolean getType() {
        return this.type;
    }
    
    public void setType(boolean type) {
        this.type = type;
    }
    
    @Column(name="uid")

    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    @Column(name="downloads")

    public Integer getDownloads() {
        return this.downloads;
    }
    
    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }
    
    @Column(name="filename", length=100)

    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    @Column(name="newfilename", length=100)

    public String getNewfilename() {
        return this.newfilename;
    }
    
    public void setNewfilename(String newfilename) {
        this.newfilename = newfilename;
    }
    
    @Column(name="filepath", length=100)

    public String getFilepath() {
        return this.filepath;
    }
    
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    
    @Column(name="uploadtime")

    public Integer getUploadtime() {
        return this.uploadtime;
    }
    
    public void setUploadtime(Integer uploadtime) {
        this.uploadtime = uploadtime;
    }
   








}