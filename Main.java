import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        PhoneBook first = new PhoneBook();
        int s2 = 0;

        if(true)
        {
            first.menu();
            do
            {
                System.out.println("\n");
                Scanner sc = new Scanner(System.in);
                s2 = sc.nextInt();
                if(s2 == 1)
                {
                    first.insert();
                    System.out.println("\n");
                    first.menu();
                }
                else if(s2 == 2)
                {
                    first.view();
                    System.out.println("\n");
                    first.menu();
                }
                else if(s2 == 3)
                {
                    first.search();
                    System.out.println("\n");
                    first.menu();
                }
                else if(s2 == 4)
                {
                    first.edit();
                    System.out.println("\n");
                    first.menu();
                }
                else if(s2 == 5)
                {
                    first.deleteParticular();
                    System.out.println("\n");
                    first.menu();
                }
                else if(s2 == 6)
                {
                    first.deleteAll();
                    System.out.println("\n");
                    first.menu();
                }
                else if(s2 == 7)
                {
                    System.out.println("BYE BYE ............\n");
                    break;
                }
            }
            while(true);
        }

    }
}
