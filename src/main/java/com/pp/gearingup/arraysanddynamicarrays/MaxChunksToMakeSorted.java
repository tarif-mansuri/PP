//$Id$
package com.pp.gearingup.arraysanddynamicarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxChunksToMakeSorted {
	
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine().split(" ")[0]);
		String[] line1 = reader.readLine().split(" ");
		int[] numArray = new int[n];
		for (int i = 0; i < n; i++) {
			numArray[i] = Integer.parseInt(line1[i]);
		}
		System.out.println(getMaxChunks(numArray, n));
	}

	private static int getMaxChunks(int[] arr, int n) {
		int[] preMaxList = new int[n];
		preMaxList[0] = arr[0];
		int i = 1;
		while (i < n) {
			// filling preMax Array
			if (arr[i] >= preMaxList[i - 1]) {
				preMaxList[i] = arr[i];
			} else {
				preMaxList[i] = preMaxList[i - 1];
			}
			i++;
		}
		int chunks = 0;
		for(int j=0;j<n;j++) {
			if(j>=preMaxList[j]) {
				chunks++;
			}
		}
		return chunks;
	}

}
