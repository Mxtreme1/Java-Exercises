package simplechess;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ExampleTests {


    @Test
    public void test1() {
        List<PositionPiece> whitePieces = Arrays.asList(
                new PositionPiece(PieceKind.KNIGHT,
                                  new Position(1, 1)),
                new PositionPiece(PieceKind.QUEEN,
                                  new Position(0, 1)));
        List<PositionPiece> blackPieces = Collections.singletonList(
                new PositionPiece(PieceKind.QUEEN, new Position(3, 0))
        );

        assertTrue(Main.winnable(Boards.fromPositionPieces(whitePieces,
                                                           blackPieces, 4)
                , 1));
    }

    @Test
    public void test2() {
        List<PositionPiece> whitePieces = Arrays.asList(
                new PositionPiece(PieceKind.QUEEN,
                                  new Position(0, 3)));
        List<PositionPiece> blackPieces = Collections.singletonList(
                new PositionPiece(PieceKind.QUEEN, new Position(3, 0))
        );

        assertTrue(Main.winnable(Boards.fromPositionPieces(whitePieces,
                                                           blackPieces, 4)
                , 1));
    }

}