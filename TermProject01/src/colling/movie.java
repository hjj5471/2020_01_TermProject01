package crolling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.openqa.selenium.*;

public class movie {
	public static void main(String[] args) throws IOException{
		
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20200515";
		ArrayList point_list = new ArrayList();
		ArrayList page_list = new ArrayList();
				
		Document document = Jsoup.connect(url).get();
		Elements movies = document.select("div.tit5");
		
		
		//System.out.println(movies);
		for (Element movie : movies){
			// System.out.println(movie.select("a"));
			String moviepoint_url = movie.select("a").attr("href");
			moviepoint_url = "https://movie.naver.com" + moviepoint_url.replace("basic","point");
			point_list.add(moviepoint_url);
			System.out.println(movie.text());
		}
		
		for(int i = 0; i < point_list.size(); i++) {
			Document doc = Jsoup.connect((String)point_list.get(i)).get();
			
			Elements page = doc.select(".paging");
			System.out.println(page);
			
		
			
		}
//		
//		Document doc = Jsoup.connect((String)movie_list.get(0)).get();
//		System.out.println(doc.getElementsByTag("title"));
	
	}
	
	
	// PAGE URL 반환 함수 
	public static String getParameter(String MoviePoint_url, int PAGE) {
		return MoviePoint_url + "&type=after"
				+ "&isActualPointWriteExecute=false"
				+ "&isMileageSubscriptionAlready=false"
				+ "&isMileageSubscriptionReject=false"
				+ "&page=" + PAGE;
	}
}
