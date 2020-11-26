package org.r4.login;

import javax.enterprise.context.ApplicationScoped;
import org.r4.login.*;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger; // logging
import java.util.List;

@ApplicationScoped
public class GoalsService {

Logger logger = Logger.getLogger(GoalsService.class); // logging

@ConfigProperty(name = "hash-key")
	
	String hashKey;

    public List<Goals> goals(){
        try{
        logger.debug("hashKey: " + hashKey);
        
        List<Goals> goals = Goals.todasGoals();

        if(goals == null){
            logger.debug("goals: " + "null");
        }
        
        if ( goals!= null){
            return goals;
        }else{
            return null;
        }
        }catch(Exception e){
            logger.debug("Nos hemos caído");
            return null;
        }        
    }
}

