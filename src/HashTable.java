public class HashTable {

	private class Entry {
		String key;
		String value;
		Entry next;

		public Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	private int TABLE_SIZE;
	private int size;
	private Entry[] table;

	public HashTable(int ts) {
		size = 0;
		TABLE_SIZE = ts;
		table = new Entry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	public int getSize() {
		return size;
	}

	public boolean makeEmpty() {
		for (int i = 0; i < table.length; i++) {
			table[i] = null;
		}
		return true;
	}

	public String get(String key) {
		int hashIndex = myhash(key);
		if (table[hashIndex] == null) {
			return null;
		} else {
			Entry entry = table[hashIndex];
			while (entry != null && !entry.key.equals(key))
				entry = entry.next;

			if (entry.key.equals(key))
				return entry.value;
			else
				return null;
		}
	}
	
	public void insert(String key, String value) {
		int hashIndex = myhash(key);
		if (table[hashIndex] == null) {
			Entry entry = new Entry(key, value);
			table[hashIndex] = entry;
		} else {
			Entry entry = table[hashIndex];
			while (entry.next != null && !entry.key.equals(key))
				entry = entry.next;

			if (entry.key.equals(key))
				entry.value = value;
			else
				entry.next = new Entry(key, value);
		}
		size++;
	}

	public boolean remove(String key) {
		int hashIndex = myhash(key);
		if(table[hashIndex] == null) {
			return false;
		} else {
			Entry previous = null;
			Entry current = table[hashIndex];
			while(current != null && !current.key.equals(key)) {
				previous = current;
				current = current.next;
			}
			
			if(current.key.equals(key)) {
				if(previous == null) {
					table[hashIndex] = current.next;
				} else {
					previous.next = current.next;
				}
				size--;
				return true;
			} else {
				return false;
			}
		}
	}
	
	
	private int myhash(String x) {
		int hashVal = x.hashCode();
		hashVal %= TABLE_SIZE;
		if (hashVal < 0)
			hashVal += TABLE_SIZE;
		return hashVal;
	}
}
