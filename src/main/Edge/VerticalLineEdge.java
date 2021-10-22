package main.Edge;

// p_y = y;
public class VerticalLineEdge implements Edge{
    double x;
    boolean inversed;
    public VerticalLineEdge(double x, boolean inversed){
        this.x = x;
        this.inversed = inversed;
    }

    @Override
    public boolean check_inside(double p_x, double p_y) {
        if(inversed){
            if(p_x >= x)
                return true;
        }else {
            if(p_x <= x)
                return true;
        }
        return false;
    }

    @Override
    public boolean check_outside(double p_x, double p_y) {
        if(inversed){
            if(p_x < x)
                return true;
        }else {
            if(p_x > x)
                return true;
        }
        return false;
    }
}
