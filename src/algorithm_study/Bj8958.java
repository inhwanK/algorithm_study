package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Ä¿¹Ô Å×½ºÆ®
public class Bj8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.valueOf(br.readLine());
		ArrayList<Character> arr = new ArrayList<Character>();
		String test = null;
		int count =0;
		int sum = 0;
		
		for (int i = 0; i < num; i++) {
			test = br.readLine();
			for (int j = 0; j < test.length(); j++) {
				arr.add(test.charAt(j));
			}
			count = 0;
			sum = 0;
			for(int a = 0; a< arr.size();a++){
				
				if(arr.get(a).equals('O')){
					count++;
					
				}else{
					count = 0;
				}
				sum = sum + count;
			}
			System.out.println(sum);
		}
		br.close();
	}
}
