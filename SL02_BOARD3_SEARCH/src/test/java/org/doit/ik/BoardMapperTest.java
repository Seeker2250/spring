package org.doit.ik;



import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.mapper.BoardMapper;
import org.junit.Test;             // JUnit 4만 사용
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class BoardMapperTest {

	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	void testPaging() {
		Criteria criteria = new Criteria();
		log.info("criteria: " + criteria);
		List<BoardVO> list = this.boardMapper.getListWithPaging(criteria);
		log.info("list: " + list);
		list.forEach(board->System.out.println(board));
	}//test

}//class