package org.doit.ik.service;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
//component의 기준은 component annotation의 자식 annotation!(controller, service 등)
@Service
@Log4j
@AllArgsConstructor//스프링 4.3부터는 이것도 DI 가능
public class BoardServiceImpl implements BoardService{

	//@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		
		log.info("BoardServiceImpl.getList()호출~~~~");
		
		return this.boardMapper.getList();
	}

	@Override
	public void register(BoardVO board) {
		log.info("~~~~BoardServiceImpl.register()호출~~~~");
		//this.boardMapper.insert(board);
		this.boardMapper.insertSelectKey(board);//글 번호가 계속 저장되어 있는거야
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("~~~~BoardServiceImpl.get()호출~~~~");
		return this.boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("~~~~BoardServiceImpl.modify()호출~~~~");
		return this.boardMapper.update(board) == 1;
	}

	@Override
	public boolean delete(Long bno) {
		log.info("~~~~BoardServiceImpl.delete()호출~~~~");
		return this.boardMapper.remove(bno) == 1;
	}

}
