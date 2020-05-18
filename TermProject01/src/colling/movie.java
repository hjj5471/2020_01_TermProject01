package colling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class movie {
	public static void main(String[] args) throws IOException{
		
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20200515";
		ArrayList point_list = new ArrayList();
		ArrayList page_list = new ArrayList();
		Word_Extraction EXT = new Word_Extraction();
		
		Document document = Jsoup.connect(url).get();
		Elements movies = document.select("div.tit5");
		
		//System.out.println(movies); // 평점 URL 크롤링
		for (Element movie : movies){
			// System.out.println(movie.select("a"));
			String moviepoint_url = movie.select("a").attr("href");
			moviepoint_url = "https://movie.naver.com" + moviepoint_url.replace("basic","pointWriteFormList");
			point_list.add(moviepoint_url);
//			System.out.println(movie.text());
//			System.out.println(moviepoint_url);			
		}
		
		String total_review = "";
			
		for(int i = 49; i < point_list.size(); i++) {		// i = 영화 RANKING 번호		
			for(int j = 1; j <= 15; j++) { 					// j = PAGE 번호
//				System.out.println(getParameter((String)point_list.get(i), j));
				Document doc = Jsoup.connect(getParameter((String)point_list.get(i), j)).get();
				
				Elements pages = doc.select("div.score_reple p span");
				total_review = total_review + " " + pages.text();
//				System.out.println(pages.text());
			}
			EXT.matext(total_review);
			System.out.println("==========================================================================");
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
//	https://movie.naver.com/movie/bi/mi/pointWriteFormList.nhn?code=171539&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page=2
}
