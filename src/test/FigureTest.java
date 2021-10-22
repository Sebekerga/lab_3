package test;

import static org.junit.Assert.*;
import org.junit.Test;

import main.Edge.*;
import main.Figure;

public class FigureTest {

    // https://www.desmos.com/calculator/degndyzjga
    @Test 
    public void EllipsePartialTest(){
        Edge primitives[] = {
            new EllipseEdge(1, 1, 0, 2, false),
            new HorizontalLineEdge(2, true),
            new LineEdge(2, 1, true)
        };
        Figure ellipsePartial = new Figure(primitives);

        double inside_points[][] = {
            {-0.9,  2.1}, 
            { 0.0,  2.2}, 
            { 0.6,  2.7}, 
            {-0.5,  2.8}};
        for(int i = 0; i < inside_points.length; i++){
            assertTrue("NI I I " + Integer.toString(i), ellipsePartial.check_inside     (inside_points[i][0], inside_points[i][1]));
            assertFalse("NI I O " + Integer.toString(i), ellipsePartial.check_outside   (inside_points[i][0], inside_points[i][1]));
        }
        
        double edge_points[][] = {
            {-0.4, 2.0}, 
            { 0.4, 2.4},  
            { 0.707, 2.707}, 
            {-0.6, 2.8}};
        for(int i = 0; i < edge_points.length; i++){
            assertTrue("NI E I " + Integer.toString(i), ellipsePartial.check_inside     (edge_points[i][0], edge_points[i][1]));
            assertFalse("NI E O " + Integer.toString(i), ellipsePartial.check_outside   (edge_points[i][0], edge_points[i][1]));
        }

        double outside_points[][] = {
            { 0.0, 1.9}, 
            { 0.7, 2.6}, 
            { 0.7, 2.8}, 
            {-0.7, 1.2}, 
            {-1.1, 2.1}, 
            {-0.2, 1.9}};
        for(int i = 0; i < outside_points.length; i++){
            assertFalse("NI O I " + Integer.toString(i), ellipsePartial.check_inside     (outside_points[i][0], outside_points[i][1]));
            assertTrue("NI O O " + Integer.toString(i), ellipsePartial.check_outside   (outside_points[i][0], outside_points[i][1]));
        }         
    }
    
    // https://www.desmos.com/calculator/okgy53tdfo
    @Test
    public void TriangleTest(){
        Edge primitives[] = {
            new LineEdge(2, 2, true),
            new HorizontalLineEdge(2, false),
            new VerticalLineEdge(-2, true),
        };
        Figure triangle = new Figure(primitives);

        double inside_points[][] = {
            {-0.1, 1.9},
            {-1.9, 1.9},
            {-1.9,-1.7}};
        for(int i = 0; i < inside_points.length; i++){
            assertTrue("NI I I " + Integer.toString(i), triangle.check_inside     (inside_points[i][0], inside_points[i][1]));
            assertFalse("NI I O " + Integer.toString(i), triangle.check_outside   (inside_points[i][0], inside_points[i][1]));
        }
        
        double edge_points[][] = {
            { 0.0, 2.0},
            {-1.0, 2.0},
            {-2.0, 2.0},
            {-2.0, 0.3},
            {-2.0,-2.0},
            {-1.2,-0.4}};
        for(int i = 0; i < edge_points.length; i++){
            assertTrue("NI E I " + Integer.toString(i), triangle.check_inside     (edge_points[i][0], edge_points[i][1]));
            assertFalse("NI E O " + Integer.toString(i), triangle.check_outside   (edge_points[i][0], edge_points[i][1]));
        }

        double outside_points[][] = {
            { 0.1, 2.1},
            {-1.0, 2.1},
            {-2.1, 2.1},
            {-2.1, 0.1},
            {-2.1,-2.3},
            {-0.6, 0.7}};
        for(int i = 0; i < outside_points.length; i++){
            assertFalse("NI O I " + Integer.toString(i), triangle.check_inside     (outside_points[i][0], outside_points[i][1]));
            assertTrue("NI O O " + Integer.toString(i), triangle.check_outside   (outside_points[i][0], outside_points[i][1]));
        }         
    }
}
