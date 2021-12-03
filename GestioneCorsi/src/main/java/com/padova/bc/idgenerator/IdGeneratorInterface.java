package com.padova.bc.idgenerator;

import java.io.IOException;

import com.lorenz.architecture.dao.DAOException;


public interface IdGeneratorInterface {
	
	long getNextId() throws DAOException, ClassNotFoundException, IOException;
}
