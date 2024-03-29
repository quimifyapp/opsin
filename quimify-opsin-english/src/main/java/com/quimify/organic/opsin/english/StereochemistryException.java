package com.quimify.organic.opsin.english;


/**
 * Thrown if stereochemistry cannot be applied to a structure
 * @author Daniel
 *
 */
class StereochemistryException extends StructureBuildingException {

	private static final long serialVersionUID = 1L;

	StereochemistryException() {
		super();
	}

	StereochemistryException(String message) {
		super(message);
	}

	StereochemistryException(String message, Throwable cause) {
		super(message, cause);
	}

	StereochemistryException(Throwable cause) {
		super(cause);
	}
}