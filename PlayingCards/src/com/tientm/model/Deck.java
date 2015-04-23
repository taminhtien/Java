package com.tientm.model;

import java.util.ArrayList;

public class Deck {
	ArrayList<Card> listCard;

	public Deck() {
		Card c = null;
		listCard = new ArrayList<Card>();
		for (Suite s : Suite.values()) {
			for (Rank r : Rank.values()) {
				c = new Card(r, s);
				listCard.add(c);
			}
		}
	}

	public Deck(ArrayList<Card> listCard) {
		super();
		this.listCard = listCard;
	}

	public ArrayList<Card> getListCard() {
		return listCard;
	}

	public void setListCard(ArrayList<Card> listCard) {
		this.listCard = listCard;
	}

	@Override
	public String toString() {
		String s = "";
		for (Card c : listCard) {
			s += c.toString() + "\n";
		}
		return s;
	}
}
