import java.lang.Math;
import java.util.*;

public class EstimatingPi {
	
	public static void main(String[] args) {
		ArrayList<Double> allRuns = new ArrayList<Double>();
		
		int numberOfGames, numberOfDarts;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of games: ");
		numberOfGames = sc.nextInt();
		
		System.out.print("Enter number of darts per game: ");
		numberOfDarts = sc.nextInt();
		
		for(int i =0; i<numberOfGames; i++) {
			allRuns.add(run(numberOfDarts));
		}
		
		System.out.println("Standard Deviation: "+calculateSD(allRuns));
		System.out.println("Mean: "+calculateMean(allRuns));
		
		sc.close();		
	}
	
	//returns double of a random value between -0.5 and 0.5
	static double generateRand() {
		return Math.random()-0.5;
	}
	
	
	//param numberOfDarts: the number of darts to throw
	static double run(int numberOfDarts) {
		double d;
		int inside=0;
		double piOverFour=0;
		double pi=0;
		
		for (int i = 0 ; i < numberOfDarts ; i++) {
			d = Math.sqrt((Math.pow(generateRand(), 2))+Math.pow(generateRand(), 2));
			if(d<0.5) {
				inside++;
			}
		}
		
		piOverFour = (double) inside/(double) numberOfDarts;
		pi = 4*piOverFour;
		return pi;
	}
	
	
	//calculates the standard deviation of all values in arraylist
	//param al: array list holding the output of run()
	static double calculateSD(ArrayList<Double> al) {
		double sum = 0.0, standardDeviation = 0.0;
        int length = al.size();

        for(double num : al) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: al) {
            standardDeviation += ((num - mean)*(num - mean));
        }

        return Math.sqrt(standardDeviation/length);
	}
	
	//calculates the mean of all values in arraylist
	//param al: array list holding the output of run()
	static double calculateMean(ArrayList<Double> al) {
		double sum=0;
		double size=al.size();
		for(double numbers:al) {
			sum+=numbers;
		}
		return sum/size;
	}

}
