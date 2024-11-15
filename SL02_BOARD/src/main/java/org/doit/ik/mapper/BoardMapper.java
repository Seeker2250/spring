package org.doit.ik.mapper;

import java.util.List;

import org.doit.ik.domain.BoardVO;

public interface BoardMapper {
	//list계열 다 받을 수 있으니 확장성이 좋아서 걍 List씀
	List<BoardVO>getList();
	void insert(BoardVO board);//새 글 쓰기
	void insertSelectKey(BoardVO board); //새 글 쓰기+글 번호pk 반환
	
	BoardVO read(Long bno);//글 상세보기.. BoardVO return하는 게 나을 것 같아서
	
	int update(BoardVO board);
	int remove(Long bno);
}
