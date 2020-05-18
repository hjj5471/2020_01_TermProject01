package colling;

import java.util.List;
import org.snu.ids.ha.index.Keyword;
import org.snu.ids.ha.index.KeywordExtractor;
import org.snu.ids.ha.index.KeywordList;
import org.snu.ids.ha.ma.MExpression;
import org.snu.ids.ha.ma.MorphemeAnalyzer;
import org.snu.ids.ha.ma.Sentence;
import org.snu.ids.ha.util.Timer;

public class Word_Extraction {
      public static void matext(String strToExtrtKwrd)
      {
//    	  	maTest();
            // string to extract keywords
//            String strToExtrtKwrd = "�츮�� �����̿� ����Ű��ó�� �߿��� ������ ���翡 �������� �츮�� ���� �Ѱ��� ���������� ���� ���§ ��  �츮�� �ǹ��ִ� ��ȭ�� �ھƵ����� ���� ����, �渮���� ��ȭ ����� �̷� '��ǰ'�� �����ϴ� ������ �����ߴ�... �� ����, �޿��� ���ɼ��� ������.\r\n" + 
//            		"\r\n" + 
//            		"";
            // init KeywordExtractor
            KeywordExtractor ke = new KeywordExtractor();
            // extract keywords
            KeywordList kl = ke.extractKeyword(strToExtrtKwrd, true);
            // print result
            for( int i = 0; i < kl.size(); i++ ) {
                  Keyword kwrd = kl.get(i);
                  if(kwrd.getString().length() > 1 && kwrd.getCnt() >= 4)
                	  System.out.println(kwrd.getString() + "\t" + kwrd.getCnt());
            }
      }
//      public static void maTest()
//      {
//            String string = "�츮�� �����̿� ����Ű��ó�� �߿��� ������ ���翡 �������� �㱸�� ���� �Ѱ��� ���������� ���� ���§ �� �ǹ��ִ� ��ȭ�� �ھƵ����� ���� ����, �渮���� ��ȭ ����� �̷� '��ǰ'�� �����ϴ� ������ �����ߴ�... �� ����, �޿��� ���ɼ��� ������.\r\n" + 
//            		"\r\n" + 
//            		"";
//            try {
//                  MorphemeAnalyzer ma = new MorphemeAnalyzer();
//                  ma.createLogger(null);
//                  Timer timer = new Timer();
//                  timer.start();
//                  List<MExpression> ret = ma.analyze(string);
//                  timer.stop();
//                  timer.printMsg("Time");
//                  ret = ma.postProcess(ret);
//                  ret = ma.leaveJustBest(ret);
//                  List<Sentence> stl = ma.divideToSentences(ret);
//                  for( int i = 0; i < stl.size(); i++ ) {
//                        Sentence st = stl.get(i);
//                        System.out.println("=============================================  " + st.getSentence());
//                        for( int j = 0; j < st.size(); j++ ) {
//                              System.out.println(st.get(j));
//                        }
//                        
//                  }
//                  
//                  ma.closeLogger();
//            } catch (Exception e) {
//                  e.printStackTrace();
//            }
}
