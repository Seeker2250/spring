package org.doit.ik.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.doit.ik.domain.NoticeVO;

public interface NoticeMapper {
   
   // 공지사항의 갯수 반환하는 메서드
//  public int getCount(String field, String query) throws ClassNotFoundException, SQLException;
	public int getCount(@Param("field") String field, @Param("query") String query);
   
   public List<NoticeVO> getNotices(
		   int page,
		   String field,// 검색 조건
		   String query//검색어
		   ) throws ClassNotFoundException, SQLException;
   
   public int delete(String seq) throws ClassNotFoundException, SQLException;
   
   public int update(NoticeVO notice) throws ClassNotFoundException, SQLException;
   
   public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException;
   
   public int insert(NoticeVO n) throws ClassNotFoundException, SQLException;
   
   //트랜잭션 처리를 위한 method 추가
   //public void insertAndPointUpOfMember(NoticeVO notice, String id)throws ClassNotFoundException, SQLException;
   
   public void hitUp(String seq) throws ClassNotFoundException, SQLException ;   
   public int getHit(String seq) throws ClassNotFoundException, SQLException ;
} // interface