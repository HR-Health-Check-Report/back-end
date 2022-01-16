package com.xxxx.hrhealthcheck.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MiddleDao {
    public int addQuestion(@Param("questionnaireID")int questionnaire_id,@Param("questionList")int[] question_id);
}
