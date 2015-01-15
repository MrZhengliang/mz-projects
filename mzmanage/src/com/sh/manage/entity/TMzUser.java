package com.sh.manage.entity;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TMzUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_mz_user"
    ,schema="mz"
)

public class TMzUser  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -3928340022908941246L;
	private Integer uid;
     private String email;
     private String nickname;
     private String username;
     private String password;
     private Integer status;
     private Integer emailstatus;
     private Integer avatarstatus;
     private Integer grade;
     private Integer adminid;
     private Integer groupid;
     private String groupName;
     private Integer credits;
     private Integer regdate;
     private String timeoffset;
     private Integer conisbind;
     private String provincecode;
     private String provincename;
     private String citycode;
     private String cityname;
     private Integer sex;
     private String userintro;


    // Constructors

    /** default constructor */
    public TMzUser() {
    }

    
    /** full constructor */
    public TMzUser(String email, String nickname, String username, String password, Integer status, Integer emailstatus, Integer avatarstatus, Integer grade, Integer adminid, Integer groupid, Integer credits, Integer regdate, String timeoffset, Integer conisbind, String provincecode, String provincename, String citycode, String cityname, Integer sex, String userintro) {
        this.email = email;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.status = status;
        this.emailstatus = emailstatus;
        this.avatarstatus = avatarstatus;
        this.grade = grade;
        this.adminid = adminid;
        this.groupid = groupid;
        this.credits = credits;
        this.regdate = regdate;
        this.timeoffset = timeoffset;
        this.conisbind = conisbind;
        this.provincecode = provincecode;
        this.provincename = provincename;
        this.citycode = citycode;
        this.cityname = cityname;
        this.sex = sex;
        this.userintro = userintro;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="uid", unique=true, nullable=false)

    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    @Column(name="email", length=40)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="nickname", length=40)

    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    @Column(name="username", length=15)

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="password")

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="status")

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    @Column(name="emailstatus")

    public Integer getEmailstatus() {
        return this.emailstatus;
    }
    
    public void setEmailstatus(Integer emailstatus) {
        this.emailstatus = emailstatus;
    }
    
    @Column(name="avatarstatus")

    public Integer getAvatarstatus() {
        return this.avatarstatus;
    }
    
    public void setAvatarstatus(Integer avatarstatus) {
        this.avatarstatus = avatarstatus;
    }
    
    @Column(name="grade")

    public Integer getGrade() {
        return this.grade;
    }
    
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    
    @Column(name="adminid")

    public Integer getAdminid() {
        return this.adminid;
    }
    
    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }
    
    @Column(name="groupid")

    public Integer getGroupid() {
        return this.groupid;
    }
    
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
    
    @Column(name="credits")

    public Integer getCredits() {
        return this.credits;
    }
    
    public void setCredits(Integer credits) {
        this.credits = credits;
    }
    
    @Column(name="regdate")

    public Integer getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(Integer regdate) {
        this.regdate = regdate;
    }
    
    @Column(name="timeoffset", length=4)

    public String getTimeoffset() {
        return this.timeoffset;
    }
    
    public void setTimeoffset(String timeoffset) {
        this.timeoffset = timeoffset;
    }
    
    @Column(name="conisbind")

    public Integer getConisbind() {
        return this.conisbind;
    }
    
    public void setConisbind(Integer conisbind) {
        this.conisbind = conisbind;
    }
    
    @Column(name="provincecode", length=20)

    public String getProvincecode() {
        return this.provincecode;
    }
    
    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }
    
    @Column(name="provincename", length=20)

    public String getProvincename() {
        return this.provincename;
    }
    
    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }
    
    @Column(name="citycode", length=20)

    public String getCitycode() {
        return this.citycode;
    }
    
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
    
    @Column(name="cityname", length=20)

    public String getCityname() {
        return this.cityname;
    }
    
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
    
    @Column(name="sex")

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    @Column(name="userintro")

    public String getUserintro() {
        return this.userintro;
    }
    
    public void setUserintro(String userintro) {
        this.userintro = userintro;
    }


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


}