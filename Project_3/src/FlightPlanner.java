import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;

//This is going to be the flight planner class which will perform

public class FlightPlanner
{
    //This is the find function

    public static int find(LinkedList<LinkedList<FlightData>> list, String city)
    {

        //This is the for loop that gets the city information

        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getFirst().getCity().equals(city))
            {
                return i;
            }
        }
        return -1;

    }

    //This section is used to reset the path that we are looking at

    public static void resetFound(LinkedList<LinkedList<FlightData>> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            for(int j = 0; j < list.get(i).size(); j++)
            {
                list.get(i).get(j).setFound(false);
            }
        }
    }

    //This is the main function which will piece everything and utilize the Dijkstra's Algorithm

    public static void main(String args[]){

        LinkedList<LinkedList<FlightData>> list = new LinkedList<LinkedList<FlightData>>();

        //This try catch statement is to make sure that it open the appropriate files

        try {

            //This is the output.txt file that it will generate with the results

            PrintStream out = new PrintStream(new FileOutputStream("src/Output.txt"));
            System.setOut(out);

            //This file refers to the data with all the different flight paths

            File file = new File("src/FlightData.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String [] pipes;
            boolean present = true;;

            //This while loop is used to read and parse the FlightData.txt file

            while ((line = bufferedReader.readLine()) != null)
            {
                if (present)
                {
                    present = false;
                }
                else{

                    //This is where it is splitting each line and reading each section

                    pipes = line.split("\\|");
                    boolean found = false;
                    for (int i = 0; i < list.size() && !found; i++)
                    {
                        if(list.get(i).getFirst().getCity().equals(pipes[0]))
                        {
                            list.get(i).add(new FlightData(pipes[1],Integer.valueOf(pipes[2]), Integer.valueOf(pipes[3])));
                            found = true;
                        }
                    }
                    if (!found)
                    {
                        list.add(new LinkedList<FlightData>());
                        list.getLast().addFirst(new FlightData(pipes[0], 0, 0));
                        list.getLast().add(new FlightData(pipes[1], Integer.parseInt(pipes[2]), Integer.valueOf(pipes[3])));
                    }
                }
            }

            //This section will now be looking at the RequestedFlightData.txt and parsing that information

            String source;

            present = true;
            File request = new File("src/RequestedFlightData.txt");
            FileReader fileReader2 = new FileReader(request);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            while ((line = bufferedReader2.readLine()) != null)
            {
                if (present)
                {
                    present = false;
                }
                else {

                    //This section will parse through the RequestedFlightData.txt file

                    pipes = line.split("\\|");
                    source = pipes[0];
                    int index = find(list, source);

                    //This is what will happen if it is not able to find a source city

                    if (index == -1)
                    {
                        System.out.println("Sorry, there are no flights from " + pipes[0]);
                    }

                    //This is what will happen if there are able to find flights from a source city

                    else{
                        ArrayList<Path> paths = new ArrayList<Path>();
                        LinkedList<FlightData> sourceList = list.get(index);

                        //It will be using a linked list to figure out the destinations that are needed to figure out
                        //the paths.

                        for ( int j = 1; j < sourceList.size(); j++)
                        {
                            //This is where it is utilizing Dijitra's algorithm to figure out the path

                            FlightData city = sourceList.get(j);
                            Path original = new Path(sourceList.getFirst(), sourceList.get(j));
                            paths.add(original);
                            while(((index =find(list, city.getCity()) )!= -1 ))
                            {
                                if (list.get(index).getFirst().getFound())
                                {
                                    break;
                                }
                                LinkedList<FlightData> destList = list.get(index);
                                list.get(index).getFirst().setFound(true);
                                for (int k = 1; k < destList.size(); k++) {
                                    if (destList.get(k).getCity().equals(sourceList.getFirst().getCity()))
                                        continue;
                                    else {
                                        city = destList.get(k);
                                        paths.add(new Path(original, destList.get(k)));
                                    }
                                }
                            }

                        }

                        //This is used to search for the appropriate paths

                        LinkedList<Path> search = new LinkedList<Path>();
                        for (int i = 0; i < paths.size(); i++){
                            if ((paths.get(i).getCities().peek().getCity()).equals(pipes[1])){
                                search.add(paths.get(i));
                            }
                        }

                        //This is now going to be looking at the txt and figure out what data to print to output

                        int place = 0;
                        int shortest;

                        //This is going to be referring to the time segment

                        if (pipes[2].equals("T")){
                            System.out.println("Flight " + (place + 1) + ": " + pipes[0] + ", " + pipes[1] + " (Time)");

                            //This is what will happen if there are no flights

                            if (search.size() == 0)
                            {
                                System.out.println("Sorry, there are no flights from " + pipes[0] + " to " + pipes[1] );
                            }
                            int count = 0;

                            //This is what will happen if there are paths

                            while (count <= 3 && search.size() > 0){
                                System.out.print("Path " + (count + 1) + ": ");
                                shortest = 1000;
                                if (search.size() == 1)
                                {
                                    search.get(0).print();
                                    break;
                                }
                                else{
                                    for (int l = 0; l < search.size(); l++){
                                        if ((search.get(l).getTime()) <= shortest){
                                            place = l;
                                            shortest = search.get(l).getTime();
                                        }
                                    }
                                    search.get(place).print();
                                    search.remove(place);
                                    count++;
                                }
                            }
                        }

                        //This is dealing with the cost segment

                        if (pipes[2].equals("C"))
                        {
                            System.out.println("Flight " + (place + 1) + ": " + pipes[0] + ", " + pipes[1] + " (Cost)");

                            //This is what will happen if there are no flights

                            if (search.size() == 0)
                                System.out.println("Sorry, there are no flights from " + pipes[0] + " to " + pipes[1] );
                            {
                                int count = 0;

                                while (count <= 3 && search.size() > 0){
                                    System.out.print("Path " + (count + 1) + ": ");
                                    shortest = 1000;
                                    if (search.size() == 1){
                                        search.get(0).print();
                                        break;
                                    }
                                    else{
                                        for (int l = 0; l < search.size(); l++){
                                            if ((search.get(l).getCost()) <= shortest){
                                                place = l;
                                                shortest = search.get(l).getCost();
                                            }
                                        }
                                        search.get(place).print();
                                        search.remove(place);
                                        count++;
                                    }
                                }
                            }

                        }
                        System.out.println();
                        resetFound(list);
                    }
                }
            }

            //This is what will happen if there is an error

        }catch(IOException e){System.out.println("There is an error with the file.");}

    }
}
