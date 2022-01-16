package com.xxxx.hrhealthcheck;

import com.alibaba.fastjson.JSON;
import com.xxxx.hrhealthcheck.bean.Question;
import com.xxxx.hrhealthcheck.bean.Questionnaire;
import com.xxxx.hrhealthcheck.dao.QuestionnaireDao;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class SportplayApplicationTests {
    @Autowired
    QuestionnaireDao questionnaireDao;

    @Before
    public void init() {
        System.out.println("start-----------------");
    }

    @Test
    public void Test() {
        Questionnaire questionnaire = questionnaireDao.getQuestionnaire();
        List<Question> allQuestions = questionnaire.getQuestions();
        int len = allQuestions.size();

        ArrayList<HashMap<String,Object>> res = new ArrayList<>();

        for (int i=0;i<len;i++) {
            boolean questionIsGrouped = false;
            String title = allQuestions.get(i).getQuestionType().getDescription();
            String questionContent = allQuestions.get(i).getQuestion();
            int questionID = allQuestions.get(i).getId();
            if (!res.isEmpty()){
                for (HashMap group:res){
                    if ( group.get("title").equals(title)){
                        ArrayList questionsList = (ArrayList) group.get("questions");
                        HashMap question = new HashMap();
                        question.put("id",questionID);
                        question.put("question",questionContent);

                        questionsList.add(question);
                        group.put("questions",questionsList);
                        questionIsGrouped = true;
                    }
                }
            }
            if (questionIsGrouped) continue;

            ArrayList<HashMap<String,Object>> questionsList = new ArrayList<>();
            HashMap question = new HashMap();

            question.put("question",questionContent);
            question.put("id",questionID);

            HashMap<String,Object> temp = new HashMap<>();

            questionsList.add(question);
            temp.put("title",title);
            temp.put("questions",questionsList);
            res.add(temp);
        }

        String res_string = JSON.toJSONString(res);
        System.out.println(res_string);
    }
    @After
    public void after() {
        System.out.println("end-----------------");
    }
}