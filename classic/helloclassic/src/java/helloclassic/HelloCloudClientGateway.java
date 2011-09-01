package helloclassic;

import java.io.Serializable;
import java.util.logging.Logger;

import com.cloudsoftcorp.monterey.network.api.ClientGatewayContext;
import com.cloudsoftcorp.monterey.network.api.LppClientGateway;
import com.cloudsoftcorp.monterey.network.api.LppClientGateway.ManagementExtension;
import com.cloudsoftcorp.monterey.network.api.LppClientGatewayFactory;
import com.cloudsoftcorp.monterey.network.api.LppStateBackup;
import com.cloudsoftcorp.monterey.network.bot.BotBehaviour;
import com.cloudsoftcorp.util.StringUtils;

/**
 * Generated by Cloudsoft Monterey.
 */
public class HelloCloudClientGateway implements LppClientGateway, ManagementExtension {

	public static class Factory implements LppClientGatewayFactory {
		public LppClientGateway newClientGateway() {
			return new HelloCloudClientGateway();
		}
		public LppStateBackup newClientGatewayBackup() {
			return null; // Unsupported
		}
	}
	
	private static final Logger LOG = Logger.getLogger(HelloCloudClientGateway.class.getName());
	private ClientGatewayContext context;
	private HelloCloudBot bot;
	
	public void initialize(ClientGatewayContext context, Object stateToResume) {
		this.context = context;
		bot = new HelloCloudBot();
		bot.initializeBot(StringUtils.makeRandomId(4), this, getContext());
	}

	public String[] getSegmentsList() {
		return new String[] { "a", "b", "c" };
	}

	public void onPrivateMessage(String userRef, String segment, Object data) {
	    System.out.println("Private message from " + segment + ", saying " + data);
	}
	 
	public void onPublicMessage(String segment, Object data) {
	    System.out.println("Broadcast from " + segment + ", saying " + data);
	}

	public Serializable shutdown() {
		// placeholder for provide any state needed to persist this gateway for a restart
		// (only where platform supports persistence of LPP nodes)
		return null;
	}

	/** returns the context object, for use e.g. by the embedded web-server, to submit messages to the Monterey network */
	public ClientGatewayContext getContext() {
		return context;
	}

	@Override
	public void onManagementMessage(Object data) {
	    if (data instanceof BotBehaviour<?,?>) {
	        bot.setBotParameters((BotBehaviour<?,?>) data);
	    }
	}
}
