package es.unileon.ulebank.account.liquidation.doubleFeatureExtractors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.liquidation.AbstractFeatureExtractor;
import es.unileon.ulebank.history.DirectDebitTransaction;

public class DoubleFeatureExtractorPayrrolsNumber implements
		AbstractFeatureExtractor<Double> {

	private double value;

	@Override
	public String getFeatureName() {
		return "Numero de nominas";
	}

	@Override
	public void updateFeature(Account account, Date min, Date max) {
		int count = 0;
		List<DirectDebitTransaction> list = new ArrayList<DirectDebitTransaction>();
		for (DirectDebitTransaction actual : list) {
			if (actual.getAmount() > 0) {
				++count;
			}
		}
		this.value = count;
	}

	@Override
	public Double getFeature() {
		return value;
	}

	@Override
	public Double generateRandomFeature() {
		return new Random().nextDouble() * 4;
	}

}
