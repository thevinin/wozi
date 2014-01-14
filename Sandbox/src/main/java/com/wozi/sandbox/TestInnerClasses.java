package com.wozi.sandbox;

import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class TestInnerClasses {
	public int x = 0;
	private int y = -100;

	class FirstLevel implements Button.ClickListener,
			FieldEvents.FocusListener, FieldEvents.BlurListener {

		public int x = 1;

		void methodInFirstLevel(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("TestInnerClasses.this.x = "
					+ TestInnerClasses.this.x);
		}

		void incrementY(int z) {
			y = y * z;
		}

		@Override
		public void buttonClick(ClickEvent event) {
			// This inner class implements various UI events
			System.out.println("Button Clicked");

		}

		@Override
		public void blur(BlurEvent event) {
			System.out.println("focus lost");
		}

		@Override
		public void focus(FocusEvent event) {
			System.out.println("Focus received");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestInnerClasses st = new TestInnerClasses();
		TestInnerClasses.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);

		System.out.println("Get Y = " + st.y);
		fl.incrementY(10);
		System.out.println("Get Y = " + st.y);
	}

}
