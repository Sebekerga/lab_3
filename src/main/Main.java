package main;

import main.Edge.*;

class Main{  
    public static void main(String args[]){  
        float R = 1;
        float p_x = 0;
        float p_y = 0;

        // checking arguments
        String error_message = "input_format: task_N {Radius} {x} {y}";
        if(args.length != 3){
            System.out.println(error_message); 
            return;
        } 
        
        try {
            R = Float.parseFloat(args[0]);
            p_x = Float.parseFloat(args[1]);
            p_y = Float.parseFloat(args[2]);
        } catch (NumberFormatException e){
            System.out.println(error_message); 
            return;
        }

        Edge circle[] = {
            new EllipseEdge(R/2, R/2, 0, 0, false),
            new VerticalLineEdge(0, false), 
            new HorizontalLineEdge(0, true)
        };
        Edge square[] = {
            new VerticalLineEdge(-R, true), 
            new HorizontalLineEdge(-R, true),
            new VerticalLineEdge(0, false), 
            new HorizontalLineEdge(0, false)
        };
        Edge triangle[] = {
            new VerticalLineEdge(0, true), 
            new HorizontalLineEdge(0, true),
            new LineEdge(R/2, -0.5, false)
        };

        Figure figures[] = {
            new Figure(circle), 
            new Figure(square), 
            new Figure(triangle),    
        };
        CombinedFigure combinedFigure = new CombinedFigure(figures);


        if(combinedFigure.check_inside(p_x, p_y))
            System.out.println("🟢 Point is located on the figure");
        else
            System.out.println("🔴 Point is located outside the figure"); 

    }  
}  