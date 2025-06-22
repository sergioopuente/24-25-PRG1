
public class Aleatorio {
    public static void main (String[]args){
        
        for(int i=0;i<10;i++){
             System.out.println((int)(Math.random()*6)+1);
        }
         System.out.println("-----------------");

         
         int minimo=18;
         int maximo=90;
         for(int i=0;i<10;i++){
            System.out.println((int)(Math.random()*(maximo-minimo+1))+minimo);
         }
         
       
    }
}
