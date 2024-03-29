package es.unileon.ulebank.account.liquidation.doublefeaturextractors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.liquidation.AbstractFeatureExtractor;
import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.conditions.WrongArgsException;

public class DoubleFeatureExtractorPayrrolAverage implements
		AbstractFeatureExtractor<Double> {

	private double value;

	@Override
	public String getFeatureName() {
		return "Importe medio nominas";
	}

	@Override
	public void updateFeature(Account account, Date min, Date max) {
		double sum = 0;
		int count = 0;
		List<DirectDebitTransaction> list = new ArrayList<DirectDebitTransaction>();
		try {
			list = account.getFilteredDirectDebits(min, max);
		} catch (WrongArgsException e) {
		}
		for (DirectDebitTransaction actual : list) {
			if (actual.getAmount() > 0) {
				sum += actual.getAmount();
				++count;
			}
		}
		this.value = sum / count;
	}

	@Override
	public Double getFeature() {
		return value;
	}

	@Override
	public Double generateRandomFeature() {
		return new Random().nextDouble() * 1000;
	}
}
