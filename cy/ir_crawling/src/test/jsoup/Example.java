package test.jsoup;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Example {
	
	public static void main(String[] args) {
		new Example().ex7();
	}
	
	// print out HTML
	private void ex1() {
		final String url = "http://example.com/";
		try {

			final Document doc = Jsoup.connect(url).get();
			System.out.println(doc.outerHtml());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// difference between html() and outerhtml(): is current tag included?
	private void ex2() {
		final String url = "http://example.com/";
		
		try {
			final Document doc = Jsoup.connect(url).get();
			Element body = doc.body();
			System.out.println("======== body.html() ========");
			System.out.println(body.html());
			System.out.println("======== body.outerhtml() ========");
			System.out.println(body.outerHtml());	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// print text only
	private void ex3() {
		final String url = "http://example.com/";
		
		try {
			final Document doc = Jsoup.connect(url).get();
			System.out.println("Title: "+doc.title());
			Element body = doc.body();
			
			// extracting all p tags
			Elements paragraphs = body.getElementsByTag("p");
			
			System.out.println("======== print html ========");
			for(Element p : paragraphs) {
				System.out.println(p.html());
			}
			
			System.out.println("======== print text only ========");
			for(Element p : paragraphs) {
				System.out.println(p.text());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void ex4() {
		final String url = "https://www.ntu.edu.sg/";
		
		try {
			final Document doc = Jsoup.connect(url).get();
			Element eNews = doc.getElementById("news_area");

			System.out.println(eNews.outerHtml());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void ex5() {
		File input = new File(".\\src\\test.html");
		try {
			Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

			
			// select for all links 
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				String text = link.text();
	            String innerurl = link.attr("href");
				System.out.println(innerurl);
				
				System.out.println("> text: "+text);
	            Elements imgs  = link.select("img[src]");
	            for (Element img : imgs) {
					System.out.println("> img: "+img.attr("src"));
				}
	            System.out.println();
			};
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void ex6() {
		File input = new File(".\\src\\test.html");
		try {
			Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
			
			
			// select for all links 
			Elements headers = doc.select("h2");
			for (Element header : headers) {
				System.out.println(header.outerHtml());
				String text = header.text();
				System.out.println(text);
				
				// grab url
				Elements links = header.select("a[href]");
				for (Element link : links) {
					System.out.println("> link: "+link.attr("href"));
				}

	            System.out.println();
			};
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void ex7() {
		File input = new File(".\\src\\test.html");
		try {
			Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
			
			
			// select for all links 
			Elements links = doc.select("a[href]");
			for (Element link : links) {
	            String innerurl = link.attr("href");
	            Document innerdoc = Jsoup.connect(innerurl).get();
	            System.out.println(innerurl);
	            System.out.println("> title: "+innerdoc.title());
	            // search for h1
	            Elements innerheaders = innerdoc.select("h1");
	            for (Element innerheader : innerheaders) {
					System.out.println(">> h1: "+innerheader.text());
				}
			};
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	// for more usage of selector, go https://jsoup.org/cookbook/extracting-data/selector-syntax
}
