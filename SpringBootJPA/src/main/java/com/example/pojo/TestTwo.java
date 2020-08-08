package com.example.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * 通过ins-framework-mybatis-generator工具自动生成，请勿手工修改。表test_two的PO对象<br/>
 * 对应表名：test_two
 *
 */
//@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
@Table(name = "test_two")
public class TestTwo implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 对应字段：id */
	@Id
	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	/** 对应字段：name */
	@Column(name = "name")
	private String name;
	/** 对应字段：password */
	@Column(name = "password")
	private String password;
	
	@OneToMany(cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "testTwo")
	private List<TestTwoKey> testTwoKeyList = new ArrayList<TestTwoKey>();

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TestTwoKey> getTestTwoKeyList() {
		return testTwoKeyList;
	}

	public void setTestTwoKeyList(List<TestTwoKey> testTwoKeyList) {
		this.testTwoKeyList = testTwoKeyList;
	}
	
}
