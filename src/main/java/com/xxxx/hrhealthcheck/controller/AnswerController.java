package com.xxxx.hrhealthcheck.controller;

import com.alibaba.fastjson.JSON;
import com.xxxx.hrhealthcheck.bean.*;
import com.xxxx.hrhealthcheck.dao.CompanyDao;
import com.xxxx.hrhealthcheck.dao.GroupGradingContentDao;
import com.xxxx.hrhealthcheck.dao.QuestionTypeDao;
import com.xxxx.hrhealthcheck.dao.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    GroupGradingContentDao groupGradingContentDao;

    @Autowired
    QuestionTypeDao questionTypeDao;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    ReportDao reportDao;

    @RequestMapping("/sendanswercard")
    public String getAnswerCard(@RequestBody Company companyInfo){
        int insertCompanyInfo = companyDao.companyInfo(companyInfo);


        HashMap<String,Object> report = new HashMap();

        List<AnswerCard> answerCard = companyInfo.getAnswerCard();
        ReportForClient groupReport = new ReportForClient();
        ArrayList<Object> fineAnalysis = new ArrayList<>();

        HashMap<String, ArrayList> data = new HashMap<>();

        int totalScore =0;
        for(int i = 0; i < answerCard.size(); i++){
            int greenCount = 0,amberCount = 0,redCount = 0;

            List<Answer> tempAnswerList =  answerCard.get(i).getAnswerList();
            int groupScore = 0;
            for (Answer answer:tempAnswerList) {
                int choose = answer.getChoose();
                switch (choose){
                    case 0:
                        groupScore += 2;
                        greenCount++;
                        break;
                    case 1:
                        groupScore += 1;
                        amberCount++;
                        break;
                    case 2:
                        groupScore += 0;
                        redCount++;
                        break;
                }
            }
            groupScore = Math.round( groupScore/tempAnswerList.size());
            System.out.println(groupScore);
            GroupGradingContent groupGradingContent = groupGradingContentDao.getContent(i+1, groupScore);
            String content = groupGradingContent.getContent();
            groupReport.setReportPart(i+1, content);

            String questionTypeDescription = questionTypeDao.getQuestionTypeDescription(i + 1);
            HashMap<String,Object> groupAnalysis= new HashMap<>();
            ArrayList chooseCount = new ArrayList();
            chooseCount.add(greenCount);
            chooseCount.add(amberCount);
            chooseCount.add(redCount);
            groupAnalysis.put("title",questionTypeDescription);
            groupAnalysis.put("analysis",content);
            groupAnalysis.put("data",chooseCount);
            fineAnalysis.add(groupAnalysis);

            if (data.isEmpty()){
                ArrayList xAxis = new ArrayList();
                xAxis.add(questionTypeDescription);
                data.put("xAxis", xAxis);
                ArrayList green = new ArrayList();
                green.add(greenCount);
                data.put("green",green);
                ArrayList amber = new ArrayList();
                green.add(amberCount);
                data.put("amber",amber);
                ArrayList red = new ArrayList();
                green.add(redCount);
                data.put("red",red);
            }else {
                data.get("xAxis").add(questionTypeDescription);
                data.get("green").add(greenCount);
                data.get("amber").add(amberCount);
                data.get("red").add(redCount);
            }
            totalScore += groupScore;
        }
        report.put("fineAnalysis",fineAnalysis);
        report.put("data",data);

        String result = JSON.toJSONString(report);
        String companyName = companyInfo.getCompanyName();
        ReportForDatabase reportForDatabase = new ReportForDatabase(result,totalScore,companyName);
        reportDao.saveReport(reportForDatabase);
        return result;
    }
}


