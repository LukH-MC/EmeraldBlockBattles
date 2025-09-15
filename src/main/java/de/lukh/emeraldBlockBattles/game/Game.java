package de.lukh.emeraldBlockBattles.game;

import net.kyori.adventure.text.BlockNBTComponent.WorldPos.Coordinate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Game {
    private Coordinate point1;
    private Coordinate point2;
    private Player[] players = {null, null};




    //getters
    public String getPlayers() {
        if (this.players[0] == null && this.players[1] == null) {
            return null;
        }
        return "1: " + this.players[0] + "\n2: " + this.players[1];
    }

    public Player[] getPlayerObj() {
        return new Player[] {this.players[0], this.players[1]};
    }


    //setters
    public int setPlayer(String p) {
        Player pl = Bukkit.getPlayer(p);
        if (this.players[0] == null) {
            this.players[0] = pl;
            return 0;
        }
        if (this.players[1] == null) {
            this.players[1] = pl;
            return 1;
        }
        //case if all player slots are occupied
        return -1;
    }

    public void forceRemovePlayer(int id){
        players[id] = null;
    }
}
