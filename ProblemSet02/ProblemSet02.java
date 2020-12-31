import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ProblemSet02
{
    public static void america()
    {
        //create a Scanner for the input file 
        File f = new File("./src/input/usa.txt");
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            //parse the initial data to obtain the canvas coordinates
            String firstLine = br.readLine();
            String[] canvasSize_String = firstLine.split(" ");
            double[] canvasSize = new double[canvasSize_String.length];
            for(int i = 0; i< canvasSize.length; i++)
            {
            	String num = canvasSize_String[i].trim();
            	canvasSize[i] = Double.parseDouble(num);
            }
            int xWidth = (int) (((canvasSize[2] - canvasSize[0])/(canvasSize[3]-canvasSize[1]))*512);
            StdDraw.setCanvasSize(xWidth,512);
            StdDraw.setYscale(canvasSize[1],canvasSize[3]);
            StdDraw.setXscale(canvasSize[0], canvasSize[2]);
            String pointString = br.readLine();
            while(br.ready())
            {
                double[] point = returnPoints(pointString);
                StdDraw.point(point[0],point[1]);
                pointString = br.readLine();
            }
            
            br.close();
            fr.close();
        }
        catch( Exception e)
        {
            e.toString();
        }
       
        
          
            // //scale the width of the canvas. keep the default height of 512, and adjust the width proportionally
            // //int xProportion = canvasSize[]
            // 
        // } 
        // catch (Exception e) {
            
            // e.toString();
        // }      

        // //for speed of application wait to display the image until the program is complete. for cool effect, disable doubleBuffering
        StdDraw.enableDoubleBuffering();
        StdDraw.show();

        // //there isn't an integer to tell us how many lines of code exist,
        // //so you should first check if there is still a line in existence
        // //revist BufferedReader's documentation to discover how to see if there is still text remaining

        // // Since doubleBuffering was enabled, call StdDraw.show() at the end to view your map. 
        
    }
    public static double[] returnPoints (String line)
    {
        String[] lineSplit = line.split("   ");
        double[] points = new double[lineSplit.length];
        for(int i = 0; i< points.length; i++)
        {
            points[i] = Double.parseDouble(lineSplit[i]);
        }
        return points;
    }

    public static void web(int n, double p)
    {
    	
    	StdDraw.setCanvasSize();
        StdDraw.setScale(-2,2);
        StdDraw.setPenRadius(0.005);
        
        // draws the points around the circle and puts all the points in a 2d array
        double[][] points = drawPointsOnWeb(n);
 
        // for each point in points, randomly draw a line between any other point with a probability of p. 
        for(int i = 0; i< n; i++)
        {
        	double[] point1 = points[i];
        	for(int j = 0; j< n; j++)
        	{
        		double[] point2 = points[j];
        		double num = Math.random();
        		if(num<p) 
        		{
        			StdDraw.line(point1[0], point1[1], point2[0], point2[1]);
        		}
        	}
        }    
    }
    public static double[][] drawPointsOnWeb(int n)
    {
    	
    	double degreesPerDot = (360.0/n);
    	double radiansPerDot = Math.toRadians(degreesPerDot);
    	double currentRadian = 0; 
    	double[][] points = new double[n][2];
    	for(int i = 0; i< n; i++)
    	{
    		points[i][0] = Math.cos(currentRadian);
    		points[i][1] = Math.sin(currentRadian);
    		StdDraw.point(points[i][1], points[i][0]);
    		currentRadian+= radiansPerDot;
    	}
    	return points;  	
    }

    
    public static void checkerboard(int n)
    {
    	StdDraw.setCanvasSize();
        StdDraw.setScale(0,n);
        double squareLength = 1;//scale/n = n/n = 1
        double halfLength = squareLength/2;
        for(int i = 0; i< n; i++)
        {
            for(int j = 0; j< n; j++)
            {
                if((i+j)%2 == 0)
                {
                    StdDraw.setPenColor(StdDraw.CYAN);
                }
// for different colors
//                else if((i+j)%2 == 0)
//                {
//                	StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
//                }
//                else if((i+j)%4 == 0)
//                {
//                	StdDraw.setPenColor(StdDraw.BOOK_BLUE);
//                }
//                else if((i+j)%5 == 0)
//                {
//                	StdDraw.setPenColor(StdDraw.BOOK_RED);
//                }
                else
                {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                }
                StdDraw.filledSquare(i+halfLength,j+halfLength,halfLength);
            }
        }
        StdDraw.enableDoubleBuffering();
        StdDraw.show();
    }
    
    public static void rose(int n)
    {
        StdDraw.setCanvasSize();
        StdDraw.setScale(-1.5, 1.5);
        double[][] points = new double[2][2];
        points[0][0] = 0;
        points[0][1] = 0;
        double x1 = points[0][0]; 
        double y1 = points[0][1];
        double x2 = points[1][0]; 
        double y2 = points[1][1];
        for(int degree = 0; degree< 360; degree++)
        {
        	
    		 double radians = Math.toRadians(degree);
    		 double r = Math.sin(n*radians);
    		 x2 = r*Math.cos(radians);
    		 y2 = r*Math.sin(radians);
    		 StdDraw.line(x1, y1, x2, y2);
    		 x1 = x2;
    		 y1 = y2;
        }
        	
//        for(int j = 0; j<points.length-1; j++)
//        {
//        	double[] point1 = points[i];
//        	double[] point2 = points[i+1];
//        	double x1 = point1[0];
//        	double y1 = point1[1];
//        	double x2 = point2[0]; 
//        	double y2 = point2[1];
//        	StdDraw.line(x1,y1,x2,y2);
//        }
        StdDraw.enableDoubleBuffering();
    	StdDraw.show();
    }
    public static void harmonicMotion ()
    {

        StdDraw.setCanvasSize();
        StdDraw.setYscale(-10,10);
        StdDraw.setXscale(0,10);
        double x1 = 0 ;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;
        for(int degree = 0; degree<360; degree++)
        {
        	
    		 double radians = Math.toRadians(degree);
    		
    		 x2 = radians;
    		 y2 = Math.sin(radians);
    		 StdDraw.line(x1, y1, x2, y2);
    		 x1 = x2;
    		 y1 = y2;
        }
        StdDraw.enableDoubleBuffering();
        StdDraw.show();
    }
    public static void main(String[] args)
    {
    	harmonicMotion();
    }
   
}