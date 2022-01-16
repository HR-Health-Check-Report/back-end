package com.xxxx.hrhealthcheck.dao;

import com.xxxx.hrhealthcheck.bean.QuestionType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionTypeDao {

    public List<QuestionType> getAllQuestionType(@Param("pageStart") int pageStart, @Param("pageSize")int pageSize);
    public int getQuestionTypeCount();

    public int addQuestionType(QuestionType type);

    public int deleteQuestionType(int id);

    public String getQuestionTypeDescription(int id);

}
