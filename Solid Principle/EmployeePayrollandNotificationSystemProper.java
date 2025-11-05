import java.util.List;
import java.util.Arrays;

// ----------------- Domain (SRP) -----------------
class Employee {
    private String name;
    private int id;
    private double salary; // gross salary

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    } // used to set net pay if desired
}

// ----------------- Payroll (OCP, DIP) -----------------
// PayCalculator is an abstraction so payroll rules can be extended without
// modifying consumers
interface PayCalculator {
    double calculatePay(Employee employee);
}

// Default implementation: 20% tax
class DefaultPayCalculator implements PayCalculator {
    @Override
    public double calculatePay(Employee employee) {
        return employee.getSalary() * 0.8; // net pay after 20% tax
    }
}

// Example: Contractor calculator (different rule) demonstrating OCP (extend
// without change)
class ContractorPayCalculator implements PayCalculator {
    private double flatFee;

    public ContractorPayCalculator(double flatFee) {
        this.flatFee = flatFee;
    }

    @Override
    public double calculatePay(Employee employee) {
        // Contractors get salary minus a flat fee rather than percentage tax (example)
        return Math.max(0, employee.getSalary() - flatFee);
    }
}

// ----------------- Payslip (ISP, SRP) -----------------
// Small, focused interface for printing/generating payslips
interface PayslipGenerator {
    void generatePayslip(Employee employee, double netPay);
}

class ConsolePayslipGenerator implements PayslipGenerator {
    @Override
    public void generatePayslip(Employee employee, double netPay) {
        System.out.println("----- PAYSLIP -----");
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee ID  : " + employee.getId());
        System.out.printf("Net Pay      : %.2f%n", netPay);
        System.out.println("-------------------");
    }
}

// ----------------- Messaging & Notification (DIP, ISP) -----------------
interface MessageService {
    void sendMessage(String recipient, String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("[Email to " + recipient + "] " + message);
    }
}

class SMSService implements MessageService {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("[SMS to " + recipient + "] " + message);
    }
}

// NotificationSender depends on abstraction MessageService (DIP).
// It can use any MessageService implementation and also supports multiple
// channels.
class NotificationSender {
    private final List<MessageService> services;

    public NotificationSender(List<MessageService> services) {
        this.services = services;
    }

    public void notify(String recipient, String message) {
        for (MessageService svc : services) {
            svc.sendMessage(recipient, message);
        }
    }
}

// ----------------- Payroll Processor (SRP, DIP) -----------------
class PayrollProcessor {
    private final PayCalculator payCalculator;
    private final PayslipGenerator payslipGenerator;
    private final NotificationSender notificationSender;
    private final String contact; // in real app, employee would have contact details

    public PayrollProcessor(PayCalculator payCalculator,
            PayslipGenerator payslipGenerator,
            NotificationSender notificationSender,
            String contact) {
        this.payCalculator = payCalculator;
        this.payslipGenerator = payslipGenerator;
        this.notificationSender = notificationSender;
        this.contact = contact;
    }

    public void processPayroll(Employee employee) {
        double netPay = payCalculator.calculatePay(employee);
        // Do not overwrite gross salary in domain model; setSalary optional
        employee.setSalary(netPay); // if you want employee to hold net pay (keeps original behaviour)
        payslipGenerator.generatePayslip(employee, netPay);

        String message = "Hello " + employee.getName() + ", your payslip has been generated. Net pay: "
                + String.format("%.2f", netPay);
        notificationSender.notify(contact, message);
    }
}

// ----------------- Main / Demo -----------------
public class EmployeePayrollandNotificationSystemProper {
    public static void main(String[] args) {
        Employee employee = new Employee("Suraj", 123, 50000);

        // Choose payroll strategy (DIP + OCP)
        PayCalculator salariedCalculator = new DefaultPayCalculator();
        // PayCalculator contractorCalculator = new ContractorPayCalculator(5000); //
        // example extension

        // Payslip generator (ISP, SRP)
        PayslipGenerator payslipGenerator = new ConsolePayslipGenerator();

        // Message services (DIP) - we can add/remove channels without changing
        // NotificationSender logic
        MessageService email = new EmailService();
        MessageService sms = new SMSService();
        NotificationSender notificationSender = new NotificationSender(Arrays.asList(email, sms));

        // Payroll processor wired with abstractions (DIP)
        PayrollProcessor processor = new PayrollProcessor(salariedCalculator, payslipGenerator, notificationSender,
                "suraj@example.com");

        // Process payroll
        processor.processPayroll(employee);

        // If later you want contractor pay rules or another message type, create new
        // implementations
        // and inject them — no change to PayrollProcessor, NotificationSender, or
        // PayslipGenerator.
    }
}
