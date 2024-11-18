package org.doit.ik.mapper;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;

public interface BoardMapper {
	//list계열 다 받을 수 있으니 확장성이 좋아서 걍 List씀
	List<BoardVO>getList();//페이징 처리 X
	List<BoardVO>getListWithPaging(Criteria criteria);//페이징 처리 O
	int getTotalCount(Criteria criteria);//총 레코드 수 반환
	void insert(BoardVO board);
	void insertSelectKey(BoardVO board);
	
	BoardVO read(Long bno);
	
	int update(BoardVO board);
	int remove(Long bno);
}
