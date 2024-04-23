package com.session.listener;

import org.springframework.context.event.EventListener;
import org.springframework.session.events.*;
import org.springframework.stereotype.Component;

@Component
public class SessionListener {

    /**
     * Called when client makes a rquest to an endpoint or authenticate
     * @param sessionCreatedEvent
     */
    @EventListener
    public void CreationListener(SessionCreatedEvent sessionCreatedEvent){
        System.out.println("Session was created");
        System.out.println(sessionCreatedEvent.getSession().getAttributeNames());
    }

    @EventListener//called when user do logout
    public void DeletedEvent(SessionDeletedEvent sessionDeletedEvent){
        System.out.println("Session was deleted");
        System.out.println(sessionDeletedEvent.getSession().getAttributeNames());
    }

    /**
     * called when user logout, is called before SessionDeletedEvent
     * @param sessionDestroyedEvent
     */
    @EventListener
    public void DestroyedEvent(SessionDestroyedEvent sessionDestroyedEvent){
        System.out.println("Session was destroyed");
        System.out.println(sessionDestroyedEvent.getSession().getAttributeNames());
    }

    @EventListener
    public void ExpiredEvent(SessionExpiredEvent SessionExpiredEvent){
        System.out.println("Session was expired");
        System.out.println(SessionExpiredEvent.getSession().getAttributeNames());
    }

    /**
     * //called when session was udpated, can be when client access some endpoint,
     * authenticate or logout.
     */
    @EventListener
    public void UpdatedEvent(AbstractSessionEvent abstractSessionEvent){
        System.out.println("Session was updated");
        System.out.println(abstractSessionEvent.getSession().getAttributeNames());
    }
}
