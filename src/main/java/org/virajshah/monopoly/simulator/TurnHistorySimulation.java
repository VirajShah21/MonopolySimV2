package org.virajshah.monopoly.simulator;

import org.virajshah.monopoly.core.MonopolyGame;
import org.virajshah.monopoly.core.Player;
import org.virajshah.monopoly.logger.LogConfiguration;
import org.virajshah.monopoly.logger.Logger;

public class TurnHistorySimulation {
    public static void main(String[] args) {
        Logger.init();
        LogConfiguration.format(LogConfiguration.LogFormat.JSON);
        
        LogConfiguration.disableWritingLogs("InfoLog");
        LogConfiguration.disableWritingLogs("RentTransactionLog");
        LogConfiguration.disableWritingLogs("TransactionLog");

        MonopolyGame game = new MonopolyGame();

        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.addPlayer(new Player("Player 4"));

        for (int i = 0; i < 1000; i++) {
            game.runNextTurn();
            if (game.getPlayers().isEmpty() || game.getPlayers().size() == 1)
                break;
        }
        Logger.save();
    }
}
