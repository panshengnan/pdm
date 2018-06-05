package com.cgwx.dao;

import com.cgwx.data.entity.UrmUserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UrmUserInfoMapper {
    int insert(UrmUserInfo record);

    List<UrmUserInfo> selectAll();

    @Select("SELECT user_name\n" +
            "FROM urm_user_info\n" +
            "WHERE id = #{id}"
    )
    String selectDisplayNameById(@Param("id") int id);
    @Select("SELECT password\n" +
            "FROM urm_user_info\n" +
            "WHERE user_name = #{account}"
    )
    String selectPasswdByAccount(@Param("account") String account);


    @Insert("INSERT INTO urm_user_info(department_name, phone_number, password, user_name, role) " +
            "VALUES(#{departmentName}, #{phoneNumber}, #{password}, #{userName}, #{role})")
    int insertEntity(UrmUserInfo urmUserInfo);

    @Select("SELECT password FROM urm_user_info WHERE user_name = #{user_name}")
    @Results({
            @Result(property = "password", column = "password"),
    })
    UrmUserInfo findById(String userName);
}