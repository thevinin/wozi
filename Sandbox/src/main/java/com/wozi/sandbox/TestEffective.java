package main.java.com.wozi.sandbox;

public class TestEffective {
	private static String accessToken = null;
	private static long lastUpdate;
	private static TestEffective token = null;

	private TestEffective() {
		accessToken = "ASDFDS";
		lastUpdate = System.currentTimeMillis();
	}

	public static Boolean valueOf(boolean value) {
		return value ? Boolean.TRUE : Boolean.FALSE;
	}

	public static TestEffective createToken() {
		if (token == null)
			token = new TestEffective();
		return token;
	}

	public static void updateToken(boolean denied) {
		if (denied) {
			// create new token and update time
			accessToken = "aD@fdsf";
		}
		lastUpdate = System.currentTimeMillis();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Boolean bigFlag = TestEffective.valueOf(true);
		Boolean littleFlag = TestEffective.valueOf(false);

		Boolean anotherTrueFlag = TestEffective.valueOf(true);

		if (bigFlag)
			System.out.println("The Big Flag is TRUE");
		System.out.println("BigFlag: " + bigFlag.getClass().toString());
		if (littleFlag)
			System.out.println("The Little Flag is:"
					+ Boolean.toString(littleFlag));
		System.out.println("LittleFlag: " + littleFlag.getClass().toString());

		if (bigFlag == littleFlag)
			System.out.println("They are the same");
		else
			System.out.println("They are not the same");

		if (bigFlag == anotherTrueFlag)
			System.out.println("True flags are the same");
		else
			System.out.println("True flags are not the same");

		TestEffective accessOBIEE = createToken();
		System.out.println("The access token is : " + accessOBIEE.accessToken);
		System.out.println("Last time OBIEE was access is: "
				+ accessOBIEE.lastUpdate);

		TestEffective accessODI = createToken();
		System.out.println("The access token is : " + accessODI.accessToken);
		System.out.println("Last time OBIEE was access is: "
				+ accessODI.lastUpdate);

		if (accessOBIEE == accessODI)
			System.out.println("Access tokens are the same");
		else
			System.out.println("Access tokens are not the same");

		// simulate access to web services, first result is valid - accessToken
		// good
		// second result is invalid - accessToken invalid (timed-out)
		accessOBIEE.updateToken(littleFlag);
		System.out.println("The access token is : " + accessOBIEE.accessToken);
		System.out.println("Last time OBIEE was access is: "
				+ accessOBIEE.lastUpdate);

		accessOBIEE.updateToken(bigFlag);
		System.out.println("The access token is : " + accessOBIEE.accessToken);
		System.out.println("Last time OBIEE was access is: "
				+ accessOBIEE.lastUpdate);

	}

}
