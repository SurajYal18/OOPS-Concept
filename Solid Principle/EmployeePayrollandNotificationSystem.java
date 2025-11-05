class Employee {
    private String name;
    private int id;
    private double salary;

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
    }

}

class PayrollCalculator {
    public double calculatePay(Employee employee) {
        return employee.getSalary() * 0.8; // 20% tax
    }
}

class paysSlipGenerator {
    public void generatePayslip(Employee employee) {
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Salary: " + employee.getSalary());
    }
}

interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SMSMessage implements MessageService {
    public void sendMessage(String message) {
        System.out.println("SMS message sent: " + message);
    }
}

class Notification {
    private MessageService messageService;

    public Notification(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send(String message) {
        messageService.sendMessage(message);
    }
}

class PayRollProcessor {
    private PayrollCalculator payrollCalculator;

    public PayRollProcessor(PayrollCalculator payrollCalculator, paysSlipGenerator payslipGenerator,
            Notification notification) {
        this.payrollCalculator = payrollCalculator;
    }

    public void processPayroll(Employee employee) {
        double netPay = payrollCalculator.calculatePay(employee);
        employee.setSalary(netPay);
    }
}

public class EmployeePayrollandNotificationSystem {
    public static void main(String[] args) {
        Employee employee = new Employee("Suraj", 123, 50000);
        PayrollCalculator payrollCalculator = new PayrollCalculator();
        paysSlipGenerator payslipGenerator = new paysSlipGenerator();
        EmailService emailService = new EmailService();
        SMSMessage smsMessage = new SMSMessage();
        Notification notification = new Notification(emailService);
        Notification notification1 = new Notification(smsMessage);
        PayRollProcessor payRollProcessor = new PayRollProcessor(payrollCalculator, payslipGenerator, notification);
        payRollProcessor.processPayroll(employee);
        payslipGenerator.generatePayslip(employee);
        notification.send("Hello Suraj!");
        notification1.send("Hello Suraj!");
    }
}
