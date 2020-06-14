package com.bjsxt.pojo;



import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.bjsxt.common.valid.group.GroupA;
import com.bjsxt.common.valid.group.GroupB;

import lombok.Data;


@Data
public class Parent {
	
	@NotEmpty(message = "parent name cannot be empty", groups = {GroupB.class})
    private String name;

    @Email(message = "should be email format", groups = {GroupA.class})
    private String email;
    
}
