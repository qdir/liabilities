package es.unileon.ulebank.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {

	private Address address;

	private String street;

	/**
	 * Block in the street
	 */
	private int blockNumber;

	/**
	 * Floor in the block
	 */
	private int floor;

	/**
	 * Door in the floor
	 */
	private char door;

	/**
	 * Locality
	 */
	private String locality;

	/**
	 * Province
	 */
	private String province;

	/**
	 * Zip code
	 */
	private int zipCode;

	@Before
	public void setUp() {
		this.province = "Leon";
		this.zipCode = 24007;
		this.locality = "Leon";
		this.door = 'A';
		this.floor = 3;
		this.street = "Avn Universidad";
		this.address = new Address(street, blockNumber, floor, door, locality, province, zipCode);
	}
	
	@Test
	public void testGetAndSetProvince() {
		assertEquals(this.province.equals(this.address.getProvince()),0);
		String other = "other";
		this.address.setProvince(other);
		assertEquals(other.equals(this.address.getProvince()),0);
	}
	
	@Test
	public void testGetAndSetLocality() {
		assertEquals(this.locality.equals(this.address.getLocality()),0);
		String other = "other";
		this.address.setLocality(other);
		assertEquals(other.equals(this.address.getLocality()),0);
		
	}
	
	@Test
	public void testGetAndSetStreet() {
		assertEquals(this.street.equals(this.address.getStreet()),0);
		String other = "other";
		this.address.setStreet(other);
		assertEquals(other.equals(this.address.getStreet()),0);
	}
	
	@Test
	public void testGetAndSeZipCode() {
		assertEquals(this.zipCode, this.address.getZipCode());
		int newZip = 10;
		this.address.setZipCode(newZip);
		assertEquals(newZip, this.address.getZipCode());
	}
	
	@Test
	public void testGetAndSetFloor() {
		assertEquals(this.floor, this.address.getFloor());
		int newFloor = 3;
		this.address.setFloor(newFloor);
		assertEquals(newFloor, this.address.getFloor());
	}
	
	
	@Test
	public void testGetAndSetDoor() {
		assertEquals(this.door, this.address.getDoor());
		char newDoor = 'Z';
		this.address.setDoor(newDoor);
		assertEquals(newDoor, this.address.getDoor());
	}
	
	@Test
	public void testGetAndSetBlockNumber() {
		assertEquals(this.blockNumber, this.address.getBlockNumber());
		int newBlockNumber = 3;
		this.address.setBlockNumber(newBlockNumber);
		assertEquals(newBlockNumber, this.address.getBlockNumber());
	}

}
