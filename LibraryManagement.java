
import java.util.Date; 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
class Student 
{
    String name;
    int id_no;
    String stream;
    String book1,book2;
    int book_no,issuedbook;
    Student (String name,int id_no,String stream)
    {
        this.name=name;
        this.id_no=id_no;
        this.stream=stream;
    }
}

 class Library
{
    //sortint algorithm for sorting the student by id 
    void selectionSort(Student arr[])
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int minind=i;
            for(int j=i+1;i<n-1;j++){
                if(arr[minind].id_no>arr[j].id_no){
                    minind=j;

                }
            }
            if(minind!=i){
                //swapping names 
                String temps=arr[minind].name;
                arr[minind].name=arr[i].name;
                arr[i].name=temps;
                //swapping streams
                String tempst=arr[minind].stream;
                arr[minind].stream=arr[i].stream;
                arr[i].stream=tempst;
                //swapping ids
                int temp=arr[minind].id_no;
                arr[minind].id_no=arr[i].id_no;
                arr[i].id_no=temp;
                       }
        }
    }

    static void display(Student arr[])
    {
        for(int i=0;i<arr.length;i++){
            System.out.print("Name : "+arr[i].name+"\t");
            System.out.print("ID : "+arr[i].id_no+"\t");
            System.out.print("Name : "+arr[i].stream+"\t");

        }
    }
     class Node 
     {
        String key;
        Node left,right;
        Node(String item){
            key=item;
            left=null;
            right=null;
        }
     }
     Node root=null;
     Scanner input;
     
     void insert(String key)
     {
        root=insertRec(root,key);
     }
     Node insertRec(Node root,String key){
        if(root==null){
            root=new Node(key);
            return root;
        
        }
        if(key.compareTo(root.key)<0){
            root.left=insertRec(root.left,key);
        }
        else if(key.compareTo(root.key)>0){
          root.right=insertRec(root.right,key);
        }
        else{
            System.out.println("Book is alredy available in Library ");
        }
        return root;

     }
     void update(String key,String key1){
        delete(key);
        insert(key1);
     }
     void delete(String key){
        root=deleteRec( root,key);
     }
     Node deleteRec(Node root,String key){
        if(root==null){
            return root;
        }
        if(key.compareTo(root.key)<0){
            root.left=deleteRec(root.left,key);

        }
        else if(key.compareTo(root.key)>0){
            root.right=deleteRec(root.right,key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;

            }
            root.key=minValue(root.right);
            root.right=deleteRec(root.right,root.key);

        }
        return root;

     }
     String minValue(Node root){
        String minv=root.key;
        while(root.left!=null){
            minv=root.left.key;
            root=root.left;

        }
        return minv;
     }
     void printInorder(Node node){
        if(node==null){
            return;

        }
        printInorder(node.left);
        System.out.print(node.key+"      ");
        printInorder(node.right);
     }
     void printinOrder(){
        printInorder(root);
     }
     void inorder()
	{ 
		inorderRec(root); 
	} 
   
	void inorderRec(Node root) 
	{ 
		if (root != null) 
		{ 
			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
		} 
	}

    boolean containsNode(String val){
        return containsNodeRec(root,val);

    }
    boolean containsNodeRec(Node cur,String key){
        if(cur==null){
            return false;
        }
        if(key.equalsIgnoreCase(cur.key)){
            return true;
        }
        return key.compareTo(cur.key)<0?containsNodeRec(cur.left,key):containsNodeRec(cur.right,key);

    }
    void printTree(){
        root=printTreeRec(root,0);

    }
    Node printTreeRec(Node node,int space){
        if(node==null){
            return root;
        }
        space+=5;
        printTreeRec(node.right,space);
        System.out.println();
        System.out.print("["+node.key+"]");
        return printTreeRec(node.left,space);
    }
}
   
    public class LibraryManagement{

    public static void main(String args[])throws Exception{
        Scanner sc=new Scanner(System.in);
        Library tree=new Library();
        HashMap<String,Integer> map=new HashMap<>();
        SimpleDateFormat formatter=new SimpleDateFormat();
        Calendar cal= Calendar.getInstance();
        Student array[]=new Student[3];
        array[0]=new Student("Rudra",1205,"B.techETC");
        array[1]=new Student("Rashmi",1201,"B.techCSE");
        array[2]=new Student("vanshika",1200,"B.techCivil");
        int [][]ar=new int [100][5];
        Scanner st=new Scanner(System.in); 
        //Create file to store data of students.
    
		FileWriter fr = new FileWriter("append.txt", true);

		BufferedWriter br = new BufferedWriter(fr);
		
		FileWriter fr1 = new FileWriter("append.txt", true);
		BufferedWriter br1 = new BufferedWriter(fr1);
		
		FileWriter fr2 = new FileWriter("append.txt", true);
		BufferedWriter br2 = new BufferedWriter(fr2);
		
		FileWriter fr3 = new FileWriter("append.txt", true);
		BufferedWriter br3 = new BufferedWriter(fr3);
		
		FileReader file = new FileReader("x.txt");	
        		
		BufferedReader reader = new BufferedReader(file);	
		
		FileReader file2= new FileReader("y.txt");			
		BufferedReader reader2 = new BufferedReader(file2);	
		
		FileReader file3= new FileReader("z.txt");			
		BufferedReader reader3 = new BufferedReader(file3);	
        
        
		
		Date Rday1=null,Rday2=null,Rday3=null,Cday=null;
        boolean e1=false;
        boolean e3=false;
        int i=0;
        while(e1==false){
            System.out.println("\n------------------------------------------------------------\n");
            System.out.println("1.Librarian Login ");
            System.out.println("2.User Login");
            System.out.println("3.Exit");
            System.out.println("\n---------------------------------------------------------------------------\n");
            System.out.println("Enter your choice");
            int ch1=sc.nextInt();
            switch(ch1){
                case 1: 
                   String pwd1="abc123";
                   String id1="dsa@1";

                   System.out.println("\nEnter userId: ");
                   String id2=sc.next();

                   System.out.println("Enter the PassWord : ");
                   String pwd2=sc.next();
                   if(!id1.equals(id2)){
                    System.out.println("Invalid UserId.");

                   }
                   else if(!pwd1.equals(pwd2)){
                    System.out.println("Invalid password");

                   }
                   else{
                    System.out.println("Login Successfully.");
                    boolean e2=false;

                    while(e2==false)
                    {
                        System.out.println("\n-------------------------------------------------------\n");
                        System.out.println("1.Add book");
                        System.out.println("2.Delete book");
                        System.out.println("3.Update book");
                        System.out.println("4.Print book details ");
                        System.out.println("Print books Inorder ");
                        System.out.println("Print Tree");
                        System.out.println("Exit");

                        System.out.println("\n-----------------------------------------------------------------\n");

                        System.out.println("Enter your choice ");
                        int ch2=sc.nextInt();
                        switch(ch2){
                            //ADD BOOK
                            case 1:
                            String line;
                            
                            while((line=reader.readLine())!=null)
                            {   
                                
                            
                                tree.insert(line);
                                map.put(line,i);
                                i++;
                            }
                            int j=i;
                            int o=0;
                            String number;
                            while((number =reader2.readLine())!=null){
                                int result =Integer.parseInt(number);
                                if(j!=o){
                                    ar[o][0]=result;

                                }
                                o++;
                            }
                            int pq=0;
                            String number1;
                            while((number1=reader3.readLine())!=null)
                            {
                                int result1=Integer.parseInt(number1);
                                if(j!=pq){
                                    ar[pq][1]=result1;
                                }
                                    pq++;
                                
                            }
                            System.out.println("Enter the name of book ");
                            String name=sc.next();
                            boolean z1=tree.containsNode(name);
                            if(z1==true){
                                System.out.println("\nIt is alrready Exits:");

                            }
                            else{
                                System.out.println("\nEnter the Quantity of book :");
                                int qunt=sc.nextInt();
                                br1.write(name);
                                br2.write(qunt);
                                br3.write(qunt);
                                tree.insert(name);
                                map.put(name,i);
                                map.get(name);
                                System.out.println(i);
                                ar[i][0]+=qunt;

                                ar[i][1]+=qunt;
                                i++;
                            }
                            break;
                            //DELETE BOOK
                        case 2:
                        System.out.println("\nEnter the name of book");
                        String b1=sc.next();
                        boolean x=tree.containsNode(b1);
                        if(x==true){
                            tree.delete(b1);
                            map.remove(b1);
                        }
                        break;
                        case 3://to update 
                        System.out.println("\nEnter the name of book");
                        String b2=sc.next();
                    
                        boolean z=tree.containsNode(b2);
									if(z==true)
									{
										int a=map.get(b2);
										System.out.println("\nEnter quantity of book to add more:");
										int q = sc.nextInt();
										ar[a][0]+=q;
										
									}
									else {
										System.out.println("This Book is not available.");
									}
							break;
							
							case 4:		//Print Books Details
								
                            Set<Entry<String, Integer>> setOfEntries = map.entrySet();
									
									
									for(Entry<String, Integer> entry : setOfEntries)
									{
										int r=entry.getValue();
							            System.out.println("Name of book is: " + entry.getKey());
							            System.out.println("Total Quantity of book is: " + ar[r][0]);
										System.out.println("Available Quantity of book is: " + ar[r][1]);
										System.out.println();
							        }
									
							break;
							
							case 5:	//To Print Books in-order
								   tree.inorder();
							break;
							
							case 6://To print binary search tree
								tree.printTree();
							break;
							
							case 7:
								e2=true;
								break;
								
						}
					}
				}		
			break;
            case 2: //for user login
            
             while(e3==false){
                System.out.println("\n--------------------------------------------------------------------------------------------------\n");
                System.out.println("1.Issue book");
                System.out.println("2.Return book");
                System.out.println("3.Exit");
                System.out.println("\n----------------------------------------------------------------------------------------------------\n");
                System.out.println("\nEnter your Choice ");
                int ch3=sc.nextInt();
                switch(ch3)
                {
                    case 1: //to issue book
                    int index=-1;
                    System.out.println("Enter your id ");
                    int id= sc.nextInt();

                    for(int m=0;m<3;m++){
                        if(array[m].id_no==id){
                            index=m;
                        }
                    }
                    if(index!=-1){
                        if(array[index].book_no==2){
                            System.out.println("Sorry You cant issue books more than 2");

                        }
                        else{
                            System.out.println("Enter the name of book ");
                            String book=sc.next();
                            boolean x=tree.containsNode(book);
                            if(x==true){
                                int a=map.get(book);
                                if(ar[a][1]>0){
                                    if(array[index].book1==null){
                                        array[index].book1=book;
                                    }
                                    else{
                                        array[index].book2=book;
                                    }
                                    System.out.println("Book issued sucessfully.");
                                    ar[a][1]--;
                                    Cday=cal.getTime();
                                    System.out.println("Current Date Time : "+formatter.format(cal.getTime()));
                                    cal.add(Calendar.SECOND,5);
                                    Rday1=cal.getTime();
                                    System.out.println("Due Date Time: "+formatter.format(Rday1));
                                    array[index].book_no++;
                                    br.write("\nStudent name:	" + array[index].name);
									br.write("\nStudent ID  :	" + array[index].id_no);
									br.write("\nIssued Book :	" + book);
									br.write("\nIssued date :	" + formatter.format(Cday));
									br.write("\nReturn date :	" + formatter.format(Rday1));
                                }
                                else
                                    System.out.println("You can not issue book now \nTry after some days ");

                            }
                            
                                else
                                    System.out.println("Book is avilable now ");
 
                        }

                    }
                    else {
                        System.out.println("INVALID ID NO ");
                    }
                    break;
                    case 2: //to return the book 
                    try 
                    {
                        int ind =-1;
                        System.out.println("\nEnter your ID : ");
                        int s_id=sc.nextInt();
                        System.out.println("\nEntervthe name of book ");
                        String Rbook=sc.next();
                        for(int n=0;n<3;n++){
                            if(array[n].id_no==s_id&&(array[n].book1.equalsIgnoreCase(Rbook)==true||array[n].book2.equalsIgnoreCase(Rbook)==true)){
                                ind=n;
                            }
                        }
                        if(ind!=-1){
                            boolean y=tree.containsNode(Rbook);
                            if(y==true){
                                if(array[ind].book1.equalsIgnoreCase(Rbook)==true){
                                    array[ind].book1=null;
                                }
                            
                            else{
                                 array[ind].book2=null;
                            }
                            cal=Calendar.getInstance();
                            Rday2=cal.getTime();
                            if(Rday2.after(Rday1)){ //if you are returnig book after the due date 
                                System.out.println("Book is overdue.");
                                long diff=Rday2.getTime()-Rday1.getTime();
                                int noofdays=(int)(diff/(2000/**24*60*60*/));
                                System.out.println("Due Date Time: " + formatter.format(Rday2));
                                System.out.println("book is delayed by " + noofdays + "seconds." + diff);
                                double charge =noofdays*5;
                                System.out.println("Your charge is: " + charge + "Rs." );

                            }
                            else {
                                System.out.println("Book is returned Sucessfully ");
                            }
                            int a=map.get(Rbook);
                            ar[a][1]++;
                            array[ind].book_no--;

                        }
                    }
                    else{
                        System.out.println("INVALID ID ");
                    }
                }
                    catch(Exception e){
                      System.out.println("Something is going to be wrong ");
                    }
                    break;
                    
                    case 3: 
                    e3=true;
                    break;

                }
             }
             break;
             case 3:
             e1=true;
             break;
			

            }
        }

        br.close();
		fr.close();
		br1.close();
		fr1.close();
		br2.close();
		fr2.close();
		br3.close();
		fr3.close();
		reader.close();
		reader2.close();
		reader3.close();
            }


        }
        

