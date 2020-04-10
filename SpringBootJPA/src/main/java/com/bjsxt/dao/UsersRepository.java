package com.bjsxt.dao;

import com.bjsxt.common.jpa.base.JpaBaseRepository;
import com.bjsxt.pojo.Users;
/**
 * 参数一 T :当前需要映射的实体
 * 参数二 ID :当前映射的实体中的OID的类型
 *
 */
public interface UsersRepository extends JpaBaseRepository<Users,Integer> {

}
