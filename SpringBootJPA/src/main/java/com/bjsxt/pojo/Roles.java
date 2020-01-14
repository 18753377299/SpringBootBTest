package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * @Description: 一个角色对应多个用户
 * @author: liqiankun 20200108
 * @time:
 * @修改记录: 
 * @return
 */

//@ToString(exclude={"users","menus"})
@ToString(exclude={"users"})
@Data
@Entity
@Table(name="t_roles")
public class Roles implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleid")
	private Integer roleid;
	
	@Column(name="rolename")
	private String rolename;
	
//	@OneToMany(mappedBy="roles")
//	@OneToMany(cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")
//	private Set<Users> users = new HashSet<>();

	
//	@JsonIgnore   //  设置@JsonIgnore,这个注解的意思是表示在序列化的时候，忽略这个属性
//	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
//	//@JoinTable:映射中间表
//	//joinColumns:当前表中的主键所关联的中间表中的外键字段
//	@JoinTable(name="t_roles_menus",joinColumns=@JoinColumn(name="role_id"),inverseJoinColumns=@JoinColumn(name="menu_id"))
//	private Set<Menus> menus = new HashSet<>();

	
}
