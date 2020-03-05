package org.virajshah.monopoly.core;

import java.util.ArrayList;
import java.util.HashMap;

import org.virajshah.monopoly.tiles.PropertyTile;
import org.virajshah.monopoly.tiles.TileAttribute;

public class TradeBroker {
	private Player client;
	private TileAttribute mostWantedSet;
	private Player match;
	private TradeBroker matchBroker;

	public TradeBroker(Player client) {
		this.client = client;
	}

	public void runInitiation() {
//		Logger logs = MonopolyGame.getLogs();
		mostWantedColoredSet();
		findBestPlayerMatch();
		generateTradeBrokerForMatch();
		matchBroker.runReciprocation();
		if (matchBroker.getMostWantedSet() == mostWantedSet) { // Any conflicts?
//			logs.info(String.format("%s and %s are initiating a trade", client.getName(), match.getName()));
			for (PropertyTile prop : match.getProperties()) {
				if (prop.getAttributes().contains(mostWantedSet)) {
					prop.transferOwnership(client);
//					logs.info(String.format("%s gave %s to %s", match.getName(), prop.getName(), client.getName()));
				}
			}

			for (PropertyTile prop : client.getProperties()) {
				if (prop.getAttributes().contains(matchBroker.getMostWantedSet())) {
					prop.transferOwnership(match);
//					logs.info(String.format("%s gave %s to %s", client.getName(), prop.getName(), match.getName()));
				}
			}
		} else {
//			logs.info(String.format("%s and %s did not make any trade", client.getName(), match.getName()));
		}
	}

	public void runReciprocation() {
		mostWantedColoredSet();
	}

	private void mostWantedColoredSet() {
		HashMap<TileAttribute, Integer> scores = new HashMap<>();

		for (PropertyTile prop : client.getProperties()) {
			if (prop.getAttributes().contains(TileAttribute.COLORED_PROPERTY)) {
				if (scores.keySet().contains(prop.getColorSet()))
					scores.put(prop.getColorSet(), scores.get(prop.getColorSet()) + 1);
				else
					scores.put(prop.getColorSet(), 1);
			}
		}

		TileAttribute largest = null;

		for (TileAttribute attr : scores.keySet()) {
			if (largest == null) {
				largest = attr;
				continue;
			}

			if (scores.get(attr) > scores.get(largest))
				largest = attr;
		}

		mostWantedSet = largest;
	}

	/**
	 * @return the client
	 */
	public Player getClient() {
		return client;
	}

	/**
	 * @return the mostWantedSet
	 */
	public TileAttribute getMostWantedSet() {
		return mostWantedSet;
	}

	/**
	 * @return the match
	 */
	public Player getMatch() {
		return match;
	}

	/**
	 * @return the matchBroker
	 */
	public TradeBroker getMatchBroker() {
		return matchBroker;
	}

	private void findBestPlayerMatch() {
		ArrayList<Player> players = (ArrayList<Player>) client.getGame().getPlayers();
		HashMap<Player, Integer> scores = new HashMap<>();

		for (Player p : players) {
			int score = 0;
			for (PropertyTile prop : client.getProperties())
				if (prop.getAttributes().contains(mostWantedSet))
					score++;

			scores.put(p, score);
		}

		Player largest = null;

		for (Player p : players) {
			if (largest == null) {
				largest = p;
				continue;
			}

			if (scores.get(p) > scores.get(largest)) {
				largest = p;
			}
		}

		match = largest;
	}

	private void generateTradeBrokerForMatch() {
		matchBroker = new TradeBroker(match);
		matchBroker.runReciprocation();
	}
}
