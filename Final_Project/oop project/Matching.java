/**
 * A class to represent the Matching class of the MentorConnect.
 * This is where the matching algorithm is.
 **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Matching {
        // HashMaps to store mentee and mentor data
        static HashMap<String, Mentee> dataMentees = new HashMap<>();
        static HashMap<String, Mentor> dataMentors = new HashMap<>();
    
        // Files to read mentee and mentor data from
        static File menteeFile = new File("data/mentees.txt");
        static File mentorFile = new File("data/mentors.txt");
    
        /**
         * Reads mentee data from a file and populates the dataMentees HashMap.
         */
        public static void readMenteeData() { 
            try {
                // Open the file for reading
                Scanner menteeReader = new Scanner(menteeFile);
                ArrayList<String> menteeData = new ArrayList<>();
    
                while (menteeReader.hasNextLine()) {
                    String line = menteeReader.nextLine();
    
                    // If line is \EOD, end of mentee data, where EOD represents End of Data
                    if (line.equals("EOD")) {
                        // Create the object
                        Mentee mentee = createMenteeObject(menteeData);
                        dataMentees.put(mentee.getUserName(), mentee);    
                        // Clear data from menteeData ArrayList
                        menteeData = new ArrayList<>();
                    } else {
                        // Add mentee data
                        menteeData.add(line);
                    }
                }
    
                // Close the file
                menteeReader.close();
            } catch (FileNotFoundException fnfe) {
                System.out.println("File not found!");
                fnfe.printStackTrace();
            }
        }
    
        /**
         * Reads mentor data from a file and populates the dataMentors HashMap.
         */
        public static void readMentorData() {
    
            try {
                // Open the file for reading
                Scanner mentorReader = new Scanner(mentorFile);
                ArrayList<String> mentorData = new ArrayList<>();
    
                while (mentorReader.hasNextLine()) {
                    String line = mentorReader.nextLine();
    
                    // If line is \EOD, end of mentor data, where EOD represents End of Data
                    if (line.equals("EOD")) {
                        // Create the object
                        Mentor mentor = createMentorObject(mentorData);
                        dataMentors.put(mentor.getUserName(), mentor);    
                        // Clear data from mentorData ArrayList
                        mentorData = new ArrayList<>();
                    } else {
                        // Add mentor data
                        mentorData.add(line);
                    }
                }
    
                // Close the file
                mentorReader.close();
            } catch (FileNotFoundException fnfe) {
                System.out.println("File not found!");
                fnfe.printStackTrace();
            }
        }
    

     /**
     * Writes mentee data to the mentees file.
     * 
     * @param obj HashMap containing mentee objects
     */
    public static void writeMentee(HashMap<String, Mentee> obj){
        try{
            FileWriter writeMentee = new FileWriter("data/mentees.txt");
            for (Mentee mentee: obj.values()){
                // Construct strings for interests, traits, and availability
                StringBuilder ints = new StringBuilder();
                for (int i = 0; i < mentee.getInterests().size(); i++){
                    ints.append(mentee.getInterests().get(i));
                    ints.append(",");
                }
                StringBuilder traits = new StringBuilder();
                for(int i = 0; i < mentee.getTraits().size(); i++){
                    traits.append(mentee.getTraits().get(i));
                    traits.append(",");
                }
                StringBuilder mondayAvailability = new StringBuilder();
                StringBuilder tuesdayAvailability = new StringBuilder();
                StringBuilder wednesdayAvailability = new StringBuilder();
                StringBuilder thursdayAvailability = new StringBuilder();
                StringBuilder fridayAvailability = new StringBuilder();
                
                // Loop through availability array to append availability for each day
                for (int i = 0; i < mentee.getAvailability().length; i++) {
                    for (int j = 0; j < mentee.getAvailability()[i].length; j++) {
                        switch (i) {
                            case 0:
                                mondayAvailability.append(mentee.getAvailability()[i][j]);
                                break;
                            case 1:
                                tuesdayAvailability.append(mentee.getAvailability()[i][j]);
                                break;
                            case 2:
                                wednesdayAvailability.append(mentee.getAvailability()[i][j]);
                                break;
                            case 3:
                                thursdayAvailability.append(mentee.getAvailability()[i][j]);
                                break;
                            case 4:
                                fridayAvailability.append(mentee.getAvailability()[i][j]);
                                break;
                        }
                    }
                }

                // Write mentee data to file
                writeMentee.write(mentee.getFullName()+","+mentee.getUserName()+","+ mentee.getEmail()+","+ mentee.getPassword()+ ","+mentee.getMeetingType()+","+mentee.getLanguage()+"\n"+ mentee.getMajor()+ ","+ mentee.getCareerChoice()+","+ mentee.getFunFact()+"\n"+ints+ "\n"+ traits + "\n" +mondayAvailability+ "\n"+ tuesdayAvailability + "\n"+ wednesdayAvailability + "\n"+ thursdayAvailability + "\n"+ fridayAvailability + "\n" + "EOD\n");
            }
            writeMentee.close();
        }catch(IOException e){
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    /**
     * Writes mentor data to the mentors file.
     * 
     * @param obj HashMap containing mentor objects
     */
    public static void writeMentor(HashMap<String, Mentor> obj){
        try{
            FileWriter writeMentor = new FileWriter("data/mentors.txt");
            for (Mentor mentor: obj.values()){
                // Construct strings for interests, traits, notifications, and availability
                StringBuilder ints = new StringBuilder();
                for (int i = 0; i < mentor.getInterests().size(); i++){
                    ints.append(mentor.getInterests().get(i));
                    ints.append(",");
                }
                StringBuilder traits = new StringBuilder();
                for(int i = 0; i < mentor.getTraits().size(); i++){
                    traits.append(mentor.getTraits().get(i));
                    traits.append(",");
                }

                StringBuilder mondayAvailability = new StringBuilder();
                StringBuilder tuesdayAvailability = new StringBuilder();
                StringBuilder wednesdayAvailability = new StringBuilder();
                StringBuilder thursdayAvailability = new StringBuilder();
                StringBuilder fridayAvailability = new StringBuilder();
                
                // Loop through availability array to append availability for each day
                for (int i = 0; i < mentor.getAvailability().length; i++) {
                    for (int j = 0; j < mentor.getAvailability()[i].length; j++) {
                        switch (i) {
                            case 0:
                                mondayAvailability.append(mentor.getAvailability()[i][j]);
                                break;
                            case 1:
                                tuesdayAvailability.append(mentor.getAvailability()[i][j]);
                                break;
                            case 2:
                                wednesdayAvailability.append(mentor.getAvailability()[i][j]);
                                break;
                            case 3:
                                thursdayAvailability.append(mentor.getAvailability()[i][j]);
                                break;
                            case 4:
                                fridayAvailability.append(mentor.getAvailability()[i][j]);
                                break;
                        }
                    }
                }

                // Write mentor data to file
                writeMentor.write(mentor.getFullName()+","+mentor.getUserName()+","+ mentor.getEmail()+","+ mentor.getPassword()+ ","+mentor.getMeetingType()+","+mentor.getLanguage()+"\n"+ mentor.getYearsOfExperience()+ ","+ mentor.getJobTitle()+","+ mentor.getJobPosition()+"," + mentor.getfunFact()+"\n"+ints+ "\n"+ traits +"\n" + mondayAvailability +"\n"+ tuesdayAvailability + "\n"+ wednesdayAvailability + "\n"+ thursdayAvailability + "\n"+ fridayAvailability + "\nEOD\n");
            }
            writeMentor.close();
        }catch(IOException e){
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }
      /**
     * Creates a Mentee object based on the provided mentee data.
     *
     * @param menteeData ArrayList containing mentee data
     * @return Mentee object created from the provided data
     */
    public static Mentee createMenteeObject(ArrayList<String> menteeData) {
        // preprocess the string arraylist
        final int GENERAL_INFO_INDEX = 0;
        final int MENTEE_INFO_INDEX = 1;
        final int INTERESTS_INFO_INDEX = 2;
        final int TRAITS_INFO_INDEX = 3;
        final int MONDAY_AVAILABILITY_INDEX = 4;
        final int TUESDAY_AVAILABILITY_INDEX = 5;
        final int WEDNESDAY_AVAILABILITY_INDEX =6;
        final int THURSDAY_AVAILABILITY_INDEX = 7;
        final int FRIDAY_AVAILABILITY_INDEX = 8;

        // preprocess general info
        final int FULL_NAME_INDEX = 0;
        final int USER_NAME_INDEX = 1;
        final int EMAIL_INDEX = 2;
        final int PASSWORD_INDEX = 3;
        final int MEETING_TYPE_INDEX = 4;
        final int PREFERRED_LANGUAGE_INDEX = 5;
        
        String generalInfoString = menteeData.get(GENERAL_INFO_INDEX);
        String[] generalInfo = generalInfoString.split(",");

        // preprocess mentee info
        final int MAJOR_INDEX = 0;
        final int CAREER_CHOICE_INDEX = 1;
        final int EXTAR_CURRICULAR_ACTIVITIES_INDEX = 2;

        String menteeInfoString = menteeData.get(MENTEE_INFO_INDEX);
        String[] menteeInfo = menteeInfoString.split(",");

        // preprocess interests info
        String interests_string = menteeData.get(INTERESTS_INFO_INDEX);
        String[] interests_array = interests_string.split(",");
        ArrayList<String> interests = new ArrayList<>(Arrays.asList(interests_array));

        // preprocess traits info
        String traits_string = menteeData.get(TRAITS_INFO_INDEX);
        String[] traits = traits_string.split(",");
        ArrayList<String> personalityTraits = new ArrayList<>(Arrays.asList(traits));

        // preprocess availability
        String mondayString = menteeData.get(MONDAY_AVAILABILITY_INDEX);
        String[] mondayAvailability = mondayString.split(",");

        String tuesdayString = menteeData.get(TUESDAY_AVAILABILITY_INDEX);
        String[] tuesdayAvailability = tuesdayString.split(",");

        String wednesdayString = menteeData.get(WEDNESDAY_AVAILABILITY_INDEX);
        String[] wednesdayAvailability = wednesdayString.split(",");

        String thursdayString = menteeData.get(THURSDAY_AVAILABILITY_INDEX);
        String[] thursdayAvailability = thursdayString.split(",");

        String fridayString = menteeData.get(FRIDAY_AVAILABILITY_INDEX);
        String[] fridayAvailability = fridayString.split(",");

        String[][] availability = {mondayAvailability, tuesdayAvailability, wednesdayAvailability, thursdayAvailability, fridayAvailability};
        // Return the created Mentee object
        return new Mentee (
            menteeInfo[MAJOR_INDEX], 
            menteeInfo[CAREER_CHOICE_INDEX], 
            menteeInfo[EXTAR_CURRICULAR_ACTIVITIES_INDEX], 
            generalInfo[FULL_NAME_INDEX], 
            generalInfo[PASSWORD_INDEX], 
            generalInfo[EMAIL_INDEX], 
            interests, 
            generalInfo[USER_NAME_INDEX], 
            personalityTraits, 
            generalInfo[PREFERRED_LANGUAGE_INDEX], 
            generalInfo[MEETING_TYPE_INDEX], 
            availability
        );
    }

     /**
     * Creates a Mentor object based on the provided mentor data.
     *
     * @param mentorData ArrayList containing mentor data
     * @return Mentor object created from the provided data
     */
    public static Mentor createMentorObject(ArrayList<String> mentorData) {
        // preprocess the string arraylist
        final int GENERAL_INFO_INDEX = 0;
        final int MENTOR_INFO_INDEX = 1;
        final int INTERESTS_INFO_INDEX = 2;
        final int TRAITS_INFO_INDEX = 3;
        final int MONDAY_AVAILABILITY_INDEX = 4;
        final int TUESDAY_AVAILABILITY_INDEX = 5;
        final int WEDNESDAY_AVAILABILITY_INDEX = 6;
        final int THURSDAY_AVAILABILITY_INDEX = 7;
        final int FRIDAY_AVAILABILITY_INDEX = 8;

        // preprocess general info
        final int FULL_NAME_INDEX = 0;
        final int USER_NAME_INDEX = 1;
        final int EMAIL_INDEX = 2;
        final int PASSWORD_INDEX = 3;
        final int MEETING_TYPE_INDEX = 4;
        final int PREFERRED_LANGUAGE_INDEX = 5;
        
        String generalInfoString = mentorData.get(GENERAL_INFO_INDEX);
        String[] generalInfo = generalInfoString.split(",");

        // preprocess mentor info
        final int YEARS_OF_EXPERIENCE_INDEX = 0;
        final int JOB_TITLE_INDEX = 1;
        final int JOB_POSITION_INDEX = 2;
        final int EXPERTISE_AREAS_INDEX = 3;

        String mentorInfoString = mentorData.get(MENTOR_INFO_INDEX);
        String[] mentorInfo = mentorInfoString.split(",");

        // preprocess interests info
        String interests_string = mentorData.get(INTERESTS_INFO_INDEX);
        String[] interests_array = interests_string.split(",");
        ArrayList<String> interests = new ArrayList<>(Arrays.asList(interests_array));

        // preprocess traits info
        String traits_string = mentorData.get(TRAITS_INFO_INDEX);
        String[] traits = traits_string.split(",");
        ArrayList<String> personalityTraits = new ArrayList<>(Arrays.asList(traits));

        // preprocess availability
        String mondayString = mentorData.get(MONDAY_AVAILABILITY_INDEX);
        String[] mondayAvailability = mondayString.split(",");

        String tuesdayString = mentorData.get(TUESDAY_AVAILABILITY_INDEX);
        String[] tuesdayAvailability = tuesdayString.split(",");

        String wednesdayString = mentorData.get(WEDNESDAY_AVAILABILITY_INDEX);
        String[] wednesdayAvailability = wednesdayString.split(",");

        String thursdayString = mentorData.get(THURSDAY_AVAILABILITY_INDEX);
        String[] thursdayAvailability = thursdayString.split(",");
        String fridayString = mentorData.get(FRIDAY_AVAILABILITY_INDEX);
        String[] fridayAvailability = fridayString.split(",");
        String[][] availability = {mondayAvailability, tuesdayAvailability, wednesdayAvailability, thursdayAvailability, fridayAvailability};
        
        // Return the created Mentor object
        return new Mentor (
            Integer.parseInt(mentorInfo[YEARS_OF_EXPERIENCE_INDEX]), 
            mentorInfo[JOB_POSITION_INDEX], 
            mentorInfo[JOB_TITLE_INDEX], 
            generalInfo[EXPERTISE_AREAS_INDEX], 
            generalInfo[FULL_NAME_INDEX], 
            generalInfo[PASSWORD_INDEX], 
            generalInfo[EMAIL_INDEX],
            interests, 
            generalInfo[USER_NAME_INDEX], 
            personalityTraits, 
            generalInfo[PREFERRED_LANGUAGE_INDEX], 
            generalInfo[MEETING_TYPE_INDEX], 
            availability
        );
    }
/**
     * Adds a Mentee to the data storage.
     *
     * @param mentee The Mentee object to be added
     */
    public static void addMentee(Mentee mentee){
        Matching.dataMentees.put(mentee.getUserName(), mentee);
    }

    /**
     * Adds a Mentor to the data storage.
     *
     * @param mentor The Mentor object to be added
     */
    public static void addMentor(Mentor mentor){
        Matching.dataMentors.put(mentor.getUserName(), mentor);
    }
   
    /**
     * Notifies a Mentee about their matched Mentor.
     *
     * @param menteeUsername The username of the Mentee
     * @param mentorUsername The username of the Mentor
     * @return A notification message for the Mentee
     */
    public static String notifyMentee(String menteeUsername, String mentorUsername) {
        Mentee mentee = dataMentees.get(menteeUsername);
        Mentor mentor = dataMentors.get(mentorUsername);
        return "Dear " + mentee.getUserName() + "\n" + "Congratulations! You have been matched with " + mentor.getUserName() + " as your mentor." + "Please feel free to reach out to " + mentor.getUserName() + " (" + mentor.getEmail() + ") for mentorship support.";
    }

    /**
     * Filters available Mentors based on similarity with a given Mentee.
     *
     * @param mentee The Mentee object for which Mentors are being filtered
     * @return A HashMap containing the top 3 similar Mentors as values with their usernames as keys
     */
    public static HashMap<String, Mentor> filterMentor(Mentee mentee) {
        HashMap<String, Integer> mentorsScore = new HashMap<>();
        for (Mentor mentor : Matching.dataMentors.values()) {
            int similarityScore = calculateSimilarity(mentor, mentee);
            mentorsScore.put(mentor.getUserName(), similarityScore);
        }
        HashMap<String, Integer> sortedValues = sortByValue(mentorsScore);
        HashMap<String, Mentor> results = new HashMap<>();
        // return first 3 mentors
        for (int i = 0; i < 3; i++) {
            if (sortedValues.size() > i) {
                String key = (String) sortedValues.keySet().toArray()[i];
                results.put(key, dataMentors.get(key));
            }
        }  
        return results;
    }
   /**
     * Calculates the similarity score between a Mentor and a Mentee.
     *
     * @param mentor The Mentor object
     * @param mentee The Mentee object
     * @return The similarity score between the Mentor and the Mentee
     */
    public static int calculateSimilarity(Mentor mentor, Mentee mentee) {
        int totalSimilarityPoints = 0;
        // Calculate similarity based on interests
        for (String menteeInterest : mentee.getInterests()) {
            for (String mentorInterest : mentor.getInterests()) {
                if (menteeInterest.trim().equalsIgnoreCase(mentorInterest.trim())) {
                    totalSimilarityPoints += 10; 
                }
            }
        }

        // Calculate similarity based on traits
        for (String menteeTrait : mentee.getTraits()) {
            for (String mentorTrait : mentor.getTraits()) {
                if (menteeTrait.trim().equalsIgnoreCase(mentorTrait.trim())) {
                    totalSimilarityPoints += 10;
                }
            }
        }
        // Calculate similarity based on language
        if (mentee.getLanguage().trim().equalsIgnoreCase(mentor.getLanguage().trim())) {
            totalSimilarityPoints += 20;
        }
        // Calculate similarity based on career choice
        if (mentee.getCareerChoice().trim().equalsIgnoreCase(mentor.getJobTitle().trim())) {
            totalSimilarityPoints += 30;
        }
        // Calculate similarity based on availability
        for (int i = 0; i < mentee.getAvailability().length; i++) {
            for (int j = 0; j < mentee.getAvailability()[i].length; j++) {
                if (mentee.getAvailability()[i][j] == mentor.getAvailability()[i][j]) {
                    totalSimilarityPoints += 2;
                }
            }
        }
        //return the similarity point
        return totalSimilarityPoints;
    }


    
    /**
     * Allows a Mentee to choose a preferred Mentor from a list of filtered Mentors.
     *
     * @param mentee         The Mentee choosing the Mentor
     * @param filteredMentors HashMap containing filtered Mentor objects
     * @return The Mentor chosen by the Mentee, or null if no Mentor is chosen
     */
    public static Mentor chooseMentor(Mentee mentee, HashMap<String, Mentor> filteredMentors) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your preferred mentor from the following list:");
        int index = 1;
        for (String mentorName : filteredMentors.keySet()) {
            Mentor mentor = filteredMentors.get(mentorName);
            System.out.println(index + ". " + mentor.getUserName());
            index++;
        }

        int choice;
        while (true) {
            System.out.print("Enter the number of your preferred mentor: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= filteredMentors.size()) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please choose again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        // Retrieve the mentor using the chosen index
        String mentorUserName = null;
        index = 1;
        for (String mentorName : filteredMentors.keySet()) {
            if (index == choice) {
                mentorUserName = mentorName;
                break;
            }
            index++;
        }

        Mentor mentorChosen = null;
        if (mentorUserName != null) {
            mentorChosen = filteredMentors.get(mentorUserName);
        }
        //return the mentor chosen
        return mentorChosen;
    }
    
        /**
     * Sorts a HashMap by its values in ascending order.
     *
     * @param hm HashMap to be sorted
     * @return HashMap sorted by values in ascending order
     */
    // Hashmap sorting code is adapted from: https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/ 
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer> > list =
			new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
			public int compare(Map.Entry<String, Integer> o1, 
							Map.Entry<String, Integer> o2)
			{
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		
		// put data from sorted list to hashmap 
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

}