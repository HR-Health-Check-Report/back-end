package com.xxxx.hrhealthcheck.controller;

import com.alibaba.fastjson.JSON;
import com.xxxx.hrhealthcheck.bean.*;
import com.xxxx.hrhealthcheck.dao.QuestionnaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class QuestionnaireController {

    @Autowired
    QuestionnaireDao questionnaireDao;

    @RequestMapping("/allquestionnaire")
    public String getAllQuestionnaire(QueryInfo queryInfo) {
        int number = questionnaireDao.getQuestionnaireCount("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Questionnaire> questionnaires = questionnaireDao.getAllQuestionnaire(pageStart, queryInfo.getPageSize());
        ArrayList<HashMap> result = new ArrayList<>();

        HashMap<String,Object> res = new HashMap<>();

        for(Questionnaire questionnaire:questionnaires){ //拿到一份卷子
            HashMap<String, Object> tempQuestionnaire = new HashMap<>(); //创建卷子map
            String questionnaireDescription = questionnaire.getDescription(); //获取description
            int questionnaireID = questionnaire.getId();//获取description
            boolean state = questionnaire.isState();
            tempQuestionnaire.put("description",questionnaireDescription);
            tempQuestionnaire.put("id",questionnaireID);
            tempQuestionnaire.put("state",state);
            List<Question> questions = questionnaire.getQuestions(); //拿到当前问卷所有问题
            int len = questions.size();
            ArrayList<HashMap<String,Object>> questionList = new ArrayList<>(); //创建数组用于存储问题

            for (int j=0;j<len;j++) {
                boolean questionIsGrouped = false;
                Question question = questions.get(j);
                String title = question.getQuestionType().getDescription();
                String questionContent = question.getQuestion();
                int questionID = question.getId();
                int questionTypeID = question.getType();
                if (!questionList.isEmpty()){
                    for (HashMap group:questionList){
                        if ( group.get("title").equals(title)){
                            ArrayList temp = (ArrayList) group.get("questions");
                            HashMap tempQuestion = new HashMap();
                            tempQuestion.put("question",questionContent);
                            tempQuestion.put("id",questionID);
                            temp.add(tempQuestion);
                            group.put("questions",temp);
                            questionIsGrouped = true;
                        }
                    }
                }
                if (questionIsGrouped) continue;
                ArrayList<HashMap<String,Object>> groupQuestions = new ArrayList<>();
                HashMap tempQuestion = new HashMap();
                tempQuestion.put("question",questionContent);
                tempQuestion.put("id",questionID);
                HashMap<String,Object> temp = new HashMap<>();
                groupQuestions.add(tempQuestion);
                temp.put("title",title);
                temp.put("typeID",questionTypeID);
                temp.put("questionnaireID",questionnaireID);
                temp.put("questions",groupQuestions);
                questionList.add(temp);
            }

            tempQuestionnaire.put("questionsList",questionList);
            result.add(tempQuestionnaire);
        }
        res.put("number",number);
        res.put("data",result);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/getquestionnaire")
    public String getQuestionnaire() {
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
            question.put("id",questionID);
            question.put("question",questionContent);
            HashMap<String,Object> temp = new HashMap<>();
            questionsList.add(question);
            temp.put("title",title);
            temp.put("questions",questionsList);
            res.add(temp);
        }

        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/questionnairestate")
    public String updateQuestionState(@RequestParam("id")Integer id, @RequestParam("state")Boolean state){
        int i = questionnaireDao.updateState(id, state);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/addquestionnaire")
    public String addQuestionnaire(@RequestBody Questionnaire questionnaire){
        int i = questionnaireDao.addQuestionnaire(questionnaire);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/getaddquestionslist")
    public String getAddQuestionsList(@RequestBody GetQuestionListQuery getQuestionListQuery){
        int groupID =  getQuestionListQuery.getGroupId();
        int[] questionIDs =getQuestionListQuery.getQuestionIds();
        int questionnaireID = getQuestionListQuery.getQuestionnaireId();
        List<Question>  questionList= questionnaireDao.getQuestionList(groupID,questionIDs,questionnaireID);
        String res = JSON.toJSONString(questionList);
        return res;
    }


}


