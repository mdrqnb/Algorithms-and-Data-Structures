import java.util.*;
class BankAccount {
    int accountNumber;
    String username;
    double balance;

    public BankAccount(int accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String toString() {
        return accountNumber + " | " + username + " | Balance: " + balance;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> history = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount> requests = new LinkedList<>();

    public static void main(String[] args) {

        // TASK 1: adding initial accounts
        accounts.add(new BankAccount(1, "Ali", 150000));
        accounts.add(new BankAccount(2, "Sara", 220000));

        // TASK 6: Array (Physical Data Structure)
        BankAccount[] arr = new BankAccount[3];
        arr[0] = new BankAccount(101, "Aruzhan", 100000);
        arr[1] = new BankAccount(102, "Dana", 200000);
        arr[2] = new BankAccount(103, "Madi", 300000);

        System.out.println("=== Physical Data Structure (Array) ===");
        for (BankAccount a : arr) {
            System.out.println(a);
        }

        int choice;
        do {
            System.out.println("\n=== MINI BANKING MENU ===");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bankMenu();
                    break;
                case 2:
                    atmMenu();
                    break;
                case 3:
                    adminMenu();
                    break;
                case 4:
                    System.out.println("Program ended");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        } while (choice != 4);
    }

    static void bankMenu() {
        int choice;
        do {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1 - Add new account");
            System.out.println("2 - Show all accounts");
            System.out.println("3 - Search account by username");
            System.out.println("4 - Deposit money");
            System.out.println("5 - Withdraw money");
            System.out.println("6 - Add bill payment");
            System.out.println("7 - Submit account request");
            System.out.println("8 - Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    showAccounts();
                    break;
                case 3:
                    searchAccount();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    withdraw();
                    break;
                case 6:
                    addBill();
                    break;
                case 7:
                    addRequest();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        } while (choice != 8);
    }

    static void atmMenu() {
        int choice;
        do {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Show last transaction");
            System.out.println("4 - Undo last transaction");
            System.out.println("5 - Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    showLastTransaction();
                    break;
                case 4:
                    undoTransaction();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        } while (choice != 5);
    }

    static void adminMenu() {
        int choice;
        do {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1 - Show account requests");
            System.out.println("2 - Process account request");
            System.out.println("3 - Show bill queue");
            System.out.println("4 - Process bill payment");
            System.out.println("5 - Show transaction history");
            System.out.println("6 - Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showRequests();
                    break;
                case 2:
                    processRequest();
                    break;
                case 3:
                    showBills();
                    break;
                case 4:
                    processBill();
                    break;
                case 5:
                    showHistory();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        } while (choice != 6);
    }

    // TASK 1 METHODS
    static void addAccount() {
        System.out.print("Enter account number: ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter username: ");
        String name = sc.nextLine();

        System.out.print("Enter balance: ");
        double bal = sc.nextDouble();

        accounts.add(new BankAccount(num, name, bal));
        System.out.println("Account added successfully");
    }

    static void showAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts");
            return;
        }

        for (BankAccount a : accounts) {
            System.out.println(a);
        }
    }

    static void searchAccount() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        for (BankAccount a : accounts) {
            if (a.username.equalsIgnoreCase(name)) {
                System.out.println("Found: " + a);
                return;
            }
        }

        System.out.println("Account not found");
    }

    // TASK 2 METHODS
    static void deposit() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        for (BankAccount a : accounts) {
            if (a.username.equalsIgnoreCase(name)) {
                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                a.balance += amount;

                // TASK 3
                history.push("Deposit " + amount + " to " + name);
                System.out.println("New balance: " + a.balance);
                return;
            }
        }

        System.out.println("Account not found");
    }

    static void withdraw() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        for (BankAccount a : accounts) {
            if (a.username.equalsIgnoreCase(name)) {
                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();

                if (amount <= a.balance) {
                    a.balance -= amount;

                    // TASK 3
                    history.push("Withdraw " + amount + " from " + name);
                    System.out.println("New balance: " + a.balance);
                } else {
                    System.out.println("Not enough money");
                }
                return;
            }
        }

        System.out.println("Account not found");
    }

    // TASK 4 METHODS
    static void addBill() {
        sc.nextLine();
        System.out.print("Enter bill name: ");
        String bill = sc.nextLine();

        billQueue.offer(bill);

        // TASK 3 (history)
        history.push("Bill payment added: " + bill);
        System.out.println("Bill added");
    }

    static void showBills() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills in queue");
            return;
        }

        for (String bill : billQueue) {
            System.out.println(bill);
        }
    }

    static void processBill() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills to process");
        } else {
            System.out.println("Processing: " + billQueue.poll());
        }
    }

    // TASK 5 METHODS
    static void addRequest() {
        System.out.print("Enter account number: ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter username: ");
        String name = sc.nextLine();

        System.out.print("Enter balance: ");
        double bal = sc.nextDouble();

        requests.offer(new BankAccount(num, name, bal));
        System.out.println("Request submitted");
    }

    static void showRequests() {
        if (requests.isEmpty()) {
            System.out.println("No account requests");
            return;
        }

        for (BankAccount a : requests) {
            System.out.println(a);
        }
    }

    static void processRequest() {
        if (requests.isEmpty()) {
            System.out.println("No requests to process");
        } else {
            BankAccount a = requests.poll();
            accounts.add(a);
            System.out.println("Request processed: " + a);
        }
    }

    // TASK 2 / ATM
    static void checkBalance() {
        sc.nextLine();
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        for (BankAccount a : accounts) {
            if (a.username.equalsIgnoreCase(name)) {
                System.out.println("Balance: " + a.balance);
                return;
            }
        }

        System.out.println("Account not found");
    }

    // TASK 3 METHODS
    static void showLastTransaction() {
        if (history.isEmpty()) {
            System.out.println("No transactions");
        } else {
            System.out.println("Last transaction: " + history.peek());
        }
    }

    static void undoTransaction() {
        if (history.isEmpty()) {
            System.out.println("No transactions to undo");
        } else {
            System.out.println("Removed: " + history.pop());
        }
    }

    static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transaction history");
            return;
        }

        for (String h : history) {
            System.out.println(h);
        }
    }
}