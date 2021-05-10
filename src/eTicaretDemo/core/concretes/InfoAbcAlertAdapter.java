package eTicaretDemo.core.concretes;

import eTicaretDemo.core.abstracts.IAlert;
import eTicaretDemo.externalServices.loggerServices.abcAlertService.InfoAbcAlert;

public class InfoAbcAlertAdapter implements IAlert {

	@Override
	public void showInfoAlert(String message) {
		InfoAbcAlert alert = new InfoAbcAlert();
		alert.showInfoAlert(message);
	}

}
