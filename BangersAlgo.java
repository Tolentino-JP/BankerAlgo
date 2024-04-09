// Manaig, Dwight Jefferson C.
// Tolentino, John Paul S.

import java.util.*;


class BangersAlgo{
    

    public static void main(String [] args) { 
        Scanner pasok = new Scanner(System.in);

        System.out.print("Enter number of proccess: ");
        int proc = pasok.nextInt();

        System.out.print("Enter number of resources: ");
        int resources = pasok.nextInt();

        int[] process = new int[proc];
        int[][] allocation = new int[proc][resources];
        int[][] max = new int[proc][resources];
        int[] available = new int[resources];
        int[] sequence = new int[proc];
        int[][] need = new int[proc][resources];
        int count = 0;
        boolean condition = true;

        for(int i=0;i<process.length;i++){
            int j=(i+1);
            process[i] = j;
        }
        // input datas
        for(int i=0;i<process.length;i++){
            System.out.println("Process "+(i+1)+": ");
            System.out.println("  Allocated");
            for(int j=0;j<allocation[i].length;j++){
                System.out.print("\tR"+(j+1)+": ");
                allocation[i][j] = pasok.nextInt();;
            }
            System.out.println("\tMax");
            for(int j=0;j<max[i].length;j++){
                System.out.print("\t R"+(j+1)+": ");
                max[i][j] = pasok.nextInt();
            }

            for(int j=0;j<need[i].length;j++){
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
        System.out.println("  Available");
        for(int j=0;j<available.length;j++){
            System.out.print("R"+(j+1)+": ");
            available[j] = pasok.nextInt();
        }

        int[] available2 = new int[resources];

        for(int i=0;i<available.length;i++){
            available2[i] = available[i];
        }

       


        while(true){
            char choice = 0;
            System.out.println("Enter process sequence");

            for(int i=0;i<sequence.length;i++){
                System.out.print("  ");
                sequence[i] = pasok.nextInt();
            }

            

            for(int i=0;i<process.length;i++){
                for(int j=0;j<available.length;j++){
                    if(available[j] >= need[(sequence[i]-1)][j]){
                        count++;   
                    }else{
                        continue;
                    }
                }
                if(count != need[i].length){
                    condition = false;
                    break;
                }else{
                    for(int j=0;j<available.length;j++){
                        available[j] = available[j] + allocation[(sequence[i]-1)][j];
                    }
                }
                count = 0;
            }
            
            if(condition == true){
                System.out.println("Safe");
            }else{
                System.out.println("Not Safe");
            }
            System.out.print("Again? y/n");
            choice = pasok.next().charAt(0);
            
            if(choice == 'y'){
                for(int l=0;l<available.length;l++){
                    available[l] = available2[l];
                }
                count = 0;
                condition = true;
            }else{
                break;
            }

        }

        pasok.close();


    }



}