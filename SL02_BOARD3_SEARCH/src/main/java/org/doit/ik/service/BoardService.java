package org.doit.ik.service;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;

public interface BoardService {
	
	List<BoardVO> getList();//페이징 처리 안된 서비스
	List<BoardVO> getListWithPaging(Criteria criteria);//페이징 처리 완
	int getTotal(Criteria criteria);//총 레코드 수
	void register(BoardVO board);
	BoardVO get(Long bno);
	
	boolean modify(BoardVO board);
	boolean delete(Long bno);
}
