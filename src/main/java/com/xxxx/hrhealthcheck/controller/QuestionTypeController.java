package com.xxxx.hrhealthcheck.controller;

import com.alibaba.fastjson.JSON;
import com.xxxx.hrhealthcheck.bean.QueryInfo;
import com.xxxx.hrhealthcheck.bean.QuestionType;
import com.xxxx.hrhealthcheck.dao.QuestionTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class QuestionTypeController {

    @Autowired
    QuestionTypeDao questionTypeDao;

    @RequestMapping("/allquestiontype")
    public String getAllQuestionType(QueryInfo queryInfo) {
        int number = questionTypeDao.getQuestionTypeCount();
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<QuestionType> questionType = questionTypeDao.getAllQuestionType(pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", number);
        res.put("data", questionType);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/deletequestiontype")
    public String deleteQuestionType(int id) {
        int i = questionTypeDao.deleteQuestionType(id);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/addquestiontype")
    public String addQuestionType(@RequestBody QuestionType questionType) {
        questionType.setState(true);
        int i = questionTypeDao.addQuestionType(questionType);
        return i > 0 ? "success" : "error";
    }

}
