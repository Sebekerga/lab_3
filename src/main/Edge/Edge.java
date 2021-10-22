package main.Edge;

public interface Edge{
    public double accuracy = 0.001;
    public boolean check_inside (double p_x, double p_y);
    public boolean check_outside (double p_x, double p_y);
}