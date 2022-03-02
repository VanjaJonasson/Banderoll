package com.example.Banderoll;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlayerRepository {

    ArrayList<Player> players = new ArrayList<>();



    public PlayerRepository(ArrayList<Player> players) {
        this.players = players;
        addPlayer(new Player("admin", "123"));
    }

    public void addPlayer(Player player) {
        players.add(player);

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
