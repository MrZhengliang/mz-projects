package com.sh.manage.entity;

// default package

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TMzArticleContent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_mz_articlecontent"
    ,schema="mz"
)

public class TMzArticleContent  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	 private static final long serialVersionUID = 37931208900748582L;
	 private Integer cid;
	 /**
	  * 用户ID；根据idType判断是系统用户还是前台会员
	  */
     private Integer uid;
     /**
      * 1 管理系统人员
      * 2 网站会员
      */
     private Integer idtype;
     private String telephone;
     private String qqcode;
     private String email;
     private String title;
     private String privurl;
     private String cityname;
     private String lat;
     private String lng;
     private String address;
     private String starttime;
     private String closetime;
     /**
      * 票价方式 1 免费  2 收费
      */
     private Integer pricetype;
     private double price;
     /**
      * 订票方式 电话 、网络、售票点
      */
     private String tickettype;
     /**
      * 网络售票地址
      */
     private String netticketaddress;
     private String content;
     private String dateline;
     /**
      * 漫展封面图片,对应t_mz_attachment表的aid
      */
     private Integer faceimg;
     
     //漫展状态，0 待审核；1 已审核,上线； 9 下线。
     private Integer status;

    // Constructors

    /** default constructor */
    public TMzArticleContent() {
    }

    
    /** full constructor */
    public TMzArticleContent(Integer uid, Integer idtype, String telephone, String qqcode, String email, String title, String privurl, String cityname, String lat, String lng, String address, String starttime, String closetime, Integer pricetype, double price, String tickettype, String netticketaddress, String content, String dateline, Integer faceimg) {
        this.uid = uid;
        this.idtype = idtype;
        this.telephone = telephone;
        this.qqcode = qqcode;
        this.email = email;
        this.title = title;
        this.privurl = privurl;
        this.cityname = cityname;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.starttime = starttime;
        this.closetime = closetime;
        this.pricetype = pricetype;
        this.price = price;
        this.tickettype = tickettype;
        this.netticketaddress = netticketaddress;
        this.content = content;
        this.dateline = dateline;
        this.faceimg = faceimg;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="cid", unique=true, nullable=false)

    public Integer getCid() {
        return this.cid;
    }
    
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    
    @Column(name="uid")

    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    @Column(name="idtype")

    public Integer getIdtype() {
        return this.idtype;
    }
    
    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }
    
    @Column(name="telephone", length=40)

    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    @Column(name="qqcode", length=40)

    public String getQqcode() {
        return this.qqcode;
    }
    
    public void setQqcode(String qqcode) {
        this.qqcode = qqcode;
    }
    
    @Column(name="email", length=40)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="title")

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="privurl", length=100)

    public String getPrivurl() {
        return this.privurl;
    }
    
    public void setPrivurl(String privurl) {
        this.privurl = privurl;
    }
    
    @Column(name="cityname", length=20)

    public String getCityname() {
        return this.cityname;
    }
    
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
    
    @Column(name="lat", length=50)

    public String getLat() {
        return this.lat;
    }
    
    public void setLat(String lat) {
        this.lat = lat;
    }
    
    @Column(name="lng", length=50)

    public String getLng() {
        return this.lng;
    }
    
    public void setLng(String lng) {
        this.lng = lng;
    }
    
    @Column(name="address", length=100)

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="starttime")
    public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
   
    
    @Column(name="closetime")
    public String getClosetime() {
		return closetime;
	}


	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}
    
    @Column(name="pricetype")
    public Integer getPricetype() {
		return pricetype;
	}


	public void setPricetype(Integer pricetype) {
		this.pricetype = pricetype;
	}
    
    @Column(name="price")
    public double getPrice() {
        return this.price;
    }
    
    


	public void setPrice(double price) {
        this.price = price;
    }
    
    @Column(name="tickettype", length=50)

    public String getTickettype() {
        return this.tickettype;
    }
    
    public void setTickettype(String tickettype) {
        this.tickettype = tickettype;
    }
    
    @Column(name="netticketaddress")

    public String getNetticketaddress() {
        return this.netticketaddress;
    }
    
    public void setNetticketaddress(String netticketaddress) {
        this.netticketaddress = netticketaddress;
    }
    
    @Column(name="content", length=65535)

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name="dateline")

    public String getDateline() {
        return this.dateline;
    }
    
    public void setDateline(String dateline) {
        this.dateline = dateline;
    }
    
    @Column(name="faceimg")

    public Integer getFaceimg() {
        return this.faceimg;
    }
    
    public void setFaceimg(Integer faceimg) {
        this.faceimg = faceimg;
    }


    @Column(name="status")
	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}
}