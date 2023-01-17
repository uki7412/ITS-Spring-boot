package com.example.ITS.domain.issue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper//Mybatisを通してデータベースに接続できる。Mybatisの場合は@repository無しでこれだけでBeen登録オーケー
public interface IssueRepository {//これを後でIssueServiceにインジェクションする
    @Select("select * from issues")
    List<IssueEntity> findAll();//上のアノテーションのselect文が実行される

    @Insert("insert into issues (summary, description) values (#{summary}, #{description})")
    void insert(@Param("summary")String summary, @Param("description")String description);

    @Select("select * from issues where id = #{issueId}")
    IssueEntity findById(long issueId);
}
