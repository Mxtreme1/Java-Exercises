package simplechess;

public class PositionPiece {

    private final PieceKind pieceKind;
    private final Position position;

    public PositionPiece(PieceKind pieceKind, Position position) {
        this.pieceKind = pieceKind;
        this.position = position;
    }

    public PieceKind getPieceKind() {
        return pieceKind;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "PositionPiece{" +
               "pieceKind=" + pieceKind +
               ", position=" + position +
               '}';
    }
}
