//$Id$
package com.pp.gearingup.arraysanddynamicarrays.homework1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BuySellStocks1 {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i]=sc.nextInt();
        }
		System.out.println(getMaxProfit(prices, n));
	}

	private static int getMaxProfit(int[] arr, int n) {
		int[] postMax = new int[n];
		postMax[n-1] = arr[n-1];
		for(int i = n-2;i>=0;i--) {
			if(arr[i]>postMax[i+1]) {
				postMax[i] = arr[i];
			}else {
				postMax[i] = postMax[i+1];
			}
		}
		int profit = 0;
		for(int i=0;i<n;i++) {
			if(postMax[i]-arr[i]>profit) {
				profit = postMax[i]-arr[i];
			}
		}
		return profit;
	}
	
	 

}
