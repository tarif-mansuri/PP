//$Id$
package com.pp.gearingup.arraysanddynamicarrays.homework1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RainWaterTrapping {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine().split(" ")[0]);
		String[] line1 = reader.readLine().split(" ");
		long[] numArray = new long[n];
		for (int i = 0; i < n; i++) {
			numArray[i] = Long.parseLong(line1[i]);
		}
		System.out.println(getHeight(numArray, n));
	}

	public static long getHeight(long[] arr, int n) {

		long[] preMaxList = new long[n];
		long[] postMaxList = new long[n];
		// Initialisation
		preMaxList[0] = arr[0];
		postMaxList[n - 1] = arr[n - 1];
		int i = 1;
		int j = n - 2;
		while (i < n) {
			// filling preMax Array
			if (arr[i] >= preMaxList[i - 1]) {
				preMaxList[i] = arr[i];
			} else {
				preMaxList[i] = preMaxList[i - 1];
			}
			// filling preMax Array
			if (arr[j] >= postMaxList[j + 1]) {
				postMaxList[j] = arr[j];
			} else {
				postMaxList[j] = postMaxList[j + 1];
			}
			i++;
			j--;
		}
		// for(int k =0;k<n;k++) {
		// System.out.print(preMaxList[k]+" ");
		// }
		//
		// for(int k =0;k<n;k++) {
		// System.out.print(postMaxList[k]+" ");
		// }
		//
		long ans = 0;
		for (int index = 1; index < n - 1; index++) {
			long minSupport = getMin(preMaxList[index - 1], postMaxList[index + 1]);
			if (minSupport > arr[index]) {
				ans += (minSupport-arr[index]);
			}
		}

		return ans;
	}

	public static long getMin(long a, long b) {
		return a < b ? a : b;
	}

}
