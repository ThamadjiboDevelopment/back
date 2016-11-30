package com.concreteitsolutions.smscampaign;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SMSCampaignDatabase {
	public static List<SMSCampaign> smsCampaignList;

	static {
		smsCampaignList = new ArrayList<SMSCampaign>();
		String messageInfo83 = "TEST- CAMPAGNE SMS \n Jouez à notre jeu et gagnez beaucoup de cadeaux jusqu'au 25 Décembre 2015.\n"
				+ "Rendez-vous sur ce lien pour jouer : http://google.fr";

		smsCampaignList.add(new SMSCampaign(1, "Info83-Cadeaux", "Info 83", messageInfo83, 1 ));
	}
	public static List<SMSCampaign> getSMSCampaigns() {
		return smsCampaignList;
	}
}
