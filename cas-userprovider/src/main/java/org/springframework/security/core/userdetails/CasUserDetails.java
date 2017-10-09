/**
 * 
 */
package org.springframework.security.core.userdetails;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author ThachLN
 */
public class CasUserDetails implements UserDetails {
    private String username;

    public CasUserDetails(String username) {
        this.username = username;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<AppRole> roles = new ArrayList<AppRole>(1);
        roles.add(AppRole.USER);

        return roles;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
     */
    public String getPassword() {
        // TODO Auto-generated method stub
        return "";
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
     */
    public String getUsername() {
        return username;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     */
    public boolean isAccountNonExpired() {
        return true;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    public boolean isAccountNonLocked() {
        return true;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     */
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    public boolean isEnabled() {
        return true;
    }

}

enum AppRole implements GrantedAuthority {
    ADMIN(0), NEW_USER(1), USER(2);

    private final int bit;

    /**
     * Creates an authority with a specific bit representation. It's important that this doesn't change as it will be
     * used in the database. The enum ordinal is less reliable as the enum may be reordered or have new roles inserted
     * which would change the ordinal values.
     * @param bit the permission bit which will represent this authority in the datastore.
     */
    AppRole(int bit) {
        this.bit = bit;
    }

    public int getBit() {
        return bit;
    }

    public String getAuthority() {
        return "ROLE_" + toString();
    }
}
