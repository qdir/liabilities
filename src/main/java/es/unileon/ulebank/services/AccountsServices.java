package es.unileon.ulebank.services;

import java.util.List;

import es.unileon.ulebank.repository.domain.Persons;

public interface AccountsServices {

	public boolean addTitular(Persons titular, String accountId);
	
	public boolean deleteTitular(String titularId);
	
	public List<Persons> getTitulars(String accountId);
}
