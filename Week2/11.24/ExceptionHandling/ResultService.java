public class ResultService {

    // Incident 1
    public void sendResult(String email) {
        System.out.println("Result sent to " + email.toLowerCase());
    }

    // Incident 2
    public int classAverage(int totalMarks, int studentCount) {
        return totalMarks / studentCount;
    }

    // Incident 3
    public int readMarks(String input) {
        return Integer.parseInt(input);
    }

    // Incident 4
    public String getSubject(int index) {
        String[] subjects = {"Maths", "Physics", "Chemistry"};
        return subjects[index];
    }

    // Incidents 5 and 6
    public void recordMarks(Student student, int marks) {
        student.marks = marks;
    }
}

