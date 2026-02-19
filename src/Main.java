import java.util.Scanner;
public class Main{
    boolean stop;
    public static void main(String[] args){
        StudentService studentService = new StudentService();
        boolean stop = false;
        System.out.println("Student List Manager\n" + "Type 'help' to show commands.");
        while (stop == false){
            Scanner myObj = new Scanner(System.in);  // Scanner
            String command = myObj.nextLine();  // Read user input
            String listeee[] = command.split(" ", command.length());
            if (listeee[0].equals("help")){
                System.out.println("Available commands:\n" + "  list\n" + "  add <id> <name>\n" + "  remove <id>\n" + "  export <format> <file_path>  (formats: csv, json)\n" + "  help\n" + "  quit");
            }
            else if (listeee[0].equals("quit")) {
                stop = true;
                myObj.close();
            }
            else if (listeee[0].equals("add")){
                studentService.addStudent(Integer.parseInt(listeee[1]), listeee[2]);
            }
            else if (listeee[0].equals("remove")){
                studentService.removeStudent(Integer.parseInt(listeee[1]));
            }
            else if (listeee[0].equals("list")){
                studentService.printList();
            }
            else if (listeee[0].equals("export")){
                if (listeee[1].equals("csv")){
                    studentService.exportCsv(listeee[2]);}
                else if (listeee[1].equals("Json")){
                    studentService.exportJson(listeee[2]);
                }
            }
            else {
                System.out.println("this command does not exist");
            }



        }
    }
}