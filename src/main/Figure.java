package main;

import main.Edge.Edge;

public class Figure{  
    Edge[] edges;
    int size;
    public Figure(Edge[] edges){
        this.edges = edges;
        this.size = edges.length;
    }

    public boolean check_inside (double p_x, double p_y){
        for(int i = 0; i < size; i++)
            if(! edges[i].check_inside(p_x, p_y))
                return false;
        return true;
    }

    public boolean check_outside (double p_x, double p_y){
        return ! check_inside(p_x, p_y);
    }
}  
