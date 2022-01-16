package com.xxxx.hrhealthcheck.dao;

import com.xxxx.hrhealthcheck.bean.GroupGradingContent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupGradingContentDao {
    public GroupGradingContent getContent(@Param("group")int group, @Param("score")int score);
}
