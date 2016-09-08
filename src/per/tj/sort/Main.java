package per.tj.sort;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int totalDays = sc.nextInt();
			int remainInfos = sc.nextInt();
			int[][] infos = new int[remainInfos][2];
			
			for(int i =0;i<remainInfos;i++) {
				infos[i][0] = sc.nextInt();
				infos[i][1] = sc.nextInt();
			}
			int[] midleMax = new int[remainInfos - 1];
			boolean impossible = false;
			for(int i =0 ;i<remainInfos -1;i++) {
				int lMax = infos[i][1];
				int rMax = infos[i + 1][1];
				int l = infos[i][0];
				int r = infos[i + 1][0];
				
				int count = Math.abs(rMax-lMax);
				if(count > (r - l)) {
					impossible = true;
					break;
				}
				int remain = r - l - count;
				midleMax[i] = count + remain/2;
			}
			int startMax = infos[0][1] + infos[0][0];
			int endMax = infos[remainInfos-1][1] + (totalDays - infos[remainInfos-1][0]);
			int max = Math.max(startMax, endMax);
			
			if(impossible) {
				System.out.println("IMPOSSIBLE");
				continue;
			}
			max = midleMax[0];
			for(int i = 0;i < midleMax.length;i++) {
				if(midleMax[i] > max)
					max = midleMax[i];
			}
			System.out.println(max);
		}
	}
}
