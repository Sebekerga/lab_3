package main;

import java.util.Scanner;
 
import main.Edge.*;

public class Main{  

    static String error_message = "input_format: {Radius} {x} {y}";
    static String line_end = "\n> ";

    public static void main(String args[]){  
        System.out.print(error_message + line_end); 
        Scanner in = new Scanner(System.in);
        while(true){
            float R = 1;
            float p_x = 0;
            float p_y = 0;

            String line[] = (in.nextLine()).split(" ");
            // checking arguments            
            try {
                R = Float.parseFloat(line[0]);
                p_x = Float.parseFloat(line[1]);
                p_y = Float.parseFloat(line[2]);
            } catch (NumberFormatException e){
                System.out.print("Use floats!" + line_end); 
                continue;
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.print(error_message + line_end); 
                continue;
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
                System.out.print("🟢 Point is located on the figure" + line_end);
            else
                System.out.print("🔴 Point is located outside the figure" + line_end); 
        }
    }  
}  