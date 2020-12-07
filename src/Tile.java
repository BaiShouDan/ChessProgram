public abstract class Tile {
    private int tileCoordinates;

    public Tile(int tileCoordinates) {
        this.tileCoordinates = tileCoordinates;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {

        public EmptyTile(int tileCoordinates) {
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

        private Piece pieceOnTail;

        public OccupiedTiles(int tileCoordinates, Piece pieceOnTail) {
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
