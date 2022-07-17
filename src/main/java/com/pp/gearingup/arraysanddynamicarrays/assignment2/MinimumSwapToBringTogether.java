//$Id$
package com.pp.gearingup.arraysanddynamicarrays.assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinimumSwapToBringTogether {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line1 = reader.readLine().split(" ");
		int n = Integer.parseInt(line1[0]);
		int k = Integer.parseInt(line1[1]);
		String[] line2 = reader.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line2[i]);
		}
		System.out.println(getMinSwaps(arr, n, k));
	}

	private static int getMinSwaps(int[] arr, int n, int k) {
		// TODO Auto-generated method stub
		int windowSize = getSize(arr, n, k);
		int minItems = 0;
		int i;
		for(i =0;i<windowSize;i++) {
			if(arr[i]<=k) {
				minItems++;
			}
		}
		int minItemFrequency = minItems;
		for(;i<n;i++) {
			if(arr[i]<=k) {
				if(arr[i-windowSize]>k) {
					minItems++;
				}
			}else {
				if(arr[i-windowSize]<=k) {
					minItems--;
				}
			}
			if(minItems>minItemFrequency) {
				minItemFrequency = minItems;
			}
		}
		return windowSize-minItemFrequency;
	}

	private static int getSize(int[] arr, int n, int k) {
		int count =0;
		for(int i=0;i<n;i++) {
			if(arr[i]<=k) {
				count++;
			}
		}
		return count;
	}
	

}
