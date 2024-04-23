package com.session.web;

import com.session.service.UserSessionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.session.Session;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/session") 
public class SessionC {

    private final UserSessionsService userSessionsService;

    public SessionC(UserSessionsService userSessionsService){
        this.userSessionsService = userSessionsService;
    }

    @GetMapping(value = "/getSessions")
    public ResponseEntity<Collection<? extends Session>> getSessions(Principal principal){
        return ResponseEntity.ok(userSessionsService.getSessions(principal));
    }

    @DeleteMapping(value= "/deleteSessions/{sessionIdToDelete}")
    public ResponseEntity<String> deleteSession(Principal principal,
            @PathVariable(value = "sessionIdToDelete") String sessionIdToDelete){
        userSessionsService.removeSession(principal, sessionIdToDelete);
        return ResponseEntity.ok("Session deleted");
    }

}
