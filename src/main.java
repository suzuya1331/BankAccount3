import java.util.*;


public class main {
    public static String admin ;
    public static String adminpass ;
    public static int number = 0, nbr = 0, userIDP, AccID;
    public static Scanner input = new Scanner(System.in);
    public static account acc[] = new account[100];
    public static vipAccount vpAcc[] = new vipAccount[100];

    public static void main(String[] agrs) {
// to create admin account
        System.out.println("enter your admin username");
        admin=input.next();
        System.out.println("enter your password");
        adminpass=input.next();
        int ID = 0;
        login();

    }
   // to create vip account from admin panel
    public static void SetVipAccount() {
        System.out.println("enter number of account");
        int nbr1 = input.nextInt();
        number = number + nbr1;
        int i;
        for (i = nbr; i < number; i++) {
            vpAcc[i] = new vipAccount();

        }
        for (i = nbr; i < number; i++) {
            System.out.println("enter ID of client" + (i + 1));
            int ID = input.nextInt();
            vpAcc[i].SetNumber(ID);
            System.out.println("enter balance of client " + (i + 1));
            float balance = input.nextFloat();
            vpAcc[i].SetBlance(balance);
            System.out.println("enter name of client " + (i + 1));
            String Name = input.next();
            vpAcc[i].setName(Name);
            System.out.println("enter email of client " + (i + 1));
            String email = input.next();
            vpAcc[i].setemil(email);
            System.out.println("enter number of client " + (i + 1));
            int phoneNumber = input.nextInt();
            vpAcc[i].setPhoneNumbr(phoneNumber);
            System.out.println("enter password of client " + (i + 1));
            String UserPass = input.next();
            vpAcc[i].setUserPass(UserPass);
            System.out.println("enter limit of the account" + (i + 1));
            int AccountLimits = input.nextInt();
            vpAcc[i].setAccountLimit(AccountLimits);
        }
        nbr = nbr + nbr1;
        System.out.println(nbr + " " + nbr1);
    }
// to create normal account from admin panel
    public static void SetAccount() {
        System.out.println("enter number of account");
        int nbr1 = input.nextInt();
        number = number + nbr1;
        int i;
        for (i = nbr; i < number; i++) {
            acc[i] = new account();

        }
        for (i = nbr; i < number; i++) {
            System.out.println("enter ID of client" + (i + 1));
            int ID = input.nextInt();
            acc[i].SetNumber(ID);
            System.out.println("enter balance of client " + (i + 1));
            float balance = input.nextFloat();
            acc[i].SetBlance(balance);
            System.out.println("enter name of client " + (i + 1));
            String Name = input.next();
            acc[i].setName(Name);
            System.out.println("enter email of client " + (i + 1));
            String email = input.next();
            acc[i].setemil(email);
            System.out.println("enter number of client " + (i + 1));
            int phoneNumber = input.nextInt();
            acc[i].setPhoneNumbr(phoneNumber);
            System.out.println("enter password of client " + (i + 1));
            String UserPass = input.next();
            acc[i].setUserPass(UserPass);
        }
        nbr = nbr + nbr1;
        System.out.println(nbr + " " + nbr1);
    }
// to deposit money to account
    public static void userdeposit() {
        // to deposit money to normal account
        if (AccID == 2) {
            for (int i = 0; i < number; i++) {
                if (userIDP == acc[i].GetNumber()) {
                    System.out.println("enter mount of money for deposit into your bank account");
                    float money = input.nextFloat();
                    acc[i].SetBlance(acc[i].GetBlance() + money);

                }
            }
        } // to deposit money to VIP account
        else if (AccID == 3) {
            for (int i = 0; i < number; i++) {
                if (userIDP == vpAcc[i].GetNumber()) {
                    System.out.println("enter mount of money for deposit into your bank account");
                    float money = input.nextFloat();
                    vpAcc[i].SetBlance(vpAcc[i].GetBlance() + money);

                }
            }
        }


    }
// to deposit money from admin panel
    public static void deposit() {
        System.out.println("1. NORMAL ACCOUNT DEPOSIT");
        System.out.println("2. VIP ACCOUNT DEPOSIT");
        System.out.println("3. EXIT");
        System.out.println("eneter number to selcet");
        int IDacc = input.nextInt();
        // normal account
        if (IDacc == 1) {


            System.out.println("enter number of the account to add deposit to it ");

            boolean isAccount = false;
            int ID = input.nextInt();
            for (int i = 0; i < number; i++) {

                if (ID == acc[i].GetNumber()) {
                    System.out.println("enter mount of money for deposit into your bank account");
                    float money = input.nextFloat();
                    acc[i].SetBlance(acc[i].GetBlance() + money);
                    isAccount = true;
                }


            }
            if (!isAccount) {
                System.out.println("the number that you entered is unccorect");
            }
        }
        // vip account
        else if (IDacc == 2) {
            System.out.println("enter number of the account to add deposit to it ");

            boolean isAccount = false;
            int ID = input.nextInt();
            for (int i = 0; i < number; i++) {

                if (ID == vpAcc[i].GetNumber()) {
                    System.out.println("enter mount of money for deposit into your bank account");
                    float money = input.nextFloat();
                    vpAcc[i].SetBlance(vpAcc[i].GetBlance() + money);
                    isAccount = true;
                }


            }
            if (!isAccount) {
                System.out.println("the number that you entered is unccorect");
            }
        }
    }

   // to withdraw money from vip account
    public static void vpWithDraw() {

        for (int i = 0; i < number; i++) {
            if (userIDP == vpAcc[i].GetNumber()) {

                System.out.println("enter mount of money to withdraw");
                float money = input.nextFloat();
                if ((money - vpAcc[i].getAccountLimit())<= vpAcc[i].GetBlance()) {
                    vpAcc[i].SetBlance(vpAcc[i].GetBlance() - money);
                } else
                    System.out.println("your money is not enough");
            }
        }

    }
    // to withdraw from normal account
    public static void userWithDraw() {

        for (int i = 0; i < number; i++) {
            if (userIDP == acc[i].GetNumber()) {

                System.out.println("enter mount of money to withdraw");
                float money = input.nextFloat();
                if (money <= acc[i].GetBlance()) {
                    acc[i].SetBlance(acc[i].GetBlance() - money);
                } else
                    System.out.println("your money is not enough");
            }
        }

    }
// to withdraw money from admin panel
    public static void withdraw() {
        int IDacc;

        do {
            System.out.println("1. NORMAL ACCOUNT DEPOSIT");
            System.out.println("2. VIP ACCOUNT DEPOSIT");
            System.out.println("99. EXIT");
            System.out.println("eneter number to selcet");
             IDacc = input.nextInt();
//withdraw from normal account
            if (IDacc == 1) {
                boolean isAccount = false;
                System.out.println("enter number of the account to take out withdraw from  it ");

                int ID = input.nextInt();
                for (int i = 0; i < number; i++) {
                    if (ID == acc[i].GetNumber()) {
                        isAccount = true;
                        System.out.println("enter mount of money to withdraw");
                        float money = input.nextFloat();
                        if (money <= acc[i].GetBlance()) {
                            acc[i].SetBlance(acc[i].GetBlance() - money);
                        } else
                            System.out.println("your money is not enough");
                    }


                }
                if (!isAccount) {
                    System.out.println("the number that you entered is unccorect");
                }
            }
            // withdraw from vip account
            else if (IDacc == 2) {
                boolean isAccount = false;
                System.out.println("enter number of the account to take out withdraw from  it ");

                int ID = input.nextInt();
                for (int i = 0; i < number; i++) {
                    if (ID == vpAcc[i].GetNumber()) {
                        isAccount = true;
                        System.out.println("enter mount of money to withdraw");
                        float money = input.nextFloat();
                        if ((money - vpAcc[i].getAccountLimit()) <= vpAcc[i].GetBlance()) {
                            vpAcc[i].SetBlance(vpAcc[i].GetBlance() - money);
                        } else
                            System.out.println("your money is not enough");
                    }


                }
                if (!isAccount) {
                    System.out.println("the number that you entered is unccorect");
                }
            }
        } while (IDacc != 99);

    }
// to transfer money from admin panel
    public static void TransferMoney() {
        System.out.println("1. RECHERCHE FOR NORMAL ACCOUNT");
        System.out.println("2. RECHRCHE FOR VIP ACCOUNT");
        System.out.println("enter nymber to select");
        int ID=input.nextInt();
        //transfer from normal account
        if(ID==1) {
            System.out.println("enter account that you want to transfer money from");

            int ID1 = input.nextInt();
            boolean isID1 = false, isID2 = false;
            for (int i = 0; i < number; i++) {
                if (ID1 == acc[i].GetNumber()) {
                    isID1 = true;
                    System.out.println("enter account that you want to transfer money to  ");
                    int ID2 = input.nextInt();
                    for (int j = 0; j < number; j++) {
                        if (ID2 == acc[j].GetNumber()) {
                            isID2 = true;
                            System.out.println("enter amount of money that you want to transfer ");
                            float money = input.nextFloat();
                            if (money <= acc[i].GetBlance()) {
                                acc[i].SetBlance(acc[i].GetBlance() - money);
                                acc[j].SetBlance(acc[j].GetBlance() + money);
                            } else
                                System.out.println("your money is not enough to make that transfer");
                        }
                    }
                }

            }
            if (!isID1 || !isID2)
                System.out.println("account was not found");
        }
        // transfer from vip account
        else if(ID==2){
            System.out.println("enter account that you want to transfer money from");

            int ID1 = input.nextInt();
            boolean isID1 = false, isID2 = false;
            for (int i = 0; i < number; i++) {
                if (ID1 == vpAcc[i].GetNumber()) {
                    isID1 = true;
                    System.out.println("enter account that you want to transfer money to  ");
                    int ID2 = input.nextInt();
                    for (int j = 0; j < number; j++) {
                        if (ID2 == vpAcc[j].GetNumber()) {
                            isID2 = true;
                            System.out.println("enter amount of money that you want to transfer ");
                            float money = input.nextFloat();
                            if ((money-vpAcc[i].getAccountLimit() )<= vpAcc[i].GetBlance()) {
                                vpAcc[i].SetBlance(vpAcc[i].GetBlance() - money);
                                vpAcc[j].SetBlance(vpAcc[j].GetBlance() + money);
                            } else
                                System.out.println("your money is not enough to make that transfer");
                        }
                    }
                }

            }
            if (!isID1 || !isID2)
                System.out.println("account was not found");
        }
    }
    //transfer money from user panel
    public static void UsertranserMoney() {

   // normal account
        if(AccID==2) {
            boolean isID2 = false;
            for (int i = 0; i < number; i++) {
                if (userIDP == acc[i].GetNumber()) {

                    System.out.println("enter account that you want to transfer money to  ");
                    int ID2 = input.nextInt();
                    for (int j = 0; j < number; j++) {
                        if (ID2 == acc[j].GetNumber()) {
                            isID2 = true;
                            System.out.println("enter amount of money that you want to transfer ");
                            float money = input.nextFloat();
                            if (money <= acc[i].GetBlance()) {
                                acc[i].SetBlance(acc[i].GetBlance() - money);
                                acc[j].SetBlance(acc[j].GetBlance() + money);
                            } else
                                System.out.println("your money is not enough to make that transfer");
                        }
                    }
                }

            }
            if (!isID2)
                System.out.println("account was not found");
        }
        // VIP account
        else if(AccID==3)
        {
            boolean isID2 = false;
            for (int i = 0; i < number; i++) {
                if (userIDP == vpAcc[i].GetNumber()) {

                    System.out.println("enter account that you want to transfer money to  ");
                    int ID2 = input.nextInt();
                    for (int j = 0; j < number; j++) {
                        if (ID2 == vpAcc[j].GetNumber()) {
                            isID2 = true;
                            System.out.println("enter amount of money that you want to transfer ");
                            float money = input.nextFloat();
                            if ((money - vpAcc[i].getAccountLimit())<= vpAcc[i].GetBlance()) {
                                vpAcc[i].SetBlance(vpAcc[i].GetBlance() - money);
                                vpAcc[j].SetBlance(vpAcc[j].GetBlance() + money);
                            } else
                                System.out.println("your money is not enough to make that transfer");
                        }
                    }
                }

            }
            if (!isID2)
                System.out.println("account was not found");

        }
    }
// recherche for account from admin panel
    public static void Recherche() {
        System.out.println("1. RECHERCHE FOR NORMAL ACCOUNT");
        System.out.println("2. RECHRCHE FOR VIP ACCOUNT");
        System.out.println("enter nymber to select");
      int ID1 =input.nextInt();
      //normal account
       if (ID1==1) {
           System.out.println("enter number to recherche for");
           int ID = input.nextInt();
           for (int i = 0; i < number; i++) {
               if (ID == acc[i].GetNumber())
                   System.out.println(acc[i].GetNumber() + " " + acc[i].GetBlance() + " " + acc[i].Getname() + " " + acc[i].Getemail() + " " + acc[i].GetPhoneNumber());

           }
       }
       //VIP account
       else if (ID1==2) {
           System.out.println("enter number to recherche for");
           int ID = input.nextInt();
           for (int i = 0; i < number; i++) {
               if (ID == vpAcc[i].GetNumber())
                   System.out.println(vpAcc[i].GetNumber() + " " + vpAcc[i].GetBlance() + " " + vpAcc[i].Getname() + " " + vpAcc[i].Getemail() + " " + vpAcc[i].GetPhoneNumber());

           }

       }
    }
// to login to account
    public static void login() {
        int ID = 0;
        while (ID != 99) {
            System.out.println("enter number to select ");

            System.out.println("1.ADMIN account ");
            System.out.println("2.USER account");
            System.out.println("3.vip account");
            System.out.println("99.EXIT");
            ID = input.nextInt();
            AccID = ID;
            switch (ID) {
                //admin account
                case 1:
                    System.out.println("enter your username");
                    String adminacc = input.next();
                    System.out.println("enter your password");
                    String adminpassacc = input.next();
                    if ((adminacc.equals(admin)) && (adminpassacc.equals(adminpass)))
                        admin();
                    else
                        System.out.println("error");
                    break;
                 // normal account
                case 2:
                    System.out.println("enter your ID");
                    int userID = input.nextInt();
                    userIDP = userID;
                    System.out.println("enter your password");
                    String userpassacc = input.next();
                    boolean check = false;
                    for (int i = 0; i < number; i++) {
                        if (acc[i].getUserPass().equals(userpassacc) && acc[i].GetNumber() == userID) {
                            user();
                            check = true;
                        }
                    }
                    if (!check)
                        System.out.println("eroor");

                    break;
                 // VIP account
                case 3:
                    System.out.println("enter your ID");
                    int vpID = input.nextInt();
                    userIDP = vpID;
                    System.out.println("enter your password");
                    String vppassacc = input.next();
                     check = false;
                    for (int i = 0; i < number; i++) {
                        if (vpAcc[i].getUserPass().equals(vppassacc) && vpAcc[i].GetNumber() == vpID) {
                            vpuser();
                            check = true;
                        }
                    }
                    if (!check)
                        System.out.println("eroor");

                    break;
                default:
                    System.out.println("unvalid number");
            }

        }
    }
// admin panel
    public static void admin() {
        int ID = 0;
        while (ID != 99) {
            System.out.println("enter number to select");
            System.out.println("1.ADD ACOUUNTS");
            System.out.println("2.DEPOSIT");
            System.out.println("3.WITHDRAW");
            System.out.println("4.TRANSFER");
            System.out.println("5.RECHERCHE");
            System.out.println("99.EXIT");
            ID = input.nextInt();
            switch (ID) {
                case 1:
                    System.out.println("1.USER ACCOUNT");
                    System.out.println("2.VIP ACCOUNT");
                    System.out.println("enter number to select");
                    int ID1=input.nextInt();
                    if(ID1==1) {
                        SetAccount();
                        for (int i = 0; i < number; i++) {
                            System.out.println(acc[i].GetNumber() + " " + acc[i].GetBlance() + " " + acc[i].Getname() + " " + acc[i].Getemail() + " " + acc[i].GetPhoneNumber());
                        }
                    }
                    else if(ID1==2) {
                        SetVipAccount();
                        for (int i = 0; i < number; i++) {
                            System.out.println(vpAcc[i].GetNumber() + " " + vpAcc[i].GetBlance() + " " + vpAcc[i].Getname() + " " + vpAcc[i].Getemail() + " " + vpAcc[i].GetPhoneNumber());
                        }
                    }
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    TransferMoney();
                    break;
                case 5:
                    Recherche();
                    break;
                default:
                    System.out.println("your pick wrong number");

            }


        }

    }
// user panel
    public static void user() {
        int ID = 0;
        while (ID != 99) {
            System.out.println("enter number to select");

            System.out.println("1.DEPOSIT");
            System.out.println("2.WITHDRAW");
            System.out.println("3.TRANSFER");
            System.out.println("99.EXIT");
            ID = input.nextInt();
            switch (ID) {
                case 1:
                    userdeposit();
                    break;
                case 2:
                    userWithDraw();
                    break;
                case 3:
                    UsertranserMoney();
                    break;

                default:
                    System.out.println("your pick wrong number");

            }
            for (int i = 0; i < number; i++) {
                System.out.println(acc[i].GetNumber() + " " + acc[i].GetBlance() + " " + acc[i].Getname() + " " + acc[i].Getemail() + " " + acc[i].GetPhoneNumber());
            }

        }
    }
    // VIP user panel
    public static void vpuser() {
        int ID = 0;
        while (ID != 99) {
            System.out.println("enter number to select");

            System.out.println("1.DEPOSIT");
            System.out.println("2.WITHDRAW");
            System.out.println("3.TRANSFER");
            System.out.println("99.EXIT");
            ID = input.nextInt();
            switch (ID) {
                case 1:
                    userdeposit();
                    break;
                case 2:
                    vpWithDraw();
                    break;
                case 3:
                    UsertranserMoney();
                    break;

                default:
                    System.out.println("your pick wrong number");

            }
            for (int i = 0; i < number; i++) {
                System.out.println(vpAcc[i].GetNumber() + " " + vpAcc[i].GetBlance() + " " + vpAcc[i].Getname() + " " + vpAcc[i].Getemail() + " " + vpAcc[i].GetPhoneNumber());
            }

        }
    }
}
