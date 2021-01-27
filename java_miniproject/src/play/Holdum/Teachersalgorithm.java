package play.Holdum;

import java.util.ArrayList;
import java.util.Collections;

public class Teachersalgorithm {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		int i, j;
		for (i = 1; i < 11; i++) {
			for (j = 0; j < i; j++) {
				list.add(i);
			}
		}
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);

		for (j = 0; j < list.size(); j++) {
			int val = list.get(j);
			if (val == 0) {
				continue;
			}
			int cnt = 0;
			for (i = 0; i < list.size(); i++) {
				if (i == j) {
					continue;
				}
				if (val == list.get(i)) {
					list.set(i, 0);
					cnt++;
				}
			}

			if (cnt > 0) {
				list.set(j, 0);
			}
		}
		for (i = list.size()-1; i>=0 ; i--) {
			if (list.get(i) == 0) {
				list.remove(i);
			}
		}
		
		System.out.println(list);
	}

}
