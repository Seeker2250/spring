package org.doit.ik.domain.security;

import java.sql.SQLException;

import org.doit.ik.domain.MemberVO;
import org.doit.ik.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
//인증 담당하는 애인데 내가 만든거야
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
    private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("> MemberMapper.Load User By UserName : " + username);
	      MemberVO vo = null ;
	      try {
	         vo = this.memberMapper.read(username);
	      } catch (ClassNotFoundException | SQLException e) { 
	         System.out.println(" > MemberMapper.Load User By UserName : " );
	         e.printStackTrace();
	      }
	      return vo == null ? null : new CustomerUser(vo);//내가 만든 객체 타입으로 return한 거니까 CustomerUser가 나중에 principal이 되는거야
	}
}
