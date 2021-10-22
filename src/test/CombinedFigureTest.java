package test;

import static org.junit.Assert.*;
import org.junit.Test;

import main.Edge.*;
import main.Figure;
import main.CombinedFigure;


public class CombinedFigureTest {
    
    // https://www.desmos.com/calculator/qquawgyqhk
    @Test
    public void CombinedFigure12354Test(){
        double raduises[] = {
            0.5,
            1.0,
            2.0,
            4.0,
            8.0,
            32.0,
            256.0,
            1024.0
        };

        for(int r = 0; r < raduises.length; r++){
            double R = raduises[r];
            String r_number = "R" + Integer.toString(r)+ " ";

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

            double inside_points[][] = {
                { 0.85*R, 0.05*R},
                { 0.05*R, 0.40*R},
                {-0.05*R, 0.45*R},
                {-0.40*R, 0.25*R},
                {-0.90*R,-0.10*R},
                {-0.95*R,-0.95*R},
                {-0.10*R,-0.95*R},
                {-0.05*R,-0.30*R},
                { 0.10*R, 0.05*R},
                { 0.30*R, 0.15*R},
                {-0.25*R, 0.10*R},
                {-0.55*R,-0.50*R}};
            for(int i = 0; i < inside_points.length; i++){
                assertTrue(r_number + "I I " + Integer.toString(i), combinedFigure.check_inside     (inside_points[i][0], inside_points[i][1]));
                assertFalse(r_number + "I O " + Integer.toString(i), combinedFigure.check_outside   (inside_points[i][0], inside_points[i][1]));
            }

            double edge_points[][] = {
                { 1.00*R, 0.00*R},
                { 0.40*R, 0.30*R},
                { 0.00*R, 0.50*R},
                {-0.40*R, 0.30*R},
                {-0.50*R, 0.00*R},
                {-0.85*R, 0.00*R},
                {-1.00*R, 0.00*R},
                {-1.00*R,-0.35*R},
                {-1.00*R,-1.00*R},
                {-0.40*R,-1.00*R},
                { 0.00*R,-1.00*R},
                { 0.00*R,-0.40*R},
                { 0.00*R, 0.00*R},
                { 0.60*R, 0.00*R}};
            for(int i = 0; i < edge_points.length; i++){
                assertTrue(r_number + "E I " + Integer.toString(i), combinedFigure.check_inside     (edge_points[i][0], edge_points[i][1]));
                assertFalse(r_number + "E O " + Integer.toString(i), combinedFigure.check_outside   (edge_points[i][0], edge_points[i][1]));
            }

            double outside_points[][] = {
                { 0.05*R,-0.05*R},
                { 1.05*R,-0.05*R},
                { 0.10*R, 0.50*R},
                {-0.30*R, 0.45*R},
                {-0.55*R, 0.05*R},
                {-1.05*R, 0.05*R},
                {-1.10*R,-0.45*R},
                {-1.05*R,-1.10*R},
                {-0.15*R,-1.05*R},
                { 0.05*R,-0.80*R}};
            for(int i = 0; i < outside_points.length; i++){
                assertFalse(r_number + "O I " + Integer.toString(i), combinedFigure.check_inside     (outside_points[i][0], outside_points[i][1]));
                assertTrue(r_number + "O O " + Integer.toString(i), combinedFigure.check_outside   (outside_points[i][0], outside_points[i][1]));
            }        
        }
    }
}
