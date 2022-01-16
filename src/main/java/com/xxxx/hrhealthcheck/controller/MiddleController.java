package com.xxxx.hrhealthcheck.controller;

import com.xxxx.hrhealthcheck.bean.AddQuestionForm;
import com.xxxx.hrhealthcheck.dao.MiddleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiddleController {

    @Autowired
    MiddleDao middleDao;

    @RequestMapping( "/addquestiontoquestionnaire")
    public String addQuestion(@RequestBody AddQuestionForm addQuestionForm){
        int[] questionList = addQuestionForm.getQuestionList();
        int questionnaireID = addQuestionForm.getQuestionnaireID();
        int len = questionList.length;
        int res = middleDao.addQuestion(questionnaireID,questionList);
        return res == len ? "success" : "error";
    }

}
