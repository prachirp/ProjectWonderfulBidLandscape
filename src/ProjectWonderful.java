import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ProjectWonderful {
	public static void main(String[] args) throws IOException {
		//print("Site; Avg Pg Views Past 5 Days (US); Avg Pg Views Past 5 Days (Canada); Avg Pg Views Past 5 Days (Europe); Avg Pg Views Past 5 Days (Elsewhere); Current Bid ($/day) (US); Current Bid ($/day) (Canada); Current Bid ($/day) (Europe); Current Bid ($/day) (Elsewhere); URL; Ad Box Type; Proj Wond ID #;");
		for ( int pno = 0; pno < 250; pno++){
			//int pno = 50;
			String url = "https://www.projectwonderful.com/adsearch.php?"
					+ "self=1"
					+ "&page="+ pno
					+ "&advanced=0"
					+ "&sort="
					+ "&regions%5B%5D=1"
					+ "&regions%5B%5D=0"
					+ "&regions%5B%5D=2"
					+ "&regions%5B%5D=9"
					+ "&avguniqueusers="
					+ "&minhits="
					+ "&maxhits="
					+ "&hitdays=5"
					+ "&trafficany=1"
					+ "&sumdata=0"
					+ "&showallregions=1"
					+ "&measurement=1"
					+ "&minbids="
					+ "&maxbids="
					+ "&biddays="
					+ "&mincurrentbid="
					+ "&maxcurrentbid="
					+ "&minbidmin="
					+ "&minbidmax="
					+ "&biddingany=2"
					+ "&button=2"
					+ "&square=4"
					+ "&halfbanner=6"
					+ "&banner=1"
					+ "&rectangle=7"
					+ "&leaderboard=5"
					+ "&skyscraper=3"
					+ "&namefilter="
					+ "&domainfilter="
					+ "&tags="
					+ "&badtags="
					+ "&referrerhits="
					+ "&referrer="
					+ "&referrerdays=0"
					+ "&referrerany=1"
					+ "&countrypercentage="
					+ "&countrytype=0"
					+ "&country="
					+ "&c=1"
					+ "&sfw=1"
					+ "&nsfw=1"
					+ "&adult=1"
					+ "&adrating=6"
					+ "&graphical=2"
					+ "&approval=0"
					+ "&mincols="
					+ "&maxcols="
					+ "&submit=1";
			//print("Fetching %s...", url);
			
			Document doc = Jsoup.connect(url).timeout(0).get();
			Elements trow1s = doc.select("table tr.row1");
			Elements trow2s = doc.select("table tr.row2");
			
			for(Element thread : trow1s){
				Element name = thread.select("td span.larger").first();
				System.out.print(name.text() + "; ");
				
				Elements tables = thread.select("td.rowhl1 table tr");
				for(Element row : tables){
					System.out.print(row.text() + "; ");
				}
				
				Elements links = thread.select("td p a[href]");
				System.out.print(links.first().attr("abs:href") + "; ");
				int typeloc = links.last().attr("abs:href").indexOf("&type=");
				char type = links.last().attr("abs:href").charAt(typeloc+6);
				
				if (type == '1'){System.out.print("banner; ");}
				else if (type == '2'){System.out.print("button; ");}
				else if (type == '3'){System.out.print("skyscraper; ");}
				else if (type == '4'){System.out.print("square; ");}
				else if (type == '5'){System.out.print("leaderboard; ");}
				else if (type == '6'){System.out.print("half banner; ");}
				else if (type == '7'){System.out.print("rectangle; ");}
				
				Element id = thread.select("td span.small").first();
				System.out.print(id.text() + "; ");
				System.out.println();
			}
			
			for(Element thread: trow2s){
				Element name = thread.select("td span.larger").first();
				System.out.print(name.text() + "; ");
				
				Elements tables = thread.select("td.rowhl2 table tr");
				for(Element row : tables){
					System.out.print(row.text() + "; ");
				}
				
				Elements links = thread.select("td p a[href]");
				System.out.print(links.first().attr("abs:href") + "; ");
				int typeloc = links.last().attr("abs:href").indexOf("&type=");
				char type = links.last().attr("abs:href").charAt(typeloc+6);
				
				if (type == '1'){System.out.print("banner; ");}
				else if (type == '2'){System.out.print("button; ");}
				else if (type == '3'){System.out.print("skyscraper; ");}
				else if (type == '4'){System.out.print("square; ");}
				else if (type == '5'){System.out.print("leaderboard; ");}
				else if (type == '6'){System.out.print("half banner; ");}
				else if (type == '7'){System.out.print("rectangle; ");}
				
				Element id = thread.select("td span.small").first();
				System.out.print(id.text() + "; ");
				System.out.println();
			}			
			
		}
	}

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width-1) + ".";
		else
			return s;
	}
}

