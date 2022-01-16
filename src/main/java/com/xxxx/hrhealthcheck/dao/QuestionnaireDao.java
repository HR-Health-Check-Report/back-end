package com.xxxx.hrhealthcheck.dao;

import com.xxxx.hrhealthcheck.bean.Question;
import com.xxxx.hrhealthcheck.bean.Questionnaire;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionnaireDao {
    public List<Questionnaire> getAllQuestionnaire(@Param("pageStart") int pageStart, @Param("pageSize")int pageSize);
    public Questionnaire getQuestionnaire();
    public int getQuestionnaireCount(@Param("questionnaire") String questionnaire);
    public int updateState(@Param("id")Integer id, @Param("state") boolean state);
    public int addQuestionnaire(Questionnaire questionnaire);
    public List<Question> getQuestionList(@Param("groupId")int groupId, @Param("questionIds")int[] questionIDs, @Param("questionnaireId")int questionnaireID);
    public int addQuestion(@Param("questionIdList")int[] questionIdList);
}
