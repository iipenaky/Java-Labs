 /**
 * The main class for the mentorship program.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main{

        /**
     * The main method to run the mentorship program.
     * 
     * @param args The command-line arguments
     */
    public static void main(String[] args) {

        // read mentee and and mentor file
        Matching.readMenteeData();
        Matching.readMentorData();

        Scanner input =new Scanner(System.in);
        // Prompts the user to choose between being a mentor or a mentee and handles input validation.
        // If the input is invalid, it prompts the user again until a valid input is provided.
        System.out.print("Are you a mentee or a mentor? Press 1 if you are a mentor or Press 2 if you are a mentee: ");
        int userType = 0;
        boolean validInput2=false;
        // While loop to handle input validation for user choice.
        while (!validInput2) {
            try {
                userType=input.nextInt();
                if (userType!=1 && userType!=2){
                throw new Exception("Invalid input. Please enter 1 or 2.");}
                validInput2=true;
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
                System.out.print("Please enter 1 if you are a mentor or 2 if you are a mentee: ");
                input.nextLine(); // Consumes the newline character left after input.nextInt().

            }
            System.out.println(); // Add a line for readability.

            // If the user is a mentor (userType == 1), proceeds with mentor-related actions.
            if (userType ==1){
                // If the user is a mentor (userType == 1), proceeds with mentor-related actions.
                String[] timesOfDay = {"8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm"};
                String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                String [][] availabilityMentor = new String[daysOfWeek.length][timesOfDay.length];
                int userChoice = 0;
                boolean validInput3=false;

            if (userType ==1){
                System.out.print("What do you want to do? Press 1 to create an account, Press 2 to log in or Press 3 to exit: ");
                // While loop to handle input validation for user choice.
                while (!validInput3) {
                    try {
                        userChoice=input.nextInt();
                        if (userChoice!=1 && userChoice!=2 && userChoice!=3){
                        throw new Exception("Invalid input. Please enter 1 or 2 or 3: ");}
                        validInput3=true;
                    }catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                        System.out.print("Press 1 to create an account, Press 2 to log in or Press 3 to exit: ");       
                    }
                    input.nextLine();
                    System.out.println();

                // Switch statement to handle different user choices.
                switch(userChoice){
                    case 1:
                        // Prompts the mentor to input various details for creating an account.
                        // These details include name, email, meeting preference, interests, traits, language, experience, job position, title, and a fun fact.
                        // Name
                        System.out.println("Enter fullName: ");
                        String mentorName = input.nextLine();
                        System.out.println();

                        // Email
                        System.out.println("Enter email address: ");
                        String mentorEmail = input.nextLine();
                        System.out.println();

                        // Meeting type
                        System.out.println("Do you prefer to meet Virtually on in person?: ");
                        String mentorMeetingType = input.nextLine();
                        System.out.println();

                        // Interests
                        ArrayList<String> mentorInterests = new ArrayList<>();
                        while(true){
                            System.out.println("Enter your interests and enter Done when you finish: ");
                            String interest = input.nextLine();
                            if(!interest.equalsIgnoreCase("done")){
                                mentorInterests.add(interest);
                            }
                            else{
                                break;
                            }
                        }

                        // Personality traits
                        ArrayList<String> mentorTraits = new ArrayList<>();
                        while(true){
                            System.out.println("Enter your personality traits and enter done when you finish: ");
                            String traits = input.nextLine();
                            if(!traits.equalsIgnoreCase("done")){
                                mentorTraits.add(traits);
                            }
                            else{
                                break;
                            }
                        }
                        // Language
                        System.out.println("Enter your preferred language: ");
                        String mentorLanguage= input.nextLine();
                        System.out.println();

                        // Years of experience
                        System.out.println("Enter your  years of experience: ");
                        int mentorExperience = input.nextInt();
                        input.nextLine();
                        System.out.println();

                        // Job position
                        System.out.println("Enter your job position: ");
                        String mentorPosition = input.nextLine();
                        System.out.println();

                        // Job title
                        System.out.println("Enter your job title: ");
                        String mentorTitle = input.nextLine();
                        System.out.println();

                        // Funfact
                        System.out.println("Enter a fun fact about you: ");
                        String Funfact = input.nextLine();
                        System.out.println();

                        // Username
                        String mentorUserName = "";
                        while (true) {
                            System.out.println("Enter your user name: ");
                            String mentorUserName_ = input.nextLine();
                            boolean userNameExists = false;
                            // Check if the provided username already exists among mentors
                            for (String UserName : Matching.dataMentors.keySet()) {
                                if (UserName.equals(mentorUserName_)) {
                                    System.out.println("Please provide another username. The one provided already exists.");
                                    userNameExists = true;
                                    break; 
                                }
                            }
                            // If the username doesn't exist among mentors, it's valid
                            if (!userNameExists) {
                                mentorUserName = mentorUserName_;
                                break; 
                            }
                        }

                        // Password
                        System.out.println("Enter password: ");
                        String mentorPassword= input.nextLine();
                        System.out.println();

                        //availability
                        Scanner scanner = new Scanner(System.in);
                        for (int i = 0; i < daysOfWeek.length; i++) {
                            for (int j = 0; j < timesOfDay.length; j++) {
                                boolean validInput = false;
                                while (!validInput) {
                                    System.out.print("Are you available on " + daysOfWeek[i] + " at " + timesOfDay[j] + " (Y/N)? ");
                                    String answer = scanner.nextLine().trim().toUpperCase();
                                    if (answer.equals("Y") || answer.equals("N")) {
                                        availabilityMentor[i][j] = answer;
                                        validInput = true;
                                    } else {
                                        System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no.");
                                    }
                                }
                            }
                        }

                        // Create object
                        Mentor mentor = new Mentor(mentorExperience, mentorPosition, mentorTitle, Funfact, mentorName, mentorPassword, mentorEmail, mentorInterests, mentorUserName, mentorTraits,mentorLanguage,mentorMeetingType,availabilityMentor);
                        //put mentor in hashmap
                        Matching.addMentor(mentor);
                        // Add the user to choose the log in method to access account.
                        System.out.println("Please log in to your account by choosing to login. \n Redirecting to main......");
                        main(args);
                        break;             
                    case 2:
                    // Login Mentor and Proceed to User's profile
                        while(true){
                            // Takes user name
                            System.out.println("Enter your user name: ");
                            String mentorUsername= input.nextLine();
                            System.out.println();
                            
                            // Takes password
                            System.out.println("Enter password: ");
                            String mentorPassWord= input.nextLine();
                            System.out.println();
                            // Verifies info given
                            if (Matching.dataMentors.containsKey(mentorUsername) && Matching.dataMentors.get(mentorUsername).getPassword().equals( mentorPassWord)) {
                                // Logs Mentor in if info is verified
                                System.out.println("Logged in as Mentor: " + mentorUsername);                                
                                System.out.println("Thank you for signing up to be a mentor. Please check your mail as your mentee would reach out to you.");
                                Matching.writeMentor(Matching.dataMentors);
                                System.exit(0);
                                }else {
                                // Prompt user that either the username or password is not correct
                                System.out.println("Invalid username or password. Please try again.");
                                System.out.println("Press 1 to go back to the main and 2 to try again");
                                int choice = input.nextInt();
                                input.nextLine();
                                if (choice ==1){
                                    main(args);
                                }
                            }   
                        }
                    case 3:
                        //Log out of the application
                        Matching.writeMentor(Matching.dataMentors);
                        System.exit(0);
            }}}}
            else if (userType ==2){
                // If the user is a mentor (userType == 2), proceeds with mentee-related actions.
                String[] timesOfDay = {"8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm"};
                String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                String [][] availabilityMentee = new String[daysOfWeek.length][timesOfDay.length];
                System.out.print("Please press 1 to create an account, 2 to log in  or Press 3 to exit: ");
                int userChoice = 0;
                boolean validInput4=false;
                // While loop to handle input validation for user choice.
                while (!validInput4) {
                    try {
                        userChoice=input.nextInt();
                        if (userChoice!=1 && userChoice!=2 && userChoice!=3){
                        throw new Exception("Invalid input. Please enter 1 or 2 or 3 or 4: ");}
                        validInput4=true;
                    }
                    catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                        System.out.print("Press 1 to create an account, Press 2 to log in or Press 3 to exit: ");        
                    }
                    input.nextLine();
                    System.out.println();
                switch(userChoice){
                    case 1:
                    // Prompts the mentee to input various details for creating an account.
                    // These details include name, email, meeting preference, interests, traits, language, experience, job position, title, and a fun fact.
                    // name
                        System.out.println("Enter fullName: ");
                        String menteeName = input.nextLine();
                        System.out.println();

                        // Email
                        System.out.println("Enter email address: ");
                        String menteeEmail = input.nextLine();
                        System.out.println();

                        // Meeting type
                        System.out.println("Do you prefer an in person meeting or a virtual meeting?: ");
                        String menteeMeetingType = input.nextLine();
                        System.out.println();

                        // traits
                        ArrayList<String> menteeTraits = new ArrayList<>();
                        while(true){
                            System.out.println("Enter your personality traits and enter done when you finish: ");
                            String traits = input.nextLine();
                            if(!traits.equalsIgnoreCase("done") ){
                                menteeTraits.add(traits);
                            }
                            else{
                                break;
                            }
                        }
                            // interests
                            ArrayList<String> menteeInterests = new ArrayList<>();
                            while(true) {
                                System.out.println("Enter your interests and enter 'Done' when you finish: ");
                                String interest = input.nextLine();
                                if(!interest.equalsIgnoreCase("Done")) {
                                    menteeInterests.add(interest);
                                } else {
                                    break;
                                }
                            }

                        // language
                        System.out.println("Enter your preferred language: ");
                        String menteeLanguage= input.nextLine();
                        System.out.println();
 
                        // career choice
                        System.out.println("Enter your  career choice: ");
                        String menteeCareerChoice = input.nextLine();
                        System.out.println();

                        // funfact
                        System.out.println("Enter your fun fact: ");
                        String menteeActivities = input.nextLine();
                        System.out.println();

                        // major
                        System.out.println("Enter your major: ");
                        String menteeMajor = input.nextLine();
                        System.out.println();

                        // user name
                        String menteeUserName = "";
                        while (true) {
                            System.out.println("Enter your user name: ");
                            String menteeUserName_ = input.nextLine();
                            boolean userNameExists = false;
                
                            // Check if the provided username already exists among mentors
                            for (String UserName : Matching.dataMentees.keySet()) {
                                if (UserName.equals(menteeUserName_)) {
                                    System.out.println("Please provide another username. The one provided already exists.");
                                    userNameExists = true;
                                    break; // No need to continue checking once a match is found
                                }
                            }
                
                            // If the username doesn't exist among mentors, it's valid
                            if (!userNameExists) {
                                menteeUserName = menteeUserName_;
                                break; 
                            }
                        }

                        // password
                        System.out.println("Enter password: ");
                        String menteePassword= input.nextLine();
                        System.out.println();

                        // availability
                        Scanner scanner = new Scanner(System.in);
                        for (int i = 0; i < daysOfWeek.length; i++) {
                            for (int j = 0; j < timesOfDay.length; j++) {
                                boolean validInput = false;
                                while (!validInput) {
                                    System.out.print("Are you available on " + daysOfWeek[i] + " at " + timesOfDay[j] + " (Y/N)? ");
                                    String answer = scanner.nextLine().trim().toUpperCase();
                                    if (answer.equals("Y") || answer.equals("N")) {
                                        availabilityMentee[i][j] = answer;
                                        validInput = true;
                                    } else {
                                        System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no.");
                                    }
                                }
                            }
                        }

                        // create mentee object
                        Mentee mentee = new Mentee(menteeMajor,menteeCareerChoice, menteeActivities, menteeName, menteePassword, menteeEmail, menteeInterests, menteeUserName, menteeTraits, menteeLanguage, menteeMeetingType,availabilityMentee);
                        Matching.addMentee(mentee);
                        Matching.writeMentee(Matching.dataMentees);
                        System.out.println("Please log in to your account by pressing 2 to login. Redirecting to main");
                        main(args);
                        break;  
               
                    case 2:
                    // Log mentee in 
                        while(true){
                            // take user name
                            System.out.println("Enter your user name: ");
                            String menteeUsername= input.nextLine();
                            System.out.println();
    
                            // take password
                            System.out.println("Enter password: ");
                            String menteePassWord= input.nextLine();
                            System.out.println();
                            //validate info given
                            if (Matching.dataMentees.containsKey(menteeUsername) && Matching.dataMentees.get(menteeUsername).getPassword().equals(menteePassWord)) {
                                System.out.println("Logged in as Mentee: " + menteeUsername);
                                // list mentors and choose mentors
                                System.out.println("Please enter 1 to choose your mentor, or any where to logout.");
                                int choice = input.nextInt();
                                input.nextLine();
                                if(choice ==1){
                                    //Get the object of the current mentee signed in
                                    Mentee currentMentee = null;
                                    for(Mentee ment: Matching.dataMentees.values()){
                                        if (ment.getUserName().equals(menteeUsername)){
                                            currentMentee = ment;
                                            break;
                                        }
                                    }
                                    //List the first 3 mentors the mentee matches with and ask the mentee to choose their preferred choice.
                                    HashMap<String ,Mentor> top3Mentors = Matching.filterMentor(currentMentee);
                                    Mentor chosenMentor = Matching.chooseMentor(currentMentee, top3Mentors);
                                    System.out.println(Matching.notifyMentee(currentMentee.getUserName(), chosenMentor.getUserName()));
                                    Matching.writeMentee(Matching.dataMentees);
                                }else if (choice!=1){
                                    Matching.writeMentee(Matching.dataMentees);
                                    System.exit(0);
                                }
                                break;
                            }
                            else {
                                //Ask user for user name again because the info provided was incorrect
                                System.out.println("Invalid username or password. Please try again");
                                System.out.println("Enter 1 to return to the main program or press 2 to try again: ");
                                int choice = input.nextInt();
                                input.nextLine();
                                if (choice ==1){
                                    main(args);           
                                }
                            } 
                        }
                        break;
                    case 3:
                    //Leave the program
                        Matching.writeMentee(Matching.dataMentees);
                        System.exit(0);
                }
        }
    }
}
}

}
