package main.java.com.wozi.sandbox;

import oracle.odi.sdk.opentools.IOpenToolParameter;
import oracle.odi.sdk.opentools.OpenToolParameter;

public class SearchableArray {
	private static final Object[] mParameters = new Object[] { new Object(),
			new String("Hello there"), new Float("234.324") };

	private static final IOpenToolParameter[] parameters = new IOpenToolParameter[] {
			new OpenToolParameter("-TEXT", "Message text",
					"Text to show in the messagebox (Mandatory).", true),
			new OpenToolParameter("-TITLE", "Messagebox title",
					"Title of the messagebox.", false),
			new OpenToolParameter("-BOOLEAN", "Boolean Value",
					"Title of the messagebox.", false) };

	// public Object getParameterValue(Criteria criteria){
	//
	// }

	public Object getParameterValue(String parameter) {
		Object result = null;
		for (int i = 0; i < parameters.length; i++) {
			if (parameters[i].getCode().equals(parameter)) {
				result = parameters[i];
				break;
			}
		}
		return result;
	}

	public void buildParameters() {
		parameters[0].setValue(new String("14"));
		parameters[1].setValue(new String("http://hr1dsvfps002.gcs.frb.org"));
		parameters[2].setValue(new String("TRUE"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchableArray app = new SearchableArray();
		IOpenToolParameter parameter = null;

		app.buildParameters();

		parameter = (IOpenToolParameter) app.getParameterValue("-TITLE");
		if (parameter != null)
			System.out.println("The parameter " + parameter.getName() + " = "
					+ parameter.getValue());

		parameter = (IOpenToolParameter) app.getParameterValue("-TEXT");
		if (parameter != null)
			System.out.println("The parameter " + parameter.getName() + " = "
					+ parameter.getValue());

		parameter = (IOpenToolParameter) app.getParameterValue("-BOOLEAN");
		if (parameter != null)
			System.out.println("The parameter " + parameter.getName() + " = "
					+ parameter.getValue());
	}

}
