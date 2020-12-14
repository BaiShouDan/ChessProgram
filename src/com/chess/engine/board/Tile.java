package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {
    protected final int tileCoordinate;
    private static final Map<Integer, Tile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    private static Map<Integer, Tile> createAllPossibleEmptyTiles() {
        final Map<Integer, Tile> emptyTileMap = new HashMap<>();
        for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        return piece != null ? new OccupiedTiles(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    private Tile(final int tileCoordinates) {
        this.tileCoordinate = tileCoordinates;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {

        public EmptyTile(final int tileCoordinates) {
            super(tileCoordinates);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }

    public static final class OccupiedTiles extends Tile {

        private final Piece pieceOnTail;

        public OccupiedTiles(int tileCoordinates, final Piece pieceOnTail) {
            super(tileCoordinates);
            this.pieceOnTail = pieceOnTail;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return pieceOnTail;
        }
    }
}
