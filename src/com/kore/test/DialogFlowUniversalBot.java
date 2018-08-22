package com.kore.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DialogFlowUniversalBot {
	
	public void approachOne() {
		System.out.println("Universal Bot Called\n");
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(21, 21, 10000L,TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5));
		String query = "What is timesheet";
		
		DialogFlowChildBotOne dialogFlowChildBotOne1 = new DialogFlowChildBotOne("e9b16b5e8c2b462fb4eb3d43160a43b5", query, "FirstBot");
		DialogFlowChildBotOne dialogFlowChildBotOne2 = new DialogFlowChildBotOne("435a067cd96e4de09c3b30ee325999de", query, "Chota_Pirate");
		DialogFlowChildBotOne dialogFlowChildBotOne3 = new DialogFlowChildBotOne("8df2384ce8e14946b309c07a3644e9eb", query, "timesheet_usecases");
		DialogFlowChildBotOne dialogFlowChildBotOne4 = new DialogFlowChildBotOne("f9df942120c94858a472c7a7b52c3931", query, "travel_bot");
		DialogFlowChildBotOne dialogFlowChildBotOne5 = new DialogFlowChildBotOne("d101e92843ea4f65b26c1d5531e5436c", query, "travel_oneIntent_bot");
		
		threadPoolExecutor.execute(dialogFlowChildBotOne1);
		threadPoolExecutor.execute(dialogFlowChildBotOne2);
		threadPoolExecutor.execute(dialogFlowChildBotOne3);
		threadPoolExecutor.execute(dialogFlowChildBotOne4);
		threadPoolExecutor.execute(dialogFlowChildBotOne5);
		/*DialogFlowChildBotTwo dialogFlowChildBotTwo = new DialogFlowChildBotTwo();
		threadPoolExecutor.execute(dialogFlowChildBotTwo);*/
		threadPoolExecutor.shutdown();
	}
	
	public static void main(String args[]) {
		DialogFlowUniversalBot dialogFlowUniversalBot = new DialogFlowUniversalBot();
		dialogFlowUniversalBot.approachOne();
	}
}
