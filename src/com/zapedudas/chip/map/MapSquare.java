package com.zapedudas.chip.map;

import java.util.ArrayList;

import com.zapedudas.chip.Tile.Tile;
import com.zapedudas.chip.Tile.Item.Item;
import com.zapedudas.chip.Tile.Unit.Unit;

public class MapSquare {
	private Tile groundTile;
	private Tile itemTile;
	private ArrayList<Tile> unitTiles;
	
	public MapSquare(Tile groundTile, Tile itemTile, Tile unitTile) {
		this();
		
		setGroundTile(groundTile);
		setItemTile(itemTile);
		if (unitTile != null) unitTiles.add(unitTile);
	}
	
	public MapSquare() {
		this.unitTiles = new ArrayList<Tile>();
	}

	public Tile getGroundTile() {
		return groundTile;
	}
	
	public void setGroundTile(Tile groundTile) {
		this.groundTile = groundTile;
	}
	
	public Tile getItemTile() {
		return itemTile;
	}
	
	public Item getItem() {
		return (Item)itemTile;
	}
	
	public void setItemTile(Tile itemTile) {
		this.itemTile = itemTile;
	}
	
	public void clearItemTile() {
		this.itemTile = null;
	}
	
	public Tile[] getUnitTiles() {
		return unitTiles.toArray(new Tile[unitTiles.size()]);
	}
	
	public Unit[] getUnits() {
		return unitTiles.toArray(new Unit[unitTiles.size()]);
	}
	
//	public void setUnitTiles(Tile[] unitTiles) {
//		this.unitTiles = unitTiles;
//	}
	
	/** This will add the unit to the top of the pile **/
	public void addUnitTile(Tile unitTileToAdd) {
		unitTiles.add(unitTileToAdd);
	}
	
	public void removeUnitTile(Tile unitToRemove) {
		unitTiles.remove(unitToRemove);
	}
	
	public Tile[] toArray() {
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		
		for (Tile unitTile : unitTiles) {
			if (unitTile != null) tiles.add(unitTile);
		}
		
		if (itemTile != null) tiles.add(itemTile);
		
		if (groundTile != null) tiles.add(groundTile);
		
		return tiles.toArray(new Tile[tiles.size()]);
	}
	
	public Tile[] toArrayTopLayer() {
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		
		if (itemTile != null) tiles.add(itemTile);
		
		for (Tile unitTile : unitTiles) {
			if (unitTile != null) tiles.add(unitTile);
		}
		
		return tiles.toArray(new Tile[tiles.size()]);		
	}
}