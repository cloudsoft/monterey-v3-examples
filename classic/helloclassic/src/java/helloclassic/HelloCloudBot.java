package helloclassic;

import com.cloudsoftcorp.monterey.network.bot.AbstractCdmUserBot;
import com.cloudsoftcorp.monterey.network.bot.BotBehaviour.BotSegmentBehaviour;

public class HelloCloudBot extends AbstractCdmUserBot<Object,Object> {

	@Override
	public void makeMediationRequest(BotSegmentBehaviour<Object> segment,
	        Object appCustomBotParameters) throws InterruptedException {
	    context.sendMediationRequest(botName, segment.getSegmentId(), "greetings from " + botName);
	}

}
