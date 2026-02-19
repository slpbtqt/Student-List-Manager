import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>(); 
    
    public void printList() {
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println("- " + s.toString());
        }
    }

    public void addStudent(int id, String name) {
        Student newStudent = new Student(id, name);
        students.add(newStudent);
        System.out.println("Student '" + name + "' added.");
    }

    public void removeStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student with id '" + id + "' removed.");
                break;
            }
        }
    }

    public void exportCsv(String filepath){
    try (FileWriter writer = new FileWriter(filepath + ".csv"))
    {
        writer.append("id");
        writer.append(',');
        writer.append("name");
        writer.append('\n');
        for (Student student:students){
            writer.append(String.valueOf(student.getId()));
            writer.append(',');
            writer.append(student.getName());
            writer.append('\n');
        }
        writer.flush();
    }
    catch(IOException e)
    {
        System.err.println("Error exporting CSV: " + e.getMessage());
    } 
    }
}