import java.util.ArrayList;
import java.util.Stack;

public class Path
{

    //These are variables used in this class

    private Stack<FlightData> cities;
    private int cost;
    private int time;

    //This is the constructor used if we know the source and the destination

    public Path(FlightData source, FlightData destination)
    {
        cities = new Stack<FlightData> ();
        this.cities.push(source);
        this.cities.push(destination);
        this.cost = destination.getCost();
        this.time = destination.getTime();
    }

    //This is the constructor used if we know the path and the destination

    public Path(Path path, FlightData destination){
        Stack<FlightData> list = path.getCities();
        this.cities = (Stack<FlightData>)list.clone();
        this.cities.push(destination);
        this.cost = path.getCost() + destination.getCost();
        this.time = path.getTime() + destination.getTime();

    }

    //These are the getters used in this class

    public Stack<FlightData> getCities() {
        return cities;
    }
    public int getCost() {
        return cost;
    }
    public int getTime() {
        return time;
    }

    //This function is used to print the different paths

    public void print()
    {
        ArrayList<String> cities = new ArrayList<String> ();
        Stack<FlightData> list = (Stack<FlightData>) this.cities.clone();
        while(!list.isEmpty()){
            cities.add(list.pop().getCity());
        }

        //This function is used to print out the paths for a certain flight

        for (int i = (cities.size()-1); i >=0; i--){
            if (i == 0)
                System.out.print(cities.get(i) + ". ");
            else
                System.out.print(cities.get(i) + " -> ");
        }
        System.out.println("Time: " + this.time + " Cost: " + this.cost);
    }
}
