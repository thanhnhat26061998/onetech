package vn.com.onetech.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import vn.com.onetech.dao.IUserDao;
import vn.com.onetech.entity.Role;
import vn.com.onetech.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private IUserDao userRepository;
	
	@Autowired HttpSession session;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		session.setAttribute("user", user);
		if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(), grantedAuthorities);
	}
	
	

}
