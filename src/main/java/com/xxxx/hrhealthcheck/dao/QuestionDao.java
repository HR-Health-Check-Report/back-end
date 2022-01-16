package com.xxxx.hrhealthcheck.dao;

import com.xxxx.hrhealthcheck.bean.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao {

    public List<Question> getAllQuestion(@Param("question") String question,
                                         @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getQuestionCount(@Param("question") String question);

    public int addQuestion(Question question);

    public int deleteQuestion(int id);

    public int updateState(@Param("id") Integer id, @Param("state") Boolean state);

    public int editQuestion(@Param("id") int id, @Param("question") String question, @Param("type") Integer type);

    public Question getQuestionInfo(@Param("id")Integer id);
}
