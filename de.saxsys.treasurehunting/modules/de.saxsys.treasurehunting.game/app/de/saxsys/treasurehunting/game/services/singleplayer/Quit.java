package de.saxsys.treasurehunting.game.services.singleplayer;

import de.saxsys.treasurehunting.common.models.user.User;

/**
 * Austritt aus der Spielhalle.
 * 
 * @author stefan.illgen
 *
 */
public class Quit {
    
    final User user;
    
    public Quit(User user) {
        this.user = user;
    }
    
}
