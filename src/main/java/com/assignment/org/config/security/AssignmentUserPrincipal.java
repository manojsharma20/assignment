package com.assignment.org.config.security;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.assignment.org.persistence.model.Privilege;
import com.assignment.org.persistence.model.User;

@SuppressWarnings("serial")
public class AssignmentUserPrincipal implements UserDetails {
    private User user;
 
    public AssignmentUserPrincipal(User user) {
        this.user = user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> privilegeAuthorities = getPrivilegeAuthorities(user.getPrivileges());
		return privilegeAuthorities;
	}

	private List<GrantedAuthority> getPrivilegeAuthorities(Set<Privilege> privileges) {
		List<GrantedAuthority> authorities = new LinkedList<>();
		
		GrantedAuthority authority = null;
		for (Privilege privilege : privileges) {
			authority = new SimpleGrantedAuthority(privilege.getPrivilegeName());
			authorities.add(authority);
		}
	
		
		return authorities;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmailId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
