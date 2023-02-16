package com.quimify.organic.opsin.english;

/**Thrown during assembly of the structure
 *
 * @author ptc24
 *
 */
class StructureBuildingException extends Exception {

	private static final long serialVersionUID = 1L;

	StructureBuildingException() {
		super();
	}

	StructureBuildingException(String message) {
		super(message);
	}

	StructureBuildingException(String message, Throwable cause) {
		super(message, cause);
	}

	StructureBuildingException(Throwable cause) {
		super(cause);
	}

}