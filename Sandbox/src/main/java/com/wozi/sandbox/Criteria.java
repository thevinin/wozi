package main.java.com.wozi.sandbox;

public class Criteria {
	Object searchObj = null;
	String field = null;

	public Criteria(Object obj) {
		searchObj = obj;
	}

	public void setField() {
		;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Criteria app = new Criteria(new String("Hello"));

	}

}
