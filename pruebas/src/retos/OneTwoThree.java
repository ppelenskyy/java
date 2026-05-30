package retos;

import java.util.ArrayList;
import java.util.Arrays;

public class OneTwoThree {

	public static void main(String[] args) {
		ArrayList<Integer> one = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
		int i = 0;	
		while(i < 8) {
			for (int x: one) {
				System.out.print(x);
			}
			System.out.println();
			one.removeFirst();
			i++;
		}
		while(i > 0) {
			one.add(i);
			for (int x: one) {
				System.out.print(x);
			}
			System.out.println();
			i--;
		}
	}

}
