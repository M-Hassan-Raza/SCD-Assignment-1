import java.io.*;
import java.util.Scanner;

public class PhoneBook extends Phone
{
    private PrintStream out;

    public PhoneBook()
    {
    }

    ;

    public void menu()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        System.out.println(ANSI_BLUE_BACKGROUND + ".");
        System.out.println("\t\t\t\t\t------------------------------");
        System.out.println("\t\t\t\t\t\tWELCOME IN MAIN MENU");
        System.out.println("\t\t\t\t\t------------------------------\n");
        System.out.println("1\t INSERT");
        System.out.println("2\t VIEW");
        System.out.println("3\t SEARCH");
        System.out.println("4\t EDIT");
        System.out.println("5\t DELETE particular ");
        System.out.println("6\t DELETE ALL");
        System.out.println("7\t EXIT ");
        System.out.println("\t\t\t please enter your choice");

    }

    ;

    public void setName()
    {
        String localName = "\0";
        System.out.println("ENTER YOUR NAME");
        Scanner sc = new Scanner(System.in);
        localName = sc.next();
        if (localName.length() < 2)
        {
            System.out.println("YOU ENTER INVALID NAME.....");
            System.out.println("ENTER NAME AGAIN");
            setName();
        } else
        {
            this.name = localName;
        }

    }

    ;

    public void setMobileNo()
    {
        String localMobileNo = "\0";
        System.out.println("ENTER YOUR MOBILE NO");
        Scanner sc = new Scanner(System.in);
        localMobileNo = sc.next();
        if (localMobileNo.length() < 9)
        {
            System.out.println("YOU ENTER INVALID NUMBER.....");
            System.out.println("ENTER NUMBER AGAIN");
            setMobileNo();
        } else
        {
            this.mobileno = localMobileNo;
        }
    }

    ;

    public void setEmail()
    {
        String localEmail = "\0";
        System.out.println("ENTER YOUR EMAIL ADDRESS NO");
        Scanner sc = new Scanner(System.in);
        localEmail = sc.next();
        int sizeOfMail = localEmail.length();
        if (localEmail.contains("@"))
        {
            this.email = localEmail;
        }
        else
        {
            System.out.println("YOU ENTER INVALID EMAIL.....");
            System.out.println("ENTER EMAIL AGAIN");
            setEmail();
        }
    }

    ;

    public void setNationality()
    {
        String localNationality = "\0";
        System.out.println("ENTER YOUR nationality");
        Scanner sc = new Scanner(System.in);
        localNationality = sc.next();
        if (localNationality.length() <= 3)
        {
            System.out.println("YOU ENTER INVALID NATIONALITY.....");
            System.out.println("ENTER NATIONALITY AGAIN");
            setName();
        } else
        {
            this.nationality = localNationality;
        }
    }

    ;

    public void setCity()
    {
        String localCity = "\0";
        System.out.println("ENTER YOUR city");
        Scanner sc = new Scanner(System.in);
        localCity = sc.next();
        if (localCity.length() < 3)
        {
            System.out.println("YOU ENTER INVALID CITY.....");
            System.out.println("ENTER CITY AGAIN");
            setName();
        } else
        {
            this.city = localCity;
        }
    }

    ;

    public void insert()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        System.out.println(ANSI_BLUE_BACKGROUND + ".");
        setMobileNo();
        setName();
        setEmail();
        setNationality();
        setCity();
        File file = new File("phone.txt");
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            String outputString = this.mobileno + " " + this.name + " " + this.email + " " + this.nationality + " " + this.city + "\n";
            writer.write(outputString);
            writer.close();
        } catch (IOException e)
        {
            System.out.println("Error in File opening");
            e.printStackTrace();
        }

        System.out.println("PRESS ENTER TO CONTINUE\n");

    }

    ;

    public void view()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        System.out.println(ANSI_BLUE_BACKGROUND + ".");
        String readByString = "\0";
        String _name = "\0";
        String no = "\0";
        String _email = "\0";
        String _nationality = "\0";
        String _city = "\0";
        String completeLine = "\0";
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("phone.txt"));
            while((completeLine = reader.readLine()) != null)
            {
                String[] array = completeLine.trim().split(" ");
                no = array[0];
                _name = array[1];
                _email = array[2];
                _nationality = array[3];
                _city = array[4];
                System.out.print("NUMBER = " + no + "\t\t\tNAME = " + _name + "\t\t\tEMAIL = " + _email + "\t\t\tNATIONALITY = " + _nationality + "\t\t\tCITY = " + _city + "\n");
            }
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("PRESS ENTER TO CONTINUE");

    }

    ;

    public void search()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        String searchByNo = "\0";
        String _name = "\0";
        String no = "\0";
        String _email = "\0";
        String _nationality = "\0";
        String _city = "\0";
        String completeLine = "\0";

        System.out.println("ENTER THE NUMBER FOR WHICH YOU WANT TO SEARCH");
        searchByNo = sc.next();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("phone.txt"));
            while((completeLine = reader.readLine()) != null)
            {
                String[] array = completeLine.trim().split(" ");
                no = array[0];
                _name = array[1];
                _email = array[2];
                _nationality = array[3];
                _city = array[4];
                if(searchByNo.equals(no))
                {
                    flag = true;
                    System.out.print("The Search No is: \nNUMBER:\t" + no + "\nNAME:\t" + _name + "\nEMAIL:\t" + _email + "\nNATIONALITY:\t" + _nationality + "\nCITY:\t" + _city + "\n");
                    reader.close();
                    break;
                }
            }
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        if(!flag)
        {
            System.out.println("DATA NOT FOUND----");
        }

        System.out.println("PRESS ENTER TO CONTINUE");

    }

    ;

    public void edit()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        String searchByNo = "\0";
        String _name = "\0";
        String no = "\0";
        String _email = "\0";
        String _nationality = "\0";
        String _city = "\0";
        String _number = "\0";
        String completeLine = "\0";

        System.out.println("ENTER THE NUMBER OF WHOM YOU WANT TO EDIT");
        searchByNo = sc.next();

        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt", true));
            BufferedReader reader = new BufferedReader(new FileReader("phone.txt"));

            while((completeLine = reader.readLine()) != null)
            {
                String[] array = completeLine.trim().split(" ");
                String file_no = array[0];
                String file_name = array[1];
                String file_email = array[2];
                String file_nationality = array[3];
                String file_city = array[4];
                if(searchByNo.equals(file_no))
                {
                    flag = true;
                    System.out.println("ENTER YOUR NUMBER");
                    _number =sc.next();
                    System.out.println("Enter Your Name");
                    _name = sc.next();
                    System.out.println("Enter Your EMail Address");
                    _email = sc.next();
                    System.out.println("Enter Your Nationality");
                    _nationality = sc.next();
                    System.out.println("Enter Your City");
                    _city = sc.next();

                    writer.write(_number + " ");
                    writer.write(_name + " ");
                    writer.write(_email + " ");
                    writer.write(_nationality + " ");
                    writer.write(_city + "\n");

                    System.out.println("Record Edited Successfully!");

                }
                else
                {
                    writer.write(file_no + " ");
                    writer.write(file_name + " ");
                    writer.write(file_email + " ");
                    writer.write(file_nationality + " ");
                    writer.write(file_city + "\n");
                }
            }

            if(!flag)
            {
                System.out.println("THE DATA YOU WANT TO EDIT DOES NOT EXIST");
            }

            reader.close();
            writer.close();
            File file = new File("phone.txt");
            File tempFile = new File("temp.txt");
            boolean delete = file.delete();
            tempFile.renameTo(new File("phone.txt"));
            System.out.println("PRESS ENTER TO CONTINUE");

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    ;

    public void deleteParticular()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        System.out.println(ANSI_BLUE_BACKGROUND + ".");
        boolean flag = false;
        String search_by_number = "\0";
        String _name = "\0";
        String _no = "\0";
        String _email = "\0";
        String _nationality = "\0";
        String _city = "\0";
        String completeLine = "\0";
        System.out.println("ENTER THE NUMBER WHOM YOU WANT TO DELETE\n");
        Scanner sc = new Scanner(System.in);
        search_by_number = sc.next();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("phone.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt", true));
            while((completeLine = reader.readLine()) != null)
            {
                String[] array = completeLine.trim().split(" ");
                _no = array[0];
                _name = array[1];
                _email = array[2];
                _nationality = array[3];
                _city = array[4];
                if(!search_by_number.equals(_no))
                {
                    writer.write(_no + " ");
                    writer.write(_name + " ");
                    writer.write(_email + " ");
                    writer.write(_nationality + " ");
                    writer.write(_city + "\n");
                }
                else
                {
                    flag = true;
                    System.out.println("DELETED SUCCESSFULLY");
                }

            }
            reader.close();
            writer.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        if(!flag)
        {
            System.out.println("DATA DOES NOT EXIST");
        }
        File file = new File("phone.txt");
        File tempFile = new File("temp.txt");
        boolean delete = file.delete();
        tempFile.renameTo(new File("phone.txt"));
        System.out.println("PRESS ENTER TO CONTINUE");

    }

    ;

    public void deleteAll()
    {
        File file = new File("phone.txt");
        boolean delete = file.delete();
        if(delete)
        {
            System.out.println("File Deletion Successful!!");
        }
        else
        {
            System.out.println("File Deletion Failed!!");
        }
    }

    ;
}
