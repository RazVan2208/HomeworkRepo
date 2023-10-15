package Oct13HomeworkPart1;
import java.util.*;
public class OrderedPoints {
    ArrayList<Double> xPointList = new ArrayList<Double>();
    ArrayList<Double> yPointList = new ArrayList<Double>();
    public OrderedPoints(){

    }
    public void addPoint(double x, double y){
        int size = xPointList.size();
        if(size == 0){
            xPointList.add(x);
            yPointList.add(y);
            return;
        }
        for(int i = 0; i < xPointList.size(); i += 1){
            if(x < xPointList.get(i)){
                xPointList.add(i, x);
                yPointList.add(i, y);
                break;
            }
            else if(x > xPointList.get(size - 1)){
            xPointList.add(x);
            yPointList.add(y);
                break;
        }
        }

        
    
}
    public List<Double> getXValues(){
        for(double i : xPointList){
            System.out.println(i);
        }
        return xPointList;
    }
    public List<Double> getYValues(){

        for(double i : yPointList){
            System.out.println(i);
        }
        return yPointList;
    }
    public double getRenameX(int i){
        i = 0;
        return xPointList.get(i);
    }
    public double getYValue(int i){
        i = 0;
        return yPointList.get(i);
    }
    public void printPoints(){
        for(int i = 0; i < xPointList.size(); i += 1){
            System.out.println("(" + xPointList.get(i) + "," + yPointList.get(i) + ")");
        }
    }
}
