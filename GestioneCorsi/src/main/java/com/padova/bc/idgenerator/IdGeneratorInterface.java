package com.padova.bc.idgenerator;

import java.io.IOException;

import com.padova.architecture.DAO.DAOException;


public interface IdGeneratorInterface {
	
	long getNextId() throws DAOException, ClassNotFoundException, IOException;
}
