//$Id$
package com.pp.gearingup.arraysanddynamicarrays.homework1;

import java.util.Scanner;

public class AlyonaAndFlower {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i =0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		long[] sumArray = new long[n];
		sumArray[0] = arr[0];
		for(int i=1;i<n;i++) {
			sumArray[i] = sumArray[i-1] + arr[i];
		}
		long res = 0;
		for(int i=0;i<m;i++) {
			int l = sc.nextInt()-1;
			int r = sc.nextInt()-1;
			if(l!=0) {
				long k = sumArray[r]-sumArray[l-1];
				if(k>0) {
					res += k;
				}
			}else {
				if(sumArray[r]>0) {
					res +=sumArray[r];
				}		
			}
		}
		System.out.println(res);
	}

}
