package com.wozi.adsb.common;

//import org.htmlparser.*;
//import org.htmlparser.nodes.RemarkNode;
//import org.htmlparser.nodes.TagNode;
//import org.htmlparser.nodes.TextNode;
//import org.htmlparser.util.NodeIterator;
//import org.htmlparser.util.NodeList;
//import org.htmlparser.util.ParserException;

public class HTMLReader {
	private String url = null;

	// private Parser parser = new Parser();

	// This class is used (part of) of HTMLAircraftProvider. It reads and
	// parsers aircraft location data from HTML stream

	public HTMLReader() {
		// super(null);
	}

	/*
	 * public HTMLReader(String url){ this.url = url; try {
	 * this.getParser().setConnection(new URL(this.url).openConnection()); }
	 * catch (ParserException e) { // TODO Auto-generated catch block
	 * this.parser = null; e.printStackTrace(); } catch (MalformedURLException
	 * e) { this.parser = null; e.printStackTrace(); } catch (IOException e) {
	 * this.parser=null; e.printStackTrace(); } }
	 * 
	 * private Parser getParser(){ return parser; }
	 * 
	 * public void setURL(String url){ try { this.getParser().setURL(url);
	 * 
	 * } catch (ParserException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * public Node findTable(String id){ parser.visitAllNodesWith(arg0); }
	 * 
	 * public void read(){
	 * 
	 * try { for (NodeIterator i = parser.elements(); i.hasMoreNodes(); )
	 * processNodes (i.nextNode ());
	 * 
	 * } catch (ParserException e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * void processNodes (Node node) { if (node instanceof TextNode) { //
	 * downcast to TextNode TextNode text = (TextNode)node; // do whatever
	 * processing you want with the text
	 * System.out.println("Process Text Node => " + text.toHtml()); } if (node
	 * instanceof RemarkNode) { // downcast to RemarkNode RemarkNode remark =
	 * (RemarkNode)node; System.out.println ("Processing a Remark Node => " +
	 * remark.toHtml()); // do whatever processing you want with the comment }
	 * else if (node instanceof TagNode) { String attribute;
	 * 
	 * // downcast to TagNode TagNode tag = (TagNode)node; if
	 * (tag.getTagName().equalsIgnoreCase("TABLE")){
	 * System.out.println("Process table " + tag.getText()); attribute =
	 * tag.getAttribute("CLASS"); if (attribute.equalsIgnoreCase("")); }
	 * 
	 * NodeList nl = tag.getChildren(); if (null != nl) try { for (NodeIterator
	 * i = nl.elements(); i.hasMoreNodes(); ) processNodes(i.nextNode()); }
	 * catch (ParserException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } }
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Node data = null;

		String flight1 = "http://flightaware.com/live/flight/SWA1259/history/20121006/2330Z/KLGA/KSTL/tracklog";
		String flight2 = "http://flightaware.com/live/flight/FLG3534";
		// HTMLReader app = new HTMLReader(flight2);
		// data = app.findTable("prettyTable");
		// processData(data);

		// Parse HTML page looking for table with appropriate ID - this is the
		// data table (container)
		// return table and data in tr
	}

}
