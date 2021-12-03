package com.padova.bc.idgenerator;

import java.io.IOException;

import com.padova.architecture.dao.DAOException;


public interface IdGeneratorInterface {
	
	int getNextId() throws DAOException, ClassNotFoundException, IOException;
}
