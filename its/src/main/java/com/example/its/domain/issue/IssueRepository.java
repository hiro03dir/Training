package com.example.its.domain.issue;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// MyBatisを通してDBにアクセスできるようになる。また@Mapperは@Repositoryも兼ねている。
@Mapper
public interface IssueRepository {

    // 直接SQLを書いてDBからレコードを取得できる
    @Select("select * from issues")
    List<IssueEntity> findAll();
}
