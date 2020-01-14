package com.bjsxt.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude={"roles"})
@Entity
@Table(name="t_users")
public class Users implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="t_users_generator")
	@SequenceGenerator(name="t_users_generator", sequenceName="t_users_sequence", allocationSize = 1)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="address")
	private String address;
	
//	@JsonIgnore   //  设置@JsonIgnore,这个注解的意思是表示在序列化的时候，忽略这个属性
////	@ManyToOne(cascade=CascadeType.PERSIST)
//	@ManyToOne(fetch = FetchType.LAZY)
//	//@JoinColumn:维护外键
//	@JoinColumn(name="roles_id")
//	private Roles roles;

	
	
//	@Override
//	public String toString() {
//		return "Users [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
//	}

	
}
