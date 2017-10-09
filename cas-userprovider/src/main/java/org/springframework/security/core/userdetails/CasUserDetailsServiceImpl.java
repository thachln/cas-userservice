/**
 * 
 */
package org.springframework.security.core.userdetails;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author ThachLN
 *
 */
public class CasUserDetailsServiceImpl implements UserDetailsService {
    private static final Logger LOG = Logger.getLogger(CasUserDetailsServiceImpl.class);
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.debug("Get information of user  '" + username + "...");
        
        return new CasUserDetails(username);
    }

 
}
