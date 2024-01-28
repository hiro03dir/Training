package com.example.its.domain.issue;

import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into issues (summary, description) values (#{summary}, #{description})")
    void insert (String summary, String description);

    @Select("select * from issues where id = #{issueId}")
    IssueEntity findById(long issueId);
}
