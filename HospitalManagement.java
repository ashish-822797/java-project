import java.util.*;

class Patient {
    String id, name, disease;
    int age;

    public Patient(String id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public void display() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
    }
}

class Doctor {
    String id, name, specialty;

    public Doctor(String id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public void display() {
        System.out.println("Doctor ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialty: " + specialty);
    }
}

class Appointment {
    String appointmentId, patientId, doctorId;
    String date;

    public Appointment(String appointmentId, String patientId, String doctorId, String date) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public void display() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Date: " + date);
    }
}

public class HospitalManagement {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Patient> patients = new HashMap<>();
    static HashMap<String, Doctor> doctors = new HashMap<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addDoctor();
                case 3 -> scheduleAppointment();
                case 4 -> viewPatients();
                case 5 -> viewDoctors();
                case 6 -> viewAppointments();
                case 7 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();

        patients.put(id, new Patient(id, name, age, disease));
        System.out.println("Patient added successfully.");
    }

    static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialty: ");
        String specialty = scanner.nextLine();

        doctors.put(id, new Doctor(id, name, specialty));
        System.out.println("Doctor added successfully.");
    }

    static void scheduleAppointment() {
        System.out.print("Enter Appointment ID: ");
        String appId = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String pId = scanner.nextLine();
        System.out.print("Enter Doctor ID: ");
        String dId = scanner.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        if (patients.containsKey(pId) && doctors.containsKey(dId)) {
            appointments.add(new Appointment(appId, pId, dId, date));
            System.out.println("Appointment scheduled.");
        } else {
            System.out.println("Invalid Patient or Doctor ID.");
        }
    }

    static void viewPatients() {
        for (Patient p : patients.values()) {
            p.display();
            System.out.println("----------------------");
        }
    }

    static void viewDoctors() {
        for (Doctor d : doctors.values()) {
            d.display();
            System.out.println("----------------------");
        }
    }

    static void viewAppointments() {
        for (Appointment a : appointments) {
            a.display();
            System.out.println("----------------------");
        }
    }
}