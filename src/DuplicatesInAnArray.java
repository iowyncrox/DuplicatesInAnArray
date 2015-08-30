import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

public class DuplicatesInAnArray {

	private static class ShowIndexDuplicateData<T> {
		private static final String NEW_LINE = System
				.getProperty("line.separator");
		private Set<T> indices;
		private int count;

		public ShowIndexDuplicateData(Set<T> indices, int count) {
			this.indices = indices;
			this.count = count;
		}

		public Set<T> getIndices() {
			return indices;
		}

		public int getCount() {
			return count;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Count: ").append(getCount()).append(" Indices: ")
					.append(getIndices()).append(NEW_LINE);

			return sb.toString();
		}
	}

	public static void duplicatesInAnArray(Integer[] array) {
		if (array == null || array.length <= 1) {
			System.out.println("");
		}

		Map<Integer, ShowIndexDuplicateData<Integer>> map = new HashMap<>();

		for (int i = 0; i < array.length - 1; i++) {

			if (map.containsKey(array[i])) {
				ShowIndexDuplicateData<Integer> showIndexDuplicateData = map
						.get(array[i]);
				showIndexDuplicateData.count++;
				showIndexDuplicateData.indices.add(i);
			} else {
				int count = 1;
				Set<Integer> indices = new HashSet<>();
				indices.add(i);
				ShowIndexDuplicateData<Integer> showIndexDuplicateData = new ShowIndexDuplicateData<>(
						indices, count);
				map.put(array[i], showIndexDuplicateData);
			}
		}
		System.out.println(map);
	}

	public static void main(String[] args) {
		Integer[] array = { 5, 6, 1, 2, 3, 3, 6, 1 };
		DuplicatesInAnArray.duplicatesInAnArray(array);
	}
}
