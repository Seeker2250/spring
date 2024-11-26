package org.doit.ik.service;

import java.sql.SQLException;

import org.doit.ik.domain.NoticeVO;

public interface MemberShipService {
	//트랜잭션 처리를 위한 method 분리
	public void insertAndPointUpOfMember(NoticeVO notice, String id)throws ClassNotFoundException, SQLException;
}
