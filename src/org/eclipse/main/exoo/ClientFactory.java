package org.eclipse.main.exoo;

public class ClientFactory {

	public Client getClient(String clientType) {
		if (clientType == null) {
			return null;
		}
		if (clientType.equalsIgnoreCase("ClCr")) {
			return new ClientCredit();

		} else if (clientType.equalsIgnoreCase("ClDe")) {
			return new ClientDebit();
		}
		return null;
	}
}
