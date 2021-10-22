package main.Edge;

// (p_x - x)^2 /r_x^2 + (p_y - y)^2 /r_y^2 = 1  
// ((p_x - x)*(p_x - x))/(r_x*r_x) + ((p_y - y)*(p_y - y))/(r_y*r_y) = 1 
public class EllipseEdge implements Edge{
    double r_x, r_y, x, y;
    boolean inversed;
    public EllipseEdge(double r_x, double r_y, double x, double y, boolean inversed){
        if(r_x <= 0 || r_y <= 0)
            throw new NumberFormatException("Radius of ellipse must be greater then zero");
        this.r_x = r_x;
        this.r_y = r_y;
        this.x = x;
        this.y = y;
        this.inversed = inversed;
    }

    @Override
    public boolean check_inside(double p_x, double p_y){
        if(((p_x - x)*(p_x - x))/(r_x*r_x) + ((p_y - y)*(p_y - y))/(r_y*r_y) <= 1 + accuracy)
            return true;
        return false;
    }

    @Override
    public boolean check_outside(double p_x, double p_y){
        if(((p_x - x)*(p_x - x))/(r_x*r_x) + ((p_y - y)*(p_y - y))/(r_y*r_y) > 1)
            return true;
        return false;
    }
}
