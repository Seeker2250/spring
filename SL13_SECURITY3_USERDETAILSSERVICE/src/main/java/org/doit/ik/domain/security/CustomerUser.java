package org.doit.ik.domain.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.doit.ik.domain.MemberVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

//인증 처리 한 후에 내가 원하는 로그인한 사용자 정보를 저장하는 객체
@Getter
public class CustomerUser extends User{

	
	private MemberVO member;//모든 사용자 정보, 이게 principal이 되니까 여기에서 어떤 정보를 빼면 돼
	
	public CustomerUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
	}
	
	public CustomerUser(MemberVO member) {
	
	      super( member.getId(),member.getPwd()
	            // List<AuthVO>  -> 
	            //  Collection<? extends GrantedAuthority> authorities 권한 정보가 이 타입이어야 하니까 다 담아
	            ,   member.getAuthList().stream().map( 
	               auth->new SimpleGrantedAuthority(auth.getAuthority()) )
	                .collect(Collectors.toList())
	          );
	      this.member = member; // *** 로그인 할 때의 모든 사용자 정보를 이 field에 담아
	   }
	
}
