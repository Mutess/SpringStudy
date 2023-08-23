package com.sist.manager;

import org.snu.ids.ha.index.Keyword;
import org.snu.ids.ha.index.KeywordExtractor;
import org.snu.ids.ha.index.KeywordList;

public class KeywordManager {
	public static void main(String[] args) {
		String keyword="부산식 떡볶이의 정석 같은 곳! 매콤달콤 끈적한 양념에 쫄깃하고 통통한 쌀떡, 달달하면서 개운한 뒷맛까지 최고다. 지옥불 마그마 같은 진한 붉은색이 어딘가 위험할 것 같지만 보기보다 맵지 않다. 콧잔등에 살짝 땀이 맺히는 정도. 기록적인 폭염에도 포장손님이 끊임없을 정도로 장사가 잘된다. 이런 회전율 덕분에 떡이 아주 쪼올깃 한듯!! 넘나 맛있었다";
		KeywordExtractor ke=new KeywordExtractor();
		KeywordList list=ke.extractKeyword(keyword, true);
		
		for(int i=0;i<list.size();i++) {
			Keyword wrd=list.get(i);
			System.out.println(wrd.getString()+":"+wrd.getCnt());
		}
	}
}
