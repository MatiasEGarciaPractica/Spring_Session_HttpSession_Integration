package com.session.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collection;
import java.util.Set;

@Service
public class UserSessionsService {

    @Autowired
    private FindByIndexNameSessionRepository<? extends Session> sessions;

    public Collection<? extends Session> getSessions(Principal principal) {
        return this.sessions.findByPrincipalName(principal.getName()).values();
    }

    public void removeSession(Principal principal, String sessionIdToDelete) {
        Set<String> usersSessionIds = this.sessions.findByPrincipalName(principal.getName()).keySet();
        if (usersSessionIds.contains(sessionIdToDelete)) {
            this.sessions.deleteById(sessionIdToDelete);
        }
    }

}
