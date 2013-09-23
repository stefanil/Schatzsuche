package de.saxsys.treasurehunting.game.services.singleplayer;

import de.saxsys.treasurehunting.common.models.user.User;

/**
 * Quit of the game hall.
 * 
 * @author stefan.illgen
 *
 */
public class Quit {
    
    final User user;
    
    /**
     * Default contructor.
     * 
     * @param user The user.
     */
    public Quit(User user) {
        this.user = user;
    }
    
}
