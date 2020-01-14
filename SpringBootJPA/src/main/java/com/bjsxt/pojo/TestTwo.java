package com.bjsxt.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 通过ins-framework-mybatis-generator工具自动生成，请勿手工修改。表test_two的PO对象<br/>
 * 对应表名：test_two
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "test_two")
public class TestTwo implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 对应字段：id */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** 对应字段：name */
	@Column(name = "name")
	private String name;
	/** 对应字段：password */
	@Column(name = "password")
	private String password;
}
