package local_bets_withbaseamt;
import java.util.Scanner;

public class game{
    static int betsamt;
    static players[] p;
    static int a;
    static{
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of playeers");
        a=Integer.parseInt(sc.nextLine());
        System.out.println("enter the bets");
        betsamt=Integer.parseInt(sc.nextLine());
        p=new players[a];
        for (int i=0,j=1;i<a;i++,j++){
            System.out.println("enter player "+j+" name");
            String pname=sc.nextLine();
            System.out.println("enter player "+ j+" base amt");
            int amt=Integer.parseInt(sc.nextLine());
            p[i]=new players(pname,amt);
        }
    }
    static void display(){
        System.out.println("----------------------------------------------");
        int i=1;
        for (players p1:p) {
            System.out.println(i++ +" "+p1); 
            System.out.println();   
        }
        System.out.println("------------------------------------------------");
    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int conti=1;
    int matches=0;
    while(true){//conti==1){
        System.out.println();
        display();
        System.out.println("enter id of player who won");
        int id=Integer.parseInt(sc.nextLine());
        for (players p1:p) {
            if(p1 == p[id-1]){
                p1.win(betsamt,a);
            }else{
                try {
                    p1.loss(betsamt);
                } catch (lowbaseamt e) {
                    // TODO Auto-generated catch block
                    System.out.println(p1.getName()+" has low amt so collect money from him/her of rupees"+p1.getinitialamt());
                    System.out.println();
                    System.out.println("enter "+p1.getName()+" new base amt");
                    int amt=Integer.parseInt(sc.nextLine());
                    p1.setBaseamt(amt);
                }catch (zerobaseamt a){
                    System.out.println(p1.getName()+" has zero amt so collect money from him/her of rupees"+p1.getinitialamt());
                    System.out.println();
                    System.out.println("enter "+p1.getName()+" new base amt");
                    int amt=Integer.parseInt(sc.nextLine());
                    p1.setBaseamt(amt);
                }catch (negativebaseamt a){
                    System.out.println(p1.getName()+" has negative amt so collect money from him/her of rupees"+p1.getinitialamt()+(int)Math.abs(p1.getBaseamt()));
                    System.out.println();
                    System.out.println("enter "+p1.getName()+" new base amt or atleast collect "+p1.getBaseamt() +"amt");
                    int amt=Integer.parseInt(sc.nextLine());
                    p1.setBaseamt(amt);
                }
            }   
        }
        System.out.println(matches++ +" after player "+id+" wining data are");
        display();
        System.out.println();
       // System.out.println("press 1 to continue");
        //conti=Integer.parseInt(sc.nextLine());
    }
    // System.out.println("final data are");
    // for (players p1:p) {
    //     System.out.println(p1);    
    // }
    
}   
}
