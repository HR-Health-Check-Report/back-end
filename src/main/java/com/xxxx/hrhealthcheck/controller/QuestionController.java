package com.xxxx.hrhealthcheck.controller;

import com.alibaba.fastjson.JSON;
import com.xxxx.hrhealthcheck.bean.QueryInfo;
import com.xxxx.hrhealthcheck.bean.Question;
import com.xxxx.hrhealthcheck.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionDao questionDao;

    @RequestMapping("/allquestion")
    public String getAllQuestion(QueryInfo queryInfo){
        System.out.println(queryInfo.toString());
        int number = questionDao.getQuestionCount("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Question> questions = questionDao.getAllQuestion("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", number);
        res.put("data", questions);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/addquestion")
    public String addQuestionType(@RequestBody Question question){
        question.setState(false);
        int i = questionDao.addQuestion(question);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/deletequestion")
    public String deleteQuestion(int id){
        System.out.println(id);
        int i = questionDao.deleteQuestion(id);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/questionstate")
    public String updateQuestionState(@RequestParam("id")Integer id, @RequestParam("state")Boolean state){
        int i = questionDao.updateState(id, state);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/editquestion")
    public String editQuestion(@RequestParam("id")Integer id,
                               @RequestParam("question")String question,
                               @RequestParam("type")Integer type){
        int i = questionDao.editQuestion(id, question, type);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/getquestion")
    public String getQuestion(@RequestParam("id")Integer id){
        HashMap<String, Object> data = new HashMap<>();
        Question question = questionDao.getQuestionInfo(id);
        String des = question.getQuestionType().getDescription();
        data.put("question",question.getQuestion());
        data.put("typeDescription",des);
        String res = JSON.toJSONString(question);
        return res;
    }

}