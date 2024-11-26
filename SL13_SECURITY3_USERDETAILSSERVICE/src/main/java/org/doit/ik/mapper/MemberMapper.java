package org.doit.ik.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;
import org.doit.ik.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public interface MemberMapper { // 인터페이스로 바꿈
   
   public MemberVO getMember(String id) throws ClassNotFoundException, SQLException;
   
   public int insert(MemberVO member) throws ClassNotFoundException, SQLException;
   
   //회원 정보와 권한 정보를 모두 돌려주는 method
   public MemberVO read(@Param("userid")String id) throws ClassNotFoundException, SQLException;
} // interface
