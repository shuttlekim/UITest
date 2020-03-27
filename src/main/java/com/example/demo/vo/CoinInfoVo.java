package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinInfoVo {

	private String coin;
	private String rateName;
	private String present;
	private String change;
	private String trade_p;
}
