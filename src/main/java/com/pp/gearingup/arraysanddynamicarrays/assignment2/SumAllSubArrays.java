//$Id$
package com.pp.gearingup.arraysanddynamicarrays.assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumAllSubArrays {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine().split(" ")[0]);
		int[] arr = new int[n];
		String[] line1 = reader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line1[i]);
		}
		System.out.println(getsum(arr, n));
	}

	private static int getsum(int[] arr, int n) {
		int sum = 0;
		int m = 1000000007;
		for(int i=0;i<n;i++) {
			sum =(sum%m + (((i+1)%m)*((n-i)%m)*(arr[i])%m)%m)%m;
		}
		return sum;
	}
}
