package Oct13HomeworkPart1;
import java.util.*;
public class OrderedPoints {
    ArrayList<Double> xPointList = new ArrayList<Double>();
    ArrayList<Double> yPointList = new ArrayList<Double>();
    public OrderedPoints(){

    }
    public void addPoint(double x, double y){
        for(int i = 1; i < xPointList.size(); i += 1){
            if(x > xPointList.get(i)){
            xPointList.add(i - 1, x);
            }
        }
        for(int i = 0; i < yPointList.size(); i += 1){
            if(y > xPointList.get(i)){
            yPointList.add(i - 1, y);
            }
        }
    
}
    public List<Double> getXValues(){
        double nextValue = 0;
        for(double i : xPointList){
            System.out.println(i);
        }
        return xPointList;
    }
}
