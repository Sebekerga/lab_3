package main.Edge;

// p_x = x
public class HorizontalLineEdge implements Edge{
    double y;
    boolean inversed;
    public HorizontalLineEdge(double y, boolean inversed){
        this.y = y;
        this.inversed = inversed;
    }

    @Override
    public boolean check_inside(double p_x, double p_y) {
        if(inversed){
            if(p_y >= y)
                return true;
        }else {
            if(p_y <= y)
                return true;
        }
        return false;
    }

    @Override
    public boolean check_outside(double p_x, double p_y) {
        if(inversed){
            if(p_y < y)
                return true;
        }else {
            if(p_y > y)
                return true;
        }
        return false;
    }
}