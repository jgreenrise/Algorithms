package Array.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hashtable {

	int i_capacityOfHashTable;
	Object[] values;

	public class KeyValuePair {
		Object key;
		Object value;

		public KeyValuePair(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}

	public Hashtable(int i_capacityOfHashTable) {
		this.i_capacityOfHashTable = i_capacityOfHashTable;
		values = new Object[i_capacityOfHashTable];
	}

	public synchronized void put(Object key, Object value) {

		int index = hash(key);
		System.out.println("Key " + key + " was added at index: " + index);

		ArrayList<KeyValuePair> arrList;
		if (values[index] == null)
			arrList = new ArrayList<Hashtable.KeyValuePair>();
		else
			arrList = (ArrayList<KeyValuePair>) values[index];

		arrList.add(new KeyValuePair(key, value));
		values[index] = arrList;
	}

	public Object get(Object key) {

		int index = hash(key);

		ArrayList<KeyValuePair> arrList;
		if (values[index] == null)
			return null;
		else
			return values[index];
	}

	public boolean contains(Object key) {
		return (values[hash(key)] == null);
	}

	private int hash(Object key) {
		return Math.abs(key.hashCode()) % i_capacityOfHashTable;
	}

	public static void main(String args[]) {

		Hashtable list = new Hashtable(100);
		for (int i = 0; i < 50; i++) {
			list.put("key " + i, "value " + i);
		}

		int count = 0;

		for (Object kv : list.values) {
			if (kv == null) {
				count++;
			} else {
				System.out.println(kv);
			}
		}

		for (int i = 0; i < 10; i++) {
			list.get(i);
		}

		System.out.println("Get operation for key 25. ");
		ArrayList<KeyValuePair> key25 = (ArrayList<KeyValuePair>) list.get(25);

		for (KeyValuePair kvpair : key25) {
			System.out.println(kvpair.key + ", " + kvpair.value);
		}

		System.out.println("There are " + count + " empty slots left in table");

	}

}