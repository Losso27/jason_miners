package example;

import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import example.Env.Move;

public class WorldModel extends GridWorldModel {

    public static final int   GOLD  = 16;

    Set<Integer>              agWithGold;

    public WorldModel() throws Exception {
        super(21, 21, 4);
        agWithGold = new HashSet<Integer>();
        this.setAgPos(0, 1, 0);
        this.setAgPos(1, 20, 0);
        this.setAgPos(2, 3, 20);
        this.setAgPos(3, 20, 20);
        this.setGold(10,10);
        this.setGold(11,10);
        this.setGold(10,11);
        this.setGold(11,11);
    }

    public void setGold(int x, int y) {
        data[x][y] = GOLD;
    }

    public boolean isCarryingGold(int ag) {
        return agWithGold.contains(ag);
    }

    public void setAgCarryingGold(int ag) {
        agWithGold.add(ag);
    }
    public void setAgNotCarryingGold(int ag) {
        agWithGold.remove(ag);
    }

     boolean move(Move dir, int ag) throws Exception {
        Location l = getAgPos(ag);
        switch (dir) {
        case UP:
            if (isFree(l.x, l.y - 1)) {
                setAgPos(ag, l.x, l.y - 1);
            }
            break;
        case DOWN:
            if (isFree(l.x, l.y + 1)) {
                setAgPos(ag, l.x, l.y + 1);
            }
            break;
        case RIGHT:
            if (isFree(l.x + 1, l.y)) {
                setAgPos(ag, l.x + 1, l.y);
            }
            break;
        case LEFT:
            if (isFree(l.x - 1, l.y)) {
                setAgPos(ag, l.x - 1, l.y);
            }
            break;
        }
        return true;
    }

}