package com.xxxx.hrhealthcheck.dao;

import com.xxxx.hrhealthcheck.bean.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    public Admin getUserByMessage(@Param("username") String username, @Param("password") String password);
    public int getUserCount(@Param("username")String username);
    public int updateState(@Param("id") Integer id, @Param("state") Boolean state);
    public int addUser(Admin user);
    public int deleteUser(int id);
    public Admin getUpdateUser(int id);
    public int editUser(Admin user);
}
