import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by LaunchCode
 */
public class TechJobs {

    static Scanner in = new Scanner(System.in);

    public static void main (String[] args) {

        // Initialize our field map with key/name pairs
        HashMap<String, String> columnChoices = new HashMap<>();
        //hash_map.put(key,value)
        columnChoices.put("core competency", "Skill");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("position type", "Position Type");
        columnChoices.put("all", "All");

        // Top-level menu options
        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        System.out.println("Welcome to LaunchCode's TechJobs App!");

        // Allow the user to search until they manually quit

        while (true) {

            String actionChoice = getUserSelection("View jobs by (type 'x' to quit):", actionChoices);

            if (actionChoice == null) { break;}
            else if (actionChoice.equals("list")) {

                String columnChoice = getUserSelection("List", columnChoices);

                if (columnChoice.equals("all")) { printJobs(JobData.findAll());}
                else {
                    ArrayList<String> results = JobData.findAll(columnChoice);
                    System.out.println("\n*** All " + columnChoices.get(columnChoice) + " Values ***");

                    // Print list of skills, employers, etc
                    for (String item : results) {
                        System.out.println(item);
                    }//for item:results
                }//innerelse - elseif actionChoice.equals("list")

            } else { // choice is "search"

                // How does the user want to search (e.g. by skill or employer)
                String searchField = getUserSelection("Search by:", columnChoices);

                // What is their search term?
                System.out.println("\nSearch term:");
                String searchTerm = in.nextLine();

                if (searchField.equals("all")) {
                    printJobs(JobData.findByValue(searchTerm));
                } else {
                    printJobs(JobData.findByColumnAndValue(searchField, searchTerm));
                }
            }
        }
    }       //main method

    // ﻿Returns the key of the selected item from the choices Dictionary
    private static String getUserSelection(String menuHeader, HashMap<String, String> choices) {

        int choiceIdx = -1;
        Boolean validChoice = false;
        String[] choiceKeys = new String[choices.size()];

        // Put the choices in an ordered structure so we can
        // associate an integer with each one
        int i = 0;
        for (String choiceKey : choices.keySet()) {
            choiceKeys[i] = choiceKey;
            i++;
        }

        do {

            System.out.println("\n" + menuHeader);

            // Print available choices
            for (int j = 0; j < choiceKeys.length; j++) {
                System.out.println("" + j + " - " + choices.get(choiceKeys[j]));
            }

            if (in.hasNextInt()) {
                choiceIdx = in.nextInt();
                in.nextLine();
            } else {
                String line = in.nextLine();
                boolean shouldQuit = line.equals("x");
                if (shouldQuit) {
                    return null;
                }
            }

            // Validate user's input
            if (choiceIdx < 0 || choiceIdx >= choiceKeys.length) {
                System.out.println("Invalid choice. Try again.");
            } else {
                validChoice = true;
            }

        } while(!validChoice);

        return choiceKeys[choiceIdx];
    }       //getUserSettings method

    // Print a list of jobs
    //iterating over arraylist and accessing values with get("key")
    private static void printJobs(ArrayList<HashMap<String, String>> someJobs) {
        //No values check

        if(someJobs.isEmpty()){ System.out.print("No Results");}
        // check count - System.out.println(someJobs.size());
        //using 2 for loops to open the aray list and access the
        for(HashMap<String, String> element:someJobs){
            System.out.println("\n*****");
            //testing if key only can be used
            for (String key : element.keySet()) {

                System.out.println(key + ": " + element.get(key));
            }

//            for (Map.Entry<String, String> job : element.entrySet()) {
//
//                System.out.println(job.getKey() + ": " + job.getValue());
//            }
            System.out.print("*****\n");

            //output sanity tests
            /*
            // System.out.println(someJobs);
            // System.out.println(element);
            //System.out.println(element.getClass());
            //System.out.println(element.toString());
            //System.out.println(element.get("position type"));

             */
/*
            System.out.format(
                    "\n*****\n" +
                    "position type: %s\n" +
                    "name: %s\n" +
                    "employer: %s\n" +
                    "location: %s\n" +
                    "core competency: %s\n" +
                    "*****\n",
                    element.get("position type"),
                    element.get("name"),
                    element.get("employer"),
                    element.get("location"),
                    element.get("core competency")

            );      // sout format*/
        }       // for element:someJobs

    }       // printJobs Method
}
