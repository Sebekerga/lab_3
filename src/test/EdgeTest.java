package test;

import static org.junit.Assert.*;
import org.junit.Test;

import main.Edge.*;

public class EdgeTest {

    @Test
    public void VerticalLineEdgeTest() {

        Edge vertLineNonInverted = new VerticalLineEdge(1.0, false);
        // point to the left of the line 
        assertTrue("NI L I", vertLineNonInverted.check_inside   (0.5, -0.5));
        assertFalse("NI L O", vertLineNonInverted.check_outside (0.5, 0.5));
        // point on the line 
        assertTrue("NI O I", vertLineNonInverted.check_inside  (1.0, -0.5));
        assertFalse("NI O O", vertLineNonInverted.check_outside (1.0, 0.5));
        // point to the right of the line 
        assertFalse("NI R I", vertLineNonInverted.check_inside  (1.5, -0.5));
        assertTrue("NI R O", vertLineNonInverted.check_outside  (1.5, 0.5));


        Edge vertLineInverted = new VerticalLineEdge(1.0, true);
        // point to the left of the line 
        assertFalse("I L I",  vertLineInverted.check_inside     (0.5, -0.5));
        assertTrue("I L O",  vertLineInverted.check_outside     (0.5, 0.5));
        // point on the line 
        assertTrue("I O I",  vertLineInverted.check_inside     (1.0, -0.5));
        assertFalse("I O O",  vertLineInverted.check_outside    (1.0, 0));
        // point to the right of the line 
        assertTrue("I R I",  vertLineInverted.check_inside      (1.5, -0.5));
        assertFalse("I R O",  vertLineInverted.check_outside    (1.5, 0.5));
    }

    @Test
    public void HorizontalLineEdgeTest() {

        Edge horizLineNonInverted = new HorizontalLineEdge(1.0, false);
        // point above of the line
        assertFalse("NI A I", horizLineNonInverted.check_inside (-0.5, 1.5));
        assertTrue("NI A O", horizLineNonInverted.check_outside (0.5, 1.5));
        // point on the line 
        assertTrue("NI O I", horizLineNonInverted.check_inside (-0.5, 1.0));
        assertFalse("NI O O", horizLineNonInverted.check_outside(0.5, 1.0));
        // point below  the line
        assertTrue("NI B I", horizLineNonInverted.check_inside  (-0.5, 0.5));
        assertFalse("NI B O", horizLineNonInverted.check_outside(0.5, 0.5));


        Edge horizLineInverted = new HorizontalLineEdge(1.0, true);
        // point above of the line
        assertTrue("I A I", horizLineInverted.check_inside      (-0.5, 1.5));
        assertFalse("I A O", horizLineInverted.check_outside    (0.5, 1.5));

        // point on the line 
        assertTrue("I O I", horizLineInverted.check_inside     (-0.5, 1.0));
        assertFalse("I O O", horizLineInverted.check_outside    (0.5, 1.0));

        // point below  the line
        assertFalse("I B I", horizLineInverted.check_inside     (-0.5, 0.5));
        assertTrue("I B O", horizLineInverted.check_outside     (0.5, 0.5));
    }
    
    @Test 
    public void LineEdgeTest(){       

        Edge lineNonInverted = new LineEdge(1.0, 0.5, false);
        // point above of the line
        assertTrue("NI B I", lineNonInverted.check_inside       (1.0, 0.0));
        assertFalse("NI B O", lineNonInverted.check_outside     (1.0, 0.0));
        // point on the line 
        assertTrue("NI O I", lineNonInverted.check_inside      (3.0, 2.5));
        assertFalse("NI O O", lineNonInverted.check_outside     (3.0, 2.5));
        // point below  the line
        assertFalse("NI A I", lineNonInverted.check_inside      (-1.0, 1.0));
        assertTrue("NI A O", lineNonInverted.check_outside      (-1.0, 1.0));

        Edge lineInverted = new LineEdge(1.0, 0.5, true);
        // point above of the line
        assertFalse("I B I", lineInverted.check_inside          (1.0, 0.0));
        assertTrue("I B O", lineInverted.check_outside          (1.0, 0.0));
        // point on the line 
        assertTrue("I O I", lineInverted.check_inside          (3.0, 2.5));
        assertFalse("I O O", lineInverted.check_outside         (3.0, 2.5));
        // point below  the line
        assertTrue("I A I", lineInverted.check_inside           (-1.0, 1.0));
        assertFalse("I A O", lineInverted.check_outside         (-1.0, 1.0));   
    }

    @Test
    public void EllipseEdgeTest(){
        Edge ellipseNonInverted = new EllipseEdge(4, 1, -3, -1, false);

        double inside_points[][] = {
            { 0.8, -0.9}, 
            {-2.3, -0.1}, 
            {-6.6, -1.3}, 
            {-1.9, -1.8}};
        for(int i = 0; i < inside_points.length; i++){
            assertTrue("NI I I " + Integer.toString(i), ellipseNonInverted.check_inside     (inside_points[i][0], inside_points[i][1]));
            assertFalse("NI I O " + Integer.toString(i), ellipseNonInverted.check_outside   (inside_points[i][0], inside_points[i][1]));
        }
        
        double edge_points[][] = {
            {-0.6, -1.8}, 
            {-6.82, -0.704},  
            {-5.0, -0.134}, 
            {-4.74, -1.9}};
        for(int i = 0; i < edge_points.length; i++){
            assertTrue("NI E I " + Integer.toString(i), ellipseNonInverted.check_inside     (edge_points[i][0], edge_points[i][1]));
            assertFalse("NI E O " + Integer.toString(i), ellipseNonInverted.check_outside   (edge_points[i][0], edge_points[i][1]));
        }

        double outside_points[][] = {
            {-0.3, -0.2}, 
            {-6.9, -0.7}, 
            {-5.5, -1.8}, 
            { 0.7, -1.4}};
        for(int i = 0; i < outside_points.length; i++){
            assertFalse("NI O I " + Integer.toString(i), ellipseNonInverted.check_inside     (outside_points[i][0], outside_points[i][1]));
            assertTrue("NI O O " + Integer.toString(i), ellipseNonInverted.check_outside   (outside_points[i][0], outside_points[i][1]));
        }        
    }
}
