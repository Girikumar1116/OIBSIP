import java.util.*;
class AtmInterface
{
    double balance=10000;
	String atmpin;
	String accountNo;
    String transactionsHistory="";
    int transactions=0;
    public void Register()

    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your account number");
        this.atmpin=sc.nextLine();
        System.out.println("Create a 4 pin password");
        this.accountNo=sc.nextLine();
        System.out.println("Registration completed");

    }
    /**
     * @return
     */
    public boolean validatePin()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the atmpin");
        String password=sc.next();
        if(password.equals(atmpin))
        {  
            return true;
        }
        else{
            
            return false;
        }
        
    }
    public void validating()
    {
        Scanner sc=new Scanner(System.in);
        AtmInterface b=new AtmInterface();
        while(b.validatePin()==false)
        {
            System.out.println("Its wrong pin");
            System.out.println("\n1.continue \n2.Exit");
            int retake=sc.nextInt();
            if (retake==1)
            {
                b.validatePin();
            }
            else
            {
                System.exit(0);
            }   

        }
        System.out.println("pin iscorrect");
    }
    public void withDraw()
    {
        AtmInterface b=new AtmInterface();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount");
        double amount=sc.nextDouble();
        if (balance>=amount){
            b.validating();

            transactions++;
            balance-=amount;
            System.out.println("Remaining balance \n"+  balance);
            String str=amount + " Rs Withdrawn\n";
            transactionsHistory =transactionsHistory.concat(str);
        }
        else
        {
            //throw new InsufficientFundException();
            System.out.println("Insufficient fund");
        }
            
    }
    public void Deposit()
    {
        AtmInterface b=new AtmInterface();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter account number");
        String acc=sc.next();
        System.out.println("Enter the deposit amount");
        double amount=sc.nextDouble();
        
        if(amount<100000)
        {
            b.validating();

            transactions++;
            balance+=amount;
            System.out.println("Amount is"+ amount);
            System.out.println("Balance in your account"+ balance);
            System.out.println("Amount deposited take a receipt");
            String s=amount + " Rs deposited\n";
            transactionsHistory=transactionsHistory.concat(s);
        }
        else{
            //throw new LimitOverException();
            System.out.println("Limit over exceeded");
        }
    }
    public void Transfer()
    {
        AtmInterface b=new AtmInterface();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the transferaccount number");
        int transferaccount=sc.nextInt();
        System.out.println("enter amount");
        double amount=sc.nextDouble();
        if (balance>=amount)
        {
            if (amount<=50000)
            {
                b.validating();

                transactions++;
                balance-=amount;
                System.out.println("Sucessfully transferred to account");
                System.out.println("Remaining balance is "+ balance);
                String s=amount + "Rs transferred to" +transferaccount;
                transactionsHistory=transactionsHistory.concat(s);
            }
            else
            {
                //try{throw new LimitoverException();}
                //catch(LimitoverException e) 
                System.out.println("Limit was exceeded");
            }
        }
        else
        {
            //throw new InsufficientFundException();
            System.out.println("Insufficient funds");
        }
    }
    public void CheckBalance()
    {
        System.out.println("Remaining Balance is "+balance);
    }
    public void TranHistory()
    {
        if (transactions==0){
            System.out.println("\n");}
        else
        {
            System.out.println(transactionsHistory);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("\n**********WELCOME TO  ATM **********\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice - ");
		int select = sc.nextInt();
		if ( select == 1 ) 
        {
			AtmInterface b=new AtmInterface();;
			b.Register();
        }
        while(true)
        {
            boolean isFinished = false;
            while(!isFinished)
            {
                System.out.print("Enter Your Choice 1-6 ");
                System.out.println("\n1.withDraw \n2.Deposit \n3.Transfer \n4.CheckBalance \n5.TranHisory \n6.Exit");
                int choice=sc.nextInt();
                AtmInterface b=new AtmInterface();
                switch(choice) 
                {
                    case 1:
                    b.withDraw();
                    break;
                    case 2:
                    b.Deposit();
                    break;
                    case 3:
                    b.Transfer();
                    break;
                    case 4:
                    b. CheckBalance();
                    break;
                    case 5:
                    b.TranHistory();
                    break;
                    case 6:
                    System.exit(0);
                    break;
                }

            }
        }

    }
}