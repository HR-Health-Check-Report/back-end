package com.xxxx.hrhealthcheck.dao;

import com.xxxx.hrhealthcheck.bean.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao {
    public int companyInfo(Company company);
}
