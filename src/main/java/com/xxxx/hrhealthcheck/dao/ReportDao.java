package com.xxxx.hrhealthcheck.dao;

import com.xxxx.hrhealthcheck.bean.ReportForDatabase;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDao {
    public int saveReport(ReportForDatabase reportForDatabase);
}
