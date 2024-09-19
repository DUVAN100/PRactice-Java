package sistembanc;
import java.util.ArrayList;
import java.util.Scanner;
// this is a practices with array literals
public class SistemBanc {
    public static void main(String[] args) {
        Scanner entrance = new Scanner(System.in);
        String[] numbersChecks = new String[10];
        String[] nameHolders = new String[10];
        double[] balances = new double[10];
        int countChecks = 0;
        boolean cancelProcess = false;
        while(!cancelProcess){
            System.out.println("****Enter Option*****");
            System.out.println("1_ Create check");
            System.out.println("2_ deposit");
            System.out.println("3_ withdraw cash");
            System.out.println("4_ consult cash");
            System.out.println("5_ Show checks");
            System.out.println("6_ cancel");
            System.out.println("Select option...");
            int opc = entrance.nextInt();
            switch(opc){
                case 1:
                    if(countChecks < 10){
                        System.out.println("Enter the number check.");
                        numbersChecks[countChecks] = entrance.nextLine();
                        System.out.println("Enter name holder");
                        nameHolders[countChecks] = entrance.nextLine();
                        System.out.println("Enter balance initial");
                        balances[countChecks] = entrance.nextDouble();
                        countChecks++;
                        System.out.println("Check created succesfully...");
                    }else{
                        System.out.println("You are not allowed to create more accounts");
                    }
                case 2:
                    System.out.println("Type number wanted for account:");
                    String numberAccount = entrance.nextLine();
                    boolean accountFound = false;
                    for(int i=0; i<countChecks; i++){
                        if(numbersChecks[i].equals(numberAccount)){
                            System.out.println("type amout to deposit: ");
                            double amount = entrance.nextDouble();
                            if(amount > 0){
                                balances[i] += amount;
                                System.out.println("Process succes.");
                                System.out.println("new amout: $"+ balances[i]);
                            }else{
                                System.out.println("Amout invalid.");
                            }
                            accountFound = true;
                            break;
                        }
                    }
                    if(!accountFound){
                        System.out.println("Account not found!!");
                    }
                case 3:
                    System.out.println("Type number wanted for account:");
                    String numberAccountRet = entrance.nextLine();
                    accountFound = false;
                    for(int i=0; i<countChecks; i++){
                        if(numbersChecks[i].equals(numberAccountRet)){
                            System.out.println("type amout to withdrawal: ");
                            double amountRet = entrance.nextDouble();
                            if(amountRet > 0 && amountRet <= balances[i]){
                                balances[i] -= amountRet;
                                System.out.println("Process succes.");
                                System.out.println("new amout: $"+ balances[i]);
                            }else{
                                System.out.println("Amout invalid.");
                            }
                            accountFound = true;
                            break;
                        }
                    }
                    if(!accountFound){
                        System.out.println("Account not found!!");
                    }
                case 4:
                    System.out.println("Type number wanted for account:");
                    String numberAccountCon = entrance.nextLine();
                    accountFound = false;
                    for(int i=0; i<countChecks; i++){
                        if(numbersChecks[i].equals(numberAccountCon)){
                            System.out.println("Your amout is: $"+ balances[i]);
                            accountFound = true;
                            break;
                        }
                    }
                    if(!accountFound){
                        System.out.println("Account not found!!");
                    }
                case 5:
                    if(countChecks == 0){
                        System.out.println("Has'nt accounts created for the moment...");
                    }else{
                        System.out.println("NRO  Name Holder  balances");
                        for (int i = 0; i < countChecks; i++){
                            System.out.println(String.format("-%d %s  %.2f", numbersChecks[i], nameHolders[i], balances[i]));
                        }
                    }
                case 6:
                    cancelProcess = true;
                default:
                    System.out.println("Opcion invalid");
                    break;
            }
        }
    }
    
}
