package com.paymybuddy.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymybuddy.model.Connection;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {
	public ArrayList<Connection> findByUserFromId(int userFromId);
}
