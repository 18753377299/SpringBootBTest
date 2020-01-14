package com.bjsxt.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @Description: 菜单和用户是多对多的关系
 * @author: liqiankun 20200108
 * @time:
 * @修改记录: 
 * @return
 */
@Data
//@Entity
//@Table(name="t_menus")
public class Menus {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="menusid")
//	private Integer menusid;
//	
//	@Column(name="menusname")
//	private String menusname;
//	
//	@Column(name="menusurl")
//	private String menusurl;
//	
//	@Column(name="fatherid")
//	private Integer fatherid;
//	
//	@ManyToMany(mappedBy="menus")
//	private Set<Roles> roles = new HashSet<>();
//
//	@Override
//	public String toString() {
//		return "Menus [menusid=" + menusid + ", menusname=" + menusname + ", menusurl=" + menusurl + ", fatherid="
//				+ fatherid + "]";
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Menus other = (Menus) obj;
//		if (fatherid == null) {
//			if (other.fatherid != null)
//				return false;
//		} else if (!fatherid.equals(other.fatherid))
//			return false;
//		if (menusid == null) {
//			if (other.menusid != null)
//				return false;
//		} else if (!menusid.equals(other.menusid))
//			return false;
//		if (menusname == null) {
//			if (other.menusname != null)
//				return false;
//		} else if (!menusname.equals(other.menusname))
//			return false;
//		if (menusurl == null) {
//			if (other.menusurl != null)
//				return false;
//		} else if (!menusurl.equals(other.menusurl))
//			return false;
//		if (roles == null) {
//			if (other.roles != null)
//				return false;
//		} else if (!roles.equals(other.roles))
//			return false;
//		return true;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((fatherid == null) ? 0 : fatherid.hashCode());
//		result = prime * result + ((menusid == null) ? 0 : menusid.hashCode());
//		result = prime * result + ((menusname == null) ? 0 : menusname.hashCode());
//		result = prime * result + ((menusurl == null) ? 0 : menusurl.hashCode());
//		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
//		return result;
//	}
	
	
}
