import java.util.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Player { // Player Class to store player information.
    String name, emailid, Phone_no, DOB;
    int age, id;

    public Player(String name, String emailid, String phone_no, String dOB, int age, int id) {
        this.name = name;
        this.emailid = emailid;
        this.Phone_no = phone_no;
        this.DOB = dOB;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPhone_no() {
        return Phone_no;
    }

    public String getDOB() {
        return DOB;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
    // Constructors , Getters and Setters.
}

class quiz { // Quiz Class to store all Quiz.
    static Scanner sc = new Scanner(System.in);

    static HashSet<Integer> h1 = new HashSet<>(); // hashset to get Ques No.

    static boolean flag_50_50 = true;
    static boolean Audience_poll = true;
    static boolean call_a_friend = true;
    // 3 lifelines which initially set true.

    static int random() { // Generates Question number randomly
        int a = (int) (Math.random() * 21);

        while (a == 0) {
            a = (int) (Math.random() * 21);
        }

        while (h1.contains(a)) {

            a = (int) (Math.random() * 21);
            while (a == 0) {
                a = (int) (Math.random() * 21);
            }

        }
        h1.add(a);
        return a;
    }

    static void UseLifeLine() throws Exception { // uses Lifelines

        if ((flag_50_50 == false) && (Audience_poll == false) && (call_a_friend == false)) { // if all lifelines are
                                                                                             // used once.
            System.out.println("You have used all LifeLine");
            System.out.println("Plese select your Answer");
            playQuiz.answer = sc.nextLine();

        } else {
            System.out.println("Please select which lifeline you want to use ");

            int r = 1;

            for (String LL : playQuiz.lifeline) {
                System.out.println(r + ")." + LL);
                r++;
            }

            boolean lll = false;
            do {

                try {

                    System.out.println("Enter your choice");
                    // sc.nextLine();
                    int ch = sc.nextInt();
                    sc.nextLine();
                    switch (ch) {
                        case 1:
                            lll = true;

                            if (flag_50_50 == true) { // if 50-50 is not used.
                                System.out.println();

                                LifeLines.fifty_fifty();

                                System.out.println("Now answer on the above option");
                                playQuiz.answer = sc.nextLine();
                                flag_50_50 = false;
                                // AnswerCheck();

                            } else {
                                System.out
                                        .println(
                                                "You have already used this lifeLine. Please select anthor LifeLine");

                                UseLifeLine();

                            }
                            break;

                        case 2:

                            lll = true;
                            if (Audience_poll == true) { // If Audiance poll is not used.
                                System.out.println();

                                LifeLines.Audience_poll();

                                System.out.println("Please Select Your Answer");
                                playQuiz.answer = sc.nextLine();
                                Audience_poll = false;
                                // AnswerCheck();

                            } else {
                                System.out
                                        .println(
                                                "You have already used this lifeLine. Please select anthor LifeLine");
                                UseLifeLine();

                            }
                            break;

                        case 3:

                            lll = true;
                            if (call_a_friend == true) { // If call a friend is not used.
                                System.out.println();
                                LifeLines.call_friend();

                                System.out.println("Please select your Answer ");
                                playQuiz.answer = sc.nextLine();
                                call_a_friend = false;
                                // AnswerCheck();

                            } else {
                                System.out
                                        .println(
                                                "You have already used this lifeLine. Please select anthor LifeLine");
                                UseLifeLine();

                            }
                            break;

                        default:
                            System.out.println("Plese Enter valid choice");
                            UseLifeLine();

                            break;

                    }
                } catch (Exception e) {
                    System.out.println("Invalid Input !!");
                    sc.nextLine();
                }
            } while (lll == false);
        }
    }

    static String Date_Time() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");

        // Get the current date and time as a LocalDateTime object
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the LocalDateTime object as a string
        String dateString = currentDateTime.format(formatter);

        return dateString;
    }

}

class LifeLines { // Class Lifelines for usage of lifeLines.

    Scanner sc = new Scanner(System.in);

    static int randomOption() {
        int a = (int) (Math.random() * 3);

        return a;

    }

    static void fifty_fifty() {
        int opt = randomOption();

        String CA = playQuiz.ans;
        if (opt == 0) {

            if (CA.equals("A")) {
                System.out.println(playQuiz.A);
                System.out.println(playQuiz.B);
            } else if (CA.equals("B")) {
                System.out.println(playQuiz.A);
                System.out.println(playQuiz.B);
            } else if (CA.equals("C")) {
                System.out.println(playQuiz.A);
                System.out.println(playQuiz.C);
            } else if (CA.equals("D")) {
                System.out.println(playQuiz.A);
                System.out.println(playQuiz.D);
            }
        } else if (opt == 1) {
            if (CA.equals("A")) {
                System.out.println(playQuiz.A);
                System.out.println(playQuiz.B);
            } else if (CA.equals("B")) {
                System.out.println(playQuiz.A);
                System.out.println(playQuiz.B);
            } else if (CA.equals("C")) {
                System.out.println(playQuiz.B);
                System.out.println(playQuiz.C);
            } else if (CA.equals("D")) {
                System.out.println(playQuiz.B);
                System.out.println(playQuiz.D);
            }
        } else if (opt == 2) {
            if (CA.equals("A")) {
                System.out.println(playQuiz.A);
                System.out.println(playQuiz.C);
            } else if (CA.equals("B")) {
                System.out.println(playQuiz.B);
                System.out.println(playQuiz.C);
            } else if (CA.equals("C")) {
                System.out.println(playQuiz.A);
                System.out.println(playQuiz.C);
            } else if (CA.equals("D")) {
                System.out.println(playQuiz.C);
                System.out.println(playQuiz.D);
            }
        } else if (opt == 3) {
            if (CA.equals("A")) {
                System.out.println(playQuiz.A);
                System.out.println(playQuiz.D);
            } else if (CA.equals("B")) {
                System.out.println(playQuiz.B);
                System.out.println(playQuiz.D);
            } else if (CA.equals("C")) {
                System.out.println(playQuiz.C);
                System.out.println(playQuiz.D);
            } else if (CA.equals("D")) {
                System.out.println(playQuiz.A);
                System.out.println(playQuiz.D);
            }
        } // TestCases for 50-50 options.

    }

    static void Audience_poll() { // Method for Audiance_Poll lifeLine

        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * (100 - a));
        int c = (int) (Math.random() * (100 - (a + b)));
        int d = (100 - (a + b + c)); // Randomly produces result for Audiance Polls.

        System.out.println(a + "% Audience says  A is Correct Answer");
        System.out.println(b + "% Audience says  B is Correct Answer");
        System.out.println(c + "% Audience says  C is Correct Answer");
        System.out.println(d + "% Audience says  D is Correct Answer");
        System.out.println();

    }

    static void call_friend() { // Method for Call A Friend.

        int a = (int) (Math.random() * 4);

        if (a == 0) {
            System.out.println("Your Friend say A is a correct ans");
        } else if (a == 1) {
            System.out.println("Your Friend say B is a correct ans");
        } else if (a == 2) {
            System.out.println("Your Friend say C is a correct ans");
        } else {
            System.out.println("Your Friend say D is a correct ans");
        }

    }

}

class Valid { // Verify user details

    static Scanner sc = new Scanner(System.in);

    static void isValidName(String name) { // to check if name are Valid.

        int flag = 0;
        while ((flag == 0)) {
            String n[] = name.split(" ");

            for (int j = 0; j < n.length; j++) {

                char chr[] = n[j].toCharArray();
                for (int i = 0; i < chr.length; i++) {
                    if ((((chr[i] >= 65) && (chr[i] <= 90)) || ((chr[i] >= 97) && (chr[i] <= 122)))) {
                        flag = 1;
                    } else {
                        System.out.println("InValid Name. Enter Valid Name!!");
                        name = sc.nextLine();
                        chr = name.toCharArray();
                    }
                }
            }
        }

    }

    static void isValidPhoneNumber(String phone) { // To check if Phone Number is Valid.

        int flag_phone = 0;
        while (flag_phone == 0) {
            if (phone.length() == 10) {
                for (int i = 0; i < phone.length(); i++) {
                    if (phone.charAt(i) >= '0' && phone.charAt(i) <= '9') {
                        flag_phone = 1;
                        continue;

                    } else {

                        System.out.println("Enter Valid Phone Number");
                        phone = sc.next();
                    }
                }
            } else {

                System.out.println("InValid Phone Number. It should be 10 digits number");
                phone = sc.next();
            }
        }

    }

    static void isValidAge(int age) { // To check if Age is Valid.

        int flag_Age = 0;
        while (flag_Age == 0) {
            if (age <= 0) {
                System.out.println("Enter Valid Age");
                age = sc.nextInt();
            } else {
                if (age >= 15 && age < 100) { // Age Limit for this game is 15 to 100.
                    flag_Age = 1;
                    continue;
                } else {
                    System.out.println("You are not eligible for this game!!");
                    System.exit(0);
                    break;
                }
            }
        }

    }

    static boolean isValidBirthdate(String inputDate) { // To Check if Birthday is Valid.

        if (inputDate.length() != 10) { // Date must have 10 Characters
            return false;
        }

        String[] parts = inputDate.split("-");
        if (parts.length != 3) { // It must have 3 parts on splitting by '-'.
            return false;
        }

        int year, month, day;
        try {
            year = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            day = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return false;
        }
        // Check Year , Month and Day Ranges.
        if (year < 1000 || year > 2023 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        } else if (month == 2) { // Check for Leaf Year.
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        // If everything is true than pass true.
        return true;
    }

    static boolean isValidE_mail(String eMail) { // To check is E-Mail Valid.
        Boolean email_validate = false;
        while (email_validate != true) {
            if (eMail == null || eMail.isEmpty()) {
                System.out.println("Invalid email address: " + eMail);
                System.out.println("Enter Again.");
                eMail = sc.next();
            } else {
                int atIndex = eMail.indexOf('@');
                int dotIndex = eMail.lastIndexOf('.');
                // Check if "@" and "." are present and in the correct order
                if (atIndex > 0 && dotIndex > atIndex && dotIndex < eMail.length() - 1) {
                    // System.out.println("Valid email address: " + eMail);
                    email_validate = true;
                } else {
                    System.out.println("Invalid email address: " + eMail);
                    System.out.println("Enter Again.");
                    eMail = sc.next();
                }
            }
        } // Validated E-Mail.

        return email_validate;
    }
}

class playQuiz { // playQuiz Class to Operate Quiz.
    static ArrayList<String> lifeline;
    static String Question, A, B, C, D, ans, answer, User_Folder, username, pass, firstName, LastName, eMail, phNo, dob,
            Date, Time, Points; // answer->user
    // answer
    static int i, level, mode, choice, start;
    static BufferedWriter b1;
    static String dburl, dbuser, dbpass, driver;
    static Connection con;
    static int U_id, age, Easy_points, Medium_points, Hard_points, Daily_Point, Total, Bonus_points;
    static PreparedStatement pst;
    static Statement st;
    static boolean Daily = false;
    static Scanner sc = new Scanner(System.in);

    class QuizTimer { // QuizTimer Class to Operate Timmer in Quiz.
        private int secondsRemaining;
        private long startTimeMillis;
        private boolean timeUp;
        private boolean answered;
        private volatile boolean stopTimer; // volatile keyword to indicate that a variable's value may be modified by
                                            // multiple Threads Simultaneously.

        public QuizTimer(int seconds) {
            this.secondsRemaining = seconds;
            this.timeUp = false;
            this.answered = false;
            this.stopTimer = false;
        } // Constructor for QuizTimer.

        public void start() {
            Thread time_thread = new Thread(new Runnable() { // Annoymous Inner Class
                public void run() {
                    startTimeMillis = System.currentTimeMillis();

                    while (secondsRemaining > 0 && !answered && !stopTimer) { // Loop with several Conditions.
                        if (secondsRemaining <= 5) {
                            System.out.println("Time Remaining: " + secondsRemaining + " seconds");
                        }
                        try {
                            Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        secondsRemaining--;
                    }

                    if (secondsRemaining == 0) {
                        System.out.println("Time's up");
                        System.out.println("Please Guess the answer: ");
                        timeUp = true;
                    }
                }
            });

            Thread inputThread = new Thread(new Runnable() { // Annoymous Inner Class
                public void run() {
                    try {
                        int a = quiz.random();
                        pst.setInt(1, a);
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                            Question = rs.getString(1);
                            A = rs.getString(2);
                            B = rs.getString(3);
                            C = rs.getString(4);
                            D = rs.getString(5);
                            ans = rs.getString(6);

                            b1.write("-------------------------------------------------------------------------\n");
                            b1.write(Question + "\n");
                            b1.write(A + "\n");
                            b1.write(B + "\n");
                            b1.write(C + "\n");
                            b1.write(D + "\n");

                            System.out.println();
                            System.out.println(
                                    "-------------------------------------------------------------------------------------------------");

                            System.out.println(i + "). " + Question);
                            System.out.println(A);
                            System.out.println(B);
                            System.out.println(C);
                            System.out.println(D);
                            // To Write in file.
                            System.out.println("You Have 20 seconds to answer the Question");

                            if (mode == 2) {
                                System.out.println(
                                        "Please Enter your answer or press 0 for using Lifelines or wait for time's up: ");
                            } else if (mode == 3) {
                                System.out.println(
                                        "Please Enter your answer or wait for time's up: ");
                            }
                            answer = sc.nextLine();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (!isTimeUp() && !answered) {
                        try {
                            answered = AnswerCheck();
                        } catch (Exception e) {
                        }
                        if (!answered) {
                            stopTimer = true; // Start the timer if the answer is not valid
                        }
                    }
                    if (isTimeUp()) {
                        if (answer.equalsIgnoreCase(ans)) {
                            System.out.println(
                                    "Your Answer is Correct but Time is up so your answer is not Count \n Moving to the next question.");
                        } else {
                            System.out.println("Your Answer is Wrong ");
                            System.out.println("Correct answer is : " + ans + "\nMoving to the next question.");
                        }
                    } else {

                        if (playQuiz.answer.equalsIgnoreCase(playQuiz.ans)) {
                            long timeTakenMillis = getTimeTakenMillis();
                            int bonusPoints = calculateBonusPoints(timeTakenMillis);
                            Bonus_points += bonusPoints;
                        }
                        // Add bonus points to the user's score or perform other actions.
                    }
                }
            });
            time_thread.start();
            inputThread.start();

            try {
                time_thread.join();
                inputThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private static int calculateBonusPoints(long timeTakenMillis) {
            // Customize the bonus points calculation as per your requirements.
            // This is just a simple example.
            if (timeTakenMillis < 3000) {
                System.out.println("You answered early! \n you got " + 5 + " Bonus points extra");
                return 5; // Award 5 bonus points
            } else if (timeTakenMillis < 5000) {
                System.out.println("You answered early! \n you got " + 2 + " Bonus points extra");
                return 2; // Award 2 bonus points
            } else if (timeTakenMillis < 7000) {
                System.out.println("You answered early! \n you got " + 1 + " Bonus points extra");
                return 1; // Award 1 bonus points
            } else {
                return 0; // No bonus points
            }
        }

        static boolean AnswerCheck() throws Exception { // Checks correct answer

            if (mode == 3) {
                if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B")
                        || answer.equalsIgnoreCase("C")
                        || answer.equalsIgnoreCase("D")) {

                    if (answer.equalsIgnoreCase(ans)) {
                        b1.write("Your Answer : " + answer);
                        System.out.println("Congratulation ! Your answer is correct");
                        b1.newLine();
                    } else {
                        System.out.println("Oops ! your answer is wrong");
                        System.out.println("Correct Answer is " + ans);
                        b1.write("Your Answer : " + answer);
                        b1.newLine();
                        b1.write("Correct Answer is : " + ans);
                        b1.newLine();
                    }
                    return answer.equalsIgnoreCase(ans); // Return whether the answer is correct
                } else {
                    System.out.println("Please enter a valid choice ");
                    answer = sc.nextLine();
                    return AnswerCheck(); // Recursively call the method
                }
            } else if (mode == 2) {

                if (answer.equalsIgnoreCase("0")) {
                    quiz.UseLifeLine();
                }
                if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B")
                        || answer.equalsIgnoreCase("C")
                        || answer.equalsIgnoreCase("D")) {

                    if (answer.equalsIgnoreCase(playQuiz.ans)) {
                        if (level == 1) {
                            Easy_points = Easy_points + 1;
                        } else if (level == 2) {
                            Medium_points = Medium_points + 1;
                        } else if (level == 3) {
                            Hard_points = Hard_points + 1;
                        } else {
                            Daily_Point = Daily_Point + 1;
                        }
                        // Points according to different Modes.
                        b1.write("Your Answer : " + answer + " is Right");
                        System.out.println("Congratulation ! Your answer is correct");
                        b1.newLine();
                    } else {

                        System.out.println("Oops ! your answer is wrong");
                        System.out.println("Correct Answer is " + ans);
                        b1.write("Your Answer : " + answer);
                        b1.newLine();
                        b1.write("Correct Answer is : " + ans);
                        b1.newLine();
                    }
                    return answer.equalsIgnoreCase(playQuiz.ans); // Return whether the answer is correct
                } else {
                    System.out.println("Please enter a valid choice ");
                    answer = sc.nextLine();
                    return AnswerCheck(); // Recursively call the method
                }
            }
            return false; // Default return value if the mode is not recognized
        }

        public boolean isTimeUp() { // To check if time is up or not?
            return timeUp;
        }

        public boolean isAnswered() { // To check if Ques in Answered or not?
            return answered;
        }

        public long getTimeTakenMillis() { // To get Time in Milli-sec.
            return System.currentTimeMillis() - startTimeMillis;
        }
    }

    public static void main(String[] args) throws Exception {

        dburl = "jdbc:mysql://localhost:3306/final_quiz";
        dbuser = "root";
        dbpass = "";
        driver = "com.mysql.cj.jdbc.Driver";
        // Class.forName(driver);
        // Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC driver not found: " + e.getMessage());
            return; // Terminate the code execution
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            return; // Terminate the code execution
        }
        try {
            if (con != null) {
                // System.out.println("connection Successfull");
            }
        } catch (Exception e) {
            System.err.println("Error closing database connection: " + e.getMessage());

        }
        if (con != null) {

            System.out.println(
                    "================================================================================================");
            System.out.println("                                   WELCOME TO QUIZ APPLICATION");
            System.out.println(
                    "================================================================================================");
            lifeline = new ArrayList<>();

            lifeline.add("50/50");
            lifeline.add("Audience poll");
            lifeline.add("Call a friend");

            String Date_Time = quiz.Date_Time();
            String a[] = Date_Time.split(" ");
            Date = a[0];
            Time = a[1];

            Easy_points = Medium_points = Hard_points = Bonus_points = 0;

            do {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                try {
                    System.out.print("Enter your choice: ");
                    start = sc.nextInt();
                    System.out.println();

                    switch (start) {
                        case 1:
                            registerUser(); // To Register User.
                            break;
                        case 2:
                            loginUser(); // To Login User.
                            break;
                        case 3: // To Exit.
                            try{
                                b1.close();
                            } catch(NullPointerException e){

                            }
                            System.out.print(
                                    "                      TTTTTT   H    H      A       N   N   K  K      Y   Y   OOO    U   U\n");
                            System.out.print(
                                    "                         T     H    H     A A      NN  N   K K        Y Y   O   O   U   U\n");
                            System.out.print(
                                    "                         T     HHHHHH    AAAAAA    N N N   KK          Y    O   O   U   U\n");
                            System.out.print(
                                    "                         T     H    H   A      A   N  NN   K K         Y    O   O   U   U\n");
                            System.out.print(
                                    "                         T     H    H  A        A  N   N   K  K        Y     OOO     UUU \n");
                            System.out.println();
                            System.out.println();
                            System.out.println("                                           Thank's for visiting us  ");

                            System.exit(0);
                        default:
                            System.out.println("Invalid choice.\nPlease Enter Valid Choice");
                            sc.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid choice.\nPlease Enter Valid Choice");
                    sc.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("Exit Due To CTRL + C");
                    break;
                }

            } while (start != 3);
        } else {
            System.out.println("Connection Failed");
        }
    }

    static void registerUser() throws SQLException, IOException {

        System.out.print("Enter username: ");
        username = sc.next(); // Enter UserName.

        System.out.println();
        pass = ""; // To Check Password.

        System.out.println();
        boolean flag = false;
        do {
            System.out.println(" INSTRUCTION  FOR  PASSWORD  ");
            System.out.println("1. At least one Upper case");
            System.out.println("2. At least one Lower case");
            System.out.println("3. At least one digit");
            System.out.println("4. At least 8 to 15 character");

            System.out.print("Enter Password : ");
            // sc.nextLine();
            pass = sc.next();
            int lower_case = 0;
            int uper_case = 0;
            int digit_case = 0;
            int cnt = 0;

            for (char j = 0; j < pass.length(); j++) {
                for (char i = 65; i <= 90; i++) {

                    if (pass.charAt(j) == i) {
                        uper_case = 1;
                        break;
                    }
                }
            }
            if (uper_case == 1) {
                cnt++;
            }

            for (char j = 0; j < pass.length(); j++) {
                for (char i = 97; i <= 122; i++) {

                    if (pass.charAt(j) == i) {
                        lower_case = 1;
                        break;
                    }
                }
            }

            if (lower_case == 1) {
                cnt++;
            }

            for (char j = 0; j < pass.length(); j++) {
                for (char i = 48; i <= 57; i++) {
                    if (pass.charAt(j) == i) {
                        digit_case = 1;
                        break;
                    }
                }
            }

            if (digit_case == 1) {
                cnt++;
            }
            if (pass.length() >= 8 && pass.length() <= 15) {
                cnt++;
            }
            if (cnt == 4) {
                flag = true;
            } else {
                System.out.println("Retry");
            }
        } while (flag != true);

        flag = false;
        do {

            System.out.print("Confirm Password : ");
            String con_pass = sc.next();

            if (pass.equals(con_pass)) {
                System.out.println();
                flag = true;
                System.out.print("You have successfuly logged in ");
                System.out.println();
            } else {
                System.out.println("Invalid CONFIRM Password");
                System.out.println("Retry");
            }
        } while (flag != true);

        String insertQuery = "INSERT INTO users (User_Name, Password) VALUES (?, ?)"; // Insert into User Table.
        PreparedStatement statement = con.prepareStatement(insertQuery);
        statement.setString(1, username);
        statement.setString(2, pass);
        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            String insertQuery1 = "INSERT INTO user_profiles (User_Name, First_Name, Last_Name,E_mail, Phone_Number, Age, DOB) VALUES (?, ?, ?, ?, ?, ?, ?)";
            // Insert into user=profiles table.
            PreparedStatement statement1 = con.prepareStatement(insertQuery1);
            System.out.println("---------------------------------------------------------");

            System.out.print("\nEnter First_Name : ");
            firstName = sc.next();
            Valid.isValidName(firstName);

            System.out.print("\nEnter Last Name : ");
            LastName = sc.next();
            Valid.isValidName(LastName);

            System.out.print("\nEnter E-mail : ");
            eMail = sc.next();
            Valid.isValidE_mail(eMail);
            sc.nextLine();

            System.out.print("\nEnter Phone Number : ");
            phNo = sc.nextLine();
            Valid.isValidPhoneNumber(phNo);

            System.out.print("\nEnter your Date of Birth (YYYY-MM-DD) :");
            dob = sc.nextLine();

            while (!Valid.isValidBirthdate(dob)) {
                if (Valid.isValidBirthdate(dob)) {
                    System.out.println("Valid birthdate!");

                } else {
                    System.out.println("Invalid birthdate.\n Provide Valid BirthDate");
                    dob = sc.nextLine();
                }
            }
            System.out.println();
            System.out.println("Enter Age : ");
            int age = 0;
            Boolean flag_Age = true;

            boolean validInput = false;
            while (!validInput) {
                try {
                    age = sc.nextInt();
                    while (flag_Age) {
                        if (age <= 15 || age >= 100) {
                            System.out.println("Enter Valid Age");
                            age = sc.nextInt();
                        } else {
                            flag_Age = false;
                            break;
                        }
                    }
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Enter Valid age");
                    sc.next();
                }
            }

            System.out.println("------------------------------------------");
            statement1.setString(1, username);
            statement1.setString(2, firstName);
            statement1.setString(3, LastName);
            statement1.setString(4, eMail);
            statement1.setString(5, phNo);
            statement1.setInt(6, age);
            statement1.setString(7, dob);

            int rowsInserted1 = statement1.executeUpdate();

            if (rowsInserted1 > 0) {
                System.out.println("User profile data added.");

            } else {
                System.out.println("Failed to add user profile data.");
            }

            String User_Id = "select User_ID from user_profiles where User_Name = '" + username + "'";
            // To get User_id from Profile.
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(User_Id);

            if (rs.next()) {
                U_id = rs.getInt(1);
            }

            User_Folder = U_id + "_" + firstName; // User Folder Location
            File f1 = new File(User_Folder);
            f1.mkdir();

            String insert_Points = "Insert Into points values(?,?,?,?,?,?,?)"; // Insert details into points table.
            pst = con.prepareStatement(insert_Points);
            pst.setInt(1, U_id);
            pst.setInt(2, 0);
            pst.setInt(3, 0);
            pst.setInt(4, 0);
            pst.setInt(5, 0);
            pst.setInt(6, 0);
            pst.setInt(7, 0);
            pst.executeUpdate();
        } else {
            System.out.println("Registration failed.");
        }
    }

    static void loginUser() throws Exception { // To Login User.
        boolean flag_correct_pass = false;
        String username = "";
        String password = "";
        int attemptsLeft = 3;
        System.out.print("Enter username: ");
        username = sc.next();
        if (isUsernameExists(username)) { // Checks if userName is Exists in a table or not.

            while (flag_correct_pass != true && attemptsLeft > 0) {
                System.out.print("Enter password: ");
                password = sc.next(); // Given 3 Attempts to Enter Correct Password.

                String selectQuery = "SELECT * FROM users WHERE user_Name = ? AND Password = ?";
                PreparedStatement statement = con.prepareStatement(selectQuery);
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    String Date_Time = quiz.Date_Time(); // To get TimeStamp.
                    String a[] = Date_Time.split(" "); // Splitting Date And Time.
                    Date = a[0]; // Getting Date
                    Time = a[1]; // Getting Time.

                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println("                                     Login successful.");
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println(
                            "                                                                      Date : " + Date);
                    System.out.println(
                            "                                                                      Time : " + Time);
                    String Id = "select * from user_profiles where User_Name = '" + username + "'"; // Fetch all Details
                                                                                                    // from
                                                                                                    // User_profiles.
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(Id);

                    if (rs.next()) {
                        System.out.println();
                        U_id = rs.getInt(1);
                        b1 = new BufferedWriter(
                                new FileWriter(rs.getInt(1) + "_" + rs.getString(3) + "\\" + rs.getString(3)
                                        + "_" + Date + "_" + Time + ".txt"));

                        b1.write(
                                "------------------------------------------------Plyer Information---------------------------------\n");

                        b1.write("Id : " + rs.getInt(1) + "\n");
                        b1.write("User Name : " + rs.getString(2) + "\n");
                        b1.write("First Name : " + rs.getString(3) + "\n");
                        b1.write("Last Name : " + rs.getString(4) + "\n");
                        b1.write("E_mail : " + rs.getString(5) + "\n");
                        b1.write("Phone Number : " + rs.getString(6) + "\n");
                        b1.write("age : " + rs.getString(7) + "\n");
                        b1.write("Date of Birth : " + rs.getString(8) + "\n");
                        // Write into File.
                        String p = "select Total from points where User_id = " + U_id; // Get total_points from points.
                        st = con.createStatement();
                        ResultSet rs1 = st.executeQuery(p);
                        if (rs1.next()) {
                            System.out.println("Total Points : " + rs1.getInt(1));
                        }
                    }

                    flag_correct_pass = true;
                    do {
                        try {
                            System.out.println(
                                    "-------------------------------------------------------------------------------------------------");
                            System.out.println("1. View My Profile");
                            System.out.println("2. Modes");
                            System.out.println("3. Log Out");

                            System.out.print("Enter your choice: ");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    fetchAndDisplayUserProfile(con, username); // to show user profiles.
                                    break;
                                case 2:
                                    Modes(); // Different Modes.
                                    break;
                                case 3:
                                    System.out.println("Logged out successfully.");
                                    return;
                                default:
                                    System.out.println("Invalid choice.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Choice");
                            sc.nextLine();
                        }
                    } while (choice != 3);
                } else {
                    attemptsLeft--;
                    System.out.println("Login failed. Invalid credentials.");
                    System.out.println("Enter Again.");
                }
                if (attemptsLeft == 0) { // If Attempts is 0.

                    System.out.println("You Have Reached Maximum Attempts.\n Please try again Later.\n");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("UserName not found!!");
        }

    }

    private static boolean isUsernameExists(String username) throws SQLException { // checks if username is there or
                                                                                   // not.
        String selectQuery = "SELECT * FROM users WHERE User_Name = ?";
        PreparedStatement statement = con.prepareStatement(selectQuery);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    static void fetchAndDisplayUserProfile(Connection connection, String username) throws SQLException { // fetch user
                                                                                                         // details
        String selectQuery = "SELECT * FROM user_profiles WHERE User_Name = ?";
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println(
                    "-------------------------------------------------------------------------------------------------");
            System.out.println("                                 Player's Profile");
            System.out.println(
                    "-------------------------------------------------------------------------------------------------");
            System.out.println("First Name: " + resultSet.getString("First_Name"));
            System.out.println("Last Name: " + resultSet.getString("Last_Name"));
            System.out.println("E-mail: " + resultSet.getString("E_mail"));
            System.out.println("Phone Number: " + resultSet.getString("Phone_Number"));
            System.out.println("Age: " + resultSet.getString("Age"));

            String p = "select Total from points where User_id = " + U_id; // get total points.
            st = con.createStatement();
            ResultSet rs = st.executeQuery(p);
            if (rs.next()) {
                System.out.println("Total Points : " + rs.getInt(1));
            }

            System.out.println();
            // ... Display other profile data
        } else {
            System.out.println("Profile data not found.");
        }
    }

    static void Modes() throws Exception { // Get Diff Modes.
        boolean m = true;

        while (m == true) {

            try {
                boolean m1 = true;

                while (m1) {
                    System.out.println();
                    System.out.println(
                            "=================================================================================================");
                    System.out.println("                                            MODES");
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println(
                            "1). Practice Mode           |          2). Classic Mode           |          3). Daily Challenge ");
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");

                    System.out.print("Plese select Mode : ");
                    mode = sc.nextInt();
                    sc.nextLine();

                    System.out.println();
                    switch (mode) {
                        case 1:
                            PracticeMode();
                            m1 = false;
                            m = false;
                            break;
                        case 2:
                            ClassicMode();
                            m = false;
                            m1 = false;
                            break;
                        case 3:
                            DailyChallenge();
                            m = false;
                            m1 = false;
                            break;
                        default:
                            System.out.println("InValid Choice \nPlease Enter valid Choice");
                    }
                    // Different Modes.
                }

                boolean c = false;

                while (c == false) {

                    System.out.println("Do you want to play another Mode (Yes OR No) : ");
                    String ans = sc.nextLine();
                    if (ans.equalsIgnoreCase("no")) { // if user dosent wants to play another mode.
                        m = false;
                        c = true;
                    } else if (ans.equalsIgnoreCase("yes")) { // if user wants to play another mode.
                        m = true;
                        c = true;
                    } else {
                        System.out.println("Please Enter Valid Choice");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("InValid Choice !!\nPlease Enter valid Choice");
                sc.nextLine();
            }
        }
    }

    static void PracticeMode() throws Exception {

        String Date_Time = quiz.Date_Time();
        String a1[] = Date_Time.split(" ");
        Date = a1[0];
        Time = a1[1];
        // Get Date And Time seperately from timestamp.
        b1.write(
                "========================================================================================================\n");
        b1.write("                                  Practice Mode\n ");
        b1.write(
                "========================================================================================================\n");
        b1.write("                                                                                  Date : " + Date
                + "\n");
        b1.write("                                                                                  Time : " + Time
                + "\n");

        System.out.println(
                "=================================================================================================");
        System.out.println("                                  Practice Mode");
        System.out.println(
                "=================================================================================================");
        System.out.println("                                                                     Date : " + Date);
        System.out.println("                                                                     Time : " + Time);

        System.out.println("");

        for (int i = 1; i <= 10; i++) {
            boolean answ = false;
            CallableStatement cst = con.prepareCall("{call Que(?,?,?,?,?,?,?)}");
            int a = quiz.random();
            cst.setInt(1, a);
            cst.executeQuery();

            Question = cst.getString(2);
            A = cst.getString(3);
            B = cst.getString(4);
            C = cst.getString(5);
            D = cst.getString(6);
            ans = cst.getString(7);
            // Get Ques , Options and Answer By callable Statement.

            b1.write("-----------------------------------------------------------------------------------------\n");
            b1.write(i + ")." + Question + "\n");
            b1.write(A + "\n");
            b1.write(B + "\n");
            b1.write(C + "\n");
            b1.write(D + "\n");

            System.out.println(
                    "-------------------------------------------------------------------------------------------------");
            System.out.println(i + "). " + Question);
            System.out.println(A);
            System.out.println(B);
            System.out.println(C);
            System.out.println(D);
            System.out.println("Please select your Answer ");
            answer = sc.nextLine();

            while (!answ) {

                if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B")
                        || answer.equalsIgnoreCase("C")
                        || answer.equalsIgnoreCase("D")) {

                    if (answer.equalsIgnoreCase(ans)) {
                        answ = true;
                        b1.write("Your Answer : " + answer);
                        System.out.println("Congratulation ! Your ans is correct");
                        b1.newLine();
                    } else {
                        answ = true;
                        System.out.println("Oops ! your ans is wrong");
                        System.out.println("Correct Answer is " + ans);
                        b1.write("Your Answer : " + answer);
                        b1.newLine();
                        b1.write("Correct Answer is : " + ans);
                        b1.newLine();
                    }
                } else {
                    System.out.println("Plese enter valid choice ");
                    answer = sc.nextLine();
                }
            }
            // Checks Ans and writes in a file.
        }

        quiz.h1.clear();
    }

    static void ClassicMode() throws Exception {
        boolean l = true, l1 = true;

        while (l == true) {

            while (l1 == true) {
                System.out.println("1). Easy \n2). Medium \n3). Hard ");
                try {
                    System.out.print("Select Level : ");
                    level = sc.nextInt();
                    sc.nextLine();

                    String Date_Time = quiz.Date_Time();
                    String a[] = Date_Time.split(" ");
                    Date = a[0];
                    Time = a[1];
                    // Get date and time seperately from timestamp.

                    if (level == 1) {
                        b1.write(
                                "==========================================================================================\n");
                        b1.write("                               Classic Mode --> Easy \n");
                        b1.write(
                                "===========================================================================================\n");
                        b1.write("Date : " + Date + "\n");
                        b1.write("Time : " + Time + "\n");

                        System.out.println(
                                "=================================================================================================");
                        System.out.println("                                           CLASSIC --> EASY");
                        System.out.println(
                                "=================================================================================================");
                        System.out.println(
                                "                                                                              Date : "
                                        + Date);
                        System.out.println(
                                "                                                                              Time : "
                                        + Time);
                        Question = "select Question,Option_A,Option_B,Option_C,Option_D,Ans from easy_mode where Que_no = ? ";
                        pst = con.prepareStatement(Question);

                        Points = "select Easy_Points,Bonus_Points,Total from points where user_id = " + U_id;
                        st = con.createStatement();
                        l1 = false;

                    } else if (level == 2) {
                        b1.write(
                                "==========================================================================================\n");
                        b1.write("                                Classic Mode --> Medium \n");
                        b1.write(
                                "==========================================================================================\n");
                        b1.write(
                                "                                                                        Date : " + Date
                                        + "\n");
                        b1.write(
                                "                                                                        Time : " + Time
                                        + "\n");

                        System.out.println(
                                "=================================================================================================");
                        System.out.println("                                            CLASSIC --> MEDIUM");
                        System.out.println(
                                "=================================================================================================");
                        System.out.println(
                                "                                                                              Date : "
                                        + Date);
                        System.out.println(
                                "                                                                              Time : "
                                        + Time);
                        Question = "select Question,Option_A,Option_B,Option_C,Option_D,Ans from medium_mode where Que_no = ? ";
                        pst = con.prepareStatement(Question);

                        Points = "select Medium_Points,Bonus_Points,Total from points where user_id = " + U_id;
                        st = con.createStatement();
                        l1 = false;

                    } else if (level == 3) {
                        b1.write(
                                "==========================================================================================\n");
                        b1.write("                               Classic Mode --> Hard \n");
                        b1.write(
                                "==========================================================================================\n");
                        b1.write("                                                                      Date : " + Date
                                + "\n");
                        b1.write("                                                                      Time : " + Time
                                + "\n");

                        System.out.println(
                                "=================================================================================================");
                        System.out.println("                                          CLASSIC --> HARD");
                        System.out.println(
                                "=================================================================================================");
                        System.out.println(
                                "                                                                              Date : "
                                        + Date);
                        System.out.println(
                                "                                                                              Time : "
                                        + Time);
                        Question = "select Question,Option_A,Option_B,Option_C,Option_D,Ans from hard_mode where Que_no = ? ";
                        pst = con.prepareStatement(Question);

                        Points = "select Hard_Points,Bonus_Points,Total from points where user_id = " + U_id;
                        st = con.createStatement();
                        l1 = false;
                    } else {
                        System.out.println("InValid Choice \nPlease Enter Valid Choice");
                        sc.nextLine();
                    }
                    // Different Levels.
                } catch (InputMismatchException e) {
                    System.out.println("InValid Choice !!\nPlease Enter Valid Choice");
                    sc.nextLine();
                }
            }

            playQuiz p = new playQuiz();

            for (i = 1; i <= 15; i++) {
                playQuiz.QuizTimer quiztimer = p.new QuizTimer(20); // set timer for 20 seconds.
                quiztimer.start();
            }

            b1.write("-----------------------------------------------------------------------------------------\n");

            ResultSet rs = st.executeQuery(Points);
            if (rs.next()) {
                if (level == 1) {
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println("Your Points : " + Easy_points);
                    System.out.println("Bonus Points : " + Bonus_points);
                    b1.write("Your Points : " + Easy_points + "\n");
                    b1.write("Bonus Points : " + Bonus_points + "\n");
                    Total = rs.getInt(3) + Easy_points + Bonus_points;
                    Easy_points = Easy_points + rs.getInt(1);
                    Bonus_points = Bonus_points + rs.getInt(2);
                    String Update_points = "Update points set Easy_Points = " + Easy_points + ",Bonus_Points = "
                            + Bonus_points + ", Total = " + Total + " where User_id = " + U_id + "";
                    st = con.createStatement();
                    st.executeUpdate(Update_points);

                } else if (level == 2) {
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println("Your Points : " + Medium_points);
                    System.out.println("Bonus Points : " + Bonus_points);
                    b1.write("Your Points : " + Medium_points + "\n");
                    b1.write("Bonus Points : " + Bonus_points + "\n");
                    Total = rs.getInt(3) + Medium_points + Bonus_points;
                    Medium_points = Medium_points + rs.getInt(1);
                    Bonus_points = Bonus_points + rs.getInt(2);
                    String Update_points = "Update points set Medium_Points = " + Medium_points + ",Bonus_Points = "
                            + Bonus_points + ", Total = " + Total + " where User_id = " + U_id + "";
                    st = con.createStatement();
                    st.executeUpdate(Update_points);
                } else {
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println("Your Points : " + Hard_points);
                    System.out.println("Bonus Points : " + Bonus_points);
                    b1.write("Your Points : " + Hard_points + "\n");
                    b1.write("Bonus Points : " + Bonus_points + "\n");
                    Total = rs.getInt(3) + Hard_points + Bonus_points;
                    Hard_points = Hard_points + rs.getInt(1);
                    Bonus_points = Bonus_points + rs.getInt(2);
                    String Update_points = "Update points set Hard_Points = " + Hard_points + ",Bonus_Points = "
                            + Bonus_points + ", Total = " + Total + " where User_id = " + U_id + "";
                    st = con.createStatement();
                    st.executeUpdate(Update_points);
                }
            }
            // Updating details and Writing details in file.

            boolean a = false;

            quiz.h1.clear();
            quiz.Audience_poll = quiz.call_a_friend = quiz.flag_50_50 = true;
            Easy_points = Medium_points = Hard_points = Bonus_points = 0;

            while (a == false) {

                System.out.println("Do You want to Play Another Level (Yes OR No ) :");
                String ans = sc.nextLine();

                if (ans.equalsIgnoreCase("no")) {
                    l = false;
                    a = true;
                } else if (ans.equalsIgnoreCase("yes")) {
                    l1 = true;
                    a = true;
                } else {
                    System.out.println("Enter Valid Choice");
                }
            }
            // condition to play for another level or not.

        }

    }

    static void DailyChallenge() throws Exception {

        if (Daily == false) {
            Daily = true;
            System.out.println("You are ready for your daily Challenge Question ?(Yes or NO)");
            String DC = sc.nextLine();

            if (DC.equalsIgnoreCase("yes")) {

                String Date_Time = quiz.Date_Time();
                String a[] = Date_Time.split(" ");
                Date = a[0];
                Time = a[1];

                b1.write(
                        "==========================================================================================\n");
                b1.write("                                       Daily Challenge\n");
                b1.write(
                        "==========================================================================================\n");
                b1.write("                                                                        Date : " + Date
                        + "\n");
                b1.write("                                                                        Time : " + Time
                        + "\n");

                System.out.println(
                        "=================================================================================================");
                System.out.println("                                         DAILY CHALLENGE");
                System.out.println(
                        "=================================================================================================");
                System.out.println(
                        "                                                                              Date : " + Date);
                System.out.println(
                        "                                                                              Time : " + Time);
                playQuiz p = new playQuiz();
                Question = "select Question,Option_A,Option_B,Option_C,Option_D,Ans from daily_challenge where Que_no = ? ";
                pst = con.prepareStatement(Question);
                for (i = 1; i <= 1; i++) {
                    playQuiz.QuizTimer quiztimer = p.new QuizTimer(20);
                    quiztimer.start();
                }
                System.out.println();
            }
            // Mode of Dailly Challenge.

            Points = "select Daily_Points from points where user_id = " + U_id; // get points of daily challenge from
                                                                                // table
            st = con.createStatement();
            ResultSet rs = st.executeQuery(Points);

            if (rs.next()) {
                Daily_Point += rs.getInt(1);
                String Update_points = "Update points set Easy_Points = " + Daily_Point + ",Bonus_Points = "
                        + Bonus_points
                        + " where User_id = " + U_id;
                st = con.createStatement();
                st.executeUpdate(Update_points);
            }
            quiz.h1.clear();
        } else {
            System.out.println("You Already Completed Today's Daily Challenge"); // Daily challenge should be played
                                                                                 // once a day only
        }
    }
}