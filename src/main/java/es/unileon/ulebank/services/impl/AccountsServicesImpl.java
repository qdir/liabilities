package es.unileon.ulebank.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.unileon.ulebank.repository.dao.AccountsDao;
import es.unileon.ulebank.repository.dao.PersonsDao;
import es.unileon.ulebank.repository.domain.Accounts;
import es.unileon.ulebank.repository.domain.Persons;
import es.unileon.ulebank.services.AccountsServices;

@Service("accountService")
public class AccountsServicesImpl implements AccountsServices {

	@Autowired
	private AccountsDao accountsDao;
	@Autowired
	private PersonsDao personsDao;
	
	@Override
	public boolean addTitular(Persons titular, String accountId) {
		
		Accounts account;
		Set<Persons> titulars;
		
		if (titular == null || titular.getPersonId() == null) {
			return false;
		}else{
			
			account = accountsDao.findById(accountId);
			
			titulars = account.getPersonses();
			
			Iterator<Persons> iterator = titulars.iterator();
			
			while(iterator.hasNext()){
				
				if(iterator.next().getPersonId().equals(titular.getPersonId())){
					return false;
				}
			}
			
			personsDao.persist(titular);
			account.getPersonses().add(titular);
			accountsDao.merge(account);
			return true;
		}
	}

	@Override
	public boolean deleteTitular(String titularId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persons> getTitulars(String accountId) {
		
		Accounts account;
		
		account = accountsDao.findById(accountId);
		
		ArrayList<Persons> titulars = new ArrayList<Persons>();
		titulars.addAll(account.getPersonses());
		
		return titulars;
	}

}
