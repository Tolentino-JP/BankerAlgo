import java.util.*;

class BankersAlgo{
    
    public static Allocation allocation = new Allocation();
    public static Max max = new Max();
    public static Need need = new Need();
    public static int[] availability = new int[4];
    public static void main(String [] args) { 
        BankersAlgo _banker = new BankersAlgo();
        Scanner pasok = new Scanner(System.in);
        int r1, r2, r3, r4;

        System.out.print("Enter how many proccess: ");
        int proc = pasok.nextInt();

        int[] process = new int[proc];

        for(int i=0;i<process.length;i++){
            int j=(i+1);
            process[i] = j;
        }

        // add allocation
        for(int i=0;i<process.length;i++){
            System.out.print("Enter Allocation R1 in P" + (i+1) + ": ");
            r1 = pasok.nextInt();
            System.out.print("Enter Allocation R2 in P" + (i+1) + ": ");
            r2 = pasok.nextInt();
            System.out.print("Enter Allocation R3 in P" + (i+1) + ": ");
            r3 = pasok.nextInt();
            System.out.print("Enter Allocation R4 in P" + (i+1) + ": ");
            r4 = pasok.nextInt();

            allocation.R1.add(r1);
            allocation.R2.add(r2);
            allocation.R3.add(r3);
            allocation.R4.add(r4);
        }
        // add Max
        for(int i=0;i<process.length;i++){
            System.out.print("Enter Max R1 in P" + (i+1) + ": ");
            r1 = pasok.nextInt();
            System.out.print("Enter Max R2 in P" + (i+1) + ": ");
            r2 = pasok.nextInt();
            System.out.print("Enter Max R3 in P" + (i+1) + ": ");
            r3 = pasok.nextInt();
            System.out.print("Enter Max R4 in P" + (i+1) + ": ");
            r4 = pasok.nextInt();

            max.R1.add(r1);
            max.R2.add(r2);
            max.R3.add(r3);
            max.R4.add(r4);
        }

        for(int i=0;i<4;i++){
            System.out.println("Set availability in P"+(i+1)+": ");
            int _availability =  pasok.nextInt();
            availability[i] = _availability;
        }
        
        _banker.NeedFunc(process);

        // for debugging if working
        // System.out.println("P     R1     R2     R3     R4");
        // for(int i=0;i<process.length;i++){
            
        //     System.out.println(process[i]+ "     " + allocation.R1.get(i)+"     " + allocation.R2.get(i)+ "     " + allocation.R3.get(i)+ "     " + allocation.R4.get(i));

        // }



    }

    public void NeedFunc(int[] _process){
        for(int i=0;i<_process.length;i++){

            need.R1.add(max.R1.get(i) - allocation.R1.get(i));
            need.R2.add(max.R2.get(i) - allocation.R2.get(i));
            need.R3.add(max.R3.get(i) - allocation.R3.get(i));
            need.R4.add(max.R4.get(i) - allocation.R4.get(i));

        }
    }



}

class Allocation{

    ArrayList<Integer> R1 = new ArrayList<>();
    ArrayList<Integer> R2 = new ArrayList<>();
    ArrayList<Integer> R3 = new ArrayList<>();
    ArrayList<Integer> R4 = new ArrayList<>();

}

class Max{

    ArrayList<Integer> R1 = new ArrayList<>();
    ArrayList<Integer> R2 = new ArrayList<>();
    ArrayList<Integer> R3 = new ArrayList<>();
    ArrayList<Integer> R4 = new ArrayList<>();

}

class Need{

    ArrayList<Integer> R1 = new ArrayList<>();
    ArrayList<Integer> R2 = new ArrayList<>();
    ArrayList<Integer> R3 = new ArrayList<>();
    ArrayList<Integer> R4 = new ArrayList<>();

}