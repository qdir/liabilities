package es.unileon.ulebank.account.liquidation;

import java.util.Date;

import es.unileon.ulebank.account.Account;

public class MockFeatureExtractor<T> implements AbstractFeatureExtractor<T> {

	private T feature;
	private T randomFeature;
	private String featureName;
	private Account accountUpdated;
	private Date min;
	private Date max;

	public MockFeatureExtractor(T feature, T randomFeature, String featureName) {
		this.feature = feature;
		this.randomFeature = randomFeature;
		this.featureName = featureName;
	}

	@Override
	public String getFeatureName() {
		return this.featureName;
	}

	@Override
	public void updateFeature(Account account, Date min, Date max) {
		this.accountUpdated = account;
		this.max = max;
		this.min = min;
	}

	@Override
	public T getFeature() {
		return this.feature;
	}

	@Override
	public T generateRandomFeature() {
		return this.randomFeature;
	}

	public Account getAccountUpdated() {
		return accountUpdated;
	}

	public Date getMin() {
		return min;
	}

	public Date getMax() {
		return max;
	}

}
