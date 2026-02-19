import java.util.Scanner;
public class Main{
    boolean stop;
    public static void main(String[] args){
        boolean stop = false;
        while (stop == false){
            Scanner myObj = new Scanner(System.in);  // Scanner
            System.out.println("Student List Manager\n" + "Type 'help' to show commands.");
            String command = myObj.nextLine();  // Read user input
            String listeee[] = command.split(" ", command.length());
            if (listeee[0] == "help"){
                System.out.println("Available commands:\n" + "  list\n" + "  add <id> <name>\n" + "  remove <id>\n" + "  export <format> <file_path>  (formats: csv, json)\n" + "  help\n" + "  quit");
            }
            else if (listeee[0] ==  "quit") {
                stop = true;
            }
            else if (listeee[0] == "add"){
                StudentService.addStudent(listeee[1], listeee[2]);
            }
            else if (listeee[0] == "remove"){
                StudentService.removeStudent(listeee[1]);
            }
            else if (listeee[0] == "list"){
                StudentService.printList();
            }
            else{
                System.out.println("this command does not exist")
            }
        }
    }
}