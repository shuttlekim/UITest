package com.example.demo.controller;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.CoinInfoVo;
import com.google.gson.Gson;

@RestController
public class VirtualController {

	
	@RequestMapping(value="/listMoney", produces="application/json;charset=UTF-8")
	public String listMoney() {
		String str = "ok";
		
		String addr = "https://www.bithumb.com/";
		ArrayList<CoinInfoVo> list = new ArrayList<CoinInfoVo>();
		try {
			Document doc1 = Jsoup.connect(addr).get();
			
			for(int i=0; i<50; i++) {
				String coin = doc1.select("#sise_list > tbody > tr:nth-child("+(i+1)+") > td:nth-child(1) > p > a > strong").text();
				String rateName = doc1.select("#sise_list > tbody > tr:nth-child("+(i+1)+") > td:nth-child(1) > p > a > span").text();
				String present1 = doc1.select("#sise_list > tbody > tr:nth-child("+(i+1)+") > td:nth-child(2) > strong").text();
				
				String present = present1.substring(0,present1.length()-2);
				
				String change1 = doc1.select("#sise_list > tbody > tr:nth-child("+(i+1)+") > td:nth-child(3) > div").text();
				String change2 = doc1.select("#sise_list > tbody > tr:nth-child("+(i+1)+") > td:nth-child(3) > strong").text();
				String change = change1 +"("+change2+")";
				String trade_p = doc1.select("#sise_list > tbody > tr:nth-child("+(i+1)+") > td:nth-child(4) > span").text();
				
				//String rateName1 = rateName.replace("/", "_");
				//String addr2 = addr+"trade/order/"+rateName1;
				//Document doc2 = Jsoup.connect(addr2).get();
				//String high = doc2.select("#contents > div:nth-child(2) > article > div:nth-child(1) > div > table:nth-child(2) > tbody > tr:nth-child(1) > th").text();
				//String high = doc2.select("#contents > div.orderArea > article > div.info_con > div > table.fl.g_tb_list.tb_trade > tbody > tr:nth-child(1) > td").text();
				
				
				//#contents > div.orderArea > article > div.info_con > div > table.fl.g_tb_list.tb_trade
				//String low = doc2.select("#contents > div:nth-child(2) > article > div:nth-child(1) > div > table:nth-child(2) > tbody > tr:nth-child(2)> td > span").text();
				//String last = doc2.select("#contents > div:nth-child(2) > article > div:nth-child(1) > div > table:nth-child(2) > tbody > tr:nth-child(3)> td > span").text();
				//String trade_q = doc2.select("#contents > div:nth-child(2) > article > div:nth-child(1) > div > table:nth-child(1) > tbody > tr:nth-child(1)> td > span").text();
				
				System.out.println(coin);
				System.out.println(rateName);
				System.out.println(present);
				System.out.println(change);
				System.out.println(trade_p);
		
				list.add(new CoinInfoVo(coin, rateName, present, change, trade_p));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("데이터 개수 : "+list.size());
		str = (new Gson()).toJson(list);
		return str;
	}
	
	@RequestMapping(value="/listContain", produces="application/json;charset=UTF-8")
	public String listContain() {
		String str = "";
		
		return str;
	}
}
