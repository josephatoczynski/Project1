import java.util.Scanner;
public class FirstProject {
    // # time to vibe code the project in one a couple hours
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);

        System.out.println("Spring 2026 - CS1083 - Section 003 - Project 1 - Tariff - Writen by Joseph Toczynski");
        System.out.println();
    
     

        // getting the values

        System.out.print("Input the base price of imported item: ");
        double basePrice = console.nextDouble();

        System.out.print("Input the first tariff day: ");
        int tariffDay1 = console.nextInt();

        System.out.print("Input the % starting first tariff day: ");
        double percent1 = console.nextDouble();

        System.out.print("Input the second tariff day: ");
        int tariffDay2 = console.nextInt();

        System.out.print("Input the % starting second tariff day: ");
        double percent2 = console.nextDouble();

        System.out.print("Input the third tariff day: ");
        int tariffDay3 = console.nextInt();

        System.out.print("Input the % starting third tariff day: ");
        double percent3 = console.nextDouble();



        System.out.println("First day of the month (0-Sun, 1-Mon, 2-Tue, 3-Wed, 4-Thu, 5-Fri, 6-Sat): ");
        int firstDay = console.nextInt();


        // title and header of graph 
        System.out.println();
        System.out.println("Price Change Based on Tariffs");
        System.out.println();
        System.out.println("Sunday   Monday   Tuesday   Wednesday   Thursday   Friday   Saturday");


        // printing out the values
        
       int dayCount = 1;
       double totalRealDay = 0;
       double totalWeekSum = 0;
       
       
        for (int week = 0; week < 6; week++){
            double weekSum = 0;
            int realDayCount = 0;
            

            for (int col = 0; col < 7; col++){
                 int slot = week * 7 + col;
                 if (slot < firstDay || dayCount > 30){
                    System.out.print("00-    0.00 ");
                 }
                 else{
                    System.out.printf("%02d- %7.2f ", dayCount, getPrice(dayCount, basePrice, tariffDay1, tariffDay2, tariffDay3, percent1, percent2, percent3));
                    weekSum = weekSum + getPrice(dayCount, basePrice, tariffDay1, tariffDay2, tariffDay3, percent1, percent2, percent3);
                    dayCount += 1;
                    realDayCount += 1;
                }
                
                

            }
            totalRealDay += realDayCount;
            totalWeekSum += weekSum;
            System.out.printf("w%02d- %7.2f", week + 1, weekSum / realDayCount);
            System.out.println();
            
        }
        double theFinalAvg = totalWeekSum / totalRealDay;
        System.out.printf("Average per month: %.2f", theFinalAvg);
        System.out.println();
    }


        public static double getPrice(int dayCount, double basePrice, int tariffDay1, int tariffDay2, int tariffDay3, double percentage1, double percentage2, double percentage3){
         if (dayCount < tariffDay1){
            return basePrice;
         }
         else if (dayCount < tariffDay2){
            return newPrice(basePrice, percentage1);
         }

         else if (dayCount < tariffDay3){
            return newPrice(basePrice, percentage2);
         }
         else {
            return newPrice(basePrice, percentage3);
         }

        }

        public static double newPrice(double basePrice, double percentage){
        percentage = percentage / 100;
        return basePrice * (1 + percentage);   
   }

 
}
