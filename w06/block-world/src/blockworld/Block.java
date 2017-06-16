package blockworld;


public class Block {
    /**
     * Blocks are the inhabitants of Blockworlds and start at coordinates possess a velocity and shape
     */
    private int xblock;
    private int yblock;
    private int vblock;
    private char shapeblock;
    public Block(int x, int y, int velocity, char shape) {
        //Constructor of Block checks also for invalid starting points and negative velocity
        if (x < 0 || y < 0 || velocity < 0) {
            throw new IllegalArgumentException();
        }
        this.xblock = x;
        this.yblock = y;
        this.vblock = velocity;
        this.shapeblock = shape;
    }
    public int getxblock() {
        return this.xblock;
    }
    public void setxblock(int newx) {
        this.xblock = newx;
    }

    public int getyblock() {
        return this.yblock;
    }
    public void setyblock(int newy) {
        this.yblock = newy;
    }

    public int getvblock() {
        return this.vblock;
    }
    public void setvblock(int newv) {
        this.vblock = newv;
    }

    public char getshape () {
        return this.shapeblock;
    }
    
    public void setshape (char newshape) {
        this.shapeblock = newshape;
    }
}
