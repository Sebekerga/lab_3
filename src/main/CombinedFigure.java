package main;

public class CombinedFigure {
    Figure[] figures;
    int size;
    public CombinedFigure(Figure[] figures){
        this.figures = figures;
        this.size = figures.length;
    }

    public boolean check_inside (double p_x, double p_y){
        for(int i = 0; i < size; i++)
            if(figures[i].check_inside(p_x, p_y))
                return true;
        return false;
    }

    public boolean check_outside (double p_x, double p_y){
        return !check_inside(p_x, p_y);
    }
    
}