package main.Edge;

// p_y - y = k*p_x
public class LineEdge implements Edge{
    double y, k;
    boolean inversed;
    public LineEdge(double y, double k, boolean inversed){
        if(k == 0)
            throw new RuntimeException("Use vertical line instead when k=0");
        
        this.y = y;
        this.k = k;
        this.inversed = inversed;
    }

    @Override
    public boolean check_inside (double p_x, double p_y) {
        if(inversed){
            if(p_y - y >= k*p_x - accuracy)
                return true;
        }else {
            if(p_y - y <= k*p_x + accuracy)
                return true;
        }
        return false;
    }

    @Override
    public boolean check_outside (double p_x, double p_y) {
        if(inversed){
            if(p_y - y < k*p_x)
                return true;
        }else {
            if(p_y - y > k*p_x)
                return true;
        }
        return false;
    }    
}

