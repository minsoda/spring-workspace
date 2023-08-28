package com.kh.dice;

import com.kh.dice.impl.DiceAImpl;
import com.kh.dice.impl.DiceBImpl;
import com.kh.dice.impl.DiceCImpl;

public class DiceTestApp1 {

	public static void main(String[] args) {
		// Player은  같은 패키지 안에 있어서 import 안해도됨
		Player player1 = new Player(new DiceAImpl());
		// 3번 돌려서 합계를 냈으니
		player1.playDice(3);
		System.out.println("===============");
		// 값만 가져온당
		System.out.println("선택된 주사위 수의 통합은 : "  + player1.getTotalValue());
		System.out.println("===============");
		
		// Player은  같은 패키지 안에 있어서 import 안해도됨
		Player player2 = new Player(new DiceBImpl());
		// 3번 돌려서 합계를 냈으니
		player2.playDice(3);
		System.out.println("===============");
		// 값만 가져온당
		System.out.println("선택된 주사위 수의 통합은 : "  + player2.getTotalValue());
		System.out.println("===============");
				
		// Player은  같은 패키지 안에 있어서 import 안해도됨
		Player player3 = new Player(new DiceCImpl());
		// 3번 돌려서 합계를 냈으니
		player3.playDice(3);
		System.out.println("===============");
		// 값만 가져온당
		System.out.println("선택된 주사위 수의 통합은 : "  + player3.getTotalValue());
		System.out.println("===============");
	}
	
}
