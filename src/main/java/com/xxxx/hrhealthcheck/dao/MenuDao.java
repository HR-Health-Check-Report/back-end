package com.xxxx.hrhealthcheck.dao;

import com.xxxx.hrhealthcheck.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
