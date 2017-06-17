package blockworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockWorld {
    /**
     * A Blockworld has a height a width blocks and a representation of empty coordinates
     */
    private int widthfield;
    private int heightfield;
    List<Block> blocksfield = new ArrayList<Block>();
    private char emptyfield;
    public BlockWorld(int width, int height, List<blockworld.Block> blocks, char empty) {
        //Constructor of Blockworld also checks if all Blocks are in a valid position of the Blockworld at start
        this.widthfield = width;
        this.heightfield = height;
        this.emptyfield = empty;
        for (blockworld.Block block : blocks) {
            if (block.getxblock() > width || block.getyblock() > height) {
                throw new IllegalArgumentException();
            }
        }
        for(Block b : blocks) {
            this.blocksfield.add(new Block(b.getxblock(), b.getyblock(), b.getvblock(), b.getshape()));
        }
    }

    public int getWidth() {
        return this.widthfield; 
    }

    public int getHeight() {
        return this.heightfield; 
    }

    public char[][] observe() {
        //Returns the current state of the blockworld including all blocks and their coordinates
        char[][] observed = new char[this.widthfield][this.heightfield];//creates new empty char array for later filling
            for (char[] carray : observed) {
                Arrays.fill(carray, this.emptyfield);
            }
            for (blockworld.Block block : this.blocksfield) {
                //checks for each block where it is and fills the position inside the char array if no bigger block exists
                char position = observed[block.getxblock()][block.getyblock()];
                if (position == this.emptyfield || position < block.getshape()) {
                    observed[block.getxblock()][block.getyblock()] = block.getshape();
                }

            }
            return observed;
        }
    public void step() {
        //Iterates over all blocks and moves them their velocity closer to the floor
        for (blockworld.Block block : this.blocksfield) {
            if (block.getyblock() < this.heightfield - 1) {
                block.setyblock(block.getyblock() + block.getvblock());
                //sets the blocks to the floor if they would be under it
                if (block.getyblock() >= this.getHeight()) {
                    block.setyblock(this.getHeight() - 1);
                }
            }
        }
    
    }
    public boolean isDead() {
        //Iterates over all blocks and checks if they can still move if yes return false
        for (blockworld.Block block : this.blocksfield) {
            if (block.getyblock() != this.heightfield -1 && block.getvblock() > 0) {
                return false;
            }
        }
        return true;
    }
}
