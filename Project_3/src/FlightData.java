public class FlightData
{
    //These are the variables that are used in this class

    private String city;
    private int cost;
    private int time;
    boolean found;

    //This is the constructor that is used in this class

    public FlightData(String city, int cost, int time)
    {
        this.city = city;
        this.cost = cost;
        this.time= time;
    }

    //These are the getters that are used in this class

    public String getCity() {
        return city;
    }
    public int getCost() {
        return cost;
    }
    public int getTime() {
        return time;
    }

    //This is the getter and setters used for the boolean found variable

    public boolean getFound() {
        return found;
    }
    public void setFound(boolean found) {
        this.found = found;
    }
}
