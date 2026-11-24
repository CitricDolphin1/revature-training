import java.io.*;

public class Main {
    public static void main(String[] args) {
        Employee[] emps = new Employee[5];
        emps[0] = new Employee(1, "Alice", "Accounting", 30000);
        emps[1] = new Employee(2, "Bob", "Business", 40000);
        emps[2] = new Employee(3, "Charlie", "Customer Service", 50000);
        emps[3] = new Employee(4, "David", "Design", 60000);
        emps[4] = new Employee(5, "Edward", "Enginerring", 70000);

        try (
            FileOutputStream fos = new FileOutputStream("employess.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(emps);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("IOException");
        } 

        try (
            FileInputStream fis = new FileInputStream("employess.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            emps = (Employee[])ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(emps[i]);
        }
    }
}
