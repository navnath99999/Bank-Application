package pack3;

import java.util.Scanner;

public class BankApplication {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your 'Name' and 'CustomerId' to access your Bank account:");
        String name=sc.nextLine();
        String customerId=sc.nextLine();
        BankAccount obj1=new BankAccount(name,customerId);
        obj1.menu();
    }
}

class BankAccount{
    double bal;
    double prevTrans;
    String customerName;
    String customerId;

    BankAccount(String customerName,String customerId){
        this.customerName=customerName;
        this.customerId=customerId;
    }


    void deposit(double amount){
        if(amount!=0){
            bal+=amount;
            prevTrans=amount;
        }
    }

    void withdraw(double amt){
        if(amt!=0 && bal>=amt){
            bal-=amt;
            prevTrans=-amt;
        }
        else if(bal<amt){
            System.out.println("Bank balance insufficient");
        }
    }

    void getPreviousTrans(){
        if(prevTrans>0){
            System.out.println("Deposited: "+prevTrans);
        }
        else if(prevTrans<0){
            System.out.println("Withdrawn: "+Math.abs(prevTrans));
        }
        else{
            System.out.println("No transaction occured");
        }
    }

    void menu(){
        char option;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome "+customerName);
        System.out.println("Your ID:"+customerId);
        System.out.println("\n");
        System.out.println("1) Check Balance");
        System.out.println("2) Deposit Amount");
        System.out.println("3) Withdraw Amount");
        System.out.println("4) Previous Transaction");
        System.out.println("0) Exit");

        do{
            System.out.println("********************************************");
            System.out.println("Choose an option");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case '1':
                    System.out.println("......................");
                    System.out.println("Balance ="+bal);
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case '2':
                    System.out.println("......................");
                    System.out.println("Enter a amount to deposit :");
                    System.out.println("......................");
                    double amt=sc.nextDouble();
                    deposit(amt);
                    System.out.println("\n");
                    break;
                case '3':
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    System.out.println("......................");
                    double amtW=sc.nextDouble();
                    withdraw(amtW);
                    System.out.println("\n");
                    break;
                case '4':
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    getPreviousTrans();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;

                case '0':
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }

        }while(option!='0');

        System.out.println("Thank you for using our banking services");
    }

}